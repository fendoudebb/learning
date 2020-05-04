use std::cmp::Ordering;
use std::io;

use rand::Rng;

fn main() {
    // guess()
    // shadowing();
    // max_min_value();
    // float_point_type();
    // char_type();
    // tuple_type();
    // array_type();
    // scope();
    // if_else_if_expression()
    // if_let_expression();
    // loop_fn();
    // while_fn()
    // for_fn()
    // ownership();
    reference_borrowing();
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

fn for_fn() {
    let a = [10, 20, 30, 40, 50];
    for element in a.iter() {
        println!("element={}", element)
    }
    // Range类型
    // let b = 1..4;
    for number in 1..4 {
        println!("asc number={}", number);
    }
    for number in (1..4).rev() {
        println!("desc number={}", number);
    }
}

fn while_fn() {
    let mut number = 3;
    while number != 0 {
        println!("{}!", number);

        number -= 1;
    }
    println!("LIFTOFF!!!");

    let a = [10, 20, 30, 40, 50];
    let mut index = 0;
    while index < 5 {
        println!("the value is: {}", a[index]);

        index += 1;
    }
}

fn loop_fn() {
    let mut counter = 0;
    let result = loop {
        counter += 1;

        if counter == 10 {
            break counter * 2;
        }
    };
    println!("The result is {}", result);
}

fn if_let_expression() {
    let condition = false;
    let number = if condition {
        5
    } else {
        6
    };
    println!("The value of number is: {}", number);
}

fn if_else_if_expression() {
    let number = 3;
    if number < 5 {
        println!("condition was true");
    } else {
        println!("condition was false");
    }
    if number != 0 {
        println!("number was something other than zero");
    }
    if number % 4 == 0 {
        println!("number is divisible by 4");
    } else if number % 3 == 0 {
        println!("number is divisible by 3");
    } else if number % 2 == 0 {
        println!("number is divisible by 2");
    } else {
        println!("number is not divisible by 4, 3, or 2");
    }
}

fn scope() {
    let y = {
        let x = 5;
        x + 1;
        x + 2
    };
    println!("y={}", y);
}


fn array_type() {
    let months = ["January", "February", "March", "April", "May", "June", "July",
        "August", "September", "October", "November", "December"];
    let a: [i32; 5] = [1, 2, 3, 4, 5];
    let first = a[0];
    let second = a[1];
    // 等价于 let a = [3, 3, 3, 3, 3];
    let b = [3; 5];
}

fn tuple_type() {
    let tup = (500, 6.4, 1);
    let (x, y, z) = tup;
    println!("x={}, y= {}, z={}", x, y, z);
    let x: (i32, f64, u8) = (500, 6.4, 1);
    let index1 = x.0;
    let index2 = x.1;
    let index3 = x.2;
    println!("index1={}, index2= {}, index3={}", index1, index2, index3);
}

fn char_type() {
    let c = 'z';
    let z = 'ℤ';
    let heart_eyed_cat = '😻';
    println!("c={}", c);
    println!("z={}", z);
    println!("heart_eyed_cat={}", heart_eyed_cat);
}

fn float_point_type() {
    let x = 3.0;
    let y: f32 = 2.0;
    println!("x={}", x);
    println!("y={}", y);

    // addition
    // 15
    let sum = 5 + 10;
    println!("sum={}", sum);

    // subtraction
    // 91.2
    let difference = 95.5 - 4.3;
    println!("difference={}", difference);

    // multiplication
    // 120
    let product = 4 * 30;
    println!("product={}", product);

    // division
    // 1.7608695652173911
    let quotient = 56.7 / 32.2;
    println!("quotient={}", quotient);

    // remainder
    // 3
    let remainder = 43 % 5;
    println!("remainder={}", remainder);
}

fn max_min_value() {
    println!("i32 MAX={}", std::i32::MAX);
    println!("i32 MIN={}", std::i32::MIN);
    println!("u32 MAX={}", std::u32::MAX);
    println!("u32 MIN={}", std::u32::MIN);
}

fn shadowing() {
    // 常量
    const CONST_VAR: u8 = 255;
    println!("CONST VAR={}", CONST_VAR);

    // 变量
    let x = 5;
    println!("x={}", x);

    // mut
    let mut y = 10;
    println!("y1={}", y);
    y = 15;
    println!("y2={}", y);

    // Shadowing
    let z = 20;
    let z = z + 5;
    let z = z + 5;
    println!("z={}", z);

    // let
    let spaces = "           ";
    println!("space1={}", spaces);
    let spaces = spaces.len();
    println!("space2={}", spaces);
}

fn guess() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1, 101);

    // println!("The secret number is: {}", secret_number);

    loop {
        println!("Please input your guess.");

        let mut guess = String::new();

        io::stdin().read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("You guessed: {}", guess);

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
