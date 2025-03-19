package com.aixtor.student.core.service.persistence.impl;

import com.aixtor.student.core.model.Student;
import com.aixtor.student.core.model.impl.StudentImpl;
import com.aixtor.student.core.service.persistence.StudentFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = StudentFinder.class)
public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder {
	@Reference
	private CustomSQL customSQL;
	private static final Log _logger=LogFactoryUtil.getLog(StudentFinderImpl.class);

	@Override
	public List<Student> findByGPAGreaterThan(Double gpa)  {
    	Session session = null;

	        try {
	        	_logger.info("Entering Finder");
	            session = openSession();
	        	_logger.info("Session Opened");

	            String sql=customSQL.get(getClass(),"findByGPAGreaterThan");
	        	_logger.info("Query "+sql);

	            SQLQuery query = session.createSQLQuery(sql);
	            query.setCacheable(false);
	            query.addEntity("Students", StudentImpl.class);

	            QueryPos qPos = QueryPos.getInstance(query);
	            qPos.add(gpa);

	            return (List<Student>) query.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeSession(session);
	        }
	        return null;
	}
}
