package lomayd.YourSamppleRemake.api.domain.phone;

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
public class Phone {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Integer prize;
}
