package com.company;


import java.io.*;


public class FileOperation {

    public static void fileMaker(String path, String fileName) {
        /*létrehozom a változót amibe tárolom majd az elérési útvonalat és a file nevet összef?zve.
        * ha nincs a mappanév után / akkor rak bele egyet az összef?zésnél.
        * A FileWriter-tal létrehozom a file-t.*/
        String fullFilename = null;
        if (path.endsWith(File.separator)) {
            fullFilename = path + fileName;
        } else {
            fullFilename = path + File.separator + fileName;
        }
        FileWriter fw = null;

        try {
            fw = new FileWriter(fullFilename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileMaker(String path, int number, String fileName) {
        /*A pont mentén szétvágom a filenevet(feltételezve hogy egy db . van benne)
        * egy for ciklusban létrehozom a számozott file-neveket,
        * majd az el?z? metódust meghívva létrehozom a file-okat.*/
        String[] splittedFileName = fileName.split("\\.");
        if (splittedFileName.length == 2) {
            for (int i = 1; i <= number; i++) {
                String currentFileName = splittedFileName[0] + i + "." + splittedFileName[1];
                fileMaker(path, currentFileName);
            }
        }
    }

    public static void fileMakerWithContent(String path, String fileName, String content) {
        /*létrehozom a változót amibe tárolom majd az elérési útvonalat és a file nevet összef?zve.
        ha nincs a mappanév után / akkor rak bele egyet az összef?zésnél.
        A FileWriter-tal létrehozom a file-t,a tartalmat bele írom a file-ba a BufferedWriter segítségével*/

        String fullFilename = null;
        if (path.endsWith(File.separator)) {
            fullFilename = path + fileName;
        } else {
            fullFilename = path + File.separator + fileName;
        }
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(fullFilename);
            bw = new BufferedWriter(fw);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void fileMakerWithContent(String path, int number, String fileName, String content) {
        /*Ahogy a 2.feladatnál szétszedem a file nevet,hogy belekerüljön a szám, majd meghívva a 3.feladat metódusát,
        melyben összef?zöm a file nevet a mappanévvel és beleírom a megadott tartalmat.*/
        String[] splittedFileName = fileName.split("\\.");
        if (splittedFileName.length == 2) {
            for (int i = 1; i <= number; i++) {
                String currentFileName = splittedFileName[0] + i + "." + splittedFileName[1];
                fileMakerWithContent(path, currentFileName, content);

            }
        }
    }


    public static void printMatrixFromFile() {
    }

    public static void printDirsInDirectory(String folderName) {
        try {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printFilesInDirectory(String folderName) {
        try {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (!file.isDirectory()) {
                    System.out.println(file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Ez a metódus nincs bent az UML-ben.
    public static void printAllInDirectory(String folderName) {
        try {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                System.out.println(file.getName());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean isFilesEquals(String fileName1, String fileName2) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1));
             BufferedReader br2 = new BufferedReader(new FileReader(fileName2))) {
            String line1 = "";
            String line2 = "";
            while (true) {
                line1 = br.readLine();
                line2 = br2.readLine();
                if (line1 == null && line2 == null) {
                    break;
                }
                if (line1 == null && line2 != null || line1 != null && line2 == null) {
                    return false;
                }
                if (!line1.equals(line2)) {
                    return false;
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return true;

    }

}
