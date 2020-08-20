fn main() {
    let r;
    {
        r = 10;
    }
    println!("{:?}", r);

    let string1 = String::from("abcd");
    let string2 = "xyz";

    let result = long2(string1.as_str(), string2);
    println!("The longest string is {}", result);

    let novel = String::from("Call me Ishmael. Some years ago...");
    let first_sentence = novel.split('.')
        .next()
        .expect("Could not find a '.'");
    let i = ImportantExcerpt { part: first_sentence };

    let string1 = String::from("long string is long");
    let result;
    {
        let string2 = String::from("xyz");
        result = long2(string1.as_str(), string2.as_str());
    }
    println!("The longest string is {}", result);

}

fn long2(x: & str, y: & str) -> String {
    if x.len() > y.len() {
        x.to_string()
    } else {
        y.to_string()
    }
}

fn longest<'a>(x: &'a str, y: &'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}

struct ImportantExcerpt<'a> {
    part: &'a str,
}