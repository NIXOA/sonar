package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * map遍历
 *
 * @author qiaoxin
 * @Date 2019/7/17
 */
public class MapEntryTest {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            map.put(i, i);
        }
        for (int i = 0; i <5 ; i++) {
            System.out.println("第"+i+"次测试");
            testMap(map);
        }
    }


    /**
     * 遍历时间测试
     *
     * @param map
     */
    private static void  testMap(Map<Integer, Integer> map) {
        //keySet遍历
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            //效率低下原因在此，因为此处会再次遍历Map ，取得key对应的value值。
            int value = map.get(key);
        }
        System.out.println("keySet consume time = " + (System.currentTimeMillis() - start));

        //entrySet遍历
        start = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, Integer>> iterator2 = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry;
        while (iterator2.hasNext()) {
            entry = iterator2.next();
            int key = entry.getKey();
            int value = entry.getValue();
        }
        System.out.println("entrySet consume time = " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        map.forEach((k, v) -> {
            int key = k;
            int value = v;
        });
        System.out.println("forEach consume time = " + (System.currentTimeMillis() - start));
    }


}
