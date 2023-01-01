package lomayd.YourSamppleRemake.api.domain.agreement;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {
    @Id
    private String category;

    @Column
    private Integer time;
}
