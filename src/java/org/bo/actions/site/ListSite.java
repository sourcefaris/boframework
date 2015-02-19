package org.bo.actions.site;

import java.util.List;

import org.bo.DefaultAction;
import org.bo.entity.Site;

public class ListSite extends DefaultAction {

	private List<Site> sites;
	private String orderBy = "name";
	private String direction = "asc";

	public String execute() throws Exception {
		sites = persistence.findAllSortedDirected(Site.class,
				getOrderBy(), getDirection());
		return SUCCESS;
	}

	/**
	 * @return Returns the direction.
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            The direction to set.
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return Returns the orderBy.
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy
	 *            The orderBy to set.
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

}
