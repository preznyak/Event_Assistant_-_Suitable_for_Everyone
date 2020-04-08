package hu.charmanthere.ease.service.converter;

import hu.charmanthere.ease.controller.model.address.AddressModel;
import hu.charmanthere.ease.dao.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressModelConverter {
    private ModelMapper modelMapper;

    @Autowired
    public AddressModelConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Address fromAddressModel(AddressModel addressModel){
        return modelMapper.map(addressModel,Address.class);
    }

    public AddressModel fromAddress(Address address){
        return modelMapper.map(address, AddressModel.class);
    }
}
