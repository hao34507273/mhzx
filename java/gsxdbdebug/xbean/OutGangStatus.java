package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface OutGangStatus
  extends Bean
{
  public abstract OutGangStatus copy();
  
  public abstract OutGangStatus toData();
  
  public abstract OutGangStatus toBean();
  
  public abstract OutGangStatus toDataIf();
  
  public abstract OutGangStatus toBeanIf();
  
  public abstract String getGroupopenid();
  
  public abstract Octets getGroupopenidOctets();
  
  public abstract long getGangid();
  
  public abstract long getCreatetime();
  
  public abstract void setGroupopenid(String paramString);
  
  public abstract void setGroupopenidOctets(Octets paramOctets);
  
  public abstract void setGangid(long paramLong);
  
  public abstract void setCreatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OutGangStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */