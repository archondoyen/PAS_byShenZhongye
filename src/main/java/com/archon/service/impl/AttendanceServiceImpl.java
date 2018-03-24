package com.archon.service.impl;

import com.archon.dao.AttendanceDao;
import com.archon.po.Attendance;
import com.archon.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="AttendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;
    @Override
    public boolean addAttendance(Attendance attendance) {
        return attendanceDao.addAttendance(attendance);
    }

    @Override
    public boolean updateAttendance(Attendance attendance) {
        return attendanceDao.updateAttendance(attendance);
    }

    @Override
    public List<Attendance> queryAttendance(Attendance attendance) {
        return attendanceDao.queryAttendance(attendance);
    }
}