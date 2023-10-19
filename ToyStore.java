import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class ToyStore{
    private List<Toy> toys;
    int toysCount = 0;

    public ToyStore() {
        toys = new ArrayList<>();
        toysCount = 0;
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateProbability(int toyId, double newProbability) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setProbability(newProbability);
                break;
            }
        }
    }

    public Toy selectPrizeToy() {
        double totalProbability = 0.0;
        for (Toy toy : toys) {
            totalProbability += toy.getProbability();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalProbability;

        double cumulativeProbability = 0.0;
        for (Toy toy : toys) {
            cumulativeProbability += toy.getProbability();
            if (randomNumber <= cumulativeProbability) {
                Toy prizeToy = new Toy(toy.getId(), toy.getName(), 1, toy.getProbability());
                toy.setQuantity(toy.getQuantity() - 1);
                return prizeToy;
            }
        }

        return null;
    }

    public void savePrizeToyToFile(Toy prizeToy) {
        try (FileWriter writer = new FileWriter("prize.txt", true)) {
            writer.write("Призовая игрушка: " + prizeToy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
