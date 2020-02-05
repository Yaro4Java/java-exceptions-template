package com.epam.izh.rd.online;


import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.repository.UserRepository;

public class JavaExceptions {

    public static void main(String[] args) {

        {/***** DEBUGGING USER REPOSITORY *****/

            System.out.println("\n***** DEBUGGING USER REPOSITORY *****\n");


            System.out.println("1.Creating repository...");
            UserRepository userRepository = new UserRepository();

            System.out.println("The list inside repository is: " + userRepository.printInternalList());

            User admin = new User("Admin", "a");
            User vasja = new User("Vasja", "v");
            User styopa = new User("Styopa", "s");

            System.out.println("\n2.Adding users into repository...");

            userRepository.save(admin);
            userRepository.save(vasja);
            userRepository.save(styopa);

            System.out.println("The list inside repository is: " + userRepository.printInternalList());

            System.out.println("\n3.Deleting user at the index 1 in the list of repository...");

            userRepository.deleteByIndex(1);

            System.out.println("The list inside repository is: " + userRepository.printInternalList());
            System.out.println("Size of the list is: " + userRepository.size() + " ( < internal capacity of the list = 10 ) ");

            System.out.println("\n4.Trimming internal array of the list of the repository...");

            userRepository.trimNullElementsOfTheInternalArrayOfTheList();

            System.out.println("The list inside repository is: " + userRepository.printInternalList());
            System.out.println("Size of the list is: " + userRepository.size() + " ( = internal capacity of the list = 2 ) ");


            System.out.println("\n***** END OF DEBUGGING USER REPOSITORY *****\n");

        }/***** END OF DEBUGGING USER REPOSITORY *****/

    }

}
