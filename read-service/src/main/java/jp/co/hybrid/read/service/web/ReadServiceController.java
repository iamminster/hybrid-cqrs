package jp.co.hybrid.read.service.web;

import jp.co.hybrid.read.service.backend.ReadService;
import jp.co.hybrid.read.service.backend.UserReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/read")
public class ReadServiceController {
    @Autowired
    private ReadService readService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserReadModel> findUser(@PathVariable("id") String userId) {
        UserReadModel user = readService.find(userId);
        return user == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserReadModel>> findAllUser() {
        List<UserReadModel> users = readService.findAll();
        return ResponseEntity.ok(users);
    }
}
