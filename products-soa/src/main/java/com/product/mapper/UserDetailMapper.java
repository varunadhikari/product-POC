package com.product.mapper;

import com.product.entity.User;
import com.product.entity.UserDetail;
import com.product.model.UserDTO;
import com.product.model.UserDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserDetailMapper {
    public static final UserDetailMapper INSTANCE = Mappers.getMapper(UserDetailMapper.class);

   public abstract UserDetailDTO userDetailToUserDetailDTO(UserDetail user);
   public abstract UserDetail userDetailDTOToUserDetail(UserDetailDTO user);

}
