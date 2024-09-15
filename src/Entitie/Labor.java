package Entitie;
import Enum.ComponentType;
public class Labor extends Component {
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public Labor(int id, String name, double unitCost, int quantity,ComponentType type ,Double vatRate, double hourlyRate, double hoursWorked, double workerProductivity) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.type = type;
        this.vatRate = vatRate;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getWorkerProductivity() {
        return workerProductivity;
    }

    public void setWorkerProductivity(double workerProductivity) {
        this.workerProductivity = workerProductivity;
    }

    public double calculateTotalCost () {
        return this.unitCost * this.quantity + this.hourlyRate * this.hoursWorked * this.workerProductivity;
    }


}
