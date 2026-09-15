#pragma once
#include <string>
#include <memory>
#include "MeritCalculator.h"
#include "ScoreNormalizer.h"

using namespace std;

class StandardMeritCalculator : public MeritCalculator {
    string baseQualification;
    shared_ptr<ScoreNormalizer> normalizer;

public:
    StandardMeritCalculator(string baseQualification, shared_ptr<ScoreNormalizer> normalizer) 
        : baseQualification(baseQualification), normalizer(normalizer) {}

    double calculateMerit(const Student& student) const override {
        const Qualification* q = student.getQualification(baseQualification);
        if (!q) return 0.0;
        
        return normalizer->normalize(q->getCgpaOrPercentage());
    }
};
