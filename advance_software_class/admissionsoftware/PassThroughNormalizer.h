#pragma once
#include "ScoreNormalizer.h"

class PassThroughNormalizer : public ScoreNormalizer {
public:
    double normalize(double score) const override {
        return score;
    }
};
