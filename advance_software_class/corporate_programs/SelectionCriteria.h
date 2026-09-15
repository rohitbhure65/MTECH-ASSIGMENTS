#pragma once
#include "Candidate.h"

class SelectionCriteria {
public:
    virtual bool isEligible(const Candidate& candidate) const = 0;
    virtual double calculateScore(const Candidate& candidate) const = 0;
    virtual ~SelectionCriteria() = default;
};
