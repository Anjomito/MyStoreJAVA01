import java.util.ArrayList;
import java.util.Scanner;

public class ListStore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listproduct = new ArrayList<>();
        String choosemenu;
        String inputlistproduct;

        System.out.println("*********************");
        System.out.println("ขอต้อนรับสู่ร้านค้าของกระผมเอง");
        System.out.println("*********************");
        System.out.println();

        System.out.println("เลือกทำรายการ");
        System.out.println("พิมพ์ 1 เพิ่มรายการสินค้า");
        System.out.println("พิมพ์ 2 ลบรายการสินค้า");
        System.out.println("พิมพ์ 3 ดูรายการสินค้า");
        System.out.println("พิมพ์ 4 ออกจากร้านค้า");
        System.out.print("เลือก : ");
        choosemenu = scanner.nextLine().trim();

        if (choosemenu.equals("1")){
            System.out.println("เพิ่มรายการสินค้า พิมพ์ n เพื่อหยุด");
            while (true){
                System.out.print("กรอกชื่อรายการสินค้าที่ต้องการเพิ่ม : ");
                inputlistproduct = scanner.nextLine().trim();

                if (inputlistproduct.equalsIgnoreCase("n")){
                    break;
                } else {listproduct.add(inputlistproduct);}

                System.out.println("เพิ่ม "+ inputlistproduct + " เรียบร้อยแล้ว\nมีสินค้าทั้งหมด " + listproduct.size()+" รายการ");
                System.out.println();
            }
        }



        scanner.close();
    }
}
