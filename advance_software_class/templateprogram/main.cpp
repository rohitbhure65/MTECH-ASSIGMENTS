#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;

#include "combiner.h"

int main()
{
    int num1, num2;
    cout << "Enter first number: ";
    cin >> num1;
    cout << "Enter second number: ";
    cin >> num2;
    cout << "Numbers sum: " << add(num1, num2) << "\n\n";

    cin.ignore();

    string str1, str2;
    cout << "Enter first string: ";
    getline(cin, str1);
    cout << "Enter second string: ";
    getline(cin, str2);
    cout << "String concatenation: " << add(str1, str2) << "\n\n";

    char c1, c2;
    int temp_c2;
    cout << "Enter a character: ";
    cin >> c1;
    cout << "Enter an integer to add to the character: ";
    cin >> temp_c2;
    c2 = temp_c2;
    cout << "Char addition ('" << c1 << "' + " << temp_c2 << "): " << (char)add(c1, c2) << "\n\n";

    cin.ignore();

    string fileName1, fileName2;
    cout << "Enter path/name for File 1: ";
    getline(cin, fileName1);
    cout << "Enter path/name for File 2: ";
    getline(cin, fileName2);

    ifstream f1(fileName1);
    string fileContent1;
    if (f1) {
        stringstream buffer;
        buffer << f1.rdbuf();
        fileContent1 = buffer.str();
    } else {
        cout << "Could not open File 1. Using empty content.\n";
    }

    ifstream f2(fileName2);
    string fileContent2;
    if (f2) {
        stringstream buffer;
        buffer << f2.rdbuf();
        fileContent2 = buffer.str();
    } else {
        cout << "Could not open File 2. Using empty content.\n";
    }

    File file1(fileContent1);
    File file2(fileContent2);
    File combinedFile = add(file1, file2);
    cout << "Combined Files Content:\n"
         << combinedFile.content << "\n\n";

    string para1, para2;
    cout << "Enter text for Paragraph 1: ";
    getline(cin, para1);
    cout << "Enter text for Paragraph 2: ";
    getline(cin, para2);
    Paragraph p1(para1);
    Paragraph p2(para2);
    Paragraph combinedParagraph = add(p1, p2);
    cout << "Combined Paragraphs:\n"
         << combinedParagraph.text << "\n\n";

    string imgPath1, imgPath2;
    cout << "Enter source path for Image 1: ";
    getline(cin, imgPath1);
    cout << "Enter source path for Image 2: ";
    getline(cin, imgPath2);
    Image image1(imgPath1);
    Image image2(imgPath2);
    Image combinedImage = add(image1, image2);
    cout << "Combined Image Sources:\n"
         << combinedImage.imageData << "\n";

    return 0;
}
