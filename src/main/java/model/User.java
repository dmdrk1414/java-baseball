package model;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    public int numSelecUser;

    public User() {
    }

    public void choiceNum() {
        // TODO : 숫자의 검증
        // TODO : 숫자인지?
        // TODO : 길이가 3개인지
        // TODO : 문자열인지 or 정수인지
    }

    public String getString() {
        String strInput = "";
        strInput = readLine();
        return strInput;
    }
}
