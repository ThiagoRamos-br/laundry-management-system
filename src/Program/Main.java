package Program;

import entities.Client;
import entities.PieceValue;
import entities.Product;
import entities.Service;
import enums.laundryServices;

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

        System.out.println("Phone:");
        int phoneClient = sc.nextInt();
        sc.nextLine();


        Client client = new Client(nameClient, phoneClient, cpfClient);

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



        System.out.println("How many pieces of clothing will you wash?");
        int amountOfRepetition = sc.nextInt();
        sc.nextLine();

            for (int i = 0 ; i < amountOfRepetition ; i ++) {
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

        System.out.println(service.toString());;





    }
}