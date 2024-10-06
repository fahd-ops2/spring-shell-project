package ma.project.reactive_cli_app;

import lombok.RequiredArgsConstructor;
import ma.project.reactive_cli_app.entities.Product;
import ma.project.reactive_cli_app.repository.ProductRepository;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class CustomCommand {

    private final ProductRepository productRepository;

    @ShellMethod(key = "hello")
    public String hello(@ShellOption(defaultValue = "fahd") String name,
                         @ShellOption(defaultValue = "1") int counter) {
        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 0; i < counter; i++) {
            stringBuilder
                    .append("hello : ")
                    .append(name)
                    .append(" iteration : ")
                    .append(i)
                    .append(" \n");
        }
        return stringBuilder.toString();
    }

    @ShellMethod(key = "test")
    public String test(){
        return "test successfully";
    }

    @ShellMethod(key = "add-product")
    public Long addProduct(@ShellOption String name, @ShellOption double price) {
        Product product = Product.builder().name(name).price(price).build();
        return productRepository.save(product).getId();
    }

    @ShellMethod(key = "get-product")
    public String getProductbyId(@ShellOption Long id) {
        return productRepository.findById(id).map(Product::toString).orElse("Product not found");
    }
}
