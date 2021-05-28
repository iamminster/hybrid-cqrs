package jp.co.hybrid.write.data.service.web;


import jp.co.hybrid.write.data.service.backend.UserWriteModel;
import jp.co.hybrid.write.data.service.backend.WriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/write")
public class WriteDataController {
    @Autowired
    private WriteService writeService;

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@RequestBody UserWriteModel user) {
        return writeService.createUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") String userId, @RequestBody UserWriteModel user) {
        return writeService.updateUser(userId, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") String userId) {
        return writeService.deleteUser(userId);
    }

}
