package org.example.button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class BotButtonService {
    void inlineKeyboard() {

        InlineKeyboardButton btn1 = InlineKeyboardButton.builder()
                .text("salom")
                .callbackData("1")
                .build();

        InlineKeyboardButton btn2 = InlineKeyboardButton.builder()
                .text("salom")
                .callbackData("2")
                .build();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(btn1);
        row1.add(btn2);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        markup.setKeyboard(rows);


    }
    public static ReplyKeyboard replyKeyboard(){
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();


        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCCC Add event");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDD04 Update events");

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("\uD83D\uDDD1 Delete event");
        
        row1.add(button1);
        row2.add(button2);
        row3.add(button3);
        
        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);

        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        return null;
    }

    void startButtons(){
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCF2 Kontakt bilan bo'lishish");
        button1.setRequestContact(true);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDD79 Joylashuvni yuborish");
        button2.setRequestLocation(true);
    }
}
