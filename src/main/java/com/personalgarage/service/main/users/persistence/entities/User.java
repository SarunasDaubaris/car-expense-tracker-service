package com.personalgarage.service.main.users.persistence.entities;

import com.personalgarage.service.interfaces.main.users.constants.UserStateConst;
import com.personalgarage.service.interfaces.main.users.constants.UserTypeConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_state")
    @Enumerated(EnumType.ORDINAL)
    private UserStateConst userState;

    @Column(name = "user_type")
    @Enumerated(EnumType.ORDINAL)
    private UserTypeConst userType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserSetting> userSettings;
}