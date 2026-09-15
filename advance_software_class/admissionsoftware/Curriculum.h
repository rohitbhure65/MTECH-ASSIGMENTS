#pragma once
#include <string>
#include <vector>

using namespace std;

class Curriculum {
    int totalSemesters;
    int totalCredits;
    vector<string> subjects;

public:
    Curriculum(int totalSemesters, int totalCredits, const vector<string>& subjects)
        : totalSemesters(totalSemesters), totalCredits(totalCredits), subjects(subjects) {}
};
