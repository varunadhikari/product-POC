package com.product.mapper;

import com.product.entity.User;
import com.product.entity.UserDetail;
import com.product.model.UserDTO;
import com.product.model.UserDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailMapper {
    UserDetailMapper INSTANCE = Mappers.getMapper(UserDetailMapper.class);

    UserDetailDTO userDetailToUserDetailDTO(UserDetail user);
}
