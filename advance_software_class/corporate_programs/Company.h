#pragma once
#include <string>
#include <vector>
#include <memory>
#include "CorporateProgram.h"

using namespace std;

class Company {
    string name;
    vector<shared_ptr<CorporateProgram>> offeredPrograms;

public:
    Company(string name) : name(name) {}

    void addProgram(shared_ptr<CorporateProgram> program) {
        offeredPrograms.push_back(program);
    }

    string getName() const { return name; }
};
