package silab.nst.dan9.springJpa.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import silab.nst.dan9.springJpa.config.Config;
import silab.nst.dan9.springJpa.domain.Stats;
import silab.nst.dan9.springJpa.domain.User;
import silab.nst.dan9.springJpa.repository.Repository;
import silab.nst.dan9.springJpa.service.StatsService;
import silab.nst.dan9.springJpa.service.UserService;

import java.util.List;

@Component
public class Main {
    @Autowired
    private Repository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StatsService statsService;


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Main main = context.getBean(Main.class);

//        main.saveUserInRepository();

//        main.findUserById(35l);

//        main.updateUserInRepository(350l);

//        main.deleteUserFromRepository(39l);

//        main.upDateStatsInRepository();

        main.getAllStatsFromRepository();

        main.getAllUsersFromRepository();
    }

    private void upDateStatsInRepository() {
        try {
            statsService.updateStats("users", 1l);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllStatsFromRepository() {
        try {
            List<Stats> stats = statsService.getAllStats();
            System.out.println("\n\nStats: => ");
            stats.forEach(stat -> System.out.println(stat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUserInRepository(Long id) {
        try {
            User foundUser = userService.findUserById(id);
            if (foundUser != null) {
                foundUser.setFirstName("Andrew");
                User updatedUser = userService.update(foundUser);
                System.out.println("User was successfully updated");
                System.out.println("Updated User: => " + updatedUser);
            } else {
                System.out.println("User doesn't exist!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteUserFromRepository(Long id) {
        try {
            User foundUser = userService.findUserById(id);
            if (foundUser != null) {
                userService.delete(foundUser);
                statsService.updateStats("users", 1l);
                System.out.println("User was successfully deleted.");
                System.out.println("Stats was updated.");
            } else {
                System.out.println("User doesn't exist!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findUserById(Long id) {
        try {
            User foundUser = userService.findUserById(id);
            if (foundUser != null) {
                System.out.println("User found: => " + foundUser);
            } else {
                System.out.println("User doesn't exist!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUserInRepository() {

        User user = new User("John", "Smith", "john", "smith");
        try {
            User addedUser = userService.add(user);
            if (addedUser != null) {
                statsService.updateStats("users", 1l);
                System.out.println("User was successfully saved.");
                System.out.println("Stats was updated.");
            } else {
                System.out.println("User was not saved!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllUsersFromRepository() {
        try {
            List<User> users = userService.getAllUsers();
            System.out.println("\n\nUsers: => ");
            users.forEach(user -> System.out.println(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
