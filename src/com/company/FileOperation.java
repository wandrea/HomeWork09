package com.company;


import java.io.*;


public class FileOperation {

    public static void fileMaker(String path, String fileName) {
        /*l�trehozom a v�ltoz�t amibe t�rolom majd az el�r�si �tvonalat �s a file nevet �sszef?zve.
        * ha nincs a mappan�v ut�n / akkor rak bele egyet az �sszef?z�sn�l.
        * A FileWriter-tal l�trehozom a file-t.*/
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
        /*A pont ment�n sz�tv�gom a filenevet(felt�telezve hogy egy db . van benne)
        * egy for ciklusban l�trehozom a sz�mozott file-neveket,
        * majd az el?z? met�dust megh�vva l�trehozom a file-okat.*/
        String[] splittedFileName = fileName.split("\\.");
        if (splittedFileName.length == 2) {
            for (int i = 1; i <= number; i++) {
                String currentFileName = splittedFileName[0] + i + "." + splittedFileName[1];
                fileMaker(path, currentFileName);
            }
        }
    }

    public static void fileMakerWithContent(String path, String fileName, String content) {
        /*l�trehozom a v�ltoz�t amibe t�rolom majd az el�r�si �tvonalat �s a file nevet �sszef?zve.
        ha nincs a mappan�v ut�n / akkor rak bele egyet az �sszef?z�sn�l.
        A FileWriter-tal l�trehozom a file-t,a tartalmat bele �rom a file-ba a BufferedWriter seg�ts�g�vel*/

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
        /*Ahogy a 2.feladatn�l sz�tszedem a file nevet,hogy beleker�lj�n a sz�m, majd megh�vva a 3.feladat met�dus�t,
        melyben �sszef?z�m a file nevet a mappan�vvel �s bele�rom a megadott tartalmat.*/
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


}
