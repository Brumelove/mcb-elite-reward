package mu.mcb.reward.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Brume
 */
@Getter
@Setter
public class Customer {
    @JsonProperty("CustomerId")
    private String customerId;
    @JsonProperty("CustomerStatus")
    private String customerStatus;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("DateOfBirth")
    private String dateOfBirth;
    private String preferredLanguage;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("StreetName")
    private String streetName;
    @JsonProperty("City")
    private String city;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("JobTitle")
    private String jobTitle;
    @JsonProperty("Salary")
    private String salary;
    @JsonProperty("EmployerName")
    private String employerName;
    @JsonProperty("LastKycUpdated")
    private String lastKycUpdated;
}
