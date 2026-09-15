#pragma once
#include <string>

using namespace std;

class AcademicRecord {
    string degree;
    double cgpa;
    int graduationYear;

public:
    AcademicRecord(string degree, double cgpa, int graduationYear)
        : degree(degree), cgpa(cgpa), graduationYear(graduationYear) {}

    double getCgpa() const { return cgpa; }
    string getDegree() const { return degree; }
    int getGraduationYear() const { return graduationYear; }
};
