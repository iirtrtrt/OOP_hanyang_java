package assignment3;

public class Region extends Thread {
    String name;
    int regionNum;
    int population;
    Candidate[] candidates;

    public Region(String name, int regionNum, int population, Candidate[] candidates) {
        this.name = name;
        this.regionNum = regionNum;
        this.population = population;
        this.candidates = candidates;
    }

    public void generateVotes() {
        for (int i = 0; i < population; i++) {
            int randomCandidate = (int) (Math.random() * (candidates.length));
            candidates[randomCandidate].addVote(regionNum);
        }
    }

    @Override
    public void run() {
        generateVotes();
    }
}
