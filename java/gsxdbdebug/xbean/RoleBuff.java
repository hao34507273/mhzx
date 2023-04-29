package xbean;

import xdb.Bean;

public abstract interface RoleBuff
  extends Bean
{
  public static final int DETACH = 0;
  public static final int ATTACH = 1;
  
  public abstract RoleBuff copy();
  
  public abstract RoleBuff toData();
  
  public abstract RoleBuff toBean();
  
  public abstract RoleBuff toDataIf();
  
  public abstract RoleBuff toBeanIf();
  
  public abstract int getId();
  
  public abstract int getCount();
  
  public abstract long getEndtime();
  
  public abstract int getMultiple();
  
  public abstract long getInstall_time();
  
  public abstract int getEffect_state();
  
  public abstract void setId(int paramInt);
  
  public abstract void setCount(int paramInt);
  
  public abstract void setEndtime(long paramLong);
  
  public abstract void setMultiple(int paramInt);
  
  public abstract void setInstall_time(long paramLong);
  
  public abstract void setEffect_state(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */