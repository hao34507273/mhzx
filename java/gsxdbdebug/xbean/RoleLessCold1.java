package xbean;

import xdb.Bean;

public abstract interface RoleLessCold1
  extends Bean
{
  public abstract RoleLessCold1 copy();
  
  public abstract RoleLessCold1 toData();
  
  public abstract RoleLessCold1 toBean();
  
  public abstract RoleLessCold1 toDataIf();
  
  public abstract RoleLessCold1 toBeanIf();
  
  public abstract int getRobparadecount();
  
  public abstract int getRobprotectcount();
  
  public abstract long getRobparadetime();
  
  public abstract long getRobprotecttime();
  
  public abstract void setRobparadecount(int paramInt);
  
  public abstract void setRobprotectcount(int paramInt);
  
  public abstract void setRobparadetime(long paramLong);
  
  public abstract void setRobprotecttime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleLessCold1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */