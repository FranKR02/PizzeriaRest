package projects.pizzeria.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projects.pizzeria.persistence.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findById(username)
                .orElseThrow(()-> new UsernameNotFoundException("USER " + username + " NOT FOUND"));
        String[] roles = user.getRoleList().stream().map(userRole -> userRole.getId().getRole()).toArray(String[]::new);
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(grantedAuthorities(roles))
                .accountLocked(user.getLocked())
                .disabled(user.getDisable()).build();
    }
    private String[] getAuthorities(String rol){
        if("ADMIN".equalsIgnoreCase(rol) || "CUSTOMER".equalsIgnoreCase(rol)){
            return new String[]{"authority"};
        }
        return new String[]{};
    }
    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for(String rol: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+ rol));
            for(String authority: getAuthorities(rol)){
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
