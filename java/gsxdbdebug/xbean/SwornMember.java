package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface SwornMember
  extends Bean
{
  public abstract SwornMember copy();
  
  public abstract SwornMember toData();
  
  public abstract SwornMember toBean();
  
  public abstract SwornMember toDataIf();
  
  public abstract SwornMember toBeanIf();
  
  public abstract long getSwornid();
  
  public abstract String getTitle();
  
  public abstract Octets getTitleOctets();
  
  public abstract void setSwornid(long paramLong);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setTitleOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SwornMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */