
# Functional Programming

## Functional Paradigm differences

imperative programming (Java and C)
logic programming

but oop, it can be combined well with both imperative programming or functional / logic programming.

## imperative programming

Changes mutable variables, assigns, if-then-else, loops, breaks, etc.

## Problem with this approach?
It doesn't always scale well because a mutable variable typically corresponds to the size of a memory cell. 

### Von nuemann computer architecture
![nuemann computer architecture](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Von_Neumann_Architecture.svg/510px-Von_Neumann_Architecture.svg.png)

Based on the image above, you can see that variable definitions and variable assignments also correspond to the load and store instructions that happen between the memory and CPU (control and logic units). Control structures are shortcircuits and various other jumps in the bus.

## Reasoning in larger structures
Inventor of Fortran found that imperative programming was running out of steam. We need collections, strings, etc. higher order functions and theories so we can reason about them

## Theory?
1 or more data types, operations on them, but not mutations. Idea of immutability cna be found in Strings (Java concept).



