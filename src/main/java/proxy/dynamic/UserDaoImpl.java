package proxy.dynamic;

public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("模拟： 保存用户！");

	}

	@Override
	public void find() {
		this.look();
		// TODO Auto-generated method stub
		System.out.println("模拟： 查找用户！");
	}



}
