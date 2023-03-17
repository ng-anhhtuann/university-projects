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
        if (typeof data.status === 'number') {
            return {status: false, info: "Something's wrong"};
        }
        return data;
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
        const dataList = await response.json();
        return dataList;
    } catch (error) {
        console.error(error);
        return []
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
        return data;
    } catch (error) {
        console.error(error);
        return []
    }
}
const getStudentFromFaculty = async (faculty) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-faculty?faculty='+faculty, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
        return []
    }
}
const getStudentFromClass = async (classRoom) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-class?classRoom='+classRoom, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error(error);
        return [];
    }
}
const getStudentFromStudentId = async (studentId) => {
    try {
        const response = await fetch('https://student-management-server.herokuapp.com/get-student-id?studentId='+studentId, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const data = await response.json();
        return data
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
        return data
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
            body: JSON.stringify({studentId, newValue: faculty})
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
            body: JSON.stringify({studentId, newValue: classRoom})
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
            body: JSON.stringify({studentId, newValue: address})
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
            body: JSON.stringify({studentId, accumulateNumber})
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
        const requestBody = {
            studentId: studentId,
            newValue: number
        };

        const response = await fetch('https://student-management-server.herokuapp.com/update-number', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
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