import java.util.ArrayList;

public class Shop {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product name){
        products.add(name);
    }

    public void showAll(){
        for (Product name : products){
            System.out.println(name.getNameproduct()+" ราคา "+name.getPrice()+" บาท จำนวน "+name.getStock()+" ชิ้น");
        }
    }

    public void summary(){
        int total = 0;
        for (Product name : products){
            total = total + (name.getPrice()* name.getStock());
        }
        System.out.println("มีรายการสินค้าทั้งหมด "+products.size()+" รายการ");
        System.out.println("ราคารวมสินค้าทุกชิ้น "+total);
    }

}
