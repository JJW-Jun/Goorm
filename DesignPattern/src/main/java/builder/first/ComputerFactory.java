package builder.first;

public class ComputerFactory {

    private BluePrint bluePrint;

    public void setBluePrint(BluePrint bluePrint) {
        this.bluePrint = bluePrint;
    }

    public void make() {
        bluePrint.setRam();
        bluePrint.setCpu();
        bluePrint.setStorage();
    }

    public Computer getComputer() {
        return bluePrint.getComputer();
    }
}
