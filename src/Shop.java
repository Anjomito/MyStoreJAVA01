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
        double total = 0;
        for (Product name : products){
            total = total + (name.getPrice()* name.getStock());
        }
        System.out.println("มีรายการสินค้าทั้งหมด "+products.size()+" รายการ");
        System.out.println("ราคารวมสินค้าทุกชิ้น "+total);
    }

    public double sell(String productname ){
        for (Product name : products){
            if (name.getNameproduct().equalsIgnoreCase(productname)){
                if (name.getStock() <= 0){
                    System.out.println("สินค้าหมดแล้ว");
                    return 0;
                }else {
                    name.setStock(name.getStock()-1);
                    return name.getPrice();
                }
            }
        }
        System.out.println("ไม่มีสินค้านี้");
        return 0;
    }

}
