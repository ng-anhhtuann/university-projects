export default class Student {
    constructor(studentId, name, faculty, className, isPrimary, trainingPoint, accumulateNumber, citizenId, number, born, address) {
      this._studentId = studentId;
      this._name = name;
      this._faculty = faculty;
      this._className = className;
      this._isPrimary = isPrimary;
      this._trainingPoint = trainingPoint;
      this._accumulateNumber = accumulateNumber;
      this._citizenId = citizenId;
      this._number = number;
      this._born = born;
      this._address = address;
    }
  
    // Getter methods
    get studentId() {
      return this._studentId;
    }
  
    get name() {
      return this._name;
    }
  
    get faculty() {
      return this._faculty;
    }
  
    get className() {
      return this._className;
    }
  
    get isPrimary() {
      return this._isPrimary;
    }
  
    get trainingPoint() {
      return this._trainingPoint;
    }
  
    get accumulateNumber() {
      return this._accumulateNumber;
    }
  
    get citizenId() {
      return this._citizenId;
    }
  
    get number() {
      return this._number;
    }
  
    get born() {
      return this._born;
    }
  
    get address() {
      return this._address;
    }
  
    // Setter methods
    set studentId(value) {
      this._studentId = value;
    }
  
    set name(value) {
      this._name = value;
    }
  
    set faculty(value) {
      this._faculty = value;
    }
  
    set className(value) {
      this._className = value;
    }
  
    set isPrimary(value) {
      this._isPrimary = value;
    }
  
    set trainingPoint(value) {
      this._trainingPoint = value;
    }
  
    set accumulateNumber(value) {
      this._accumulateNumber = value;
    }
  
    set citizenId(value) {
      this._citizenId = value;
    }
  
    set number(value) {
      this._number = value;
    }
  
    set born(value) {
      this._born = value;
    }
  
    set address(value) {
      this._address = value;
    }
  }
