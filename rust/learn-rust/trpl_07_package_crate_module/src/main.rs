use std::collections::HashMap;

use trpl_07_package_crate_module::eat_at_restaurant;

fn main() {
    println!("Hello, world!");
    eat_at_restaurant();


    let mut map = HashMap::new();
    map.insert(1, 2);

    println!("{:?}", map);

}
