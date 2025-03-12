import 'package:oop/oop.dart' as oop;

void main() {
  var student = Student('JJJ', 20, 9.5);
  var studentExample = Student.example(9.5);

  student.printStudent();
  studentExample.printStudent();

  var padding = Padding(10, 20, 30, 40);
  var paddingHorizontal = Padding.horizontal(10);
  var paddingVertical = Padding.vertical(30);
  var paddingSymmetric = Padding.symmetric(10, 20);

  print(padding);
  print(paddingHorizontal);
  print(paddingVertical);
  print(paddingSymmetric);
}

class Student {
  // Recurso 'late' permite passar a responsabilidade de inicialização para o desenvolvedor, ex.: late String name;
  String name;
  int age;
  double grade;

  Student(this.name, this.age, this.grade);

  Student.example(this.grade) : name = 'Example Name', age = 99;

  void printStudent() {
    print('Name: $name, Age: $age, Grade: $grade');
  }
}

class Padding {
  double left = 0, right = 0, top = 0, bottom = 0;

  Padding(this.left, this.right, this.top, this.bottom);

  Padding.horizontal(double horizontal) : left = horizontal, right = horizontal;

  Padding.vertical(double vertical) : top = vertical, bottom = vertical;

  Padding.symmetric(double horizontal, double vertical)
    : left = horizontal,
      right = horizontal,
      top = vertical,
      bottom = vertical;

  @override
  String toString() {
    return 'Padding{left: $left, right: $right, top: $top, bottom: $bottom}';
  }
}
