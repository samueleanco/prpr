package ch.fhnw.ch.tutorials.grundkurs2;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        String inputFile = "logfile.txt";
        String outputFile = "log_summary.txt";

        Map<String, Integer> logCounts = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String logLevel = line.substring(1, line.indexOf("]"));
                logCounts.merge(logLevel,1,Integer::sum);
            }

        } catch (IOException e) {
            System.err.println("error");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : logCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("error");
        }




    }
}
