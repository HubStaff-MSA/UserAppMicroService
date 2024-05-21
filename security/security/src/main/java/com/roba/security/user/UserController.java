package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.Commands.Command;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CommandFactory commandFactory;
   //  @Autowired
    private final AuthenticationService userService;

    @PutMapping("/{userId}/profile")
//    public ResponseEntity<?> updateProfile(@PathVariable("userId") Integer userId, @RequestBody UserProfileUpdateRequest request) {
//        System.out.println("gg");
//        userService.updateUserProfile(userId, request);
//        return ResponseEntity.ok().build();
//    }

    public ResponseEntity<Object> updateProfile(@PathVariable("userId") Integer userId, @RequestBody UserProfileUpdateRequest request) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Command command = commandFactory.createUpdateProfileCommand(userId, request);
        command.execute();
//
//        Field cmdMapField = CommandsMap.class.getDeclaredField("cmdMap");
//
//        // Make the field accessible
//        cmdMapField.setAccessible(true);
//        // Get the cmdMap value
//        Object cmdMapValue = cmdMapField.get(null);
//        // Assuming cmdMapValue is a Map<String, Class<?>>
//        ConcurrentHashMap<String, Class<?>> cmdMap = (ConcurrentHashMap<String, Class<?>>) cmdMapValue;
//
//        Class<?> commandClass = (Class<?>) cmdMap.get(request.getCommand());
//
//        Object commandInstance = commandClass.newInstance();
//
////         Get the build method of the command class
//        Method buildMethod = commandClass.getDeclaredMethod("build", String.class);
//
//        // Invoke the build method
//        buildMethod.invoke(commandInstance, request.getPayload());
//
//        // Get the execute method of the command class
//        Method executeMethod = commandClass.getDeclaredMethod("execute",Integer.class);
//
//        // Invoke the execute method
//        executeMethod.invoke(commandInstance,userId);
//
//        // Get the returned field of the command class
//        Field returnedField = commandClass.getDeclaredField("returned");
//
//        // Make the field accessible
//        returnedField.setAccessible(true);
//
//        // Get the value of the returned field from the command instance
//        String returnedValue = (String) returnedField.get(commandInstance);
//
//        // Cast the returned value to TrackTime
//        return returnedValue;






        return ResponseEntity.ok().build();
    }


    @PutMapping("/{userId}/password")
//    public ResponseEntity<?> changePassword(@PathVariable("userId") Integer userId, @RequestBody ChangePasswordRequest request) {
//        userService.changeUserPassword(userId, request);
//        return ResponseEntity.ok().build();
//    }
    public ResponseEntity<Object> changePassword(@PathVariable("userId") Integer userId, @RequestBody ChangePasswordRequest request) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Command command = commandFactory.createChangePasswordCommand(userId, request);
        command.execute();
        return ResponseEntity.ok().build();
//        Field cmdMapField = CommandsMap.class.getDeclaredField("cmdMap");
//
//        // Make the field accessible
//        cmdMapField.setAccessible(true);
//        // Get the cmdMap value
//        Object cmdMapValue = cmdMapField.get(null);
//        // Assuming cmdMapValue is a Map<String, Class<?>>
//        ConcurrentHashMap<String, Class<?>> cmdMap = (ConcurrentHashMap<String, Class<?>>) cmdMapValue;
//
//        Class<?> commandClass = (Class<?>) cmdMap.get(request.getCommand());
//
//        Object commandInstance = commandClass.newInstance();
//
////         Get the build method of the command class
//        Method buildMethod = commandClass.getDeclaredMethod("build", String.class);
//
//        // Invoke the build method
//        buildMethod.invoke(commandInstance, request.getPayload());
//
//        // Get the execute method of the command class
//        Method executeMethod = commandClass.getDeclaredMethod("execute", null);
//
//        // Invoke the execute method
//        executeMethod.invoke(commandInstance);
//
//        // Get the returned field of the command class
//        Field returnedField = commandClass.getDeclaredField("returned");
//
//        // Make the field accessible
//        returnedField.setAccessible(true);
//
//        // Get the value of the returned field from the command instance
//        String returnedValue = (String) returnedField.get(commandInstance);
//
//        // Cast the returned value to TrackTime
//        return returnedValue;
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        Command command = commandFactory.createGetAllUsersCommand();
        command.execute();
        return userService.getAllUsers();
    }


//    @GetMapping("/{userId}")
//    //@Cacheable(key="#id",value="User")
//    public Optional<User> getUserById(@PathVariable Integer userId) {
//        Command command = commandFactory.createGetUserByIdCommand(userId);
//        command.execute();
//        return userService.getUserById(userId);
//    }



    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getuserById(userId);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        Command command = commandFactory.createGetUsersByRoleCommand(role);
        command.execute();
        return userService.getUsersByRole(role);
    }

//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<?> deleteUserById(@PathVariable("userId") Integer userId) {
//        Command command = commandFactory.createDeleteUserCommand(userId);
//        command.execute();
//        userService.deleteUserById(userId);
//        return ResponseEntity.ok().build();
//    }





}
