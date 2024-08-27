package bo.mibu.apptigo.services.impl;

import bo.mibu.apptigo.models.UserModel;
import bo.mibu.apptigo.repository.IUserRepository;
import bo.mibu.apptigo.services.IUserService;
import bo.mibu.apptigo.services.dto.UserRequestDto;
import bo.mibu.apptigo.services.dto.UserResponseDto;
import bo.mibu.apptigo.services.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<UserResponseDto> getUsers() {
        ArrayList<UserModel> all = (ArrayList<UserModel>) this.userRepository.findAll();
        ArrayList<UserResponseDto> result = this.userMapper.mapToUserModelList(all);
        return result;
    }

    @Override
    public UserResponseDto saveUser(UserRequestDto user) {
        UserModel userToSave = this.userMapper.mapToUserModel(user);

        UserModel save = this.userRepository.save(userToSave);

        UserResponseDto responseDto = this.userMapper.mapToUserResponse(save);

        return responseDto;
    }

    @Override
    public UserResponseDto getById(Long id) {
        UserModel one = this.userRepository.findOne(id);
        UserResponseDto responseDto = this.userMapper.mapToUserResponse(one);

        return responseDto;
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(UserRequestDto request, Long id) {
        UserModel user = this.userRepository.findOne(id);

        this.userMapper.updateUserModel(user, request);

        UserModel save = this.userRepository.save(user);

        UserResponseDto responseDto = this.userMapper.mapToUserResponse(save);

        return responseDto;
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            this.userRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
