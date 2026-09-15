#pragma once
#include <string>
#include "Student.h"

using namespace std;

class EligibilityChecker {
public:
    virtual bool isEligible(const Student& student) const = 0;
    virtual string getRejectionReason(const Student& student) const = 0;
    virtual ~EligibilityChecker() = default;
};
