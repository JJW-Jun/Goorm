package builder.second;

import org.springframework.util.Assert;

public class ComputerBuilder {


    private Computer computer;

    private ComputerBuilder() {
        computer = new Computer("test", "test", "test");
    }

    public static ComputerBuilder start() {
        return new ComputerBuilder();
    }

    public static ComputerBuilder startWithcCPu(String cpu) {
        ComputerBuilder builder = new ComputerBuilder();
        builder.computer.setCpu(cpu);
        return builder;
    }

    public ComputerBuilder setCpu(String cpu) {
        Assert.hasText(cpu, "cpu must not be empty");
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public Computer build() {
        return this.computer;
    }
}
