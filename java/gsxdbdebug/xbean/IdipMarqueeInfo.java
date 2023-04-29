package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface IdipMarqueeInfo
  extends Bean
{
  public abstract IdipMarqueeInfo copy();
  
  public abstract IdipMarqueeInfo toData();
  
  public abstract IdipMarqueeInfo toBean();
  
  public abstract IdipMarqueeInfo toDataIf();
  
  public abstract IdipMarqueeInfo toBeanIf();
  
  public abstract long getBegin_time();
  
  public abstract long getEnd_time();
  
  public abstract String getMail_title();
  
  public abstract Octets getMail_titleOctets();
  
  public abstract String getMail_content();
  
  public abstract Octets getMail_contentOctets();
  
  public abstract int getRollfre();
  
  public abstract int getRollnum();
  
  public abstract int getReal_num();
  
  public abstract int getVersion();
  
  public abstract long getIndexid();
  
  public abstract void setBegin_time(long paramLong);
  
  public abstract void setEnd_time(long paramLong);
  
  public abstract void setMail_title(String paramString);
  
  public abstract void setMail_titleOctets(Octets paramOctets);
  
  public abstract void setMail_content(String paramString);
  
  public abstract void setMail_contentOctets(Octets paramOctets);
  
  public abstract void setRollfre(int paramInt);
  
  public abstract void setRollnum(int paramInt);
  
  public abstract void setReal_num(int paramInt);
  
  public abstract void setVersion(int paramInt);
  
  public abstract void setIndexid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IdipMarqueeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */