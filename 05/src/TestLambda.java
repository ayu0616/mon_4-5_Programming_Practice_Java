import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

public class TestLambda {
    static double cumsum(DoubleFunction<Double> f, List<Double> values) {
        double s = 0.0;
        for (double x : values) {
            s += f.apply(x);
        }
        return s;
    }

    public static void main(String[] args) {
        List<Double> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            values.add(Math.random() * 10);
        }
        System.out.println(values);
        DoubleFunction<Double> f1 = x -> x + Math.cos(x);
        System.out.println(cumsum(f1, values));
        System.out.println(cumsum(x -> x * x + 1.0, values));
    }
}
