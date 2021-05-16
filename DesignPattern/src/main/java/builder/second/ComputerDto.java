package builder.second;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ComputerDto {
    private String cpu;
    private String ram;
    private String storage;

    public ComputerDto(String cpu, String ram, String storage) {
        this.cpu = Objects.requireNonNull(cpu, "Cpu is null");
        this.ram = Objects.requireNonNull(ram, "Ram is null");
        this.storage = Objects.requireNonNull(storage, "Storage is null");
    }
}
