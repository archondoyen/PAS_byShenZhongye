package com.archon.dao;

import com.archon.po.Attendance;

import java.util.List;

public interface AttendanceDao {
    boolean addAttendance(Attendance attendance);
    boolean updateAttendance(Attendance attendance);
    List<Attendance> queryAttendance(Attendance attendance);
}