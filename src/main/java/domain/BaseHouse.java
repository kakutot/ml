package domain;

import com.opencsv.bean.CsvBindByName;

public class BaseHouse {

    @CsvBindByName(column = "X2 house age")
    private Double houseAge;

    @CsvBindByName(column = "Y house price of unit area")
    private Double housePrice;

    public BaseHouse() {

    }

    public BaseHouse(Double houseAge, Double housePrice) {
        this.houseAge = houseAge;
        this.housePrice = housePrice;
    }

    @Override
    public String toString() {
        return "BaseHouse{" +
                "houseAge=" + houseAge +
                ", housePrice=" + housePrice +
                '}';
    }

    public Double getHouseAge() {
        return houseAge;
    }

    public void setHouseAge(Double houseAge) {
        this.houseAge = houseAge;
    }

    public Double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(Double housePrice) {
        this.housePrice = housePrice;
    }
}
