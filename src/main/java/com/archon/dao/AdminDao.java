package com.archon.dao;

import com.archon.po.Admin;

public interface AdminDao {
    Admin queryAdmin(Admin admin);
    Admin queryAdminByName(Admin admin);
    boolean addAdmin(Admin admin);
}