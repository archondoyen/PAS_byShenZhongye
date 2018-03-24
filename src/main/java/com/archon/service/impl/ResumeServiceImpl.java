package com.archon.service.impl;

import com.archon.dao.ResumeDao;
import com.archon.po.Resume;
import com.archon.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "ResumeService")
public class ResumeServiceImpl  implements ResumeService{
    @Autowired
    private ResumeDao resumeDao;
    @Override
    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    @Override
    public Resume updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    @Override
    public List<Resume> queryRec(Resume resume) {
        return resumeDao.queryRec(resume);
    }

    @Override
    public boolean deletResume(Resume resume) {
        return resumeDao.deletResume(resume);
    }
}