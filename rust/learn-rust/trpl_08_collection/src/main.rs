#![allow(unused_variables)]
fn main() {
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
