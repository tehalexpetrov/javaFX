package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private static final int MAX_RANGE = 9;
    private static final int MAX_COUNT = 3;
    public int multiple = (int) Math.round(Math.random() * MAX_RANGE);
    int count = 0;


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


               try {
                   String message = userAnswer.getText();
                   userAnswer.clear();

                   int number = Integer.parseInt(message);

                    do {
                        if (number == multiple) {
                            var alert = new Alert(Alert.AlertType.INFORMATION, "Поздравляю с победой");
                            alert.setTitle("ВЫ ВЫЙГРАЛИ!");
                            alert.show();
                            break;

                        } else if (number > MAX_RANGE) {
                            var alert = new Alert(Alert.AlertType.WARNING, "Введите числа от 0 до " + MAX_RANGE);
                            alert.setTitle("Превышение диапазона чисел");
                            alert.show();
                            continue;

                        } else if (number > multiple) {

                            var alert = new Alert(Alert.AlertType.INFORMATION, "Число больше ответа");
                            alert.setTitle("Информация");
                            alert.show();
                            continue;

                        } else if (number < multiple) {

                            var alert = new Alert(Alert.AlertType.INFORMATION, "Число меньше ответа");
                            alert.setTitle("Информация");
                            alert.show();
                            continue;

                        }

                    } while (number < 0 && number > MAX_RANGE);

               } catch (NumberFormatException e) {
                   e.printStackTrace();
                   var alert = new Alert(Alert.AlertType.ERROR, "Введите число!");

                   alert.setTitle("Ошибка ввода данных");
                   alert.show();
               }
   }

    @FXML
    private Label textAnswerCheat;

    @FXML
    void cheatAnswer() {
        maxCountTry();
        textAnswerCheat.setText(String.valueOf(multiple));

    }

    @FXML
    void closeButton() {
        System.exit(0);
    }

    public static void maxCountTry(){

                var alert = new Alert(Alert.AlertType.WARNING, "Читер ты!");
                alert.setTitle("Информация");
                alert.show();
    }
}
