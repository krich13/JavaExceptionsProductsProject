package ru.netology.repository;

public class ProductIsAlreadyDeleted extends RuntimeException {

    public ProductIsAlreadyDeleted(String s) {super(s);
    }
}
