#pragma once
#include <string>
#include <vector>
#include <memory>
#include "Program.h"

using namespace std;

class Department {
    string name;
    vector<shared_ptr<Program>> offeredPrograms;

public:
    Department(string name) : name(name) {}

    void addProgram(shared_ptr<Program> program) {
        offeredPrograms.push_back(program);
    }

    string getName() const { return name; }
};
