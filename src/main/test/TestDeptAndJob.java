import com.archon.dao.DeptAndJobDao;
import com.archon.po.DeptAndJob;
import com.archon.service.DeptAndJobService;
import com.archon.service.impl.DeptAndJobServiceImpl;

import java.util.List;

public class TestDeptAndJob {
    public static void main(String[] args) {
        DeptAndJobService deptAndJobService = new DeptAndJobServiceImpl();
        DeptAndJob deptAndJob = new DeptAndJob();
        deptAndJob.setCompanyId(5);
        List<DeptAndJob> deptAndJobs = deptAndJobService.queryDeptAndJob(deptAndJob);
        System.out.println(deptAndJobs.size());
    }
}