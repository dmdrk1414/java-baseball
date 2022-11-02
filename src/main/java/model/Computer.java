package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    final private static int NUM_START_RANGE_RAM = 1;
    final private static int NUM_END_RANGE_RAM = 9;
    final private List<Integer> numThreeRanOfComputerList;

    public Computer() {
        this.numThreeRanOfComputerList = new ArrayList<>();
    }

    public void creatRanNumOfComputerList() {
        while (numThreeRanOfComputerList.size() < 3) {
            int randomNumber = getOneRanNumAnInt();
            if (!numThreeRanOfComputerList.contains(randomNumber)) {
                numThreeRanOfComputerList.add(randomNumber);
            }
        }
    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }

    // 컴퓨터야 이 3개의 숫자가 너의 랜덤리스트와 맞니?
    // 컴퓨터의 숫자와 매개변수의 숫자를 비교합니다.
    public Boolean isRightThreeNumOfComputer(int numOfCompare) {
        // TODO: 1. numOfCompare를 3개의 숫자로 분리한다.
        // TODO: 2. 각숫자가 컴퓨터 랜덤 리스트에 포함하는가 안하는가 확인
        // TODO: 2.1 if 포함한다면?
        // TODO: 2.1.1 스트라이크 볼 체크
        // TODO: 2.2 else 포함안한다면? => 낫싱
        return true;
    }

    public List<Integer> getNumThreeRanOfComputerList() {
        return numThreeRanOfComputerList;
    }
}
