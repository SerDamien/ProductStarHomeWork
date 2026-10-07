package Homework.CollectionsLearn.Practice2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoworkingSystemTest {

    @Test
    void addWorkspace() {
        Workspace workspace1 = new Workspace(1, "Переговорная", true);
        Workspace workspace2 = new Workspace(2, "Рабочее место", true);
        Workspace workspace3 = new Workspace(3, "Рабочее место", true);
        CoworkingSystem system = new CoworkingSystem();
        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        int quantity = system.getWorkspaces().size();
        assertEquals(3, quantity);
    }

    @Test
    void removeWorkspace() {
        Workspace workspace1 = new Workspace(1, "Переговорная", true);
        Workspace workspace2 = new Workspace(2, "Рабочее место", true);
        Workspace workspace3 = new Workspace(3, "Рабочее место", true);
        CoworkingSystem system = new CoworkingSystem();
        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        system.removeWorkspace(workspace1);
        system.removeWorkspace(workspace2);
        assertEquals(1, system.getWorkspaces().size());
    }

    @Test
    void registerUser() {
        User user1 = new User("John", "Doe");
        User user2 = new User("Jane", "Jill");
        User user3 = new User("Polihn", "Doe");
        User user4 = new User("Jaynene", "Jill");
        CoworkingSystem system = new CoworkingSystem();
        system.registerUser(user1);
        system.registerUser(user2);
        system.registerUser(user3);
        assertEquals(3, system.getUserSpaceMap().size());
    }

    @Test
    void bookWorkspace() {

        User user1 = new User("John", "Doe");
        User user2 = new User("Jane", "Jill");
        User user3 = new User("Polihn", "Doe");
        User user4 = new User("Jaynene", "Jill");
        CoworkingSystem system = new CoworkingSystem();
        system.registerUser(user1);
        system.registerUser(user2);
        system.registerUser(user3);
        Workspace workspace1 = new Workspace(1, "Переговорная", true);
        Workspace workspace2 = new Workspace(2, "Рабочее место", true);
        Workspace workspace3 = new Workspace(3, "Рабочее место", true);
        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        system.bookWorkspace(user1, workspace1);
        system.bookWorkspace(user2, workspace2);
        system.bookWorkspace(user3, workspace3);
        system.bookWorkspace(user4, workspace3);
        assertEquals(3, system.getUserSpaceMap().size());
    }

    @Test
    void cancelWorkspace() {
        User user1 = new User("John", "Doe");
        User user2 = new User("Jane", "Jill");
        User user3 = new User("Polihn", "Doe");
        User user4 = new User("Jaynene", "Jill");
        CoworkingSystem system = new CoworkingSystem();
        system.registerUser(user1);
        system.registerUser(user2);
        system.registerUser(user3);
        Workspace workspace1 = new Workspace(1, "Переговорная", true);
        Workspace workspace2 = new Workspace(2, "Рабочее место", true);
        Workspace workspace3 = new Workspace(3, "Рабочее место", true);
        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        system.bookWorkspace(user1, workspace1);
        system.bookWorkspace(user2, workspace2);
        system.bookWorkspace(user3, workspace3);

        system.cancelWorkspace(user1, workspace1);
        system.cancelWorkspace(user2, workspace2);
        system.cancelWorkspace(user3, workspace3);
        assertEquals(3, system.showAvailableWorkspaces());
    }

    @Test
    void showAvailableWorkspaces() {
        Workspace workspace1 = new Workspace(1, "Переговорная", true);
        Workspace workspace2 = new Workspace(2, "Рабочее место", true);
        Workspace workspace3 = new Workspace(3, "Рабочее место", true);
        CoworkingSystem system = new CoworkingSystem();
        system.addWorkspace(workspace1);
        system.addWorkspace(workspace2);
        system.addWorkspace(workspace3);
        assertEquals(3, system.showAvailableWorkspaces());
    }
}