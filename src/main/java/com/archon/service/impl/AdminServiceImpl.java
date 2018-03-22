package com.archon.service.impl;

import com.archon.dao.AdminDao;
import com.archon.po.Admin;
import com.archon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;

    /*public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }*/

    @Override
    public Admin queryAdmin(Admin admin) {
        return adminDao.queryAdminByName(admin);
    }

    @Override
    public boolean registerAdmin(Admin admin) {
        Admin admin1 = queryAdmin(admin);
        if (admin1 != null) {
            return false;
        }
        boolean b = adminDao.addAdmin(admin);
        return b;
    }

    @Override
    public Admin loginAdmin(Admin admin) {
        Admin admin1 = queryAdmin(admin);
/*        if (admin1 == null) {
            throw new IllegalArgumentException("用户名或密码不存在");
        }*/
        return  admin1;
    }
}