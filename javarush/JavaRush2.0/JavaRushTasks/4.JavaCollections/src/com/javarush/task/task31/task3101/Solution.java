package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        List<File> list;

        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(path, myFileVisitor);
        list = myFileVisitor.getSortedListOfFileNames();

        try (FileOutputStream writer = new FileOutputStream(allFilesContent)) {
            for (File file : list) {
                if (file.getName().equals(allFilesContent.getName())) {
                    continue;
                }
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    writer.write(reader.readLine().getBytes());
                }
                reader.close();
                writer.write(System.lineSeparator().getBytes());

            }
        }
    }


    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {

        List<File> fileNames = new ArrayList<>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            if (attrs.size() > 50) {
                FileUtils.deleteFile(file.toFile());
            } else {
                fileNames.add(file.toFile());
            }
            return FileVisitResult.CONTINUE;
        }

        private List<File> getSortedListOfFileNames() {
            Collections.sort(fileNames, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            return fileNames;
        }

    }

}
