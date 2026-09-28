package Homework.AfterLesson.OOP.LessonPractice.Complete;

public class Exceptions {
    public static void main(String[] args) {
        String name = "zxc";
        int moneyOnCard = 1000;

        try {
            System.out.println(getMoney(name,moneyOnCard,1500));
        } catch (NoMoneyException e) {
            throw new RuntimeException(e);
        }

    }





    public static int getMoney(String name, int moneyOnCard, int needMoney) throws AccessDeniedException, NoMoneyException {
        if (!name.equals("zxc")){
            throw new AccessDeniedException("You not me");
        } else if (moneyOnCard < needMoney) {
            throw new NoMoneyException("No Money");
        } else {

        return moneyOnCard - needMoney;}

    }
}
