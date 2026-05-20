public class Product {
    private String Nameproduct;
    private double price;
    private int stock;

    public String getNameproduct(){ return Nameproduct; }

    public double getPrice() { return price; }

    public int getStock() {
        return stock;
    }

    public void setPrice(double newPrice){
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

    public Product(String Nameproduct, double price, int stock){
        this.Nameproduct = Nameproduct;
        setPrice(price);
        setStock(stock);
    }
}
