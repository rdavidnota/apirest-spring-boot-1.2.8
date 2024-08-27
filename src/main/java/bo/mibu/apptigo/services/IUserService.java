package bo.mibu.apptigo.services;

import bo.mibu.apptigo.models.UserModel;
import bo.mibu.apptigo.services.dto.UserRequestDto;
import bo.mibu.apptigo.services.dto.UserResponseDto;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<UserResponseDto> getUsers();

    UserResponseDto saveUser(UserRequestDto user);

    UserResponseDto getById(Long id);

    UserResponseDto updateUser(UserRequestDto request, Long id);

    Boolean deleteUser(Long id);
}
