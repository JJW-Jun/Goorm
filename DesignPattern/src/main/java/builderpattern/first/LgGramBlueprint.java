package builderpattern.first;

public class LgGramBlueprint extends BluePrint {

    private Computer computer;

    public LgGramBlueprint() {
        computer = new Computer("default", "default", "default");
    }

    @Override
    public void setCpu() {
        computer.setCpu("i7");
    }

    @Override
    public void setRam() {
        computer.setRam("16G");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1TSSD");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}