package lomayd.YourSamppleRemake.api.domain.plan;

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
public class Plan {
    @Id
    private String id;

    @Column
    private Carrier carrier;

    @Column
    private Integer cost;

}
