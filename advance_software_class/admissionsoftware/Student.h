#pragma once
#include <string>
#include <vector>
#include "Qualification.h"

using namespace std;

class Student {
    string id;
    string name;
    vector<Qualification> qualifications;

public:
    Student(string id, string name) : id(id), name(name) {}

    void addQualification(const Qualification& q) {
        qualifications.push_back(q);
    }

    const Qualification* getQualification(const string& type) const {
        for (const auto& q : qualifications) {
            if (q.getType() == type) {
                return &q;
            }
        }
        return nullptr;
    }

    string getId() const { return id; }
    string getName() const { return name; }
};
