import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Shop shop = new Shop();

    public static void main(String[] args){
        boolean Running = true;

        System.out.println("*********************");
        System.out.println("ขอต้อนรับสู่ร้านค้าของกระผมเอง");
        System.out.println("*********************");
        System.out.println();

        while (Running) {
            System.out.println("กรุณาเลือกโหมดการใช้งาน");
            System.out.println("เลือก 1 เพื่อใช้งานโหมดเจ้าของร้าน");
            System.out.println("เลือก 2 เพื่อใช้งานโหมดลูกค้า");
            System.out.println("เลือก 3 เพื่อออก");
            System.out.print("เลือก : ");
            int choosemode = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choosemode) {
                case 1 -> {
                    boolean sellerRunning = true;

                    while (sellerRunning) {
                        System.out.println("[เจ้าของร้าน]");
                        System.out.println("เลือกทำรายการ");
                        System.out.println("เลือก 1 เพื่อเพิ่มสินค้า");
                        System.out.println("เลือก 2 ลบรายการสินค้า");
                        System.out.println("เลือก 3 ดูรายการสินค้า");
                        System.out.println("เลือก 4 ออกจากร้านค้า");
                        System.out.print("เลือก : ");
                        int sellermode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();

                        switch (sellermode){
                            case 1 -> inputProduct(shop);
                            case 2 -> removeProduct(shop);
                            case 3 -> System.out.println();
                            case 4 -> {
                                sellerRunning = false;
                                System.out.println("ออกจากโหมดเจ้าของร้านแล้ว...\n");
                            }
                            default -> System.out.println("ไม่มีตัวเลือกนี้ในโหมดเจ้าของร้านครับ");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("[ลูกค้า]");
                }
                case 3 -> Running = false;
                default -> System.out.println("ไม่มีตัวเลือกนี้เว้ย ไม่อ่านหรือไง");
            }
        }
    }

    public static void inputProduct(Shop product){
        System.out.println("+ [เพิ่มรายการสินค้า] +");
        System.out.println("สามารถใส่คำว่า //ออก// หรือ //exit// เพื่อออกจากหน้านี้ ");

        while (true){
            System.out.print("ใส่ชื่อสินค้าที่ต้องการเพิ่ม : ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("ออก") || name.equalsIgnoreCase("exit")){
                break;
            }

            System.out.print("ใส่ราคาสินค้า : ");
            double price = scanner.nextDouble();

            System.out.print("ใส่จำนวนสินค้า : ");
            int stock = scanner.nextInt();
            scanner.nextLine();

            Product newProduct = new Product(name, price, stock);
            product.addProduct(newProduct);
            System.out.println("เพิ่มสินค้า [ " + name +" ] สำเร็จ");
            System.out.println();
        }
    }

    public static void removeProduct(Shop product){
        System.out.println("- [ลบรายการสินค้า] -");
        System.out.println("สามารถใส่คำว่า //ออก// หรือ //exit// เพื่อออกจากหน้านี้ ");

        while (true){
            System.out.print("ใส่ชื่อสินค้าที่ต้องการลบ : ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("ออก") || name.equalsIgnoreCase("exit")){
                break;
            }

            boolean isFoundAndRemoved = false;

            for (int i = 0; i < product.products.size(); i++) {
                if (product.products.get(i).getNameproduct().equalsIgnoreCase(name)) {
                    product.products.remove(i);
                    isFoundAndRemoved = true;
                    break;
                }
            }

            if (isFoundAndRemoved){
                System.out.println("ลบ " + name + " เรียบร้อยแล้ว");
            } else {
                System.out.println("ไม่พบ " + name + " ในรายการ");
            }

            System.out.println();
        }
    }
}