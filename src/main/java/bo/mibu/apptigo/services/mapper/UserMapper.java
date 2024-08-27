package bo.mibu.apptigo.services.mapper;

import bo.mibu.apptigo.models.UserModel;
import bo.mibu.apptigo.services.dto.UserRequestDto;
import bo.mibu.apptigo.services.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel mapToUserModel(UserRequestDto user);

    UserResponseDto mapToUserResponse(UserModel user);

    UserModel updateUserModel(@MappingTarget UserModel userModel, UserRequestDto user);

    ArrayList<UserResponseDto> mapToUserModelList(ArrayList<UserModel> all);
}
