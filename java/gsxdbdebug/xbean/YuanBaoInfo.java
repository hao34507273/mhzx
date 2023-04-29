package xbean;

import java.util.Set;
import xdb.Bean;

public abstract interface YuanBaoInfo
  extends Bean
{
  public abstract YuanBaoInfo copy();
  
  public abstract YuanBaoInfo toData();
  
  public abstract YuanBaoInfo toBean();
  
  public abstract YuanBaoInfo toDataIf();
  
  public abstract YuanBaoInfo toBeanIf();
  
  public abstract long getAwardyuanbao();
  
  public abstract long getBuyyuanbao();
  
  public abstract long getMoney();
  
  public abstract long getTotalbuyyuanbao();
  
  public abstract long getTotalawardyuanbao();
  
  public abstract Set<Long> getBuyorderid();
  
  public abstract Set<Long> getBuyorderidAsData();
  
  public abstract void setAwardyuanbao(long paramLong);
  
  public abstract void setBuyyuanbao(long paramLong);
  
  public abstract void setMoney(long paramLong);
  
  public abstract void setTotalbuyyuanbao(long paramLong);
  
  public abstract void setTotalawardyuanbao(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\YuanBaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */