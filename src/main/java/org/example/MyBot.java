package org.example;

import lombok.SneakyThrows;
import org.example.event.Event;
import org.example.event.EventService;
import org.example.event.EventServiceImpl;
import org.example.user.Role;
import org.example.user.User;
import org.example.user.UserAuthService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    private UserAuthService userService;
    private final long ADMIN_ID=6662050382l;
    boolean key = true;

    public MyBot() {
        userService = new UserAuthService(this);
    }
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        EventService eventService = new EventServiceImpl(userService.getUserList());

        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            User user = userService.getUserByChatId(chatId);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);

            if (user.getRole().equals(Role.ADMIN)) {
                //logika

                return;
            }

            switch (text) {

                case "/start" -> sendMessage.setText("Assalomu alaykum hurmatli foydalanuvchi. \n" +
                        "Botdan to'liq foydalanish uchun /register bo'limidan foydalanib ro'yxardan o'ting.");
                case "/register" -> {
                    user.setChatId(chatId);
                    user.setName(update.getMessage().getFrom().getFirstName());

                    sendMessage.setText("Tabriklaymiz siz muvaffaqiyatli qo'yxatdan o'tdingiz\n" +
                            "/events komandasi orqali mavjud tadbirlarni ko'rishingiz mumkin");
                }
                case "/events" -> {
                    List<Event> eventByChatId = eventService.getEventByChatId(chatId);
                    if (eventByChatId.isEmpty()) {

                        sendMessage.setText("hali birorta tadbirga yozilmagansiz!!");
                    } else {
                        sendMessage.setText(eventByChatId.toString());
                    }

                    execute(sendMessage);
                }
                case "/my_events" -> {
                    sendMessage.setText(user.getEventList().toString());
                }
            }
            execute(sendMessage);
        }
    }


private void sendMessage(String chatId, String text) {
    SendMessage message = new SendMessage();
    message.setChatId(chatId);
    message.setText(text);
    try {
        execute(message);
    } catch (TelegramApiException e) {
        e.printStackTrace();
    }
}


@Override
    public String getBotUsername() {
        return "@my_helper_robot";
    }

    @Override
    public String getBotToken() {
        return "6963630194:AAENX9-A9Xvmn4vnKbVYLEAo_i1FmZkZ8kw";
    }

}
