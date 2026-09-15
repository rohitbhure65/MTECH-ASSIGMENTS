#pragma once
class ScoreNormalizer {
public:
    virtual double normalize(double score) const = 0;
    virtual ~ScoreNormalizer() = default;
};
