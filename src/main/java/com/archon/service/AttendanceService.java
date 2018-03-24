package com.archon.service;

import com.archon.po.Attendance;

import java.util.List;

public interface AttendanceService {
    boolean addAttendance(Attendance attendance);
    boolean updateAttendance(Attendance attendance);
    List<Attendance> queryAttendance(Attendance attendance);
}