package model.enums;

public enum laundryServices {

    NORMAL("Normal Wash", 15.00),
    A_SECO("Dry Clean", 20.00),
    DELICADA("Delicate Wash", 30.00);

    private final String description;
    private final Double basePrice;

    laundryServices(String description, Double basePrice) {
      this.description = description;
      this.basePrice = basePrice;
    }

    public String getDescription() {
        return description;
    }

    public Double getBasePrice() {
        return basePrice;
    }
}
