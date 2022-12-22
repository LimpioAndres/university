package com.solvd.university.tasks.fileCount;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTask {

        public static final void main(String[] args) throws IOException{

            String text = FileUtils.readFileToString(new File("src/main/java/com/solvd/university/tasks/fileCount/text.txt"),
                    "UTF-8");

            Map<String, Long> uniqueCount = Arrays.stream(StringUtils.split(text, " ,.;:¡!¿?-_()[]{}<>$%#&=+*'´/\"\r\n\uFEFF"))
                    .map(StringUtils::upperCase).collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            Stream<Map.Entry<String, Long>> sorted = uniqueCount.entrySet().stream().
                    sorted(Map.Entry.comparingByValue(Collections.reverseOrder()));
            StringBuilder result = new StringBuilder();
            sorted.forEach(result::append);

            FileUtils.writeStringToFile(new File("src/main/java/com/solvd/university/tasks/fileCount/textResult.txt"),
                    result.toString(), "UTF-8");

        }
}
