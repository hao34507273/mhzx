package mzm.gsp.activitypointexchange.main.handler;

import xbean.ActivityPointExchangeGoodsInfo;

public abstract interface ActivityPointExchangeHandler
{
  public abstract long getPointExchangeCountResetTime(int paramInt1, int paramInt2, ActivityPointExchangeGoodsInfo paramActivityPointExchangeGoodsInfo);
  
  public abstract long getManualRefreshCountResetTime(int paramInt1, int paramInt2, ActivityPointExchangeGoodsInfo paramActivityPointExchangeGoodsInfo);
  
  public abstract void registerActivityPointExchangeHandler();
  
  public abstract boolean isMallOpenForRole(long paramLong, int paramInt1, int paramInt2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\handler\ActivityPointExchangeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */