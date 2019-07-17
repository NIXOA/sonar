package test;

import entity.User;

import java.util.*;

/**
 * @author qiaoxin
 * @Date 2019/7/16
 */
public class NullPointTest {

    private static final String OK="ok";
    private static final String NO="no";


    /**
     * 字符串比较
     * @param user
     */
    private static void strEuqal(User user){
        if (user.getPassword().equals("password")){
            System.out.println(user);
        }

    }

    private static void nullCollection(Map<String,String> map){
        List<String> result=getList(map);
        for (String s : result) {
            System.out.println(s);
        }
    }


    private static List<String> getList(Map<String,String> map){
        List<String> list = null;
        if (map.containsKey(OK)){
            list= new ArrayList<>();
            list.add(map.get(OK));
        }
        return list;
        //return list == null ? Collections.emptyList() : list ;
    }

    public static void main(String[] args) {
         Map<String,String> map=new HashMap<>(1);
         map.put(NO,NO);
         nullCollection(map);
    }



}
