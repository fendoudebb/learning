use std::any::{Any, type_name, TypeId};
use std::fmt::Display;

fn main() {
    println!("Hello, world!");

    let integer = Point1 { x: 5, y: 10 };
    let float = Point1 { x: 1.0, y: 4.0 };

    let both_integer = Point2 { x: 5, y: 10 };
    let both_float = Point2 { x: 1.0, y: 4.0 };
    let integer_and_float = Point2 { x: 5, y: 4.0 };

    let p = Point1 { x: 5, y: 10 };

    println!("p.x = {}", p.x());

    let p1 = Point2 { x: 5, y: 10.4 };
    let p2 = Point2 { x: "Hello", y: 'c' };

    let p3 = p1.mixup(p2);

    println!("p3.x = {}, p3.y = {}", p3.x, p3.y);

    let float32_point = Point1 { x: 500.0, y: 100.0 };

    let x = float32_point.distance_from_origin();

    println!("{:?}", x);

    println!("{:?}", print_type(3));
    println!("{:?}", print_type(3.0));
    println!("{:?}", print_type(true));
}

fn test<T>(t: T) -> T{
    t
}

struct Point1<T> {
    x: T,
    y: T,
}

struct Point2<T, U> {
    x: T,
    y: U,
}

impl<T> Point1<T> {
    fn x(&self) -> &T {
        &self.x
    }
}

impl Point1<f32> {
    fn distance_from_origin(&self) -> f32 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    }
}

impl<T, U> Point2<T, U> {
    fn mixup<V, W>(self, other: Point2<V, W>) -> Point2<T, W> {
        Point2 {
            x: self.x,
            y: other.y,
        }
    }
}
