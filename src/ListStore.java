import java.util.ArrayList;
import java.util.Scanner;

public class ListStore {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listproduct = new ArrayList<>();
        String choosemenu;
        String inputlistproduct;
        String deleteproduct;

        System.out.println("*********************");
        System.out.println("ขอต้อนรับสู่ร้านค้าของกระผมเอง");
        System.out.println("*********************");
        System.out.println();

        do {System.out.println("เลือกทำรายการ");
        System.out.println("พิมพ์ 1 เพิ่มรายการสินค้า");
        System.out.println("พิมพ์ 2 ลบรายการสินค้า");
        System.out.println("พิมพ์ 3 ดูรายการสินค้า");
        System.out.println("พิมพ์ 4 ออกจากร้านค้า");
        System.out.print("เลือก : ");
        choosemenu = scanner.nextLine().trim();
            System.out.println();

        if (choosemenu.equals("1")){
            System.out.println("เพิ่มรายการสินค้า พิมพ์ n เพื่อหยุด");
            while (true){
                System.out.print("กรอกชื่อรายการสินค้าที่ต้องการเพิ่ม : ");
                inputlistproduct = scanner.nextLine().trim();

                if (inputlistproduct.equalsIgnoreCase("n")){
                    break;
                } else {listproduct.add(inputlistproduct);}

                System.out.println();
            }
        }
        else if(choosemenu.equals("2")){
            System.out.println("ลบรายการสินค้า พิมพ์ n เพื่อหยุด");
            while (true){
                System.out.print("กรอกชื่อรายการสินค้าที่ต้องการลบ : ");
                deleteproduct = scanner.nextLine().trim();
                if (deleteproduct.equalsIgnoreCase("n")){
                    break;
                } else { boolean remove = listproduct.remove(deleteproduct);
                if (remove){
                    System.out.println("ลบ "+ deleteproduct + " เรียบร้อยแล้ว\nมีสินค้าทั้งหมด " + listproduct.size()+" รายการ");
                } else {
                    System.out.println("ไม่พบ "+ deleteproduct + " ในรายการ");
                }
                }
            }
                System.out.println();

        }

        else if (choosemenu.equals("3")){
            System.out.println("แสดงรายการสินค้าทั้งหมด");
            if (listproduct.isEmpty()){
                System.out.println("ไม่มีรายการสินค้า");
            }
            else {
                for (String MyStoreproduct : listproduct) {
                    System.out.println(MyStoreproduct);
                }
            }
            }
            System.out.println();

    }while (!choosemenu.equals("4"));
        System.out.println("ขอบคุณที่ใช้บริการ");
        scanner.close();
    }
}
