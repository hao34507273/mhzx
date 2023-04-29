package xbean;

import xdb.Bean;

public abstract interface RoleFlowerParadeRecord
  extends Bean
{
  public abstract RoleFlowerParadeRecord copy();
  
  public abstract RoleFlowerParadeRecord toData();
  
  public abstract RoleFlowerParadeRecord toBean();
  
  public abstract RoleFlowerParadeRecord toDataIf();
  
  public abstract RoleFlowerParadeRecord toBeanIf();
  
  public abstract int getFollowawardcount();
  
  public abstract int getDanceawardcount();
  
  public abstract int getRedbagawardcount();
  
  public abstract DanceAwardInfo getPredanceawardinfo();
  
  public abstract void setFollowawardcount(int paramInt);
  
  public abstract void setDanceawardcount(int paramInt);
  
  public abstract void setRedbagawardcount(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RoleFlowerParadeRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */