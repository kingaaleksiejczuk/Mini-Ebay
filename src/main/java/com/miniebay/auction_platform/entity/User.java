package com.miniebay.auction_platform.entity;
import com.miniebay.auction_platform.validator.UniqueEmail;
import com.miniebay.auction_platform.validator.UserRegisterValidationGroup;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    @Email(groups = UserRegisterValidationGroup.class)
    @UniqueEmail(groups = UserRegisterValidationGroup.class)
    private String email;

    @Size(min=3, max=20,
            message="Username must be between 3 and 20 characters long.")
    @Column(name = "username")
    private String username;

    @Size(min = 6,  message = "password must be at least 6 characters")
    @Column(name = "password")
    private String password;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column(name = "user_details")
    private String details;

    @Column (name = "balance")
    private double balance;

    private Date joined;

    @Transient
    private int logged;


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Bid> bidDetails;

    @OneToMany
    private Set<Message> received;

    @OneToMany
    private Set<Message> sent;

}
