package main.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * INSERT INTO table_name (column_list)
 * VALUES
 * (value_list_1),
 * (value_list_2),
 * ...
 * (value_list_n);
 */

public class CsvGenerator {

    public void generate(String resourceFolder, String outputFolder) {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        InputStream inputStream = null;
        CSVParser csvParser = null;
        CSVFormat csvFormat = CSVFormat.POSTGRESQL_CSV
                .builder()
                .setHeader().setSkipHeaderRecord(true)
                .setEscape('\\')
                .setIgnoreEmptyLines(true)
                .setAllowDuplicateHeaderNames(false)
                .setAllowMissingColumnNames(false)
                .setNullString(null)
                .setSkipHeaderRecord(false)
                .setQuoteMode(QuoteMode.ALL_NON_NULL)
                .build();

        StringBuilder sql = new StringBuilder("");


        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        List<String> inputFiles = getResourceFiles(classloader, resourceFolder);

        for (String fileName : inputFiles) {
            sql.setLength(0); //reset sql
            try {
                //Read input csv file
                inputStream = classloader.getResourceAsStream(resourceFolder + "/" + fileName);
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String table = fileName.replace(".csv", "");

                //Parse Csv
                csvParser = CSVParser.parse(reader, csvFormat);
                List<String> headers = csvParser.getHeaderNames();

                //Build sql
                sql.append("INSERT INTO ").append(table).append("(");
                sql.append(String.join(",", headers)).append(")");
                sql.append("\n").append("VALUES").append("\n");

                //Build values to insert
                for (CSVRecord record : csvParser) {
                    buildValues(csvParser, record, sql);
                }

                System.out.println("sql = \n" + sql);

                String outputFileName = getOutputFile(outputFolder, table);

                writer = new BufferedWriter(new FileWriter(outputFileName));
                writer.write(sql.toString());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    close(reader, writer, inputStream, csvParser);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private StringBuilder buildValues(CSVParser csvParser, CSVRecord record, StringBuilder sql) {
        sql.append("(");
        sql.append(record.stream().map(s -> {
            if (s != null
//                    && !s.equals("")
                    && !s.equals("NULL")) {
                //Apply quote character for all non-null values
                s = "'" + s + "'";
            }
            return s;
        }).collect(Collectors.joining(",")));
        sql.append(")");

        if (csvParser.iterator().hasNext()) {
            sql.append(",").append("\n");
        } else {
            sql.append(";");
        }
        return sql;
    }

    /**
     * Get all input files in resource folder
     *
     * @param classloader
     * @param resourceFolder
     * @return
     */
    private List<String> getResourceFiles(ClassLoader classloader, String resourceFolder) {

        InputStream is = classloader.getResourceAsStream(resourceFolder);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        List<String> filenames = new ArrayList<>();
        String resource;

        try {
            while ((resource = bufferedReader.readLine()) != null) {
                filenames.add(resource);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filenames;
    }

    /**
     * Create output file
     * @param outputFolder
     * @param table
     * @return
     * @throws IOException
     */
    private String getOutputFile(String outputFolder, String table) throws IOException {


        String outputFileName = outputFolder + FileSystems.getDefault().getSeparator() + table + ".sql";
        File outputFile = new File(outputFileName);

        if (outputFile.createNewFile()) {
            System.out.println("File created: " + outputFile.getName());
        } else {
            System.out.println("File already exists.");
        }
        return outputFileName;
    }

    /**
     * Dong cua tha cho
     * @param reader
     * @param writer
     * @param inputStream
     * @param csvParser
     * @throws IOException
     */
    private void close(BufferedReader reader, BufferedWriter writer, InputStream inputStream, CSVParser csvParser) throws IOException {
        if (reader != null)
            reader.close();

        if (writer != null)
            writer.close();

        if (csvParser != null)
            csvParser.close();

        if (inputStream != null)
            inputStream.close();
    }

}
