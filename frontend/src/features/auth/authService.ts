import { mockRegister, mockRegisterResponse, User } from './authMocks';

export const registerUser = async (
  formValues: Omit<User, 'id'>
): Promise<mockRegisterResponse> => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      try {
        const response = mockRegister(formValues);
        resolve(response);
      } catch (error) {
        reject(error);
      }
    }, 2000);
  });
};
