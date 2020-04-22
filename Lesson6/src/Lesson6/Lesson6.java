package Lesson6;

import java.io.*;
import java.util.Scanner;

public class Lesson6 {

    public static boolean createTextFile(String path, int length, char symbol)
            throws IOException {
        if (!new File(path).createNewFile()) return false;

        StringBuilder content = new StringBuilder();
        for (int i = 0; i < length; i++) {
            content.append(symbol);
        }

        FileOutputStream fos = new FileOutputStream(path);
        fos.write(content.toString().getBytes());
        fos.close();
        return true;
    }

    private static String getFileContent(String filePath)
            throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fis);
        StringBuilder ret = new StringBuilder();
        while (scanner.hasNext()) {
            ret.append(scanner.nextLine() + '\n');
        }
        scanner.close();
        return ret.toString();
    }

    public static boolean concatFiles(String fileOnePath, String fileTwoPath, String newFilePath)
            throws IOException {
        if (!new File(newFilePath).createNewFile()) return false;

        String fileOneContent = getFileContent(fileOnePath);
        String fileTwoContent = getFileContent(fileTwoPath);
        String newFileContent = fileOneContent + fileTwoContent;

        FileOutputStream fos = new FileOutputStream(newFilePath);
        fos.write(newFileContent.getBytes());
        fos.close();
        return true;
    }

    public static boolean kindaGrep (String filePath, String pattern) {
        try {
            String fileContent = getFileContent(filePath);
            return fileContent.contains(pattern);
        } catch (FileNotFoundException fnf) {
            return false;
        }
    }

    public static boolean folderGrep (String folderPath, String pattern) {
        File folder = new File(folderPath);

        if (!folder.exists()) return false;
        for (File file : folder.listFiles()) {
            if (file.isFile() && kindaGrep(file.getPath(), pattern)) return true;
        }
        return false;
    }

    public static void main (String[] args) {
       try {
           createTextFile("file1.txt", 50, 'B');
           createTextFile("file2.txt", 100, 'A');
           concatFiles("file1.txt", "file2.txt", "file3.txt");
           System.out.println(kindaGrep("File3.txt", "AB"));
           System.out.println(kindaGrep("File3.txt", "BA"));
           System.out.println(folderGrep(".", "AB"));
           System.out.println(folderGrep(".", "BA"));
           System.out.println(folderGrep("./src/Lesson6", "main"));
       } catch (FileNotFoundException fnf) {
           System.out.println("Wild fnf exception appears!");
       } catch (IOException exception) {
           System.out.println("Wild io exception appears!");
       }
    }
}
