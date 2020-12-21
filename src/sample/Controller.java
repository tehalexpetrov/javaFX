package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.*;

public class Controller {

    public int maxCount = 3;
    public int count = 0;
    public int multiple = (int) Math.round(Math.random() * 9);
    private String winer = "Поздравляю! Вы угадали число";
    private String messageCount = "У Вас осталось ";

    public void initialize(){

    }

    @FXML
    private Label answerLabel;

    @FXML
    private Label textAnswer;

    @FXML
    private TextField userAnswer;



   @FXML
    void doUserAction() {

       String message = userAnswer.getText();
       userAnswer.clear();

       int numberTwo = 0;
       try {
           numberTwo = Integer.parseInt(message);
           for (int i = 0; i < maxCount; i++) {
               count++;
               if (numberTwo == multiple) {
                   textAnswer.setText(String.valueOf(winer));
                   break;

               } else if (numberTwo >= maxCount) {
                   var alertTwo = new  Alert(Alert.AlertType.CONFIRMATION, "Число больше ответа");
                   textAnswer.setText(String.valueOf("К сожалению, Вы проиграли"));

               } else if (numberTwo < multiple) {

//                           System.out.println("Число меньше ответа");

               } else if (numberTwo > multiple) {

//                           System.out.println("Число больше ответа");
               }

               textAnswer.setText(String.valueOf(messageCount + (maxCount - count) + " попыток"));
           }
       } catch (NumberFormatException e) {
           e.printStackTrace();
           var alert = new Alert(Alert.AlertType.ERROR, "Введите число!");
       }

       if (!message.isBlank()) {
               try {
                   int number = Integer.parseInt(message);
                   answerLabel.setText(String.valueOf(multiple));
               } catch (NumberFormatException e) {
                   e.printStackTrace();
                   var alert = new Alert(Alert.AlertType.ERROR, "Введите число!");

                   alert.setTitle("Ошибка ввода данных");
                   alert.show();
               }
           }
       }
}
