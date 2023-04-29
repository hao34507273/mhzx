package xbean;

import xdb.Bean;

public abstract interface CatBestPartnerInfo
  extends Bean
{
  public abstract CatBestPartnerInfo copy();
  
  public abstract CatBestPartnerInfo toData();
  
  public abstract CatBestPartnerInfo toBean();
  
  public abstract CatBestPartnerInfo toDataIf();
  
  public abstract CatBestPartnerInfo toBeanIf();
  
  public abstract long getLast_timestamp();
  
  public abstract int getPartner_cfgid();
  
  public abstract void setLast_timestamp(long paramLong);
  
  public abstract void setPartner_cfgid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CatBestPartnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */