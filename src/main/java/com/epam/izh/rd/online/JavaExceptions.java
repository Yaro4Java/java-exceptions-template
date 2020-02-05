package com.epam.izh.rd.online;


import com.epam.izh.rd.online.entity.User;
import com.epam.izh.rd.online.exception.NotCorrectPasswordException;
import com.epam.izh.rd.online.exception.UserNotFoundException;
import com.epam.izh.rd.online.repository.UserRepository;
import com.epam.izh.rd.online.service.AuthenticationService;
import com.epam.izh.rd.online.service.CurrentUserManager;

public class JavaExceptions {

    public static void main(String[] args) {

        {/***** DEBUGGING USER REPOSITORY AND SERVICES *****/

            System.out.println("\n***** DEBUGGING USER REPOSITORY AND SERVICES*****\n");


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

            AuthenticationService authenticationService = new AuthenticationService(userRepository);

            System.out.println("\n5.Styopa is trying to log in...");
            try {
                System.out.println("Result of login is: " + authenticationService.login(styopa));
            } catch (UserNotFoundException | NotCorrectPasswordException e) {
                e.printStackTrace();
            }
            System.out.println("Current user is: " + CurrentUserManager.getCurrentLoggedInUser());

            System.out.println("\n6.Styopa is trying to log in with wrong password...");
            try {
                System.out.println("Result of login is: " + authenticationService.login(new User("Styopa", "password")));
            } catch (UserNotFoundException | NotCorrectPasswordException e) {
                e.printStackTrace();
            }
            System.out.println("Current user is: " + CurrentUserManager.getCurrentLoggedInUser());


            System.out.println("\n***** END OF DEBUGGING USER REPOSITORY AND SERVICES *****\n");

        }/***** END OF DEBUGGING USER REPOSITORY AND SERVICES*****/

    }

}
