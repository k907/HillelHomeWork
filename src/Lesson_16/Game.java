package Lesson_16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
Игра "Камень / Ножницы / Бумага"

                Правила:

                Пользователь выбирает количество раундов.
                Затем совершает ход, набрав в консоли один из вариантов:
                К (Камень) | Н (Ножницы) | Б (Бумага)
                Программа совершает ответный ход.

                Победитель раунда определяется по следующим правилам:
                - Камень побеждает ножницы
                - Ножницы побеждают бумагу
                - Бумага побеждает камень
                Если игроки сделали одинаковый выбор, засчитывается ничья и раунд переигрывается.

                Победитель игры определяется по количеству выигранных раундов.
                Для завершения игры наберите "В" (Выйти)

 start()  -  основной метод игры, запускает все процессы

 1. вывести правила в консоль showRules()
 2. предлагаем пользователю указать количество раундов
 3. ждать ответ пользователя setNumRound(userResponse)
 4. проверять наличие команды от пользователя на завершение игры
 5. после получения количества раундов, меняем статус игры на "waitUserMove"
 6. предлагаем пользователю совершить ход
 7. обрабатываем ответ пользователя и завершаем игру если сыграны все раунды
 8. записываем результат игры в файл, если сыгран минимум один раунд

 Для вывода цветного текста в консоль испозуется enum Colors
*/
public class Game {

    // файл для записи результата игр
    private final Path fileResult = Paths.get("resources\\result.txt");

    // форматирование времени, используется для записи в лог
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // статус игры - waitNumRound | waitUserMove
    private String statusGame = "waitNumRound";

    // количество раундов игры
    private int numRoundGame;

    // количество выигранных раундов пользователя
    private int scoreUser;

    // количество выигранных раундов программы
    private int scoreProgram;

    // количество прошедших игр
    private int counterRound;

    // текущий ход пользователя - К| Н | Б
    private String currMoveUser;

    // текущий ход программы - К | Н | Б
    private String currMoveProgram;

    //----------------------------------------------
    // основной метод игры, запускает все процессы
    public void start() {

        // вывести правила игры в консоль
        showRules();

        printColor("Укажите количество раундов:", Colors.YELLOW);

        Scanner sc = new Scanner(System.in);
        while (true) {

            // получает ввод пользователя из консоли
            String userResponse = sc.nextLine().toLowerCase().trim();

            // завершить игру если пользователь ввел команду "В" (выйти)
            if (endGame(userResponse)) {
                break;
            }

            // ждем пока пользователе укажет количество раундов игры
            if (statusGame.equals("waitNumRound")) {

                // изменит статус игры на "waitUserMove"
                setNumRound(userResponse);
                continue;
            }

            // ждет ход пользователя и обрабатывает результат
            if (statusGame.equals("waitUserMove") && !play(userResponse)) {

                // значит ответ пользователя не валидный
                continue;
            }

            // завершить игру если отыграли все раунды
            if (endGame(userResponse)) {
                break;
            }

            printColor("[Раунд " + (counterRound + 1) + "] Сделайте ход: ", Colors.YELLOW);
        }
    }

    //----------------------------------------------
    /*
      - проверить валидность ответа пользователя
      - сделать ответный ход
      - определить победителя раунда

      return false если не удалось распознать ответ пользователя (нет совпадений с к | н | б)
    */
    private boolean play(String userResponse) {

        if (getMoveUser(userResponse)) {

            currMoveProgram = getMoveProgram();
            printColor("Ход программы: " + currMoveProgram, Colors.YELLOW);

            // определить победителя раунда
            getWinnerRound();

            return true;
        }

        return false;
    }

    //----------------------------------------------
    /*
     - определить победителя
     - обновить счет scoreUser / scoreProgram;
     - инкрементировать счетчик раундов
     - вывести результат в консоль
    */
    private void getWinnerRound() {

        try {
            int UserIsWinner = compareMoves(currMoveUser, currMoveProgram);
            String mess = "Результат раунда: ";
            if (UserIsWinner == 1) {
                scoreUser++;
                printColor(mess + "Вы выиграли!", Colors.YELLOW);
            } else if (UserIsWinner == 0) {
                scoreProgram++;
                printColor(mess + "Вы проиграли!", Colors.RED);
            } else {
                printColor(mess + "Ничья", Colors.YELLOW);

                // если ничья, counterRound не увеличивать
                return;
            }

            counterRound++;
            printColor("֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍\n", Colors.RED);

        } catch (IllegalStateException ex) {
            printColor(ex.getMessage(), Colors.RED);
        }
    }

    //----------------------------------------------
    /*
     Сравнить ход пользователя и программы, определить победителя
     return  1  user победил | 0  user проиграл | -1 ничья
    */
    private int compareMoves(String userMove, String programMove) throws IllegalStateException {

        if (userMove.equals(programMove)) {
            return -1;
        }

        return switch (userMove) {
            case "Камень" -> switch (programMove) {
                case "Ножницы" -> 1;
                case "Бумага" -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + programMove);
            };
            case "Ножницы" -> switch (programMove) {
                case "Камень" -> 0;
                case "Бумага" -> 1;
                default -> throw new IllegalStateException("Unexpected value: " + programMove);
            };
            case "Бумага" -> switch (programMove) {
                case "Камень" -> 1;
                case "Ножницы" -> 0;
                default -> throw new IllegalStateException("Unexpected value: " + programMove);
            };
            default -> throw new IllegalStateException("Unexpected value: " + userMove);
        };
    }

    //----------------------------------------------
    // сгенерировать случайное значение - Камень | Ножницы | Бумага 
    private String getMoveProgram() {

        return switch ((int) (Math.random() * 3)) {
            case 0 -> "Камень";
            case 1 -> "Ножницы";
            default -> "Бумага";
        };
    }

    //----------------------------------------------
    // получить выбор пользоваеля - к | н | б
    private boolean getMoveUser(String userResponse) {

        currMoveUser = switch (userResponse) {
            case "к" -> "Камень";
            case "н" -> "Ножницы";
            case "б" -> "Бумага";
            default -> "";
        };

        if (currMoveUser.isEmpty()) {
            printColor("Выберите один из вариантов - К (Камень) | Н (Ножницы) | Б (Бумага)", Colors.RED);
            printColor("Или завершите игру командой \"В\" (Выйти)", Colors.RED);
            return false;
        }

        printColor("Ваш ход: " + currMoveUser, Colors.YELLOW);
        return true;
    }

    //----------------------------------------------
    // изменит статус игры на statusGame = "waitUserMove", если пользователь указал кол. раундов
    private void setNumRound(String userResponse) {

        if (!isNumber(userResponse)) {
            printColor("\"" + userResponse + "\" не является числом", Colors.RED);
            return;
        }

        int numRound = Integer.parseInt(userResponse);

        if (numRound == 0) {
            printColor(" Количество раундов должно быть больше нуля", Colors.RED);
            return;
        }

        numRoundGame = numRound;
        statusGame = "waitUserMove";
        printColor("Количество раундов: " + numRoundGame, Colors.YELLOW);
        printColor("֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍\n", Colors.RED);
        printColor("[Раунд " + (counterRound + 1) + "] Сделайте ход: ", Colors.YELLOW);
    }

    //----------------------------------------------
    // Проверяет состоит ли строка из числовых значений
    public boolean isNumber(String str) {

        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    //--------------------------------------
    // вывеси правила игры в консоль
    private void showRules() {

        String rules = """
                                      Правила игры “Камень Ножницы Бумага”
                                                            
                Пользователь выбирает количество раундов. 
                Затем совершает ход, набрав в консоли один из вариантов:
                К (Камень) | Н (Ножницы) | Б (Бумага)
                Программа совершает ответный ход.
                                       
                Победитель раунда определяется по следующим правилам:
                - Камень побеждает ножницы
                - Ножницы побеждают бумагу
                - Бумага побеждает камень
                Если игроки сделали одинаковый выбор, засчитывается ничья и раунд переигрывается.
                                
                Победитель игры определяется по количеству выигранных раундов.                   
                Для завершения игры наберите В (Выйти)             
                """;

        printColor(rules, Colors.BLUE);
        printColor("֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍\n", Colors.RED);
    }

    //--------------------------------------
    /*
      завершит игру если получена команда "В" или отыграли все раунды
      сохранит результат в файл если был сыгран минимум один раунд
    */
    private boolean endGame(String userResponse) {

        if (userResponse.equals("в") || (numRoundGame != 0 && counterRound >= numRoundGame)) {

            String mess;
            if ((scoreUser + scoreProgram) > 0) {
                mess = "\n ---- Игра завершена ----\n";
                mess += "Результат игры: " + switch (Integer.compare(scoreUser, scoreProgram)) {
                    case -1 -> "Вы проиграли!\n";
                    case 0 -> "Ничья\n";
                    case 1 -> "Вы победили!\n";
                    default -> "Результ игры неизвестен\n";
                };

                mess += "Выигранных раундов: " + scoreUser + "\n";
                mess += "Проигранных раундов: " + scoreProgram + "\n";
                mess += "֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍ ֍\n\n";

                // сохранить результат игры в файл
                writeMessageToFile(mess);

            } else {
                mess = " ---- Игра завершена ----";
            }

            printColor(mess, Colors.RED);
            return true;
        }

        return false;
    }

    //--------------------------------------
    // записать текст в файл
    private void writeMessageToFile(String mess) {

        try {

            String title = "[" + formatter.format(new Date()) + "] ";
            mess = title + mess;

            if (Files.exists(fileResult)) {
                Files.write(fileResult, mess.getBytes(), StandardOpenOption.APPEND);
            } else {
                Files.write(fileResult, mess.getBytes(), StandardOpenOption.CREATE);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //--------------------------------------
    // вывод цветного текста в консль 
    public static void printColor(String mess, Colors color) {
        System.out.println(color.getCodeColor() + mess + "\u001B[0m");
    }
    //--------------------------------------

}