package com.example.Auth;
// package com.example.cinema.Auth;

// import com.example.cinema.ResetSecurity.ResetTokenService;
// import com.example.cinema.entity.User;
// import com.example.cinema.repository.UserRepository;
// import com.example.cinema.service.UserService;
// import jakarta.servlet.http.HttpServletResponse;
// import lombok.RequiredArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.Map;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/auth")
// @RequiredArgsConstructor
// public class AuthController {
//     @Autowired
//     private  final ResetTokenService resetTokenService;
//     @Autowired
//     private  final AuthenticationService service;
//     @Autowired
//     private final PasswordEncoder passwordEncoder;
//     @Autowired
//     private final UserService userService;
//     @Autowired
//     private final UserRepository userRepository;


//     @PostMapping("/register")
//     public ResponseEntity<AuthenticationResponse> register(
//             @RequestBody RegisterRequest request,
//             HttpServletResponse response
//     ) {
//         AuthenticationResponse authenticationResponse = service.register(request, response);
//         return ResponseEntity.ok(authenticationResponse);
//     }
//     @PostMapping("/login")
//     public ResponseEntity<AuthenticationResponse> authenticate(
//             @RequestBody AuthenticationRequest request,
//             HttpServletResponse response
//     ) {
//         AuthenticationResponse authenticationResponse = service.authenticate(request, response);
//         return ResponseEntity.ok(authenticationResponse);
//     }
//     @PostMapping("/forgot-password")
//     public ResponseEntity<String> requestPasswordReset(@RequestBody Map<String, String> request) {
//         String email = request.get("email");
//         boolean emailExists = userService.emailExists(email);
//         if (emailExists) {
//             userService.initiatePasswordReset(email);
//             return ResponseEntity.ok("Password reset instructions sent to your email.");
//         } else {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
//         }
//     }
//     @PostMapping("/reset")
//     public ResponseEntity<String> handlePasswordReset(@RequestBody Map<String, String> request) {
//         String token = request.get("token");
//         String newPassword = request.get("newPassword");
//         if (resetTokenService.validateToken(token)) {
//             Optional<User> optionalUser = resetTokenService.findUserByPasswordToken(token);
//             if (optionalUser.isPresent()) {
//                 User user = optionalUser.get();
//                 passwordEncoder.encode(newPassword);
//                 user.setPassword(passwordEncoder.encode(newPassword));
//                 userRepository.save(user);
//                 resetTokenService.deleteToken(token);
//                 resetTokenService.invalidateToken(token);
//                 return ResponseEntity.ok("Password reset successful");
//             } else {
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//             }
//         } else {
//             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token");
//         }
//     }
// }
