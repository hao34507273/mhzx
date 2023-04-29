package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface ActivityPointExchangeMallInfo
  extends Bean
{
  public abstract ActivityPointExchangeMallInfo copy();
  
  public abstract ActivityPointExchangeMallInfo toData();
  
  public abstract ActivityPointExchangeMallInfo toBean();
  
  public abstract ActivityPointExchangeMallInfo toDataIf();
  
  public abstract ActivityPointExchangeMallInfo toBeanIf();
  
  public abstract Map<Integer, ActivityPointExchangeGoodsInfo> getMallcfgid2goodsinfo();
  
  public abstract Map<Integer, ActivityPointExchangeGoodsInfo> getMallcfgid2goodsinfoAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ActivityPointExchangeMallInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */