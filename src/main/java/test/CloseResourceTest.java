package test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author Godzilla
 * @Date 2019/7/17 15:33
 */
public class CloseResourceTest {
    private static final String FileName = "file.txt";

    public static void closeByFinally() throws IOException {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(FileName);
            char c1 = (char) inputStream.read();
            System.out.println("c1=" + c1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }


    /**
     * try-with-resource关闭资源
     * Resource的定义：所有实现了 java.lang.AutoCloseable 接口（其中，它包括实现了 java.io.Closeable 的所有对象）
     * 可以使用作为资源。
     */
    private static void closeByResource(){
        try (FileInputStream inputStream = new FileInputStream(FileName)) {
            char c1 = (char) inputStream.read();
            System.out.println("c1=" + c1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        closeByFinally();
    }



}
