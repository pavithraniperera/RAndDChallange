package lk.ijse.randdchallange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class WeavyController {
    @Autowired
    private WeavyService weavyServer;

    @PostMapping("/create")
    public String createUser(@RequestParam String name, @RequestParam String email) throws IOException {
        return weavyServer.createUser(name, email);
    }

    @GetMapping("/list")
    public String listUsers() throws IOException {
        return weavyServer.listUsers();
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable String userId,
                             @RequestParam String newName,
                             @RequestParam String newEmail) throws IOException {
        return weavyServer.updateUser(userId, newName, newEmail);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) throws IOException {
        return weavyServer.deleteUser(userId);
    }









}
