#pragma once
#include "ScoreNormalizer.h"

class IndianCGPANormalizer : public ScoreNormalizer {
public:
    double normalize(double score) const override {
        if (score <= 10.0) {
            return score * 9.5;
        }
        return score;
    }
};
