package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface MaidInfo
  extends Bean
{
  public abstract MaidInfo copy();
  
  public abstract MaidInfo toData();
  
  public abstract MaidInfo toBean();
  
  public abstract MaidInfo toDataIf();
  
  public abstract MaidInfo toBeanIf();
  
  public abstract int getMaidcfgid();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getX();
  
  public abstract int getY();
  
  public abstract void setMaidcfgid(int paramInt);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setX(int paramInt);
  
  public abstract void setY(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MaidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */