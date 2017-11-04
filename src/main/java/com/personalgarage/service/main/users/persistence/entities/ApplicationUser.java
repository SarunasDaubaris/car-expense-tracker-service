package com.personalgarage.service.main.users.persistence.entities;

import com.personalgarage.service.main.users.interfaces.constants.UserStateConst;
import com.personalgarage.service.main.users.interfaces.constants.UserTypeConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime",
            parameters = {@Parameter(name = "databaseZone", value = "UTC"),
                    @Parameter(name = "javaZone", value = "UTC")})
    private DateTime createdDate;

    @Column(name = "user_state")
    private Short userStateId;

    @Column(name = "user_type")
    private Short userTypeId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserSetting> userSettings;

    public UserTypeConst getUserType() {
        return UserTypeConst.forId(userTypeId);
    }

    public void setUserType(UserTypeConst userType) {
        this.userTypeId = userType.getId();
    }

    public UserStateConst getUserState() {
        return UserStateConst.forId(userStateId);
    }

    public void setUserState(UserStateConst userState) {
        this.userStateId = userState.getId();
    }
}