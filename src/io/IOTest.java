package io;

import java.io.File;

public class IOTest {
    public static void main(String[] args) {
        //File file = new File("D:\\myTest\\thrift-service");
        //readFile(file);
        int a=11;
        int b=8;
        System.out.println(Integer.toBinaryString(a+b));

        String s = Integer.toString(a, 16);
        System.out.println(s);

    }

    private static void readFile(File file) {
        File[] files = file.listFiles();
        if (null==files){
            return;
        }
        for (File f : files
                ) {
            if (f.isDirectory()) {
                f = f.getAbsoluteFile();
                readFile(f);
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
