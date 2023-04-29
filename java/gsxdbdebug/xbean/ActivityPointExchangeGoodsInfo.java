package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityPointExchangeGoodsInfo
  extends Bean
{
  public abstract ActivityPointExchangeGoodsInfo copy();
  
  public abstract ActivityPointExchangeGoodsInfo toData();
  
  public abstract ActivityPointExchangeGoodsInfo toBean();
  
  public abstract ActivityPointExchangeGoodsInfo toDataIf();
  
  public abstract ActivityPointExchangeGoodsInfo toBeanIf();
  
  public abstract Map<Integer, Integer> getGoodscfgid2count();
  
  public abstract Map<Integer, Integer> getGoodscfgid2countAsData();
  
  public abstract int getManualrefreshcount();
  
  public abstract long getManualrefreshcountresettimestamp();
  
  public abstract long getExchangecountresettimestamp();
  
  public abstract boolean getIsneedrefresh();
  
  public abstract void setManualrefreshcount(int paramInt);
  
  public abstract void setManualrefreshcountresettimestamp(long paramLong);
  
  public abstract void setExchangecountresettimestamp(long paramLong);
  
  public abstract void setIsneedrefresh(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityPointExchangeGoodsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */