package ru.netology.domain;

    public class TShirt extends Product {
        private String producer;

        public String getProducer() {
            return producer;
        }

        public TShirt(int id, String name, int price, String producer) {
            super(id, name, price); //super отвечает за вызов конструктора родителя, обращения к полям родителя, если они не приватные
            this.producer = producer;
        }
    }