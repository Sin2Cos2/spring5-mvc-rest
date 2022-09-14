package guru.springfamework.bootstrap;

import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.services.CategoryService;
import guru.springfamework.domain.Category;
import guru.springfamework.services.CustomerService;
import guru.springfamework.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryService categoryService;
    private final CustomerService customerService;
    private final VendorService vendorService;

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadVendors() {
        Vendor v1 = new Vendor("Franks Fresh Fruits from France Ltd.");
        Vendor v2 = new Vendor("Western Tasty Fruits Ltd.");
        Vendor v3 = new Vendor("Exotic Fruits Company");
        Vendor v4 = new Vendor("Home Fruits");

        vendorService.save(v1);
        vendorService.save(v2);
        vendorService.save(v3);
        vendorService.save(v4);
    }

    private void loadCustomers() {
        Customer c1 = new Customer("John", "Soeno");
        Customer c2 = new Customer("Pavel", "Cox");
        Customer c3 = new Customer("Vasea", "Pupkin");
        Customer c4 = new Customer("Alex", "Conor");

        customerService.save(c1);
        customerService.save(c2);
        customerService.save(c3);
        customerService.save(c4);
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryService.save(fruits);
        categoryService.save(dried);
        categoryService.save(fresh);
        categoryService.save(exotic);
        categoryService.save(nuts);
    }
}
