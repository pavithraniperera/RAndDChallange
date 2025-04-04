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







}
