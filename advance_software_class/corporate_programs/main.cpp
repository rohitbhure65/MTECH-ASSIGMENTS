#include <iostream>
#include <memory>
#include <vector>
#include <string>
#include "AcademicRecord.h"
#include "Candidate.h"
#include "SelectionCriteria.h"
#include "StandardSelectionCriteria.h"
#include "CorporateProgram.h"
#include "Company.h"
#include "RecruitmentProcess.h"

using namespace std;

int main() {
    cout << "=== Corporate Sponsored Degree & Training Registration System ===\n" << endl;

    auto tcs = make_shared<Company>("TCS");
    auto wipro = make_shared<Company>("Wipro");

    auto tcsIgnite = make_shared<CorporateProgram>("Ignite MCA", "MCA", 24);
    auto wiproWilp = make_shared<CorporateProgram>("WILP M.Tech", "MTECH", 48);

    tcs->addProgram(tcsIgnite);
    wipro->addProgram(wiproWilp);

    AcademicRecord rec1("BCA", 8.5, 2024);
    Candidate c1("Ramesh", "ramesh@email.com", rec1);

    AcademicRecord rec2("BSC", 9.2, 2024);
    Candidate c2("Suresh", "suresh@email.com", rec2);

    AcademicRecord rec3("BTECH", 7.5, 2024);
    Candidate c3("Anita", "anita@email.com", rec3);

    auto wilpCriteria = make_shared<StandardSelectionCriteria>(6.0, vector<string>{"BCA", "BSC"});
    auto igniteCriteria = make_shared<StandardSelectionCriteria>(7.0, vector<string>{"BCA", "BSC"});

    RecruitmentProcess wiproProcess(wipro, wiproWilp, 2024, 1, wilpCriteria);
    RecruitmentProcess tcsProcess(tcs, tcsIgnite, 2024, 2, igniteCriteria);

    wiproProcess.apply(c1);
    wiproProcess.apply(c2);
    wiproProcess.apply(c3); 

    tcsProcess.apply(c1);
    tcsProcess.apply(c2);
    
    wiproProcess.processSelection();
    cout << endl;
    tcsProcess.processSelection();

    return 0;
}
