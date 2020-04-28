use std::io;
use rand::Rng;
use std::cmp::Ordering;

fn main() {
    // guess()
    shadowing();
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
