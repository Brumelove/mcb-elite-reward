package mu.mcb.reward.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Brume
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(updatable = false)
    private String customerId;
    @OneToMany
    private List<AccountEntity> accounts;


}
