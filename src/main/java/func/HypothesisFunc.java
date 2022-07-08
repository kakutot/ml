package func;

import java.util.function.Function;

public class HypothesisFunc implements Function<Double, Double> {

    private final Double theta0;
    private final Double theta1;

    public HypothesisFunc(Double theta0, Double theta1) {
        this.theta0 = theta0;
        this.theta1 = theta1;
    }

    @Override
    public String toString() {
        return "HypothesisFunc{" +
                "theta0=" + theta0 +
                ", theta1=" + theta1 +
                '}';
    }

    @Override
    public Double apply(Double x) {
        return theta0 + theta1 * x;
    }
}
