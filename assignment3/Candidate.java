package assignment3;

public class Candidate implements Comparable<Candidate> {
    String name;
    Vote[] votes;
    int numVotes = 0;

    public Candidate(String name, int maxVotes) {
        this.name = name;
        this.votes = new Vote[maxVotes];
    }

    @Override
    public int compareTo(Candidate arg0) {
        return arg0.numVotes - this.numVotes;
    }

    @Override
    public String toString() {
        return "----------Candidate----------\nName: " + name + "\nVotes: " + numVotes
                + "\n=============================\n";
    }

    private class Vote {
        int regionNum;

        public Vote(int regionNum) {
            this.regionNum = regionNum;
        }
    }

    public synchronized void addVote(int regionNum) {
        votes[numVotes++] = new Vote(regionNum);
    }
}
