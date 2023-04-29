package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface CompensateInfo
  extends Bean
{
  public static final int USER_MODE = 1;
  public static final int ROLE_MODE = 2;
  
  public abstract CompensateInfo copy();
  
  public abstract CompensateInfo toData();
  
  public abstract CompensateInfo toBean();
  
  public abstract CompensateInfo toDataIf();
  
  public abstract CompensateInfo toBeanIf();
  
  public abstract int getMode();
  
  public abstract int getMin_level();
  
  public abstract int getMax_level();
  
  public abstract long getStart_time();
  
  public abstract long getEnd_time();
  
  public abstract String getMail_title();
  
  public abstract Octets getMail_titleOctets();
  
  public abstract String getMail_content();
  
  public abstract Octets getMail_contentOctets();
  
  public abstract Map<Integer, Integer> getItems();
  
  public abstract Map<Integer, Integer> getItemsAsData();
  
  public abstract Map<Integer, Integer> getCurrencies();
  
  public abstract Map<Integer, Integer> getCurrenciesAsData();
  
  public abstract long getMin_create_role_time();
  
  public abstract long getMax_create_role_time();
  
  public abstract int getTagid();
  
  public abstract void setMode(int paramInt);
  
  public abstract void setMin_level(int paramInt);
  
  public abstract void setMax_level(int paramInt);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setEnd_time(long paramLong);
  
  public abstract void setMail_title(String paramString);
  
  public abstract void setMail_titleOctets(Octets paramOctets);
  
  public abstract void setMail_content(String paramString);
  
  public abstract void setMail_contentOctets(Octets paramOctets);
  
  public abstract void setMin_create_role_time(long paramLong);
  
  public abstract void setMax_create_role_time(long paramLong);
  
  public abstract void setTagid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CompensateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */