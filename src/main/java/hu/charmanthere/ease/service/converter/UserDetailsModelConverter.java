package hu.charmanthere.ease.service.converter;

import hu.charmanthere.ease.controller.model.userdetails.UserDetailsModel;
import hu.charmanthere.ease.dao.entity.UserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsModelConverter {
    private ModelMapper modelMapper;

    @Autowired
    public UserDetailsModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDetails fromUserDetailsModel(UserDetailsModel userDetailsModel){
        return modelMapper.map(userDetailsModel,UserDetails.class);
    }

    public UserDetailsModel fromUserDetails(UserDetails userDetails){
        return modelMapper.map(userDetails, UserDetailsModel.class);
    }
}
