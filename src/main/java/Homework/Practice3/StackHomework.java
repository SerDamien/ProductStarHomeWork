package Homework.Practice3;

import java.util.Stack;

public class StackHomework {


    public static void validator(String str) {
        Stack<String> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                int closingTagIdx = str.indexOf('>', i);
                if (closingTagIdx == -1) {
                    System.out.println("Ошибка: обнаружен незакрытый тег (пропущена '>')");
                    return;
                }
                String tag = str.substring(i, closingTagIdx + 1);
                i = closingTagIdx;

                if (tag.startsWith("</")){
                    if (stack.isEmpty()){
                        System.out.println("Ошибка. Нет открывающего тега");
                        return;
                    }
                    String lastTag = stack.pop();
                    String tag1 = tag.substring(1, tag.length()-1);
                    String tag2 = lastTag.substring(1, lastTag.length()-1);
                    if  (!tag1.equals("/" + tag2)){
                        System.out.println("Ошибка. Ожидается закрывающий тег для: " + lastTag);
                        return;
                    }


                }else {
                    stack.push(tag);
                }
                if (stack.isEmpty()){
                    System.out.println("Строка валидна");
                } else {
                    System.out.println("Остались не закрытые теги: " + stack);
                }
            }


        }


    }
    public static void main(String[] args) {
        String EXAMPLE1 = "<div><p>Текст</p></div>";
        String EXAMPLE2 = "<h1>Заголовок</h1>";
        String WRONG_EXAMPLE = "<div>Текст</p>";
        validator(EXAMPLE1);

    }
}
