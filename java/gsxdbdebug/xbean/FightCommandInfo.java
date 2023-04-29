package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface FightCommandInfo
  extends Bean
{
  public abstract FightCommandInfo copy();
  
  public abstract FightCommandInfo toData();
  
  public abstract FightCommandInfo toBean();
  
  public abstract FightCommandInfo toDataIf();
  
  public abstract FightCommandInfo toBeanIf();
  
  public abstract String getContent();
  
  public abstract Octets getContentOctets();
  
  public abstract void setContent(String paramString);
  
  public abstract void setContentOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCommandInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */