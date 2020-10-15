fn main() {
    // a..=b表示两端都包含在内的范围
    // 1 2 3 4
    for n in 1..=4 {
        print!("{} ", n)
    }

    println!();

    // 3 2 1
    for number in (1..4).rev() {
        print!("{} ", number);
    }

}


