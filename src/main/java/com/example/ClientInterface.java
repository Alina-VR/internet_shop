package com.example;

public interface ClientInterface {

    void viewDescription(String text);

    public void addToFavorites(Product product);
    public void addToBasket(Product product);
    public void checkout();
    public void arrangeDelivery();

}
