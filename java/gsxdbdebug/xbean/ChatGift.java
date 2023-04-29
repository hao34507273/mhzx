package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface ChatGift
  extends Bean
{
  public abstract ChatGift copy();
  
  public abstract ChatGift toData();
  
  public abstract ChatGift toBean();
  
  public abstract ChatGift toDataIf();
  
  public abstract ChatGift toBeanIf();
  
  public abstract long getRoleid();
  
  public abstract long getStarttime();
  
  public abstract int getType();
  
  public abstract Map<Long, ChatGiftRoleMoney> getRole2money();
  
  public abstract Map<Long, ChatGiftRoleMoney> getRole2moneyAsData();
  
  public abstract int getNum();
  
  public abstract String getDescstr();
  
  public abstract Octets getDescstrOctets();
  
  public abstract Map<Integer, ChannelSet> getChannelinfo();
  
  public abstract Map<Integer, ChannelSet> getChannelinfoAsData();
  
  public abstract void setRoleid(long paramLong);
  
  public abstract void setStarttime(long paramLong);
  
  public abstract void setType(int paramInt);
  
  public abstract void setNum(int paramInt);
  
  public abstract void setDescstr(String paramString);
  
  public abstract void setDescstrOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */