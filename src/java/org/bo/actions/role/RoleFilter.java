package org.bo.actions.role;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;


import org.bo.LogInformation;
import org.bo.entity.Role;
import org.bo.persistence.hibernate.HibernateSessionFactory;
import org.bo.persistence.hibernate.HibernateSessionFactoryAware;

public class RoleFilter extends RoleForm implements HibernateSessionFactoryAware
{
	private Session sess;
	private List roles = new ArrayList();
	private HibernateSessionFactory hsf;
	private int maxPage, currPage, nextPage, prevPage, page = 0;
	private int maxRowPerPage = 10;
	private String orderBy = "name";
	private int resultRows;
	
	public String execute() {
		try {
			
			
			sess = hsf.createSession();
			Criteria crit = sess.createCriteria(Role.class);
			
			crit.add(Expression.like("logInformation.activeFlag", LogInformation.ACTIVE));
			resultRows = crit.list().size();
			
			maxPage = resultRows / maxRowPerPage;
			if (resultRows % maxRowPerPage == 0) maxPage = maxPage - 1;
			
			roles = crit.addOrder(Order.asc(orderBy)).setFirstResult(currPage*maxRowPerPage).setMaxResults(maxRowPerPage).list();
			
			prevPage = currPage - 1;
			nextPage = currPage + 1;
			page = currPage + 1;
			hsf.endSession(sess);
			hsf.closeSession(sess);
			return SUCCESS;
		} catch (HibernateException e) {
			e.printStackTrace();
			return ERROR;
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		} 
		
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return Returns the currPage.
	 */
	public int getCurrPage() {
		return currPage;
	}
	/**
	 * @param currPage The currPage to set.
	 */
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * @return Returns the maxPage.
	 */
	public int getMaxPage() {
		return maxPage;
	}
	/**
	 * @param maxPage The maxPage to set.
	 */
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	/**
	 * @return Returns the maxRowPerPage.
	 */
	public int getMaxRowPerPage() {
		return maxRowPerPage;
	}
	/**
	 * @param maxRowPerPage The maxRowPerPage to set.
	 */
	public void setMaxRowPerPage(int maxRowPerPage) {
		this.maxRowPerPage = maxRowPerPage;
	}
	/**
	 * @return Returns the nextPage.
	 */
	public int getNextPage() {
		return nextPage;
	}
	/**
	 * @param nextPage The nextPage to set.
	 */
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * @return Returns the orderBy.
	 */
	public String getOrderBy() {
		return orderBy;
	}
	/**
	 * @param orderBy The orderBy to set.
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return Returns the prevPage.
	 */
	public int getPrevPage() {
		return prevPage;
	}
	/**
	 * @param prevPage The prevPage to set.
	 */
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	/**
	 * @return Returns the resultRows.
	 */
	public int getResultRows() {
		return resultRows;
	}
	/**
	 * @param resultRows The resultRows to set.
	 */
	public void setResultRows(int resultRows) {
		this.resultRows = resultRows;
	}
	/**
	 * @return Returns the roles.
	 */
	public List getRoles() {
		return roles;
	}
	/**
	 * @param roles The roles to set.
	 */
	public void setRoles(List roles) {
		this.roles = roles;
	}



	public void setHibernateSessionFactory(HibernateSessionFactory hsf) {
		this.hsf = hsf;
	}
}