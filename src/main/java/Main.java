import domain.BaseHouse;
import func.GradientDescent;
import func.HypothesisFunc;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<BaseHouse> baseHouseList = CsvUtil.readAllAsType(BaseHouse.class, "src/main/resources/Real estate.csv");
        List<BaseHouse> training = baseHouseList.subList(0, baseHouseList.size() - (baseHouseList.size() / 5));
        List<BaseHouse> predict = baseHouseList.subList(training.size(), baseHouseList.size() - 1);

        List<Double> xValuesTraining = training.stream().map(BaseHouse::getHouseAge).collect(Collectors.toList());
        List<Double> yValuesTraining = training.stream().map(BaseHouse::getHousePrice).collect(Collectors.toList());

        HypothesisFunc bestHypo = new GradientDescent().apply(xValuesTraining, yValuesTraining);

        System.out.println(bestHypo);
        predict.forEach(
                it -> System.out.printf(
                        "Age : %s, Actual price : %s, Predicted price : %s, Diff : %s \n",
                        it.getHouseAge(),
                        it.getHousePrice(),
                        bestHypo.apply(it.getHouseAge()),
                        it.getHousePrice() - bestHypo.apply(it.getHouseAge())
                )
        );
    }
}
