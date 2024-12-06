package org.example.event;

import org.example.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventServiceImpl implements EventService {

    List<Event> eventList = new ArrayList<>();
    Event event = new Event();
    List<User> userList;

    public EventServiceImpl(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void addEvent(Event event) {
        eventList.add(event);

    }

    @Override
    public void updateEvent(int id, String name) {
        for (Event event : eventList) {
            if (event.getId() == id) {
                event.setTitle(name);
            }
        }

    }


    @Override
    public void deleteEvent() {
        for (Event event : eventList) {
            eventList.remove(event);
        }

    }

    @Override
    public void registerUserToEvent(User user, Event event) {
        user.setEventList(event);
    }

    @Override
    public List<Event> getEventByChatId(Long chatId) {
        return userList.stream()
                .filter(u -> Objects.equals(u.getChatId(), chatId))
                .findFirst()
                .map(User::getEventList).orElse(new ArrayList<>());
    }
}
