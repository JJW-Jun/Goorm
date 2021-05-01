import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntity {

    private String uniqueId;
    private LocalDate createLocalDate;
}
