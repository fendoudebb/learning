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
    let p2 = Point2 { x: "Hello", y: 'c'};

    let p3 = p1.mixup(p2);

    println!("p3.x = {}, p3.y = {}", p3.x, p3.y);

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

impl<T, U> Point2<T, U> {
    fn mixup<V, W>(self, other: Point2<V, W>) -> Point2<T, W> {
        Point2 {
            x: self.x,
            y: other.y,
        }
    }
}
