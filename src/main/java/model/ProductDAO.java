package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDAO {
	private Transaction trans;
	private Session sess;
	private boolean b=true;
	public boolean insertProduct(Product p) {
		try
		{
			DbConfig db=new DbConfig();
			sess=db.getSess();
			trans=sess.beginTransaction();
			sess.save(p);
			trans.commit();
			sess.close();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			trans.rollback();
			b=false;
		}
		return b;
		}

}
