//package com.roba.user;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class UserService {
//
//
//    private final UserRepository userRepository;
////    public void saveUser(User user) {
////
////
////        userRepository.save(user);
////    }
//
//    public void createUser(UserRequest userRequest) {
//        User user = User.builder().fullName(userRequest.getFullName())
//                .workEmail(userRequest.getWorkEmail()).password(userRequest.getPassword()).role(userRequest.getRole()).build();
//        userRepository.save(user);
//        log.info("is saved user: {}", user);
//    }
//
//    public List<UserResponse> getAllUsers(){
//        List<User> users= userRepository.findAll();
//        return users.stream().map(this::mapToUserResponse).toList();
//    }
//    private UserResponse  mapToUserResponse (User user ){
//        return  UserResponse.builder().
//                id(user.getId())
//                .fullName(user.getFullName()).workEmail(user.getWorkEmail()).password(user.getPassword()).role(user.getRole()).build();
//    }
//
//}
