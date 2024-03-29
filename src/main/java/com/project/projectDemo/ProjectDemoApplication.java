package com.project.projectDemo;

import com.project.projectDemo.domain.dto.UserDto;
import com.project.projectDemo.services.CartService;
import com.project.projectDemo.services.ProductService;
import com.project.projectDemo.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
@Log
@RequiredArgsConstructor
public class ProjectDemoApplication implements CommandLineRunner {

    private final ProductService productService;

    private final CartService cartService;

    private final UserService userService;

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(ProjectDemoApplication.class, args);


    }

    @Override
    public void run(final String... args) {
        displayConsoleMenu();
    }

    public void displayConsoleMenu() {

        while (true) {
            displayMenu();
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayUserOptions();
                case 2 -> displayCartOptions();
                case 3 -> displayProductOptions();
                case 4 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n===== Console Menu =====");
        System.out.println("1. Display User Options");
        System.out.println("2. Display Cart Options");
        System.out.println("3. Display Product Options");
        System.out.println("4. Exit");
    }

    private void displayProductOptions() {
        System.out.println("\n===== Console Menu =====");
        System.out.println("1. Get all products");
        System.out.println("2. Get a specific product");
        System.out.println("3. Create a product");
        System.out.println("4. Update a product");
        System.out.println("5. Delete a product");
        System.out.println("6. Search for a product");
        System.out.println("7. Return to main menu");
        System.out.println("8. Exit");

        while (true) {
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    displayProducts();
                    displayProductOptions();
                }
                case 2 -> {
                    System.out.print("Enter the id of the product: ");
                    int productId = getIntInput();
                    displaySingleProduct(productId);
                    displayProductOptions();
                }
                case 3 -> {
                    createProduct();
                    displayProductOptions();
                }
                case 4 -> {
                    System.out.print("Enter the id of the product: ");
                    int updateProductId = getIntInput();
                    updateProduct(updateProductId);
                    displayProductOptions();
                }
                case 5 -> {
                    System.out.print("Enter the id of the product: ");
                    int productDeleteId = getIntInput();
                    deleteProduct(productDeleteId);
                    displayProductOptions();
                }
                case 6 -> {
                    System.out.println("Enter a search word");
                    String productSearch = scanner.next();
                    searchProduct(productSearch);
                    displayProductOptions();
                }
                case 7 -> {
                    System.out.println("Returning to main menu...");
                    displayConsoleMenu();
                }
                case 8 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayUserOptions() {
        System.out.println("\n===== Console Menu =====");
        System.out.println("1. Get all users");
        System.out.println("2. Get a specific user");
        System.out.println("3. Create a user");
        System.out.println("4. Update a user");
        System.out.println("5. Delete a user");
        System.out.println("6. Search a user");
        System.out.println("7. Return to main menu");
        System.out.println("8. Exit");

        while (true) {
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    displayUsers();
                    displayUserOptions();
                }
                case 2 -> {
                    System.out.print("Enter the id of the user: ");
                    int userId = getIntInput();
                    displaySingleUser(userId);
                    displayUserOptions();
                }
                case 3 -> {
                    createUser();
                    displayUserOptions();
                }
                case 4 -> {
                    System.out.print("Enter the id of the user: ");
                    int updateUserId = getIntInput();
                    updateUser(updateUserId);
                    displayUserOptions();
                }
                case 5 -> {
                    System.out.print("Enter the id of the user: ");
                    int userDeleteId = getIntInput();
                    deleteUser(userDeleteId);
                    displayUserOptions();
                }
                case 6 -> {
                    System.out.println("Enter the name to search: ");
                    String productSearch = scanner.next();
                    searchUser(productSearch);
                    displayUserOptions();
                }
                case 7 -> {
                    System.out.println("Returning to main menu...");
                    displayConsoleMenu();
                }
                case 8 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayCartOptions() {
        System.out.println("\n===== Console Menu =====");
        System.out.println("1. Get all carts");
        System.out.println("2. Get a specific cart");
        System.out.println("3. Create a cart");
        System.out.println("4. Update a cart");
        System.out.println("5. Delete a cart");
        System.out.println("6. Return to main menu");
        System.out.println("7. Exit");

        while (true) {
            int choice = getIntInput();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    displayCarts();
                    displayCartOptions();
                }
                case 2 -> {
                    System.out.print("Enter the id of the cart: ");
                    int cartId = getIntInput();
                    displaySingleCart(cartId);
                    displayCartOptions();
                }
                case 3 -> {
                    createCart();
                    displayCartOptions();
                }
                case 4 -> {
                    System.out.print("Enter the id of the cart: ");
                    int updateCartId = getIntInput();
                    updateCart(updateCartId);
                    displayCartOptions();
                }
                case 5 -> {
                    System.out.print("Enter the id of the cart: ");
                    int cartDeleteId = getIntInput();
                    deleteCart(cartDeleteId);
                    displayCartOptions();
                }
                case 6 -> {
                    System.out.println("Returning to main menu...");
                    displayConsoleMenu();
                }
                case 7 -> {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayProducts() {
        System.out.println("Fetching all products...");
        String productData = productService.getAll().toString();
        System.out.println(productData);
    }

    private void displaySingleProduct(Integer id) {
        System.out.println("Fetching selected product...");
        String productData = productService.get(id).toString();
        System.out.println(productData);
    }

    private void deleteProduct(Integer id) {
        System.out.println("Deleting selected product...");
        String productData = productService.delete(id).toString();
        System.out.println(productData);
    }

    private void updateProduct(Integer id) {
        System.out.println("Updating selected product...");
        String productData = productService.update(id).toString();
        System.out.println(productData);
    }

    private void createProduct() {
        System.out.println("Creating product...");
        String productData = productService.create().toString();
        System.out.println(productData);
    }

    private void searchProduct(String string) {
        System.out.println("Searching for product...");
        String productData = productService.search(string).toString();
        System.out.println(productData);
    }

    private void displayCarts() {
        System.out.println("Fetching all carts...");
        String cartData = cartService.getAll().toString();
        System.out.println(cartData);
    }

    private void displaySingleCart(Integer id) {
        System.out.println("Fetching selected cart...");
        String cartData = cartService.get(id).toString();
        System.out.println(cartData);
    }

    private void createCart() {
        System.out.println("Creating cart...");
        String cartData = cartService.create().toString();
        System.out.println(cartData);
    }

    private void deleteCart(Integer id) {
        System.out.println("Deleting selected cart...");
        String cartData = cartService.delete(id).toString();
        System.out.println(cartData);
    }

    private void updateCart(Integer id) {
        System.out.println("Updating selected cart...");
        String cartData = cartService.update(id).toString();
        System.out.println(cartData);
    }

    private void displayUsers() {
        System.out.println("Fetching all users...");
        String userData = userService.getAll().toString();
        System.out.println(userData);
    }

    private void displaySingleUser(Integer id) {
        System.out.println("Fetching selected user...");
        UserDto userDto = userService.get(id);
        if (userDto != null) {
            System.out.println(userDto.toString());
            System.out.print("Do you want to save the user's image locally? (yes/no): ");
            scanner.nextLine();
            String saveImageOption = scanner.nextLine().trim().toLowerCase();
            if (saveImageOption.equals("yes")) {
                String directoryPath = "src/main/java/com/project/projectDemo/images";
                saveUserImageLocally(userDto.getImage(), directoryPath);
            } else {
                System.out.println("User's image not saved.");
            }
        } else {
            System.out.println("User not found!");
        }
    }

    private void createUser() {
        System.out.println("Creating user...");
        String cartData = userService.create().toString();
        System.out.println(cartData);
    }

    private void deleteUser(Integer id) {
        System.out.println("Deleting selected user...");
        String userData = userService.delete(id).toString();
        System.out.println(userData);
    }

    private void updateUser(Integer id) {
        System.out.println("Updating selected user...");
        String userData = userService.update(id).toString();
        System.out.println(userData);
    }

    private void searchUser(String string) {
        System.out.println("Searching for selected user...");
        String userData = userService.search(string).toString();
        System.out.println(userData);
    }

    private void saveUserImageLocally(String imageUrl, String directoryPath) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            String fileName = String.format("user_image_%s.png", UUID.randomUUID());
            File outputDirectory = new File(directoryPath);
            if (!outputDirectory.exists()) {
                outputDirectory.mkdirs();
            }
            File outputFile = new File(outputDirectory, fileName);
            ImageIO.write(image, "png", outputFile);
            System.out.println("User's image saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
    }

}
