public class Toy {
    Integer id;
    String name;
    Integer quantity;
    Double probability;


    public Toy(int id, String name, int quantity, double probability) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.probability = probability;
    }
    public Integer getId() {
        return this.id;
    }
    
        public String getName() {
            return name;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public double getProbability() {
            return probability;
        }
    
        public void setProbability(double probability) {
            this.probability = probability;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
}

