
import java.util.Random;

public class ProductVerifierImpl implements ProductVerifier{
    private Random rnd;
    public ProductVerifierImpl() {
        this.rnd = new Random();

    }

    @Override
    public void verify(Product product) throws Exception {
        int typeException = this.rnd.nextInt(4) + 1;
        switch (typeException) {
            case 1:
                throw new Exception("product fout");
            case 2:
                throw new RuntimeException("Runtime exception");
            case 3:
                throw new Error("error in product");
            default:
                //product is good
        }
    }
}
