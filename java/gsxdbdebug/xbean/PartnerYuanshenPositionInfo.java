package xbean;

import xdb.Bean;

public abstract interface PartnerYuanshenPositionInfo
  extends Bean
{
  public abstract PartnerYuanshenPositionInfo copy();
  
  public abstract PartnerYuanshenPositionInfo toData();
  
  public abstract PartnerYuanshenPositionInfo toBean();
  
  public abstract PartnerYuanshenPositionInfo toDataIf();
  
  public abstract PartnerYuanshenPositionInfo toBeanIf();
  
  public abstract int getAttached_partner_id();
  
  public abstract int getLevel();
  
  public abstract int getProperty_num();
  
  public abstract void setAttached_partner_id(int paramInt);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setProperty_num(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\PartnerYuanshenPositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */