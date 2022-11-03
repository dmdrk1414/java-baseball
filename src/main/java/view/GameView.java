package view;

import controller.GameController;

public class GameView {

    final String MSG_FIRST = "숫자 야구 게임을 시작합니다.";
    final String MSG_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    final String MSG_THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    final String MSG_CHOICE_PLAY_MORE_GAMES = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void run() {
        GameController gameController = new GameController();
        while (true) {
            System.out.println(MSG_FIRST);

            // User에게 숫자를 입력 받는다.
            System.out.println(MSG_ENTER_NUMBER);
            gameController.callInputNumOfUser();

            // User의 숫자가 맞는지 확인
            if (gameController.isRightNumOfUser2Computer()) {
                System.out.println(gameController.getHintOfComputer());
            } else {
                System.out.println(gameController.getHintOfComputer());
            }

            // 게임이 계속되는지 확인
            if (gameController.isEndGame()) {
                System.out.println(MSG_THREE_STRIKE);
                System.out.println(MSG_CHOICE_PLAY_MORE_GAMES);
            }
        }
    }

}
