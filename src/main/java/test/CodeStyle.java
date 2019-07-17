package test;

/**
 * @author qiaoxin
 * @Date 2019/7/17
 */
public class CodeStyle {


    public static void main(String[] args) {
        // 缩进 4 个空格
        String say = "hello";
        // 运算符的左右必须有一个空格
        int flag = 0;
        // 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }
        // 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) {
            System.out.println("world");
            // 右大括号前换行，右大括号后有 else，不用换行
        } else {
            System.out.println("ok");
            // 在右大括号后直接结束，则必须换行
        }
    }


}
