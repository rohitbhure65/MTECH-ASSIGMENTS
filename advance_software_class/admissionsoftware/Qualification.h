#pragma once
#include <string>

using namespace std;

class Qualification {
    string degreeName;
    double cgpaOrPercentage;
    string institution;
    int yearOfPassing;
    string type;
    bool specialExamQualified;
    double specialExamScore;

public:
    Qualification(string degreeName, double cgpaOrPercentage, string institution, int yearOfPassing, string type, bool specialExamQualified = false, double specialExamScore = 0.0)
        : degreeName(degreeName), cgpaOrPercentage(cgpaOrPercentage), institution(institution), yearOfPassing(yearOfPassing), type(type), specialExamQualified(specialExamQualified), specialExamScore(specialExamScore) {}

    double getCgpaOrPercentage() const { return cgpaOrPercentage; }
    bool isSpecialExamQualified() const { return specialExamQualified; }
    double getSpecialExamScore() const { return specialExamScore; }
    string getDegreeName() const { return degreeName; }
    string getInstitution() const { return institution; }
    int getYearOfPassing() const { return yearOfPassing; }
    string getType() const { return type; }
};
