public class Product {
    private String Nameproduct;
    private int price;
    private int stock;

    public String getNameproduct(){
        return Nameproduct;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(int newPrice){
        if (newPrice < 0){
            System.out.println("ราคาติดลบไม่ได้");
        } else {
            price = newPrice;
        }
    }

    public void setStock(int newStock){
        if (newStock < 0){
            System.out.println("จำนวนสินค้าติดลบไม่ได้");
        } else {
            stock = newStock;
        }
    }

    public Product(String Nameproduct, int price, int stock){
        this.Nameproduct = Nameproduct;
        setPrice(price);
        setStock(stock);
    }
}
