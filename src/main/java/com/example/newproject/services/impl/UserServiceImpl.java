package com.example.newproject.services.impl;

import com.example.newproject.exceptions.EntityDuplicationException;
import com.example.newproject.exceptions.InvalidParamException;
import com.example.newproject.exceptions.RoleConflictException;
import com.example.newproject.models.User;
import com.example.newproject.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.example.newproject.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    public static final String ID_MUST_BE_POSITIVE = "Id must be positive.";
    public static final String USER_IS_ALREADY_ADMIN = "This user is already admin";
    public static final String USER_IS_NOT_ADMIN = "This user is not an admin.";
    public static final String USER_IS_ALREADY_BLOCKED = "This user is already blocked";
    public static final String USER_IS_NOT_BLOCKED = "This user is not blocked.";

    public static final String USER_WITH_EMAIL_S_ALREADY_EXISTS = "Email already registered";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(long id) {
        validateId(id);
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User", id));
    }

    @Override
    public User create(User user) {
        if (userRepository.findFirstByEmail(user.getEmail()).isPresent()) {
            throw new EntityDuplicationException(String.format(USER_WITH_EMAIL_S_ALREADY_EXISTS, user.getEmail()));
        }
        user.setAdmin(true);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(String username) {
        User deletedUser = userRepository.findFirstByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException("User", username));

        userRepository.deleteById(deletedUser.getId());
        return deletedUser;
    }

    @Override
    public void makeAdmin(long id) {
        User userToAdmin = getById(id);
        if (userIsAdmin(userToAdmin)) {
            throw new RoleConflictException(USER_IS_ALREADY_ADMIN);
        }


        userToAdmin.setAdmin(true);

        userRepository.save(userToAdmin);
    }

    @Override
    public void makeNotAdmin(long id) {
        User userToAdmin = getById(id);
        if (!userIsAdmin(userToAdmin)) {
            throw new RoleConflictException(USER_IS_NOT_ADMIN);
        }


        userToAdmin.setAdmin(false);

        userRepository.save(userToAdmin);
    }

    @Override
    public void makeBlocked(long id) {
        User userToBlock = getById(id);
        if (userIsBlocked(userToBlock)) {
            throw new RoleConflictException(USER_IS_ALREADY_BLOCKED);
        }

        userToBlock.setBlocked(true);

        userRepository.save(userToBlock);
    }


    @Override
    public void makeUnblocked(long id) {
        User userToUnblock = getById(id);
        if (!userIsBlocked(userToUnblock)) {
            throw new RoleConflictException(USER_IS_NOT_ADMIN);
        }


        userToUnblock.setBlocked(false);

        userRepository.save(userToUnblock);
    }

    private void validateId(Long id) {
        if (id != null && id <= 0) {
            throw new InvalidParamException(ID_MUST_BE_POSITIVE);
        }
    }

    public static boolean userIsAdmin(User user) {
        return user.isAdmin();
    }

    public static boolean userIsBlocked(User user) {
        return user.isBlocked();
    }
}
