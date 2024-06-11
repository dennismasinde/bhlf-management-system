package io.dennismasinde.services;

import io.dennismasinde.entities.Menu;
import io.dennismasinde.entities.User;
import io.dennismasinde.exceptions.EntityNotFoundException;
import io.dennismasinde.repositories.MenuRepository;
import io.dennismasinde.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    @Transactional
    public Menu assignMenuToUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException("User not found with id " + userId));
        Menu menu = new Menu();
        menu.setUser(user);
        return menuRepository.save(menu);
    }
}
