package main;

import main.service.CsvGenerator;

public class Main {

    private static final String RESOURCE_FOLDER = "./input-csv-files";
    private static final String OUTPUT_FOLDER_DEFAULT = "/src/main/resources/output-files"; //output files in project dir
//    private static final String OUTPUT_FOLDER = "C:\\Users\\tranquangphong\\Desktop"; //custom dir
    private static final String OUTPUT_FOLDER = ""; //custom dir

    public static void main(String[] args) {

        System.out.println("------Started!------\n");

        String resourcePath = System.getProperty("user.dir"); //project directory
        String outputDir = OUTPUT_FOLDER.equals("") ?
                resourcePath + OUTPUT_FOLDER_DEFAULT
                : OUTPUT_FOLDER;

        CsvGenerator generator = new CsvGenerator();
        generator.generate(RESOURCE_FOLDER, outputDir);

        System.out.println("\n------Finished!------");
    }
}
