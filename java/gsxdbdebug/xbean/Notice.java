package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface Notice
  extends Bean
{
  public abstract Notice copy();
  
  public abstract Notice toData();
  
  public abstract Notice toBean();
  
  public abstract Notice toDataIf();
  
  public abstract Notice toBeanIf();
  
  public abstract String getTitle();
  
  public abstract Octets getTitleOctets();
  
  public abstract String getContent();
  
  public abstract Octets getContentOctets();
  
  public abstract long getTimestamp();
  
  public abstract void setTitle(String paramString);
  
  public abstract void setTitleOctets(Octets paramOctets);
  
  public abstract void setContent(String paramString);
  
  public abstract void setContentOctets(Octets paramOctets);
  
  public abstract void setTimestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Notice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */