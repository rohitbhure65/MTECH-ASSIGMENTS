#pragma once
#include <string>
#include <memory>
#include "Curriculum.h"
#include "EligibilityChecker.h"

using namespace std;

class Program {
    string name;
    string type;
    shared_ptr<Curriculum> curriculum;
    shared_ptr<EligibilityChecker> eligibilityChecker;

public:
    Program(string name, string type, shared_ptr<Curriculum> curriculum, shared_ptr<EligibilityChecker> eligibilityChecker)
        : name(name), type(type), curriculum(curriculum), eligibilityChecker(eligibilityChecker) {}

    string getName() const { return name; }
    string getType() const { return type; }
    shared_ptr<Curriculum> getCurriculum() const { return curriculum; }
    shared_ptr<EligibilityChecker> getEligibilityChecker() const { return eligibilityChecker; }
};
