package assignment3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ElectionSim {
    String outputFile;
    int population;
    Candidate[] candidates;
    Region[] regions;

    public ElectionSim(String inputFile, String outputFile) {
        this.outputFile = outputFile;
        try {
            Scanner inputStream = new Scanner(new FileInputStream(inputFile));
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                String[] splitedLine = line.split(" ");
                String subString = splitedLine[0];

                switch (subString) {
                    case "POPULATION":
                        this.population = Integer.parseInt(splitedLine[1]);
                        break;
                    case "CANDIDATES":
                        candidates = new Candidate[Integer.parseInt(splitedLine[1])];
                        for (int i = 0; i < Integer.parseInt(splitedLine[1]); i++) {
                            Candidate newCandidate = new Candidate(inputStream.nextLine(), population);
                            this.candidates[i] = newCandidate;
                        }
                        break;
                    case "REGIONS":
                        regions = new Region[Integer.parseInt(splitedLine[1])];
                        for (int i = 0; i < Integer.parseInt(splitedLine[1]); i++) {
                            String[] splitedRegion = inputStream.nextLine().split(" ");
                            Region newRegion = new Region(splitedRegion[0], Integer.parseInt(splitedRegion[1]),
                                    Integer.parseInt(splitedRegion[2]), candidates);
                            this.regions[i] = newRegion;
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find " + inputFile);
            System.exit(0);
        }
    }

    public void saveData() {
        try {
            PrintWriter outputStream = new PrintWriter(new FileOutputStream(outputFile));
            Arrays.sort(candidates);
            for (int i = 0; i < candidates.length; i++) {
                outputStream.println(candidates[i].toString());
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.exit(0);
        }
    }

    public void runSimulation() {
        for (int i = 0; i < regions.length; i++) {
            try {
                regions[i].start();
                regions[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saveData();
    }
}
