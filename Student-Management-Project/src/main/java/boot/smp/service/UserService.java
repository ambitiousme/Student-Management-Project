package boot.smp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import boot.smp.model.User;
import boot.smp.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository userRepo;

	public User saveUser(User user) {

		User result = null;

		try {
			result = userRepo.save(user);
		} catch (Exception e) {

			System.out.println("Here we have got an Exception " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("After saving the user " + result);
		return result;

	}

	@Override
	public String getUserByID(String userId) throws Exception {
		// TODO Auto-generated

		User result = null;
		try {
			result = userRepo.findByUserId(userId);
			System.out.println("Printing result of User " + result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		if (result != null)
			return result.getUserId();
		else
			return null;
	}

	/*
	 * 
	 * 
	 * @Override public List<User> getUsers() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public List<User> getAllUser() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public List<User> findUserByName(String name) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public List<User> getUserByName(String name) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public User insertUser(User User) { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public List<User> insertListUser(List<User> list) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void deleteUser(User User) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void deleteByUserName(String name) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteByUserId(int id) { // TODO Auto-generated method
	 * stub
	 * 
	 * }
	 * 
	 * @Override public void updateUser() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
