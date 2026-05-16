public class Main {
    public static void main(String[] args){
        Product num = new Product("Chocolate", 20, 100);
        System.out.println(num.getNameproduct());
        System.out.println(num.getPrice());
        System.out.println(num.getStock());
        num.setPrice(40);
        num.setStock(200);
        System.out.println(num.getPrice());
        System.out.println(num.getStock());
    }
}
