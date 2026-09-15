#pragma once
#include <memory>
#include "MeritCalculator.h"
#include "ScoreNormalizer.h"

using namespace std;

class GatePreferenceMeritCalculator : public MeritCalculator {
    shared_ptr<ScoreNormalizer> normalizer;

public:
    GatePreferenceMeritCalculator(shared_ptr<ScoreNormalizer> normalizer) : normalizer(normalizer) {}

    double calculateMerit(const Student& student) const override {
        const Qualification* bachelors = student.getQualification("BACHELORS");
        if (!bachelors) return 0.0;
        
        double baseScore = normalizer->normalize(bachelors->getCgpaOrPercentage());
        
        const Qualification* gate = student.getQualification("GATE");
        if (gate && gate->isSpecialExamQualified()) {
            return (baseScore * 0.6) + (gate->getSpecialExamScore() * 0.4);
        }
        return baseScore * 0.6;
    }
};
