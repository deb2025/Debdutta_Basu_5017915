package BuilderPatternExample;

public class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private String motherboard;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.motherboard = builder.motherboard;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public static class ComputerBuilder {

        private String CPU;
        private String RAM;
        private String Storage;
        private String motherboard;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public ComputerBuilder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage + ", motherboard=" + motherboard + "]";
    }

}
