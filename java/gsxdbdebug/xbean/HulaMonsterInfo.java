package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface HulaMonsterInfo
  extends Bean
{
  public abstract HulaMonsterInfo copy();
  
  public abstract HulaMonsterInfo toData();
  
  public abstract HulaMonsterInfo toBean();
  
  public abstract HulaMonsterInfo toDataIf();
  
  public abstract HulaMonsterInfo toBeanIf();
  
  public abstract int getMonsterid();
  
  public abstract int getState();
  
  public abstract int getSeq();
  
  public abstract String getMark_content();
  
  public abstract Octets getMark_contentOctets();
  
  public abstract void setMonsterid(int paramInt);
  
  public abstract void setState(int paramInt);
  
  public abstract void setSeq(int paramInt);
  
  public abstract void setMark_content(String paramString);
  
  public abstract void setMark_contentOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HulaMonsterInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */