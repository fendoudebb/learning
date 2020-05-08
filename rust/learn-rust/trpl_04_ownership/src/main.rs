fn main() {
    ownership();
    reference_borrowing();

    // find_first_word_index();
    let s = String::from("hello world");

    let hello = &s[0..5];
    let world = &s[6..11];

    let slice1 = &s[0..2];
    let slice2 = &s[..2];

    let len = s.len();

    let slice3 = &s[3..len];
    let slice4 = &s[3..];

    let slice5 = &s[0..len];
    let slice6 = &s[..];

    println!("{} = {}", hello, world);
    println!("slice1={}, slice2={}", slice1, slice2);
    println!("slice3={}, slice4={}", slice3, slice4);
    println!("slice5={}, slice6={}", slice5, slice6);

    let mut s2 = String::from("hello world");

    let word = first_word2(&s2);

    s2.clear(); // error!

    // 注释掉这句话能编译通过，因为不可变引用没有使用
    // println!("the first word is: {}", word);

    let a = [1, 2, 3, 4, 5];

    let slice = &a[1..3];
}

fn first_word2(s: &String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }

    &s[..]
}

fn find_first_word_index() {
    let mut s = String::from("hello world");
    let word = first_word(&s);
    s.clear();
    println!("word={}", word);
}

fn first_word(s: &String) -> usize {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return i;
        }
    }

    s.len()
}

fn reference_borrowing() {
    let s1 = String::from("hello");
    let len = calculate_length2(&s1);
    println!("The length of '{}' is {}.", s1, len);
    let mut s = String::from("hello");
    change(&mut s);
    println!("s={}", s);
    let mut s3 = String::from("hello");
    {
        let r1 = &mut s3;
    }
    // r1 在这一行超出作用域，所以我们可以创建一个新的引用
    let r2 = &mut s3;
    let mut s4 = String::from("hello");
    let r3 = &s4; // no problem
    let r4 = &s4; // no problem
    println!("{} and {}", r3, r4);
    // r3 and r3 在这之后不再使用
    let r5 = &mut s4; // no problem
    println!("{}", r5);
}

fn change(some_string: &mut String) {
    some_string.push_str(", world");
}

fn calculate_length2(s: &String) -> usize {
    s.len()
}

fn ownership() {
    let mut s = String::from("hello");
    s.push_str(", world!");
    println!("{}", s);
    let x = 5;
    let y = x;
    println!("x={}, y={}", x, y);
// shallow copy浅拷贝
    let s1 = String::from("hello");
    let s2 = s1;
    println!("s2={}", s2);
// deep copy深拷贝
    let s3 = String::from("hello");
    let s4 = s3.clone();
    println!("s3={}, s4={}", s3, s4);
// 整数等固定且已知大小的类型，都是存放在栈帧中的，clone和浅拷贝一样，都是直接复制一个值
    let x1 = 10;
    let y1 = x1.clone();
    println!("x1={}, y1={}", x1, y1);
    ownership_fn1();
    ownership_fn2();
    multiple_returning_value();
}

fn multiple_returning_value() {
    let s1 = String::from("hello");

    let (s2, len) = calculate_length(s1);

    println!("The length of '{}' is {}.", s2, len);
}

fn calculate_length(s: String) -> (String, usize) {
    let length = s.len(); // len() returns the length of a String

    (s, length)
}

fn ownership_fn2() {
    let s1 = gives_ownership();         // gives_ownership 的返回值移入 s1

    let s2 = String::from("hello");     // s2 进入作用域

    let s3 = takes_and_gives_back(s2);  // s2 移入 takes_and_gives_back 函数中，
    // 并且 takes_and_gives_back 的返回值移入 s3
} // 这一行，s3 超出作用域并被销毁。s2 超出作用域但是已经被移动了，不发生任何事。s1 超出作用域并被销毁。

fn gives_ownership() -> String {             // gives_ownership 将移动它的返回值到调用它的地方

    let some_string = String::from("hello"); // some_string 进入作用域

    some_string                              // some_string 被返回，并且移出到调用这个函数的地方
}

// takes_and_gives_back 函数接收一个 String 参数，并且返回一个 String
fn takes_and_gives_back(a_string: String) -> String { // a_string 进入作用域

    a_string  // a_string 被返回，并且移出到调用这个函数的地方
}

fn ownership_fn1() {
    let s = String::from("hello");  // s 进入作用域

    takes_ownership(s);             // s 的值移入函数 takes_ownership 中
    // takes_ownership 函数在这一行开始就不再有效

    let x = 5;                      // x 进入作用域

    makes_copy(x);                  // x 移入函数中，
    // 但是 i32 是可`Copy`，所以再这一行之后还可以继续使用 x
} // 这一行，x 超出作用域，接着是 s。但因为 s 的值已经移动了，没有特殊处理了。


fn takes_ownership(some_string: String) { // some_string 进入作用域
    println!("{}", some_string);
} // 这一行，some_string 超出作用域，接着`drop`函数被调用。备份内存被释放。

fn makes_copy(some_integer: i32) { // some_integer 进入作用域
    println!("{}", some_integer);
} // 这一行，some_integer 超出作用域，不发生任何事情。

