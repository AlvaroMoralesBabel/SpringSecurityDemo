package es.neesis.security.controller;

import es.neesis.security.auth.JwtUtil;
import es.neesis.security.service.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserListController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;


    @RequestMapping(value = "/list", method = RequestMethod.GET,
            consumes = "application/x-www-form-urlencoded")
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        List<UserDetails> users = userDetailsServiceImpl.loadAllUsers();


        System.out.println("Users: " + users);

        if (auth.isAuthenticated()) {
            RedirectView redirectView;
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equalsIgnoreCase("ADMIN"))) {

            } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equalsIgnoreCase("GESTION"))) {

            } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equalsIgnoreCase("CONSULTA"))) {

            } else {

            }


        }


        model.addAttribute("users", users);

        return ("/userList");
    }

}
