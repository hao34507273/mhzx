package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface ChatGiftRoleMoney
  extends Bean
{
  public abstract ChatGiftRoleMoney copy();
  
  public abstract ChatGiftRoleMoney toData();
  
  public abstract ChatGiftRoleMoney toBean();
  
  public abstract ChatGiftRoleMoney toDataIf();
  
  public abstract ChatGiftRoleMoney toBeanIf();
  
  public abstract String getRolename();
  
  public abstract Octets getRolenameOctets();
  
  public abstract int getMoneynum();
  
  public abstract void setRolename(String paramString);
  
  public abstract void setRolenameOctets(Octets paramOctets);
  
  public abstract void setMoneynum(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatGiftRoleMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */