package ru.job4j.condition;

/**
 *@author Dmitriy Kostyanetsky (onlywarinfarfuture@gmail.com)
 *@version 1
 *@since 23.03.18
 */
public class DummyBot {
    /**
     * Бот, отвечающий на вопросы
     * @param question Вопрос от клиента
     * @return Ответ
     */
    public String answer(String question) {
        String rs1 = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rs1 = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
                rs1 = "До скорой встречи.";
            }
            return rs1;
        }
    }