package com.jb.statistics.dao.impl;

import com.jb.statistics.dao.TestDao;

//@Repository("testDao")
public class TestDaoImpl implements TestDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public Session getSession() {
//		return sessionFactory.openSession();
//	}
//
//	public static void closeSession(Session session) throws HibernateException {
//		if (session != null) {
//			session.close();
//		}
//	}
//
//	@Transactional
//	public void save() { 
//		Test t = new Test();
//		t.setName("xuhui5");
//		Session s = this.getSession();
//		s.save(t);
//		s.close();
//	}
//
//	@Transactional
//	public void insert() {
//		this.jdbcTemplate
//				.update("insert into wm_test (name) values ('name_xuhui1')");
//	}
//
//	@Transactional(propagation = Propagation.NOT_SUPPORTED)
//	public void get() {
//		Session s = this.getSession();
//		Test t = (Test) s.get(Test.class, 3);
//		s.close();
//		System.out.println(t);
//
//		System.out.println("========================================");
//		this.jdbcTemplate.query(new PreparedStatementCreator() {
//
//			public PreparedStatement createPreparedStatement(Connection conn)
//					throws SQLException {
//				return conn.prepareStatement("select * from wm_test");
//			}
//		}, new RowMapper() {
//
//			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
//				System.out.println("id:" + rs.getInt("id"));
//				System.out.println("name:" + rs.getString("name"));
//				return null;
//			}
//
//		});
//	}
}
