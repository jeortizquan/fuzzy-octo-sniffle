import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    private Stream<List<Product>> batches(List<Product> source, int length) {
        if (length <= 0)
            throw new IllegalArgumentException("length = " + length);
        int size = source.size();
        if (size <= 0)
            return Stream.empty();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }

    ProductLineTestReport test(Stream<Product> products) {
        List<Product> success = new ArrayList<>();
        List<Product> simplyError = new ArrayList<>();
        List<Product> checkedException = new ArrayList<>();
        List<Product> uncheckedException = new ArrayList<>();

        ArrayList<Product> aproducts = (ArrayList<Product>) products.filter(p -> p != null)
                .filter(p -> !p.status.toLowerCase().equals("invalid"))
                .skip(10)
                .collect(Collectors.toList());

        batches(aproducts, 20).forEach(batch -> {
            batch.forEach(product -> {
                try {
                    verifier.verify(product);
                    success.add(product);
                } catch (Exception | Error e) {
                    if (e instanceof Error)
                        simplyError.add(product);
                    else if (e instanceof RuntimeException)
                        uncheckedException.add(product);
                    else
                        checkedException.add(product);
                }
            });
        });

        ProductLineTestReport productLineTestReport = new ProductLineTestReport(success.size(),
                checkedException.size(),
                uncheckedException.size(),
                simplyError.size());
        return productLineTestReport;
    }

}
