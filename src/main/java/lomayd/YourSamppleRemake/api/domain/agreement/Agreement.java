package lomayd.YourSamppleRemake.api.domain.agreement;

import lomayd.YourSamppleRemake.api.domain.phone.Phone;
import lomayd.YourSamppleRemake.api.domain.plan.Plan;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agreement {
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Phone phone;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plan plan;

    @Column
    private Integer sale;
}
