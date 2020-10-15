use std::convert::TryFrom;

fn main() {
    let decimal = 65.4321_f32;

    let integer = decimal as u8;

    let character = integer as char;

    println!("Casting: {} -> {} -> {}", decimal, integer, character);

    println!("  -1 as a u8 is : {}", (-1i8) as u8);

    println!("1000 mod 256 is : {}", 1000 % 256);


    let num = Number::from(30);
    println!("My number is {:?}", num);

    let value: i32 = num.into();

    println!("My number value is {}", value);

    let int = 5;
    // 试试删除类型说明
    let num: Number = int.into();
    println!("int into number is {:?}", num);

}

#[derive(Debug)]
struct Number {
    value: i32,
}

impl From<i32> for Number {
    fn from(item: i32) -> Self {
        Number { value: item }
    }
}

impl Into<i32> for Number {
    fn into(self) -> i32 {
        self.value
    }
}

#[derive(Debug, PartialEq)]
struct EvenNumber(i32);

impl TryFrom<i32> for EvenNumber {
    type Error = ();

    fn try_from(value: i32) -> Result<Self, Self::Error> {
        if value % 2 == 0 {
            Ok(EvenNumber(value))
        } else {
            Err(())
        }
    }
}


