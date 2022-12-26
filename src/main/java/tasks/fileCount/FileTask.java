package tasks.fileCount;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;



public class FileTask {

    public static final void main(String[] args) throws IOException{
            String textIn = FileUtils.readFileToString(new File("src/main/java/com/solvd/university/tasks/fileCount/text.txt"),
                    "UTF-8");
            FileUtils.forceDelete(new File("src/main/java/com/solvd/university/tasks/fileCount/textResult.txt"));
            Map<String, Long> calculateWords = Arrays.stream(StringUtils.split(textIn, " ,.;:¡!¿?-_()[]{}<>$%#&=+*'´/\"\r\n\uFEFF"))
                    .map(StringUtils::upperCase).collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            for (Map.Entry<String, Long> sorted : calculateWords.entrySet()) {
                FileUtils.writeStringToFile(new File("src/main/java/com/solvd/university/tasks/fileCount/textResult.txt"),
                        sorted.getKey() + "= " + sorted.getValue() + "\n", "UTF-8", true);
            }
    }
}

            /*m For each in lambda expression
            uniqueCount.forEach((key, value) -> {
                try {
                    FileUtils.writeStringToFile(new File("src/main/java/com/solvd/university/tasks/fileCount/textResult.txt"),
                        key + "= " + value + "\n", "UTF-8", true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });*/


            /* Way to sort the results but forgetting the aesthetics
            Stream<Map.Entry<String, Long>> sorted = uniqueCount.entrySet().stream().
                    sorted(Map.Entry.comparingByValue(Collections.reverseOrder()));
                    // uniqueCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()));

            StringBuilder result = new StringBuilder();
            sorted.forEach(result::append);

            FileUtils.writeStringToFile(new File("src/main/java/com/solvd/university/tasks/fileCount/textResult.txt"),
                    uniqueCount.toString(), "UTF-8");*/


