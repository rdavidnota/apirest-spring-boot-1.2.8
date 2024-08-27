package bo.mibu.apptigo.services;

import bo.mibu.apptigo.models.UserModel;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<UserModel> getUsers();

    UserModel saveUser(UserModel user);

    UserModel getById(Long id);

    UserModel updateUser(UserModel request, Long id);

    Boolean deleteUser(Long id);
}
