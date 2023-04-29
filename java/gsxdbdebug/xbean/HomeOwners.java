package xbean;

import xdb.Bean;

public abstract interface HomeOwners
  extends Bean
{
  public abstract HomeOwners copy();
  
  public abstract HomeOwners toData();
  
  public abstract HomeOwners toBean();
  
  public abstract HomeOwners toDataIf();
  
  public abstract HomeOwners toBeanIf();
  
  public abstract long getCreatorroleid();
  
  public abstract long getPartnerroleid();
  
  public abstract void setCreatorroleid(long paramLong);
  
  public abstract void setPartnerroleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\HomeOwners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */