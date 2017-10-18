package com.personalgarage.service.main.users.application.components;

import com.personalgarage.service.interfaces.main.users.dtos.UserDTO;
import com.personalgarage.service.interfaces.main.users.dtos.UserSettingDTO;
import com.personalgarage.service.main.users.persistence.entities.User;
import com.personalgarage.service.main.users.persistence.entities.UserSetting;
import lombok.NoArgsConstructor;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class UserServiceModelMapper {

    private MapperFactory mapperFactory;

    @PostConstruct
    private void configure() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserDTO.class)
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
        mapperFactory.classMap(UserSetting.class, UserSettingDTO.class)
                .field("user.id", "userId")
                .mapNulls(false)
                .mapNullsInReverse(false)
                .byDefault()
                .register();
    }

    public <S, D> D mapByClass(S source, Class<D> dest) {
        return mapperFactory.getMapperFacade().map(source, dest);
    }

    public <S, D> List<D> mapToListByClass(List<S> source, Class<D> dest) {
        if (source == null) {
            return null;
        }
        return source.stream().map(s -> mapperFactory.getMapperFacade().map(s, dest)).collect(Collectors.toList());
    }

    public <S, D> void mapByObject(S source, D dest) {
        mapperFactory.getMapperFacade().map(source, dest);
    }
}