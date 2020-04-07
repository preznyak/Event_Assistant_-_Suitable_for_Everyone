package hu.charmanthere.ease.service.converter;

import hu.charmanthere.ease.controller.model.UserModel;
import hu.charmanthere.ease.dao.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserModelConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public UserModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User from(UserModel userModel){
        return modelMapper.map(userModel, User.class);
    }
}

