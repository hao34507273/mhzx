package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface BuyYuanBaoOrder
  extends Bean
{
  public abstract BuyYuanBaoOrder copy();
  
  public abstract BuyYuanBaoOrder toData();
  
  public abstract BuyYuanBaoOrder toBean();
  
  public abstract BuyYuanBaoOrder toDataIf();
  
  public abstract BuyYuanBaoOrder toBeanIf();
  
  public abstract String getUserid();
  
  public abstract Octets getUseridOctets();
  
  public abstract long getRoleid();
  
  public abstract String getServername();
  
  public abstract Octets getServernameOctets();
  
  public abstract long getCashnum();
  
  public abstract long getYuanbaonum();
  
  public abstract long getBuytime();
  
  public abstract void setUserid(String paramString);
  
  public abstract void setUseridOctets(Octets paramOctets);
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setServername(String paramString);
  
  public abstract void setServernameOctets(Octets paramOctets);
  
  public abstract void setCashnum(long paramLong);
  
  public abstract void setYuanbaonum(long paramLong);
  
  public abstract void setBuytime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\BuyYuanBaoOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */