package test;

import entity.User;

/**
 * @Author Godzilla
 * @Date 2019/7/16 14:19
 */
public class ObjectEqual {
    private static final Integer INT_128 = 128;
    private static final Integer INT_127 = 127;

    public static void main(String[] args) {
        lessThan128(127);
        moreThan128(128);

        String age="18";
        int userAge;
        userAge=Integer.valueOf(age);
        User user=new User();
        user.setAge(Integer.valueOf(age));

    }

    private static void lessThan128(Integer a) {
        System.out.println(INT_127.equals(a));
        System.out.println(INT_127 == a);

    }

    private static void moreThan128(Integer a) {
        System.out.println(INT_128.equals(a));
        System.out.println(INT_128 == a);
    }


}
