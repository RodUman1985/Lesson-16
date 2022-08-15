package com.company;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {
        // File, FileWriter, FileReader
        // String, StringBuilder, StringBuffer
        //Math, Random
        // классы-обертки
        // Серилизация
       // класс  File - работа с файловой системой
        // относительный путь(/dir/1.txt)
        // абсолютный путь (D:/folder1/folder2/folder3/ 1.txt)
        File f = new File("1.txt");
        if (!f.exists()){
            //создаем фаил
            f.createNewFile();
        }
        // размер фаила в байтах
        System.out.println(f.length());
        // дата изменения фаила
        System.out.println(f.lastModified());
        // времая в unix-time ( количество милисекунд, прошедших с 1.01.1970)
        // установка даты иизменения фаила
        f.setLastModified(Long.MAX_VALUE-100000000000l);
        //проверка скрытности фаила
        System.out.println(f.isHidden());
        // путь к фаилу
        System.out.println(f.getAbsolutePath());
        // работа с папками
        File dir=new File("D:\\Дубинин Р.В\\Lesson-test");
        if (!dir.exists()) {
            dir.mkdir();// создает первую не существующию папку
            dir.mkdirs();// создает все не существующие папки
        }
        // получение списка фаилов внутри папки
        File[] files =dir.listFiles();
        for (File file:files){
            System.out.print(file.getName());
            if (file.isDirectory()) {
                System.out.println("   папка");
            } else {
                System.out.println("  фаил");
            }
        }
        list (dir,0);
        // классы оьертки над примитивными типами
        int i=0;
        Integer x= i+19;
        i= x-12;
        double d=Double.parseDouble("12.7");
        System.out.println(d);
    }
    public static void list(File direcrtory, int depth) {
        File [] files=direcrtory.listFiles();
        for( File f:files) {
            printSpace(depth);
            System.out.println(f.getAbsolutePath());

            if (f.isDirectory()) {
                 list(f,depth+1);
             }
        }
    }
    public static  void printSpace (int count){
        for (int i=0;i<count;i++){
            System.out.print("   ");
        }
    }
}
