package bo.mibu.apptigo.services.impl;

import bo.mibu.apptigo.models.UserModel;
import bo.mibu.apptigo.repository.IUserRepository;
import bo.mibu.apptigo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) this.userRepository.findAll();
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserModel getById(Long id) {
        return this.userRepository.findOne(id);
    }

    @Transactional
    @Override
    public UserModel updateUser(UserModel request, Long id) {
        UserModel user = this.userRepository.findOne(id);
        user.setFullname(request.getFullname());
        user.setEmail(request.getEmail());
        user.setPriority(request.getPriority());

        this.userRepository.save(user);

        return user;
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
