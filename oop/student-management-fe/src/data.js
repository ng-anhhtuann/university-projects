const api = 'https://student-management-server.azurewebsites.net/';
const createStudent = async (student) => {
    try {
        const response = await fetch(api.concat('create'), {
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
        const response = await fetch(api.concat('delete-by-id'), {
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
        const response = await fetch(api.concat('get-all'), {
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
const getStudentFromClass = async (classRoom) => {
    try {
        const response = await fetch(api.concat('get-class?classRoom=')+classRoom, {
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
        const response = await fetch(api.concat('get-student-id?studentId=')+studentId, {
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
const getStudentLowAvgPoint = async () => {
    try {
        const response = await fetch(api.concat('get-low-point'), {
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
const updateClass = async (studentId, classRoom) => {
    try {
        const response = await fetch(api.concat('update-class'), {
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
        const response = await fetch(api.concat('update-address'), {
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
const updateAvgPoint = async (studentId, avgPoint) => {
    try {
        const response = await fetch(api.concat('update-point'), {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentId, avgPoint)
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

        const response = await fetch(api.concat('update-number'), {
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
    getStudentFromClass,
    getStudentFromStudentId,
    getStudentLowAvgPoint,
    updateAddress,
    updateClass,
    updateNumber,
    updateAvgPoint
};