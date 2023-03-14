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
        console.log({data})
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return {status: true, info:"Add successfully"};
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        console.log({data})
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var student = {studentId: data.studentId, name: data.name, faculty: data.faculty, class: data.className, isPrimary: data.isPrimary, trainingPoint: data.trainingPoint, accumulateNumber: data.accumulateNumber, citizenId: data.citizenId, number: data.number, born: data.born, address: data.address};
        return student;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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
        if (typeof data.info !== 'undefined') {
            return data;
        }
        var listStudent = [];
        listStudent = data;
        return listStudent;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateFaculty = async (studentId, faculty) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-faculty', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, faculty)
        });
        const data = await response.json();
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateClass = async (studentId, classRoom) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-class', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, classRoom)
        });
        const data = await response.json();
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateAddress = async (studentId, address) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-address', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, address)
        });
        const data = await response.json();
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateAccumulate = async (studentId, accumulateNumber) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-accumulate', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, accumulateNumber)
        });
        const data = await response.json();
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateTrainingPoint = async (studentId, trainingPoint) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-training-point', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, trainingPoint)
        });
        const data = await response.json();
        console.log({data})
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updatePrimary = async (studentId) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-primary', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId)
        });
        const data = await response.json();
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
    }
}
const updateNumber = async (studentId, number) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/update-number', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ studentId: studentId, number: number })
        });
        const data = await response.json();
        console.log({data})
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
    } catch (error) {
        console.error(error);
        return {status: false, info:"Something's wrong"};
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