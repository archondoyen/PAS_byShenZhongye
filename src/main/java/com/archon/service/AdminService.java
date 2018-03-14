package com.archon.service;

import com.archon.dao.AdminDao;
import com.archon.po.Admin;

public interface AdminService {
    Admin queryAdmin(Admin admin);
    boolean registerAdmin(Admin admin);
    Admin loginAdmin(Admin admin);
}