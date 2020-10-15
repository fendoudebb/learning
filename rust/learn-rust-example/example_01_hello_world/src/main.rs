use std::fmt::{Display, Formatter, Result};
use std::mem;

fn main() {
    // 通常情况下，`{}` 会被任意变量内容所替换
    // 不加后缀的话，31 就自动成为 i32 类型
    // 31 days
    println!("{} days", 31);

    // 可以使用位置参数
    // Alice, this is Bob. Bob, this is Alice
    println!("{0}, this is {1}. {1}, this is {0}", "Alice", "Bob");

    // 可以使用命名参数
    // the quick brown fox jumps over the lazy dog
    println!("{subject} {verb} {object}",
             object="the lazy dog",
             subject="the quick brown fox",
             verb="jumps over");

    // 可以在 `:` 后面指定特殊的格式。
    // 2 的二进制是 10
    // 1 of 10 people know binary, the other half don't
    println!("{} of {:b} people know binary, the other half don't", 1, 2);

    // 按指定宽度来右对齐文本
    // 5 个空格后面连着 1
    println!("{number:>width$}", number=1, width=6);

    // 数字左边补 0
    // 000001
    println!("{number:>0width$}", number=1, width=6);

    debug_print();

    let xs: [i32; 5] = [1, 2, 3, 4, 5];

    // 数组是在栈中分配的
    println!("array occupies {} bytes", mem::size_of_val(&xs));


}

fn debug_print() {
    #[derive(Debug)]
    struct Structure(i32);

    // `Structure` 也可以打印！
    println!("Now {:?} will print!", Structure(3));

    // 美化打印
    println!("{:#?}", Structure(3));
}

fn display_print() {
    struct Structure(i32);

    impl Display for Structure {
        fn fmt(&self, f: &mut Formatter<'_>) -> Result {
            write!(f, "{}", self.0)
        }
    }
}
