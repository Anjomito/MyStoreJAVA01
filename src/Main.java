import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Shop shop = new Shop();

        Product name1 = new Product("Chocolate", 20, 100);
        Product name2 = new Product("Sugar", 32, 500);
        Product name3 = new Product("Jar", 58, 50);

        shop.addProduct(name1);
        shop.addProduct(name2);
        shop.addProduct(name3);
        shop.addProduct(new Product("Lion", 2000, 0));

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true){
            System.out.print("พิมพ์ชื่อสินค้าที่ต้องการ : ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("ออก")){
                break;
            }else {
                int total = shop.sell(input);
                if (total > 0){
                    System.out.println("ยอดที่ต้องชำระ "+ total + " บาท");
                }
            }
        }
        System.out.println("ขอบคุณที่ใช้บริการ");

    }
}
