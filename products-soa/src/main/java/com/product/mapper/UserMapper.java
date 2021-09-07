package com.product.mapper;

import com.product.entity.User;
import com.product.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO userToUserDTO(User user);
    public abstract User userDTOToUser(UserDTO dto);

    public abstract List<UserDTO> userListToUserDTO(List<User> user);
    public abstract List<User> userDTOListToUser(List<UserDTO> dto);
}
