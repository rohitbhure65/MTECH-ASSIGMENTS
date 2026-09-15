#pragma once
#include "Student.h"

class MeritCalculator {
public:
    virtual double calculateMerit(const Student& student) const = 0;
    virtual ~MeritCalculator() = default;
};
