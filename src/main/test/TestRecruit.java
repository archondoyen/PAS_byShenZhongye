import com.archon.po.Recruitment;
import com.archon.service.RecruitmentService;
import com.archon.service.impl.RecruitmentServiceImpl;

public class TestRecruit {
    public static void main(String[] args) {
        RecruitmentService recruitmentService = new RecruitmentServiceImpl();
        Recruitment r = new Recruitment();
        r.setJobAndDeptId(10);
        r.setCreaterId(81);
        recruitmentService.queryRec(r);
    }
}