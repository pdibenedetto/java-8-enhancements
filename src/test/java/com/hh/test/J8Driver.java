package com.hh.test;

import com.hh.test.model.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class J8Driver
{

    public static void main(String []  args) throws IOException
    {
        J8Driver driver = new J8Driver();
        driver.runStreamsExamples();
    }

    // In the above code there are few operations like map, filter, limit, and collect. We can
    // categories these operations into Intermediate operations and Terminal Operations.
    //
    // The intermediate operations return streams and hence can be connected together to form a
    // pipeline of operations.
    //
    // In the example below: map, filter, and limit are such intermediate operations.
    //
    // The most interesting part to know about the intermediate operations is that they are lazy.
    // The intermediate operations will not be invoked until the terminal operation is invoked.
    // This is very important when we are processing larger data streams. The process only on
    // demand principle drastically improves the performance. The laziness of the intermediate
    // operations help to invoke these operation in one pass. Now, if you are not clear with single
    // pass, please wait until we dive into more details about Java 8 Streams during our subsequent
    // discussions.
    private void runStreamsExamples() throws IOException
    {
        this.runStudentsStreamExamples();
        this.runNumericalStreamExamples();
        this.runStreamsOfExamples();
    }

    private void runStudentsStreamExamples()
    {
        Streams streams         = new Streams();
        List<Student> students  = streams.getStudentList();
        List<String> names      = students
            .stream()
            .map(Student::getName)
            .filter(name->((String) name).startsWith("A"))
            .limit(5)
            .collect(Collectors.toList());
    }

    private void runNumericalStreamExamples()
    {
        IntStream.range(1, 10)
                 .forEach(num -> System.out.print(num));
        System.out.println();
        System.out.println();
        IntStream.rangeClosed(1, 10)
                 .forEach(num -> System.out.print(num));
        System.out.println();
        System.out.println();
    }

    private void runStreamsOfExamples() throws IOException
    {
        //Creating Stream of hardcoded Strings and printing each String
        Stream.of("This", "is", "Java8", "Stream").forEach(System.out::println);

        System.out.println();
        System.out.println();

        //Creating stream of arrays
        String[] stringArray = new String[]{"Streams", "can", "be", "created", "from", "arrays"};
        Arrays.stream(stringArray).forEach(System.out::println);

        System.out.println();
        System.out.println();

        //Creating BufferedReader for a file
        BufferedReader reader = Files
            .newBufferedReader(Paths.get("C:/Project/java-8-enhancements/src/test/resources/File.txt"),
                                          StandardCharsets.UTF_8);
        //BufferedReader's lines methods returns a stream of all lines
        reader.lines().forEach(System.out::println);

        System.out.println();
        System.out.println();
    }

}
