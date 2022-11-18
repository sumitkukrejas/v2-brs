//package com.brs.entity;
//
//import com.brs.service.Impl.MyUserDetailsService;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@NoArgsConstructor
//public class MyUserDetails implements UserDetails {
//
//    private String userName;
//    private String password;
//    private List<GrantedAuthority> authorities;
//
//    public MyUserDetails(Users1 users1){
//        this.userName = users1.getUserName();
//        this.password = users1.getPassword();
//        this.authorities = Arrays.stream(users1.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//    }
//
////ROLE_ADMIN,ROLE_USER
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
