package com.archon.service;

import com.archon.po.Resume;

import java.util.List;

public interface ResumeService {
    boolean addResume(Resume resume);
    Resume updateResume(Resume resume);
    List<Resume> queryRec(Resume resume);
    boolean deletResume(Resume resume);
}