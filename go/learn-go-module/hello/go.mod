module hello

go 1.15

replace example.com/greetings => ../greetings

require (
	example.com/greetings v1.1.0
	golang.org/x/tools v0.0.0-20201022035929-9cf592e881e9 // indirect
)
