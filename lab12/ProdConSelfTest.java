package lab12;

public class ProdConSelfTest {
    private Buffer buffer;
    private Producer producer;
    private Consumer conumer;

    public ProdConSelfTest() {
        buffer = new Buffer(100);
        producer = new Producer(buffer);
        conumer = new Consumer(buffer);
    }

    private class Producer extends Thread {
        private final Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void produce() throws InterruptedException {
            for (int i = 0; i < buffer.getSize(); i++) {
                buffer.add(Math.random() * 100);
            }
        }

        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class Consumer extends Thread {
        private final Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        public void consume() throws InterruptedException {
            for (int i = buffer.getSize(); i >= 0; i--) {
                buffer.remove();
            }
        }

        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startThread() {
        producer.start();
        conumer.start();
    }
}
