package mu.mcb.reward.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author Brume
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column
    private String accountNumber;
    @Column
    private String accountType;
    @Column
    private String accountName;
    @Column
    private String balance;
}
