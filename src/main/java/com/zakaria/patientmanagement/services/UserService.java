package com.zakaria.patientmanagement.services;

import com.zakaria.patientmanagement.models.Role;
import com.zakaria.patientmanagement.models.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);
    User authenticate(String userName, String password);
}
