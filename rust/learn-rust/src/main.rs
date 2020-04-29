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
    scope();
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
