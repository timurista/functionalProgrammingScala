
# Functional Programming

## Functional Paradigm differences

Imperative programming (Java and C) can be thought of as giving explicit instructions per word written in the language. Traditionally, oop existed in imperative programming models (thinking of classes in Java).

## Problem with the imperative approach?
It doesn't always scale well because a mutable variable typically corresponds to the size of a memory cell. 

### Von nuemann computer architecture
![nuemann computer architecture](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Von_Neumann_Architecture.svg/510px-Von_Neumann_Architecture.svg.png)

Based on the image above, you can see that variable definitions and variable assignments also correspond to the load and store instructions that happen between the memory and CPU (control and logic units). Control structures are shortcircuits and various other jumps in the bus.

## Reasoning in larger structures
Inventor of Fortran found that imperative programming was running out of steam. We need collections, strings, etc. higher order functions and theories so we can reason about them

## Theory?
1 or more data types, operations on them, but not mutations. Idea of immutability cna be found in Strings (Java concept).

## Functional programming
1. Avoid mutations
2. Abstract and compose functions

### Restricted
no mutable variables, no loops, etc.

### General
functions in program, certain functions can be composed etc.

### First class citizens
As a first-class citizen, you can define functions anywhere, can pass functions as parameters and return them as functions. You can even compose functions.

## Functional History
Lisp was invented in 159, then 1970s-1990s which haskel. Clojure, Scala in last 10 years.

``` 
Why is it gaining popularity
```

Great for cloud computing, exploiting multicore processing.