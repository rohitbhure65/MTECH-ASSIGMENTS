#ifndef COMBINER_H
#define COMBINER_H

#include <string>

using namespace std;

template <typename T>
T add(const T &a, const T &b){
    return a + b;
}

class File{
public:
    string content;

    File(string c) : content(c) {}

    File operator+(const File &other) const
    {
        return File(this->content + "\n" + other.content);
    }
};

class Paragraph{
public:
    string text;

    Paragraph(string t) : text(t) {}

    Paragraph operator+(const Paragraph &other) const
    {
        return Paragraph(this->text + "\n" + other.text);
    }
};

class Image{
public:
    string imageData;

    Image(string data) : imageData(data) {}

    Image operator+(const Image &other) const
    {
        return Image(this->imageData + " [COMBINED WITH] " + other.imageData);
    }
};

#endif
