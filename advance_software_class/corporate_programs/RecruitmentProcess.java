package corporate_programs;

import java.util.ArrayList;
import java.util.List;

public class RecruitmentProcess {
    private Company company;
    private CorporateProgram program;
    private int batchYear;
    private int intakeCapacity;
    private SelectionCriteria criteria;
    private List<Candidate> applicants;
    private List<Candidate> selectedCandidates;

    public RecruitmentProcess(Company company, CorporateProgram program, int batchYear, int intakeCapacity, SelectionCriteria criteria) {
        this.company = company;
        this.program = program;
        this.batchYear = batchYear;
        this.intakeCapacity = intakeCapacity;
        this.criteria = criteria;
        this.applicants = new ArrayList<>();
        this.selectedCandidates = new ArrayList<>();
    }

    public void apply(Candidate candidate) {
        applicants.add(candidate);
    }

    public void processSelection() {
        List<Candidate> eligible = new ArrayList<>();
        for (Candidate c : applicants) {
            if (criteria.isEligible(c)) {
                eligible.add(c);
            }
        }
        
        eligible.sort((c1, c2) -> Double.compare(criteria.calculateScore(c2), criteria.calculateScore(c1)));

        System.out.println("--- Selection List for " + company.getName() + " " + program.getProgramName() + " (" + batchYear + ") ---");
        int count = 0;
        for (Candidate c : eligible) {
            if (count < intakeCapacity) {
                selectedCandidates.add(c);
                System.out.println(c.getName() + " - Selected with CGPA: " + c.getRecord().getCgpa());
                count++;
            }
        }
        if (selectedCandidates.isEmpty()) {
            System.out.println("No candidates met the eligibility criteria or applied.");
        }
        System.out.println("-------------------------------------------------");
    }
}
