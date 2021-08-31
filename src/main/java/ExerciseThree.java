import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExerciseThree {

    public static void main(String [] args) {
        ProductVerifierImpl verifier = new ProductVerifierImpl();
        ProductionLineTester tester = new ProductionLineTester(verifier);
        ProductBuilder productBuilder = new ProductBuilder();
        Supplier<Stream<Product>> productStream = () -> Arrays.stream(productBuilder.getProducts(500));
        ProductLineTestReport report = tester.test(productStream.get());

        System.out.println("Product Tester Report");
        System.out.println("=====================");
        System.out.println("Checked exceptions  : " + report.checkedExcCnt);
        System.out.println("Unchecked exceptions: " + report.uncheckedExcCnt);
        System.out.println("Errors              : " + report.otherExcCnt);
        System.out.println("Correct products    : " + report.otherExcCnt);
    }
}
