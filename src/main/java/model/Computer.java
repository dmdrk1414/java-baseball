package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Computer {


    final private static int NUM_START_RANGE_RAM = 1;
    final private static int NUM_END_RANGE_RAM = 9;
    final private static String NOT_TING_ANSWER = "낫싱";
    final private static int COUNT_ZERO = 0;

    public List<Integer> numThreeRanOfComputerList;

    private int cntStrike;
    private int cntBall;

    public Computer() {
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    public void initComputer() {
        this.creatRanNumOfComputerList();

        while (!isNumOfComputerIndividually()) {
            this.creatRanNumOfComputerList();
        }
    }

    private void creatRanNumOfComputerList() {
        this.numThreeRanOfComputerList = new ArrayList<>();
        while (numThreeRanOfComputerList.size() < 3) {
            addRanNumList();
        }
    }

    private void addRanNumList() {
        int randomNumber = getOneRanNumAnInt();
        if (!isContainList(randomNumber)) {
            numThreeRanOfComputerList.add(randomNumber);
        }
    }

    private boolean isContainList(int randomNumber) {
        return numThreeRanOfComputerList.contains(randomNumber);
    }

    private boolean isNumOfComputerIndividually() {
        String strComputerList = getStrFromList();
        if (UseFunc.isNumOfIndividually(strComputerList)) {
            return true;
        }
        return false;
    }

    private String getStrFromList() {
        String strOfList = "";
        for (Integer numComputerList : numThreeRanOfComputerList) {
            strOfList = strOfList + numComputerList;
        }
        return strOfList;
    }

    public void initCntStrikeBall() {
        this.cntStrike = 0;
        this.cntBall = 0;
    }

    // 게임을 종료해도 되겠니?
    public boolean isEndTheGame() {
        if (this.cntStrike == 3) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        ResultType result = getResultType();
        switch (result) {
            // 볼 0 , 스트라이크 0
            case BALL_STRIKE_ZERO:
                return NOT_TING_ANSWER;
            // 스트라이크 0
            case BALL_ONLY:
                return (this.cntBall + "볼 ");
            // 볼 0
            case STRIKE_ONLY:
                return (this.cntStrike + "스트라이크");
            case BALL_STRIKE:
                return (this.cntBall + "볼 " + this.cntStrike + "스트라이크");
        }
        return "";
    }

    private ResultType getResultType() {
        // 볼 0 , 스트라이크 0
        if (isHinNotting()) {
            return ResultType.BALL_STRIKE_ZERO;
        }
        // 스트라이크 0
        else if (isHintBallOnly()) {
            return ResultType.BALL_ONLY;
        }
        // 볼 0
        if (isHintStrikeOnly()) {
            return ResultType.STRIKE_ONLY;
        }
        if (isHintBallStrik()) {
            return ResultType.BALL_STRIKE;
        }
        return null;
    }

    private boolean isHintBallStrik() {
        return !UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO) && !UseFunc.isEqualIntOfTwo(cntStrike,
            COUNT_ZERO);
    }

    private boolean isHintStrikeOnly() {
        return UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO);
    }

    private boolean isHintBallOnly() {
        return UseFunc.isEqualIntOfTwo(cntStrike, COUNT_ZERO);

    }

    private boolean isHinNotting() {
        return UseFunc.isEqualIntOfTwo(cntBall, COUNT_ZERO) && UseFunc.isEqualIntOfTwo(cntStrike,
            COUNT_ZERO);

    }

    public int getOneRanNumAnInt() {
        return Randoms.pickNumberInRange(NUM_START_RANGE_RAM, NUM_END_RANGE_RAM);
    }

    public boolean isRealRightNumOfUser(int numInputOfUser) {
        if (isRightThreeNumOfComputer(numInputOfUser)) {
            // TODO: 스트라이크와 볼이 있다면
            return true;
        }
        // TODO: 낫싱이면
        return false;

    }

    // 컴퓨터야 이 3개의 숫자가 너의 랜덤리스트와 맞니?
    // 컴퓨터의 숫자와 매개변수의 숫자를 비교합니다.
    private Boolean isRightThreeNumOfComputer(int numOfCompare) {
        // TODO: 1. numOfCompare를 3개의 숫자로 분리한다.
        ArrayList<Integer> splitNumOfCompare = splitEachDigitOfNum(numOfCompare);
        // TODO: 2. 각숫자가 컴퓨터 랜덤 리스트에 포함하는가 안하는가 확인
        if (isEqualsCollection(this.numThreeRanOfComputerList, splitNumOfCompare)) {
            // TODO: 2.1 if 포함한다면?
            // TODO: 2.1.1 스트라이크 체크
            checkStrikeBall(splitNumOfCompare);
            // TODO: 2.1.2 스트라이크 체크
//            System.out.println(this.numThreeRanOfComputerList);
//            System.out.println(this.cntBall + " " + this.cntStrike);
            return true;
        }
        // TODO: 2.2 else 포함안한다면? => 낫싱
        return false;
    }

    // strike체크 함수
    private void checkStrikeBall(List<Integer> listSplitNum) {
        // TODO: 매개변수 숫자의 첫번째 숫자가 컴퓨터의 나머지 숫자들과 비교
        boolean isStrike = true;
        boolean isBall = true;
        for (int first = 0; first < listSplitNum.size(); first++) {
            isStrike = false;
            isBall = false;
            int numComputerAtNow = this.numThreeRanOfComputerList.get(first);
            for (int second = 0; second < this.numThreeRanOfComputerList.size(); second++) {
                int numAtNow = listSplitNum.get(second);
                isStrike = isCheckStrike(isStrike, first, numComputerAtNow, second, numAtNow);
                isBall = isBallCheck(isBall, first, numComputerAtNow, second, numAtNow);
            }
            addCntBallStrike(isStrike, isBall);
        }
    }

    private void addCntBallStrike(boolean isStrike, boolean isBall) {
        if (isStrike) {
            addCntStrike();
        }
        if (isBall) {
            addCntBall();
        }
    }

    private void addCntBall() {
        this.cntBall = this.cntBall + 1;
    }

    private void addCntStrike() {
        this.cntStrike = this.cntStrike + 1;
    }

    private boolean isCheckStrike(boolean isStrike, int first, int numComputerAtNow, int second,
        int numAtNow) {
        if (first == second && numComputerAtNow == numAtNow) {
            isStrike = true;
        }
        return isStrike;
    }


    private boolean isBallCheck(boolean isBall, int first, int numComputerAtNow, int second,
        int numAtNow) {
        if (first != second && numComputerAtNow == numAtNow) {
            isBall = true;
        }
        return isBall;
    }

    private boolean isEqualsCollection(Collection collection_1, Collection collection_2) {
        // TODO: collection의 equals 메서드 이용하여 리펙토링
        boolean isTrue = true;
        for (Object num : collection_2) {
            if (collection_1.contains(num)) {
                isTrue = true;
            }
        }
        return isTrue;
    }

    // 숫자의 각각의 자릿수를 List로 리턴
    private ArrayList<Integer> splitEachDigitOfNum(int numTosplit) {
        // TODO: 숫자가 3개인가? 확인
        String[] strSplitArr = getSpitArr(parseStringFromNum(numTosplit));
        return getListOfIntegerFromStrArr(strSplitArr);
    }

    private ArrayList<Integer> getListOfIntegerFromStrArr(String[] strSplitArr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String str : strSplitArr) {
            list.add(parseIntegerFromStr(str));
        }
        return list;
    }

    private String parseStringFromNum(int num) {
        return ("" + num);
    }

    private String[] getSpitArr(String str) {
        return str.split("");
    }

    private Integer parseIntegerFromStr(String str) {
        return Integer.valueOf(str);
    }

    // 유저에게 힌트를 주다
    public String giveHint2User(int numOfCompare) {
        return this.toString();
    }

    public int getCntStrike() {
        return cntStrike;
    }

    public int getCntBall() {
        return cntBall;
    }

    public List<Integer> getNumThreeRanOfComputerList() {
        return numThreeRanOfComputerList;
    }
}
