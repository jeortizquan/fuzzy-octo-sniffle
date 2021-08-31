import java.util.Random;

public class ProductBuilder {
    private String name;
    private String status;

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Product createProduct() {
        return new Product(name, status);
    }

    public Product[] getProducts(int amount){
        Random rnd = new Random();
        Product [] products = new Product[amount];

        for(int i=0; i< amount; i++) {
            this.setName("product"+i);
            switch(rnd.nextInt(2)+1){
                case 1:
                    this.setStatus("valid");
                    break;
                default:
                    this.setStatus("invalid");
                    break;
            }
            // fake paretto 80% of products ok / 20% of products null
            int paretto = (rnd.nextInt(100) + 1 );
            if ( paretto >= 80){
                products[i] = null;
            } else {
                products[i] = this.createProduct();
            }
        }
        return products;
    }
}