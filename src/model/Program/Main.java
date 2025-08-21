package model.Program;

import model.Exception.Domain.LaundryException;
import model.entities.Client;
import model.entities.PieceValue;
import model.entities.Product;
import model.entities.Service;
import model.enums.laundryServices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Laundry customer registration");
        System.out.println();

        System.out.println("===Client===");
        System.out.println("Name:");
        String nameClient = sc.nextLine();

        System.out.println("CPF:");
        String cpfClient = sc.nextLine();

        Client client = null;

        try {
            System.out.println("Phone:");
            long phoneClient = sc.nextLong();
            sc.nextLine(); // Adicionado para consumir a quebra de linha

            client = new Client(nameClient, phoneClient, cpfClient);

        } catch (LaundryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Service service = new Service(client);

        laundryServices laundryServices = null;

        while (true) {
            try {
                System.out.println("Type of wash: NORMAL / A_SECO / DELICADA");
                String desc = sc.nextLine().toUpperCase();
                laundryServices = laundryServices.valueOf(desc); // conversão segura
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid wash type. Try again.");
            }
        }

        service.chooseTypeOfWash(laundryServices);

        int amountOfRepetition = 0;

        try {
            System.out.println("How many pieces of clothing will you wash?");
            amountOfRepetition = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid option!!!");
        }


        for (int i = 0; i < amountOfRepetition; i++) {
            System.out.println("Par type:");
            String parTypeProduct = sc.nextLine();

            System.out.println("color:");
            String colorProduct = sc.nextLine();

            System.out.println("mark:");
            String markProduct = sc.nextLine();


            Product product = new Product(markProduct, colorProduct, parTypeProduct);
            PieceValue pieceValue = new PieceValue(product);

            service.addProduct(pieceValue);
        }

        System.out.println(service.toString());

        // Apenas UMA chamada para fechar o scanner no final do programa
        sc.close();
    }
}