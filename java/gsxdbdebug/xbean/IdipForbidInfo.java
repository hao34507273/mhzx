package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface IdipForbidInfo
  extends Bean
{
  public abstract IdipForbidInfo copy();
  
  public abstract IdipForbidInfo toData();
  
  public abstract IdipForbidInfo toBean();
  
  public abstract IdipForbidInfo toDataIf();
  
  public abstract IdipForbidInfo toBeanIf();
  
  public abstract long getStarttime();
  
  public abstract long getExpiretime();
  
  public abstract String getReason();
  
  public abstract Octets getReasonOctets();
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setExpiretime(long paramLong);
  
  public abstract void setReason(String paramString);
  
  public abstract void setReasonOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipForbidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */