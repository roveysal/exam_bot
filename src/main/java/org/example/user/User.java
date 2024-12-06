package org.example.user;

import lombok.*;
import org.example.event.Event;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    private Long chatId;
    private String name;
    private Role role;
    private List<Event> eventList;


    public void setEventList(Event event) {
        this.eventList.add(event);
    }

}
