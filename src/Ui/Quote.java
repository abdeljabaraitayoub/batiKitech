package Ui;

import Entitie.Project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Quote extends Main {

    private final Service.Quote service = new Service.Quote();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Quote().choice();

    }

    @Override
    public void display() {
        clear();
        System.out.println("=== Quote Menu ===");
        System.out.println("1. Update a Quote");
        System.out.println("2. List all Quotes");
        System.out.println("3. Get Quote by id");
        System.out.println("4. Get Quote by project");
        System.out.println("5. Accept Quote");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

    @Override
    public void choice() {
        int option = 1;
        while (true) {
            display();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    clear();
                    update(null);
                    pause();
                    break;
                case 2:
                    clear();
                    list();
                    pause();
                    break;
                case 3:
                    clear();
                    get();
                    pause();
                    break;
                case 4:
                    clear();
                    listByProject(null);
                    pause();
                    break;
                case 5:
                    clear();
                    accept(null);
                    pause();
                    break;

                case 0:
                    new Menu().choice();
                    break;
                default:
                    System.out.println("Invalid option");

            }
        }

    }


    public List<Entitie.Quote> list() {
        List<Entitie.Quote> quotes = service.list();
        quotes.forEach(System.out::println);
        return quotes;
    }

    public Entitie.Quote get() {
        System.out.println("enter quote id: ");
        int id = scanner.nextInt();
        Entitie.Quote quote = service.get(id);
        System.out.println(quote);
        return quote;
    }

    public List<Entitie.Quote> listByProject(Project project) {
        if (project == null) {
            project = new Ui.Project().get();
        }
        clear();
        List<Entitie.Quote> quotes = service.ListByProject(project);
        quotes.forEach(System.out::println);
        return quotes;
    }

    public void update(Entitie.Quote quote) {
        if (quote == null) {
            quote = get();
        }
        System.out.println("do you want to update this quote? y/n");
        if (!scanner.next().equalsIgnoreCase("y")) {
            return;
        }
        System.out.println("enter quote validity date (yyyy/MM/dd): ");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date validity = null;
        try {
            validity = dateFormat.parse(scanner.next());
        } catch (Exception e) {
            System.err.println("Invalid date format");
        }
        System.out.println("enter estimated amount: ");
        double estimatedAmount = scanner.nextDouble();
        quote.setEstimatedAmount(estimatedAmount);
        quote.setValidityDate(validity);
        service.update(quote.getId(), quote);
    }

    public void accept(Entitie.Quote quote) {
        if (quote == null) {
            quote = get();
            if (quote == null) {
                return;
            }
        }
        if (quote.getValidityDate().before(new Date())) {
            System.err.println("Quote is expired");
            return;
        }
        System.out.println("do you want to accept this quote? y/n");
        if (!scanner.next().equalsIgnoreCase("y")) {
            return;
        }
        quote.setIsAccepted(true);
        service.update(quote.getId(), quote);
    }

    public void create(Project project) {
        System.out.println("Creating quote for project: " + project);
        System.out.println("enter quote validity date (yyyy/MM/dd): ");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date validity = null;
        try {
            validity = dateFormat.parse(scanner.next());
        } catch (Exception e) {
            System.err.println("Invalid date format");
        }

        Entitie.Quote quote = new Entitie.Quote(0, 0, new Date(), validity, false, project);
        service.create(quote);
    }
}
