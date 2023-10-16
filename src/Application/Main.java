package Application;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final String[] applicants = {"John", "Anna", "Paul", "August", "Jenny"};
    private static final double baseSalary = 2000.0;

    public static void main(String[] args) {
        System.out.println("Recruitment Process!");

        for (String applicant : applicants) {
            callApplicant(applicant);
        }

        printSelectedApplicants();
    }

    static void callApplicant(String applicant) {
        int attempts = 1;
        boolean tryAgain;
        boolean answered = false;

        do {
            answered = answerCall();
            tryAgain = !answered;

            if (tryAgain) {
                attempts++;
            } else {
                System.out.println("Successful contact!");
            }
        } while (tryAgain && attempts < 3);

        if (answered) {
            System.out.println("Successful contact with " + applicant + " after " + attempts + " attempts.");
        } else {
            System.out.println("Contact with applicant " + applicant + " not carried out after the maximum number of attempts.");
        }
    }

    static boolean answerCall() {
        return new Random().nextInt(3) == 1;
    }

    static void printSelectedApplicants() {
        System.out.println("List of selected applicants:");

        int selectedApplicants = 0;

        for (String applicant : applicants) {
            double intendedSalary = intendedSalary();
            System.out.println("Applicant name: " + applicant + ", Intended Salary: $" + intendedSalary);
            if (baseSalary >= intendedSalary) {
                System.out.println("The applicant " + applicant + " was selected for the next stage.");
                selectedApplicants++;
            }
        }
    }

    static double intendedSalary() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void applicantReview(double intendedSalary) {
        if (baseSalary > intendedSalary) {
            System.out.println("Call applicant.");
        } else if (baseSalary == intendedSalary) {
            System.out.println("Call the applicant offering a counteroffer.");
        } else {
            System.out.println("Waiting for results from other applicants...");
        }
    }
}
