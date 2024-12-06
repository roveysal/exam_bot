package org.example.event;

import org.example.user.User;

import java.util.List;

public interface EventService {
    void addEvent(Event event);
    void updateEvent(int id, String name);
    void deleteEvent();
    void registerUserToEvent(User user, Event event);

    List<Event> getEventByChatId(Long chatId);
}
