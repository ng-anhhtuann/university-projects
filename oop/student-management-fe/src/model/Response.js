export default class Response {
    constructor(status, info) {
      this._status = status;
      this._info = info;
    }
  
    get status() {
      return this._status;
    }
  
    set status(status) {
      this._status = status;
    }
  
    get info() {
      return this._info;
    }
  
    set info(info) {
      this._info = info;
    }
  }
  