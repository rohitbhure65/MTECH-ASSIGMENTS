#pragma once
#include <string>
#include <memory>
#include "EligibilityChecker.h"
#include "ScoreNormalizer.h"

using namespace std;

class BasicEligibilityChecker : public EligibilityChecker {
    string requiredType;
    double minPercentage;
    shared_ptr<ScoreNormalizer> normalizer;

public:
    BasicEligibilityChecker(string requiredType, double minPercentage, shared_ptr<ScoreNormalizer> normalizer)
        : requiredType(requiredType), minPercentage(minPercentage), normalizer(normalizer) {}

    bool isEligible(const Student& student) const override {
        const Qualification* q = student.getQualification(requiredType);
        if (!q) return false;
        
        double score = normalizer->normalize(q->getCgpaOrPercentage());
        return score >= minPercentage;
    }

    string getRejectionReason(const Student& student) const override {
        const Qualification* q = student.getQualification(requiredType);
        if (!q) return "Missing required qualification";
        
        double score = normalizer->normalize(q->getCgpaOrPercentage());
        if (score < minPercentage) {
            return "Minimum percentage not met. Required: " + to_string(minPercentage) + "%, Found: " + to_string(score) + "%";
        }
        return "Eligible";
    }
};
