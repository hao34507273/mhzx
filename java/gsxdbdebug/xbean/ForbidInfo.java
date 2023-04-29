package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface ForbidInfo
  extends Bean
{
  public abstract ForbidInfo copy();
  
  public abstract ForbidInfo toData();
  
  public abstract ForbidInfo toBean();
  
  public abstract ForbidInfo toDataIf();
  
  public abstract ForbidInfo toBeanIf();
  
  public abstract long getExpiretime();
  
  public abstract long getStarttime();
  
  public abstract String getReason();
  
  public abstract Octets getReasonOctets();
  
  public abstract void setExpiretime(long paramLong);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setReason(String paramString);
  
  public abstract void setReasonOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ForbidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */