import Student from "model/student";

const createStudent = async (student) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(student)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const deleteStudent = async (studentId) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/delete-by-id', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const getAllStudent = async () => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-all', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
    }
}
const getPrimary = async () => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-primary', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
    }
}
const getStudentFromFaculty = async (faculty) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-faculty', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(faculty)
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
    }
}
const getStudentFromClass = async (classRoom) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-class', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(classRoom)
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
    }
}
const getStudentFromStudentId = async (studentId) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-student-id', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId)
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var student = new Student(data.studentId, data.name, data.faculty, data.className, data.isPrimary, data.trainingPoint, data.accumulateNumber, data.citizenId, data.number, data.born, data.address);
        return student;
    } catch (error) {
        console.error(error);
    }
}
const getStudentLowTrainingPoint = async () => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-low-point', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });
        const data = await response.json();
        if (typeof data.status !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
    }
}
const updateFaculty = async (studentId, faculty) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-faculty', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, faculty)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updateClass = async (studentId, classRoom) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-class', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, classRoom)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updateAddress = async (studentId, address) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-address', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, address)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updateAccumulate = async (studentId, accumulateNumber) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-accumulate', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, accumulateNumber)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updateTrainingPoint = async (studentId, trainingPoint) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-training-point', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, trainingPoint)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updatePrimary = async (studentId) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-primary', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
const updateNumber = async (studentId, number) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-number', {
            method: 'UPDATE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, number)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
    }
}
export {
    createStudent,
    deleteStudent,
    getAllStudent,
    getPrimary,
    getStudentFromClass,
    getStudentFromFaculty,
    getStudentFromStudentId,
    getStudentLowTrainingPoint,
    updateAccumulate,
    updateAddress,
    updateFaculty,
    updateClass,
    updateNumber,
    updatePrimary,
    updateTrainingPoint
};