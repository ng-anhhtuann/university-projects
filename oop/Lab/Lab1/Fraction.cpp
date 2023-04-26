#include <iostream>

using namespace std;

class Fraction {
private:
    int ts;
    int ms; 

public:
    Fraction(int ts = 0, int ms = 1) {
        this->ts = ts;
        this->ms = ms;
    }

    Fraction add(const Fraction& other) const {
        int ts1 = ts * other.ms + other.ts * ms;
        int ms1 = ms * other.ms;
        return Fraction(ts1, ms1);
    }

    Fraction subtract(const Fraction& other) const {
        int ts1 = ts * other.ms - other.ts * ms;
        int ms1 = ms * other.ms;
        return Fraction(ts1, ms1);
    }

    Fraction multiply(const Fraction& other) const {
        int ts1 = ts * other.ts;
        int ms1 = ms * other.ms;
        return Fraction(ts1, ms1);
    }

    Fraction divide(const Fraction& other) const {
        int ts1 = ts * other.ms;
        int ms1 = ms * other.ts;
        return Fraction(ts1, ms1);
    }

    void input() {
        cout << "Nhap tu so: ";
        cin >> ts;
        cout << "Nhap mau so: ";
        cin >> ms;
    }

    void output() const {
        cout << ts << "/" << ms << endl;
    }
};

int main() {
    Fraction f1(1, 2); 
    Fraction f2(3, 4); 

    Fraction f3 = f1.add(f2); 
    cout << "f1 + f2 = ";
    f3.output(); 

    Fraction f4 = f1.subtract(f2);
    cout << "f1 - f2 = ";
    f4.output(); 

    Fraction f5 = f1.multiply(f2);
    cout << "f1 * f2 = ";
    f5.output(); 

    Fraction f6 = f1.divide(f2); 
    cout << "f1 / f2 = ";
    f6.output();

    Fraction f7; 
    f7.input(); 
    cout << "f7 = ";
    f7.output(); 

    return 0;
}