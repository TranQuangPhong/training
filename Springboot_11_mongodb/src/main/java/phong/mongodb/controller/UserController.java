package phong.mongodb.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phong.mongodb.entity.UserEntity;
import phong.mongodb.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<UserEntity> userEntityList = userService.getUsers();
        if (userEntityList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(Optional.of(userEntityList));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getUser(id)));
    }

    /**
     * Test mongodb transaction in different ways
     * @param userEntities
     * @return
     * @throws Exception
     */
    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody List<UserEntity> userEntities) throws Exception {
//        return ResponseEntity.ok(Optional.ofNullable(userService.createMultipleUsers(userEntities)));
//        return ResponseEntity.ok(Optional.ofNullable(userService.createMultipleUsersUsingTransactionTemplate(userEntities)));
//        return ResponseEntity.ok(Optional.ofNullable(userService.createMultipleUsersUsingClientSession(userEntities)));
        return ResponseEntity.ok(Optional.ofNullable(userService.createMultipleUsersUsingClientSessionAndMongoTemplate(userEntities)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody UserEntity userEntity) {
        try {
            UserEntity updatedUserEntity = userService.updateUser(id, userEntity);
            return ResponseEntity.ok(Optional.ofNullable(updatedUserEntity));
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(Optional.ofNullable(userService.deleteUser(id)));
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getUserByEmail(email)));
    }

    @GetMapping("/age")
    public ResponseEntity<?> getUserByAge(@RequestParam("age") Short age) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getUserByAge(age)));
    }

    @GetMapping("/age/avg")
    public ResponseEntity<?> getUserAverageAgeByGender(@RequestParam("gender") String gender) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getUserAverageAgeByGender(gender)));
    }
}
