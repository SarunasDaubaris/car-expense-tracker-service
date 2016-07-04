package com.personalgarage.service.services;

import com.personalgarage.service.base.services.DTOBaseService;
import com.personalgarage.service.dto.UsersDTO;
import com.personalgarage.service.entities.Users;
import com.personalgarage.service.repositories.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService extends DTOBaseService<UsersDTO, Users> {

    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDTO get(String id) {
        return convertToDto(usersRepository.findOne(id));
    }

    @Override
    public UsersDTO insert(UsersDTO usersDTO) {
        return convertToDto(usersRepository.insert(convertToEntity(usersDTO)));
    }

    @Override
    public UsersDTO update(UsersDTO usersDTO) {
        return convertToDto(usersRepository.save(convertToEntity(usersDTO)));
    }

    @Override
    public void delete(String id) {
        usersRepository.delete(id);
    }

    @Override
    protected UsersDTO convertToDto(Users users) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(users, UsersDTO.class);
    }

    @Override
    protected Users convertToEntity(UsersDTO usersDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usersDTO, Users.class);
    }
}