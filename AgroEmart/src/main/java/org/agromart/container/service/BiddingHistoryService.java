package org.agromart.container.service;

import org.agromart.container.api.schema.BiddingHistoryListType;

public interface BiddingHistoryService {
	
	public BiddingHistoryListType getByItemId();

}
