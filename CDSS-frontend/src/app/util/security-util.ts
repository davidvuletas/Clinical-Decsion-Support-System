export class SecurityUtil {

  static getRole() {
    if (this.isEmpty()) {
      return 'GUEST';
    }
    return JSON.parse(localStorage.getItem('loggedUser'))['role'];
  }

  static clearLocalStorage() {
    localStorage.clear();
  }

  static isEmpty() {
    return localStorage.getItem('loggedUser') === null;
  }

  static getFirstName() {
    return JSON.parse(localStorage.getItem('loggedUser'))['firstname'];
  }

  static getLastName() {
    return JSON.parse(localStorage.getItem('loggedUser'))['lastname'];
  }

  static getEmail() {
    // return JSON.parse(localStorage.getItem('loggedUser'))['RegisterDto']['Email'];
  }

  static getUser() {
    return JSON.parse(localStorage.getItem('loggedUser'));
  }
  // static getId() {
  //   if (this.isEmpty()) {
  //     return -1;
  //   }
  //   return JSON.parse(localStorage.getItem('loggedUser'))['RegisterDto']['Id'];
  // }
  //
  // static getUser() {
  //   return JSON.parse(localStorage.getItem('loggedUser'));
  // }

}
