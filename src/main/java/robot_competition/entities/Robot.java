package robot_competition.entities;

import java.util.Date;

public abstract class Robot {
    private String name;
    private String manufacturer;
    private int productionYear;
    private Date registerDate;

    public Robot(String name, String manufacturer, int productionYear) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.productionYear = productionYear;
        this.registerDate = new Date();
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public abstract String getTechnicalDescription();

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", productionYear=" + productionYear +
                ", date=" + registerDate +
                '}';
    }
}
