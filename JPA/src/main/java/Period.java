import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Embeddable @Data
public class Period {
    // Period:
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    Period() { }

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
