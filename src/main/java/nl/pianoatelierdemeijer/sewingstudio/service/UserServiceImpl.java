package nl.pianoatelierdemeijer.sewingstudio.service;

import nl.pianoatelierdemeijer.sewingstudio.exception.DatabaseErrorException;
import nl.pianoatelierdemeijer.sewingstudio.exception.RecordNotFoundException;
import nl.pianoatelierdemeijer.sewingstudio.model.User;
import nl.pianoatelierdemeijer.sewingstudio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        if(userRepository.existsById(id)){
            return userRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public void deleteUser(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public long saveUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    @Override
    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)){
            try {
                User existingUser = userRepository.findById(id).orElse(null);
                assert existingUser != null;
                existingUser.setFirstName(user.getFirstName());
                existingUser.setLastName(user.getLastName());
                existingUser.setEmail(user.getEmail());
                existingUser.setPhoneNumber(user.getPhoneNumber());
                existingUser.setBankAccount(user.getBankAccount());
            }
            catch (Exception exception){
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public User getUserByLastName(String lastName) {
        try{
            return userRepository.findByLastNameIgnoreCase(lastName);
        }
        catch (Exception exception){
            throw new RecordNotFoundException();
        }

    }


}
