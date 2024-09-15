package Entitie;

public class Material extends Component{
    private double transportCost;
    private double qualityCoefficient;

    public Material(int id, String name, double unitCost, int quantity, double vatRate, double transportCost, double qualityCoefficient) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }


    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }



    public double calculateTotalCost () {
        return this.unitCost * this.quantity + this.transportCost + this.qualityCoefficient;
    }

}
