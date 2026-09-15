#pragma once
#include <vector>
#include <string>
#include <algorithm>
#include "SelectionCriteria.h"

using namespace std;

class StandardSelectionCriteria : public SelectionCriteria {
    double minCgpa;
    vector<string> allowedDegrees;

public:
    StandardSelectionCriteria(double minCgpa, const vector<string>& allowedDegrees)
        : minCgpa(minCgpa), allowedDegrees(allowedDegrees) {}

    bool isEligible(const Candidate& candidate) const override {
        const AcademicRecord& rec = candidate.getRecord();
        bool degreeAllowed = find(allowedDegrees.begin(), allowedDegrees.end(), rec.getDegree()) != allowedDegrees.end();
        return rec.getCgpa() >= minCgpa && degreeAllowed;
    }

    double calculateScore(const Candidate& candidate) const override {
        return candidate.getRecord().getCgpa();
    }
};
