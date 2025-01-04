import repository.ProductRepository;
import service.ProductService;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);
        ConsoleView view = new ConsoleView(service);

        view.start();
        }
    }