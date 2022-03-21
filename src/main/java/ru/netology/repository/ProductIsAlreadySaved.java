package ru.netology.repository;

public class ProductIsAlreadySaved extends RuntimeException {

        public ProductIsAlreadySaved (String s) {
            super(s);
        }
}
