package mu.mcb.reward.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tier")
public class TierEntity {
    @Id
    @GeneratedValue
    private int id;
    private String tier;
    private double minimum_points;
    private double maximum_points;

}
