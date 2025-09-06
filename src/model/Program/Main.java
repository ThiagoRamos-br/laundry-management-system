// Main.java
package model.Program;

import model.Exception.Domain.LaundryException;
import model.entities.Client;
import model.entities.PieceValue;
import model.entities.Product;
import model.Service.PaymentService;
import model.enums.laundryServices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amountOfRepetition = 0;

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
            sc.nextLine(); // Consome a quebra de linha
            client = new Client(nameClient, phoneClient, cpfClient);
        } catch (LaundryException e) {
            System.out.println("Error: " + e.getMessage());
        }


        PaymentService service = new PaymentService(client);

        // --- INÍCIO: BLOCO ÚNICO E CORRETO PARA ESCOLHA DO SERVIÇO ---
        try {
            System.out.println("Type of wash: NORMAL / A_SECO / DELICADA");
            System.out.println("1 - NORMAL \n 2 - A SECO \n 3 - DELICADA ");
            int desc = sc.nextInt();

            sc.nextLine(); // Consome a quebra de linha após o número

            switch (desc) {
                case 1:
                    service.chooseTypeOfWash(laundryServices.NORMAL);
                    break;
                case 2:
                    service.chooseTypeOfWash(laundryServices.A_SECO);
                    break;
                case 3:
                    service.chooseTypeOfWash(laundryServices.DELICADA);
                    break;
                default:
                    throw new LaundryException("Invalid wash type selected.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
        } catch (LaundryException e) {
            System.out.println(e.getMessage());
        }
        // --- FIM: BLOCO ÚNICO E CORRETO PARA ESCOLHA DO SERVIÇO ---

        // --- INÍCIO: BLOCO PARA ADICIONAR PEÇAS DE ROUPA ---
        try {
            System.out.println("How many pieces of clothing will you wash?");
            amountOfRepetition = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha
        } catch (InputMismatchException e) {
            System.out.println("Invalid option!!!");
            sc.nextLine();
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
        // --- FIM: BLOCO PARA ADICIONAR PEÇAS DE ROUPA ---

        // --- IMPRESSÃO FINAL DO SERVIÇO ---
        System.out.println();
        System.out.println("--- Your Receipt ---");
        System.out.println(service.toString());

        // Apenas UMA chamada para fechar o scanner no final do programa
        sc.close();
    }
}