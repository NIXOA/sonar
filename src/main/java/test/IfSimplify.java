package test;

import entity.Address;
import entity.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author Godzilla
 * @Date 2019/7/16 15:00
 */
public class IfSimplify {


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
