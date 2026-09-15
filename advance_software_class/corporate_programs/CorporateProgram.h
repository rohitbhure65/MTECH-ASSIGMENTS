#pragma once
#include <string>

using namespace std;

class CorporateProgram {
    string programName;
    string category;
    int durationMonths;

public:
    CorporateProgram(string programName, string category, int durationMonths)
        : programName(programName), category(category), durationMonths(durationMonths) {}

    string getProgramName() const { return programName; }
    string getCategory() const { return category; }
    int getDurationMonths() const { return durationMonths; }
};
