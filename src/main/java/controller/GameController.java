package controller;

import model.Computer;
import model.User;

public class GameController {

    User user;
    Computer computer;

    public GameController(User user, Computer computer) {
        this.user = new User();
        this.computer = new Computer();
    }

    public void callInputNumOfUser() {
        this.user.inputNumOfUser();
    }

    public boolean isRightNumOfUser2Computer() {
        int numInputOfUser = user.getNumSelecUser();
        // TODO : 1. 컴퓨터에게 값을준다.
        if (computer.isRealRightNumOfUser(numInputOfUser)) {
            // 스트라이크와 볼이 있다면
            return true;
        } else {
            // 낫싱만 있다면
            return true;
        }
    }

}
