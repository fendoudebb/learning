use std::{env, process};

use trpl_12_command_line_program;

fn main() {
    let args: Vec<String> = env::args().collect();
    println!("{:?}", args);

    // let program_name = &args[0];

    // let query = &args[1];
    // let filename = &args[2];

    // println!("Program name {}", program_name);
    // println!("Searching for {}", query);
    // println!("In file {}", filename);

    let config = trpl_12_command_line_program::Config::new(&args).unwrap_or_else(|err| {
        eprintln!("Problem parsing arguments: {}", err);
        process::exit(1);
    });

    if let Err(e) = trpl_12_command_line_program::run(config) {
        eprintln!("Application error: {}", e);

        process::exit(1);
    }
}


