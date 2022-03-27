package com.example.lab5.Services;

import com.example.lab5.DBModels.Role;
import com.example.lab5.Repositories.RoleDao;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findRoleByName(name);
    }
}
