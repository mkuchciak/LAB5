package com.example.lab5.Services;

import com.example.lab5.DBModels.Role;
import com.example.lab5.Repositories.RoleDao;
import org.springframework.stereotype.Service;

public interface RoleService {
    Role findByName(String name);
}
