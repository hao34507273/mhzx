package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface RoleFeedInfo
  extends Bean
{
  public abstract RoleFeedInfo copy();
  
  public abstract RoleFeedInfo toData();
  
  public abstract RoleFeedInfo toBean();
  
  public abstract RoleFeedInfo toDataIf();
  
  public abstract RoleFeedInfo toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getFeed_timestamp();
  
  public abstract String getRole_name();
  
  public abstract Octets getRole_nameOctets();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setFeed_timestamp(long paramLong);
  
  public abstract void setRole_name(String paramString);
  
  public abstract void setRole_nameOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */