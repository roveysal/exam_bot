package org.example.user;
import lombok.Getter;
import org.example.MyBot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.telegram.telegrambots.meta.api.objects.Message;

public class UserAuthService {

    @Getter
    private List<User> userList = new ArrayList<>();
    private MyBot myBot;

    public UserAuthService(MyBot myBot) {
        this.myBot = myBot;
    }

    public void manage(Message message) {
        Long chatId = message.getChatId();
        User userByChatId = getUserByChatId(chatId);
        if (userByChatId == null) {
            registerUser(chatId);

        }
    }

        public User getUserByChatId (Long chatId){
            Optional<User> optionalUser = userList.stream()
                    .filter(u -> u.getChatId() == chatId)
                    .findFirst();

            if (optionalUser.isEmpty()) {
                return registerUser(chatId);
            }
            return optionalUser.get();
        }

        public User registerUser (Long chatId){
            User user = User.builder()
                    .chatId(chatId)
                    .role(Role.USER)
                    .build();
            userList.add(user);
            return user;
        }


    }