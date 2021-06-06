package builder.second;

import java.util.Objects;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public Computer(String cpu, String ram, String storage) {
        this.cpu = Objects.requireNonNull(cpu, "Cpu is null");
        this.ram = Objects.requireNonNull(ram, "Ram is null");
        this.storage = Objects.requireNonNull(cpu, "Storage is null");
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
