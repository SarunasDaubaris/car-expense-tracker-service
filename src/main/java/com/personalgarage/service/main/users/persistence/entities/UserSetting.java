package com.personalgarage.service.main.users.persistence.entities;

import com.personalgarage.service.interfaces.main.users.constants.UserSettingTypeConst;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user_settings")
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_setting_id")
    private Long id;

    @Column(name = "user_setting_type")
    private UserSettingTypeConst userSettingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "setting_key")
    private String settingKey;

    @Column(name = "setting_value")
    private String settingValue;
}
