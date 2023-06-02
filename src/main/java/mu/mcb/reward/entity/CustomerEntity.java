package mu.mcb.reward.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Brume
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(updatable = false)
    private String customerId;
    private String title;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String preferredLanguage;
    private String gender;
    private String phoneNumber;
//    @OneToMany
//    private List<AccountEntity> accounts;


}
