package func;

import org.apache.commons.lang3.tuple.Triple;

import java.util.List;
import java.util.function.BiFunction;

public class GradientDescent implements BiFunction<List<Double>, List<Double>, HypothesisFunc> {

    private static final double ALPHA = 0.0035;

    @Override
    public HypothesisFunc apply(List<Double> xValues, List<Double> yValues) {
        int dataSize = xValues.size();

        double theta0Init = 0.0;
        double theta1Init = 0.0;

        double theta0Curr = theta0Init;
        double theta1Curr = theta1Init;

        double costFuncPrev = new CostFunc().apply(Triple.of(
                new HypothesisFunc(theta0Init, theta1Init), xValues, yValues)
        );

        double costFuncCurr;

        while (true) {
            double currSumTheta0 = 0.0;
            double currSumTheta1 = 0.0;

            for (int i = 0; i < dataSize; i++) {
                double hCurr = new HypothesisFunc(theta0Curr, theta1Curr).apply(xValues.get(i));
                double diff = hCurr - yValues.get(i);
                currSumTheta0 += diff;
                currSumTheta1 += diff * xValues.get(i);
            }

            theta0Curr = theta0Init - ((ALPHA * currSumTheta0) / dataSize);
            theta1Curr = theta1Init - ((ALPHA * currSumTheta1) / dataSize);

            theta0Init = theta0Curr;
            theta1Init = theta1Curr;

            costFuncCurr = new CostFunc().apply(Triple.of(
                    new HypothesisFunc(theta0Curr, theta1Curr), xValues, yValues)
            );

            if ((costFuncPrev - costFuncCurr) <= 0.0001) {
                break;
            }

            costFuncPrev = costFuncCurr;
        }

        return new HypothesisFunc(theta0Curr, theta1Curr);
    }

}
