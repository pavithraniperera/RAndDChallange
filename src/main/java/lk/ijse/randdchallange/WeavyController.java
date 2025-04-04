package lk.ijse.randdchallange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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





}
