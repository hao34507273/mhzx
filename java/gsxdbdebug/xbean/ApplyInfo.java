package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface ApplyInfo
  extends Bean
{
  public abstract ApplyInfo copy();
  
  public abstract ApplyInfo toData();
  
  public abstract ApplyInfo toBean();
  
  public abstract ApplyInfo toDataIf();
  
  public abstract ApplyInfo toBeanIf();
  
  public abstract int getApplysec();
  
  public abstract String getContent();
  
  public abstract Octets getContentOctets();
  
  public abstract void setApplysec(int paramInt);
  
  public abstract void setContent(String paramString);
  
  public abstract void setContentOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ApplyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */