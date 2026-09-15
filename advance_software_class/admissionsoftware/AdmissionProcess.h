#pragma once
#include <iostream>
#include <string>
#include <vector>
#include <memory>
#include <algorithm>
#include "Program.h"
#include "Department.h"
#include "MeritCalculator.h"
#include "Student.h"

using namespace std;

class AdmissionProcess {
    int academicYear;
    shared_ptr<Program> program;
    shared_ptr<Department> department;
    int seatCapacity;
    shared_ptr<MeritCalculator> meritCalculator;
    vector<Student*> applicants;
    vector<Student*> admittedStudents;

public:
    AdmissionProcess(int academicYear, shared_ptr<Program> program, shared_ptr<Department> department, int seatCapacity, shared_ptr<MeritCalculator> meritCalculator)
        : academicYear(academicYear), program(program), department(department), seatCapacity(seatCapacity), meritCalculator(meritCalculator) {}

    void apply(Student& student) {
        auto checker = program->getEligibilityChecker();
        if (checker && !checker->isEligible(student)) {
            cout << "Application Rejected for " << student.getName() << " -> " << checker->getRejectionReason(student) << endl;
            return;
        }
        cout << "Application Accepted for " << student.getName() << " to " << program->getName() << endl;
        applicants.push_back(&student);
    }

    void generateMeritListAndAdmit() {
        sort(applicants.begin(), applicants.end(), [this](Student* s1, Student* s2) {
            return meritCalculator->calculateMerit(*s1) > meritCalculator->calculateMerit(*s2);
        });

        cout << "--- Merit List for " << program->getName() << " (" << academicYear << ") ---" << endl;
        int count = 0;
        for (Student* s : applicants) {
            double score = meritCalculator->calculateMerit(*s);
            cout << s->getName() << " - Score: " << score << endl;
            if (count < seatCapacity) {
                admittedStudents.push_back(s);
                count++;
            }
        }
        cout << "-------------------------------------------------" << endl;
    }

    void printAdmittedStudents() const {
        cout << "Admitted Students to " << program->getName() << " (" << academicYear << "):" << endl;
        for (Student* s : admittedStudents) {
            cout << "- " << s->getName() << endl;
        }
    }
};
