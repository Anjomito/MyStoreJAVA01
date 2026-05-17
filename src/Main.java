public class Main {
    public static void main(String[] args){
        Shop shop = new Shop();

        Product name1 = new Product("Chocolate", 20, 100);
        Product name2 = new Product("Sugar", 32, 500);
        Product name3 = new Product("Jar", 58, 50);

        shop.addProduct(name1);
        shop.addProduct(name2);
        shop.addProduct(name3);

        shop.showAll();
        shop.summary();
    }
}
