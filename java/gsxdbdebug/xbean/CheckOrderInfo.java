package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface CheckOrderInfo
  extends Bean
{
  public static final int STATUS_WAIT_AUANY_CONFIRM = 1;
  public static final int STATUS_AUANY_CONFIRMING = 4;
  public static final int STATUS_AUANY_CONFIRM_SUCCESS = 8;
  public static final int ORDER_FLAG_COST = 1;
  public static final int ORDER_FLAG_PRESENT = 2;
  
  public abstract CheckOrderInfo copy();
  
  public abstract CheckOrderInfo toData();
  
  public abstract CheckOrderInfo toBean();
  
  public abstract CheckOrderInfo toDataIf();
  
  public abstract CheckOrderInfo toBeanIf();
  
  public abstract int getStatus();
  
  public abstract int getFlags();
  
  public abstract String getUserid();
  
  public abstract Octets getUseridOctets();
  
  public abstract int getCost();
  
  public abstract int getCost_bind();
  
  public abstract int getPresent();
  
  public abstract int getPresent_bind();
  
  public abstract long getCreate_time();
  
  public abstract long getConfirm_success_time();
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setFlags(int paramInt);
  
  public abstract void setUserid(String paramString);
  
  public abstract void setUseridOctets(Octets paramOctets);
  
  public abstract void setCost(int paramInt);
  
  public abstract void setCost_bind(int paramInt);
  
  public abstract void setPresent(int paramInt);
  
  public abstract void setPresent_bind(int paramInt);
  
  public abstract void setCreate_time(long paramLong);
  
  public abstract void setConfirm_success_time(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CheckOrderInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */