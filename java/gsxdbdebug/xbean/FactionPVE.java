package xbean;

import xdb.Bean;

public abstract interface FactionPVE
  extends Bean
{
  public abstract FactionPVE copy();
  
  public abstract FactionPVE toData();
  
  public abstract FactionPVE toBean();
  
  public abstract FactionPVE toDataIf();
  
  public abstract FactionPVE toBeanIf();
  
  public abstract int getActivate_times();
  
  public abstract int getSet_times();
  
  public abstract long getStart_timestamp();
  
  public abstract void setActivate_times(int paramInt);
  
  public abstract void setSet_times(int paramInt);
  
  public abstract void setStart_timestamp(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionPVE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */