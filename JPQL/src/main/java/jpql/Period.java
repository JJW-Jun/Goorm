package jpql;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable @Getter
public class Period {

    // Period:
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    protected Period() {
    }

}
