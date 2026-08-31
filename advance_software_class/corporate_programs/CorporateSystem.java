package corporate_programs;

import java.util.Arrays;

public class CorporateSystem {
    public static void main(String[] args) {
        System.out.println("=== Corporate Sponsored Degree & Training Registration System ===\n");

        Company tcs = new Company("TCS");
        Company wipro = new Company("Wipro");

        CorporateProgram tcsIgnite = new CorporateProgram("Ignite MCA", ProgramCategory.MCA, 24);
        CorporateProgram wiproWilp = new CorporateProgram("WILP M.Tech", ProgramCategory.MTECH, 48);

        tcs.addProgram(tcsIgnite);
        wipro.addProgram(wiproWilp);

        AcademicRecord rec1 = new AcademicRecord(EligibilityType.BCA, 8.5, 2024);
        Candidate c1 = new Candidate("Ramesh", "ramesh@email.com", rec1);

        AcademicRecord rec2 = new AcademicRecord(EligibilityType.BSC, 9.2, 2024);
        Candidate c2 = new Candidate("Suresh", "suresh@email.com", rec2);

        AcademicRecord rec3 = new AcademicRecord(EligibilityType.BTECH, 7.5, 2024);
        Candidate c3 = new Candidate("Anita", "anita@email.com", rec3);

        SelectionCriteria wilpCriteria = new StandardSelectionCriteria(6.0, Arrays.asList(EligibilityType.BCA, EligibilityType.BSC));
        SelectionCriteria igniteCriteria = new StandardSelectionCriteria(7.0, Arrays.asList(EligibilityType.BCA, EligibilityType.BSC));

        RecruitmentProcess wiproProcess = new RecruitmentProcess(wipro, wiproWilp, 2024, 1, wilpCriteria);
        RecruitmentProcess tcsProcess = new RecruitmentProcess(tcs, tcsIgnite, 2024, 2, igniteCriteria);

        wiproProcess.apply(c1);
        wiproProcess.apply(c2);
        wiproProcess.apply(c3); 

        tcsProcess.apply(c1);
        tcsProcess.apply(c2);
        
        wiproProcess.processSelection();
        System.out.println();
        tcsProcess.processSelection();
    }
}
