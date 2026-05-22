import java.util.Scanner;
import java.util.ArrayList;

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
                            case 3 -> {
                                shop.showAll();
                                shop.summary();
                            }
                            case 4 -> {
                                sellerRunning = false;
                                System.out.println("ออกจากโหมดเจ้าของร้านแล้ว...\n");
                            }
                            default -> System.out.println("ไม่มีตัวเลือกนี้ในโหมดเจ้าของร้านครับ");
                        }
                    }
                }
                case 2 -> {
                    boolean BuyerRunning = true;
                    ArrayList<CartItem> cart = new ArrayList<>();

                    while (BuyerRunning){
                        System.out.println("[ลูกค้า]");
                        System.out.println("เลือกทำรายการ");
                        System.out.println("เลือก 1 ดูรายการสินค้า");
                        System.out.println("เลือก 2 เลือกสินค้าใส่ตะกร้า");
                        System.out.println("เลือก 3 ดูตะกร้าสินค้าและชำระเงิน");
                        System.out.println("เลือก 4 ออกจากร้านค้า");
                        System.out.print("เลือก : ");
                        int buyermode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println();

                        switch (buyermode){
                            case 1 -> shop.showAll();
                            case 2 -> addToCart(shop, cart);
                            case 3 -> checkout(cart);
                            case 4 -> {
                                BuyerRunning = false;
                                System.out.println("ออกจากโหมดลูกค้าแล้ว...\n");
                            }
                            default -> System.out.println("ไม่มีตัวเลือกนี้ในโหมดลูกค้าครับ");
                        }
                    }
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
                System.out.println();
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
                System.out.println();
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

    // ยอมละ ผมไปไม่ถูก เจน AI ล้วนเลย
    public static void addToCart(Shop shop, ArrayList<CartItem> cart) {
        System.out.println("+ [เลือกสินค้าใส่ตะกร้า] +");
        System.out.print("ใส่ชื่อสินค้าที่ต้องการซื้อ : ");
        String name = scanner.nextLine();

        Product targetProduct = null;
        // วนลูปหาว่าในร้านมีสินค้าชื่อนี้ไหม
        for (Product p : shop.products) {
            if (p.getNameproduct().equalsIgnoreCase(name)) {
                targetProduct = p;
                break;
            }
        }

        if (targetProduct == null) {
            System.out.println("ไม่มีสินค้านี้ในร้านครับ\n");
            return;
        }

        if (targetProduct.getStock() <= 0) {
            System.out.println("ขออภัย สินค้าชิ้นนี้หมดแล้วครับ\n");
            return;
        }

        System.out.print("ใส่จำนวนที่ต้องการซื้อ (มีสินค้าในสต็อก " + targetProduct.getStock() + " ชิ้น): ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        if (qty <= 0) {
            System.out.println("จำนวนสินค้าต้องมากกว่า 0 ครับ\n");
            return;
        }

        if (qty > targetProduct.getStock()) {
            System.out.println("สินค้าในคลังมีไม่พอครับ\n");
            return;
        }

        // จองสินค้าโดยการตัดสต็อกร้านค้าชั่วคราว
        targetProduct.setStock(targetProduct.getStock() - qty);

        // เช็คว่าเคยมีสินค้านี้ในตะกร้าหรือยัง ถ้ามีให้บวกจำนวนเพิ่ม ถ้าไม่มีให้แอดชิ้นใหม่
        boolean existingInCart = false;
        for (CartItem item : cart) {
            if (item.getProduct().getNameproduct().equalsIgnoreCase(name)) {
                item.addQuantity(qty);
                existingInCart = true;
                break;
            }
        }

        if (!existingInCart) {
            cart.add(new CartItem(targetProduct, qty));
        }

        System.out.println("เพิ่ม [ " + targetProduct.getNameproduct() + " ] จำนวน " + qty + " ชิ้น ลงตะกร้าเรียบร้อยแล้ว\n");
    }

    // เมธอดดูตะกร้าสินค้าและชำระเงิน
    public static void checkout(ArrayList<CartItem> cart) {
        System.out.println("= [ ตะกร้าสินค้าของคุณ ] =");
        if (cart.isEmpty()) {
            System.out.println("--- ไม่มีสินค้าในตะกร้า ---\n");
            return;
        }

        double grandTotal = 0;
        for (CartItem item : cart) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            grandTotal += itemTotal;
            System.out.println("- " + item.getProduct().getNameproduct() +
                    " จำนวน " + item.getQuantity() + " ชิ้น " +
                    "(ราคาชิ้นละ " + item.getProduct().getPrice() + " บาท) " +
                    "รวม: " + itemTotal + " บาท");
        }
        System.out.println("-------------------------");
        System.out.println("ราคารวมทั้งสิ้น: " + grandTotal + " บาท");
        System.out.println("-------------------------");

        System.out.print("ยืนยันการชำระเงินหรือไม่? (กด Y เพื่อตกลง / กด N เพื่อช็อปปิ้งต่อ): ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("Y")) {
            System.out.println("ชำระเงินสำเร็จ! ขอบคุณที่อุดหนุนครับ");
            cart.clear(); // จ่ายเงินเสร็จแล้วล้างตะกร้าให้ว่าง
            System.out.println();
        } else {
            System.out.println("คุณสามารถเลือกช็อปปิ้งต่อได้เลยครับ\n");
        }
    }

}