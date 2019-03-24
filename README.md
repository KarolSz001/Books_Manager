# Books_Manager
## App for books and magazine management

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)

## General info
Siple program to add, remove ,search books

## Technologies
* Tech 1 - version 0.4

## Setup
Simple you can run in you IDE

## Code Examples

    public static void printBooks(Library lib) {
        long countBooks = lib.getPublications().values().stream().filter(Book.class::isInstance)
                .sorted(new Library.AlphabeticalComparator()).peek(System.out::println).count();

        if (countBooks == 0) {
            System.out.println("NO BOOKS IN LIBRARY");
        }
    }
## Features

* add Exception


To-do list:
* add Maven
* add JsonFile


## Status
Project is: _in progress_
