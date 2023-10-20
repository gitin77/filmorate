package com.example.filmorate.user.storage;

import com.example.filmorate.exception.EntityNotFoundException;
import com.example.filmorate.user.model.User;
import com.example.filmorate.util.Validator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Data
@Component
public class UserStorageImpl implements UserStorage {

    private Long idGen = 1L;

    private Map<Long, User> userMap = new HashMap<>();

    @Override
    public User addUser(User user) {
        Validator.validateUser(user);
        user.setId(idGen);
        userMap.put(idGen, user);
        idGen++;
        log.info("добавлен новый пользователь");
        return user;
    }

    @Override
    public User updateUser(User user) {
        Validator.validateUser(user);
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
            log.info("пользователь обновлен");
            return user;
        } else {
            log.info("ошибка при изменении пользователя");
            throw new EntityNotFoundException("не найден данный пользователь");
        }
    }

    @Override
    public List<User> getAllUsers() {
        log.info("список всех пользователей");
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(Long id) {
        log.info("получен пользователь по АйДи" + id);
        return userMap.get(id);
    }
}
