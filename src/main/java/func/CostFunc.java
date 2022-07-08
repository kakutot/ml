package func;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.function.Function;

public class CostFunc implements Function<Triple<HypothesisFunc, List<Double>, List<Double>>, Double> {

    @Override
    public Double apply(Triple<HypothesisFunc, List<Double>, List<Double>> input) {
        HypothesisFunc hypothesisFunc = input.getLeft();
        List<Double> xValues = input.getMiddle();
        List<Double> yValues = input.getRight();
        int dataSize = xValues.size();
        double sum = 0.0;

        for (int i = 0; i < dataSize; i++) {
            Double hyph = hypothesisFunc.apply(xValues.get(i));
            sum += Math.pow(hyph - yValues.get(i), 2.0);
        }

        return sum / ( 2.0 * dataSize);
    }
}
