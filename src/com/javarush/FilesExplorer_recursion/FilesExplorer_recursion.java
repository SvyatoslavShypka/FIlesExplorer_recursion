package com.javarush.FilesExplorer_recursion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesExplorer_recursion {
/*
Находим все файлы
*/
        public static List<File> insideFolders = new ArrayList<>();
        public static List<String> list = new ArrayList<>();

        public static List<String> getFileTree(String root) throws IOException {

            File folder = new File(root);

            for (File x : folder.listFiles()
            ) {
                if (x.isDirectory()) {
                    insideFolders.add(x);
                    findDirectories(x);
                }
                if (x.isFile()) list.add(x.getAbsolutePath());
            }
            for (File y: insideFolders
             ) {
            for (File z: y.listFiles()
                 ) {
                if (z.isFile()) list.add(z.getAbsolutePath());
            }
        }
            return list;
        }

        public static void findDirectories(File path) {
            for (File x : path.listFiles()
            ) {
                if (x.isDirectory()) {
                    insideFolders.add(x);
                    findDirectories(x);
                }
            }
        }

        public static void main(String[] args) {
            try {
                System.out.println(getFileTree("root"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
