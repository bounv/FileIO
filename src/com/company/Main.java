package com.company;


import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    // ask user for input, save into magazine object
        //save object into a JSON file
        //before above, load JSON file if it exists
        //if exists, print out information and ask users if they want to update and save updated info
        // if doesn't exist then asks users questions to input then save file without
        // no loops

        File f = new File("magazine.json");


        // read json
        Scanner scanner = new Scanner(f);

        try {
            // read entire file
            scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            Magazine p2 = parser.parse(contents, Magazine.class);

            System.out.println("Magazine: " + p2.name);
            System.out.println("Cover Person: " + p2.coverPerson);
            System.out.println("Publish Date: " + p2.publish);
            System.out.println("Publisher: " + p2.publisher);
            System.out.println("Summary: " + p2.summary);
            System.out.println();

            //if statement to ask question to update data. if they say yes, then ask questions
            if(p2.name != null) {

                scanner = new Scanner(System.in);

                System.out.println("Do you want to update data? [y/n]");
                String answer = scanner.nextLine();

                if(answer.equalsIgnoreCase("y")) {

                    Magazine m = new Magazine();

                    System.out.println("What is the name of magazine?");
                    String magazine = scanner.nextLine();

                    m.name = magazine;

                    System.out.println("What date was it published?");
                    String publish = scanner.nextLine();

                    m.publish = publish;

                    System.out.println("Who is the front cover person?");
                    String coverPerson = scanner.nextLine();

                    m.coverPerson = coverPerson;

                    System.out.println("What company is the publisher?");
                    String publisher = scanner.nextLine();

                    m.publisher = publisher;

                    System.out.println("Provide a summary:");
                    String summary = scanner.nextLine();

                    m.summary = summary;

                    // write json
                    JsonSerializer serializer = new JsonSerializer();
                    String json = serializer.serialize(m);
                    FileWriter fw = new FileWriter(f);
                    fw.write(json);
                    fw.close();
                } else if(answer.equalsIgnoreCase("n")) {

                }

            }


        } catch (IOException e) {

            scanner = new Scanner(System.in);

            Magazine m = new Magazine();

            System.out.println("What is the name of magazine?");
            String magazine = scanner.nextLine();

            m.name = magazine;

            System.out.println("What date was it published?");
            String publish = scanner.nextLine();

            m.publish = publish;

            System.out.println("Who is the front cover person?");
            String coverPerson = scanner.nextLine();

            m.coverPerson = coverPerson;

            System.out.println("What company is the publisher?");
            String publisher = scanner.nextLine();

            m.publisher = publisher;

            System.out.println("Provide a summary:");
            String summary = scanner.nextLine();

            m.summary = summary;

            // write json
            JsonSerializer serializer = new JsonSerializer();
            String json = serializer.serialize(m);
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();

        }
    }
}
