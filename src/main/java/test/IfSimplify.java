package test;

import entity.Address;
import entity.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author qiaoxin
 * @Date 2019/7/16
 */
public class IfSimplify {


    private static final boolean IS_BUSY=true;
    private static final boolean IS_FREE=false;

    /**
     * 获取当前日期的中文星期天数
     * @return
     */
    private static String getChineseWeekByDate() {
        int numWeekDay = LocalDate.now().getDayOfWeek().getValue();
        if (numWeekDay == 1) {
            return "周一";
        } else if (numWeekDay == 2) {
            return "周二";
        } else if (numWeekDay == 3) {
            return "周三";
        } else if (numWeekDay == 4) {
            return "周四";
        } else if (numWeekDay == 5) {
            return "周五";
        } else if (numWeekDay == 6) {
            return "周六";
        } else if (numWeekDay == 7) {
            return "周日";
        } else {
            return "";
        }
    }


    private static String getDayOfWeekByTable() {
        String[] weekArray = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        int numWeekDay = LocalDate.now().getDayOfWeek().getValue();
        return weekArray[numWeekDay - 1];
    }



    private static void today() {
        if (!IS_BUSY) {
            if (!IS_FREE) {
                System.out.println("stay at home ");
            }else{
                System.out.println("go to travel");
            }
        }else{
            System.out.println("change time");
        }

    }


    /**
     * 卫语句(guard clauses)
     * 就是把复杂的条件表达式拆分成多个条件表达式
     */
    private static void guardToday() {
        // 单独检查报错分支
        if (IS_BUSY) {
            System.out.println("change time.");
            return;
        }
        if (IS_FREE) {
            System.out.println("go to travel.");
            return;
        }
        // 关注真正的业务代码
        System.out.println("stay at home");
    }




    private String getCity( User user){
       if (user!=null){
           if (user.getAddress()!=null){
               Address address=user.getAddress();
               if (address!=null){
                   return address.getCity();
               }
           }
       }
       return "取值错误";
    }


    private String getCityByOptional(User user){
        return Optional.ofNullable(user).map(User::getAddress).map(Address::getCity)
                .orElseThrow(()->new RuntimeException("取值错误"));
    }

    public static void main(String[] args) {

    }

}
