package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface AuAnyCheckOrderInfo
  extends Bean
{
  public abstract AuAnyCheckOrderInfo copy();
  
  public abstract AuAnyCheckOrderInfo toData();
  
  public abstract AuAnyCheckOrderInfo toBean();
  
  public abstract AuAnyCheckOrderInfo toDataIf();
  
  public abstract AuAnyCheckOrderInfo toBeanIf();
  
  public abstract String getOrderid();
  
  public abstract Octets getOrderidOctets();
  
  public abstract void setOrderid(String paramString);
  
  public abstract void setOrderidOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AuAnyCheckOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */