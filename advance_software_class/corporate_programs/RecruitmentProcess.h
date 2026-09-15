#pragma once
#include <iostream>
#include <vector>
#include <memory>
#include <algorithm>
#include "Company.h"
#include "CorporateProgram.h"
#include "SelectionCriteria.h"
#include "Candidate.h"

using namespace std;

class RecruitmentProcess {
    shared_ptr<Company> company;
    shared_ptr<CorporateProgram> program;
    int batchYear;
    int intakeCapacity;
    shared_ptr<SelectionCriteria> criteria;
    vector<Candidate*> applicants;
    vector<Candidate*> selectedCandidates;

public:
    RecruitmentProcess(shared_ptr<Company> company, shared_ptr<CorporateProgram> program, int batchYear, int intakeCapacity, shared_ptr<SelectionCriteria> criteria)
        : company(company), program(program), batchYear(batchYear), intakeCapacity(intakeCapacity), criteria(criteria) {}

    void apply(Candidate& candidate) {
        applicants.push_back(&candidate);
    }

    void processSelection() {
        vector<Candidate*> eligible;
        for (Candidate* c : applicants) {
            if (criteria->isEligible(*c)) {
                eligible.push_back(c);
            }
        }

        sort(eligible.begin(), eligible.end(), [this](Candidate* c1, Candidate* c2) {
            return criteria->calculateScore(*c1) > criteria->calculateScore(*c2);
        });

        cout << "--- Selection List for " << company->getName() << " " << program->getProgramName() << " (" << batchYear << ") ---" << endl;
        int count = 0;
        for (Candidate* c : eligible) {
            if (count < intakeCapacity) {
                selectedCandidates.push_back(c);
                cout << c->getName() << " - Selected with CGPA: " << c->getRecord().getCgpa() << endl;
                count++;
            }
        }
        if (selectedCandidates.empty()) {
            cout << "No candidates met the eligibility criteria or applied." << endl;
        }
        cout << "-------------------------------------------------" << endl;
    }
};
