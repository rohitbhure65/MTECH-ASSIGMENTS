#pragma once
#include <string>
#include "AcademicRecord.h"

using namespace std;

class Candidate {
    string name;
    string email;
    AcademicRecord record;

public:
    Candidate(string name, string email, AcademicRecord record)
        : name(name), email(email), record(record) {}

    string getName() const { return name; }
    const AcademicRecord& getRecord() const { return record; }
    string getEmail() const { return email; }
};
