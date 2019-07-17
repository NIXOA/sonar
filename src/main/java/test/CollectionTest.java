package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Godzilla
 * @Date 2019/7/17 14:26
 */
public class CollectionTest {


    private static void subListTest(){
        List<String> list=new ArrayList<>();
        list.add("d");
        list.add("33");
        list.add("44");
        list.add("55");
        list.add("66");
        List<String> sublist = list.subList(0, 2);
       // ArrayList<String> arraySubList= (ArrayList<String>) list.subList(0,2);
        //如果达到的效果要对子集进行操作，原始list不改变。建议以下方式：
        List<String> tempList = new ArrayList<>(list.subList(2, list.size()));
        sublist.forEach(System.out::println);
        tempList.forEach(System.out::println);

    }



    private static void failedRemove() {
        List<String> userNames = new ArrayList<String>() {{
            add("Ths");
            add("Ths");
            add("ThsA");
            add("H");
        }};

       for (int i = 0; i < userNames.size(); i++) {
            if ("Ths".equals(userNames.get(i))) {
                userNames.remove(i);
            }
        }



        for (String userName : userNames) {
            if ("Ths".equals(userName)) {
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);
    }



    public static void main(String[] args) {
        //subListTest();
        failedRemove();
    }
}
