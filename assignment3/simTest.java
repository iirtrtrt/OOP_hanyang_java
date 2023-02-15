package assignment3;

public class simTest {
    private static final String INPUTFILE = "inputFile.txt";
    private static final String OUTPUTFILE = "outputFile.txt";

    public static void main(String[] args) {
        ElectionSim eSim = new ElectionSim(INPUTFILE, OUTPUTFILE);
        eSim.runSimulation();
    }
}
