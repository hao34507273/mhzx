package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface RMBGiftBagActivityInfo
  extends Bean
{
  public abstract RMBGiftBagActivityInfo copy();
  
  public abstract RMBGiftBagActivityInfo toData();
  
  public abstract RMBGiftBagActivityInfo toBean();
  
  public abstract RMBGiftBagActivityInfo toDataIf();
  
  public abstract RMBGiftBagActivityInfo toBeanIf();
  
  public abstract Map<Integer, RMBGiftBagTierInfo> getTiers();
  
  public abstract Map<Integer, RMBGiftBagTierInfo> getTiersAsData();
  
  public abstract int getOpen_server_days();
  
  public abstract int getSend_award_mail_cfgid();
  
  public abstract void setOpen_server_days(int paramInt);
  
  public abstract void setSend_award_mail_cfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RMBGiftBagActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */