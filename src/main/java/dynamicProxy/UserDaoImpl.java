package main.java.dynamicProxy;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("模拟： 保存用户！");

	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("模拟： 查找用户！");

	}

}
