#![allow(unused_variables)]

fn main() {
    // vector();
    let mut s = String::new();
    let data = "initial contents";

    let s = data.to_string();

// the method also works on a literal directly:
    let s = "initial contents".to_string();

    let mut s = String::from("foo");
    s.push_str("bar");

    let mut s = String::from("lo");
    s.push('l');


    let s1 = String::from("tic");
    let s2 = String::from("tac");
    let s3 = String::from("toe");

    let s = format!("{}-{}-{}", s1, s2, s3);

    println!("s={}, s1={}, s2={}, s3={}", s, s1, s2, s3);

    let hello = "Здравствуйте";
    let s = &hello[0..4];

    println!("s={}", s);

    for c in "नमस्ते".chars() {
        println!("{}", c);
    }

    for b in "नमस्ते".bytes() {
        println!("{}", b);
    }

}

fn vector() {
    let vec: Vec<i32> = Vec::new();
    println!("{:?}", vec);

    let mut v = Vec::new();


    v.push(5);
    v.push(6);
    v.push(7);

    let third: &i32 = &v[2];
    println!("The third element is {}", third);

    v.push(8);
    v.pop();
    v.remove(0);
    println!("{:?}", v);

    let v = vec![1, 2, 3, 4, 5];

    let third: &i32 = &v[2];
    println!("The third element is {}", third);

    match v.get(2) {
        Some(third) => println!("The third element is {}", third),
        None => println!("There is no third element."),
    }

    match v.get(6) {
        Some(third) => println!("The third element is {}", third),
        None => println!("There is no third element."),
    }

    let v = vec![100, 32, 57];
    for i in &v {
        println!("{}", i);
    }

    let mut v = vec![100, 32, 57];
    for i in &mut v {
        *i += 50;
    }

    for i in &v {
        println!("{}", i);
    }
}
