package hu.charmanthere.ease.service.converter;

import hu.charmanthere.ease.controller.model.user.RegisterUserModel;
import hu.charmanthere.ease.controller.model.user.UserListModel;
import hu.charmanthere.ease.controller.model.user.UserModel;
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

    public User fromUserModel(UserModel userModel){
        return modelMapper.map(userModel, User.class);
    }

    public User fromRegisterUserModel(RegisterUserModel registerUserModel) {
        return modelMapper.map(registerUserModel, User.class);
    }

    public UserModel fromUserToUserModel(User user){
        return modelMapper.map(user, UserModel.class);
    }

    public UserListModel fromUserToUserListModel(User user){
        return modelMapper.map(user, UserListModel.class);
    }
}

