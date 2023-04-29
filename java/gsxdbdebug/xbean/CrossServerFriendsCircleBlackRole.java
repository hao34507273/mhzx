package xbean;

import xdb.Bean;

public abstract interface CrossServerFriendsCircleBlackRole
  extends Bean
{
  public abstract CrossServerFriendsCircleBlackRole copy();
  
  public abstract CrossServerFriendsCircleBlackRole toData();
  
  public abstract CrossServerFriendsCircleBlackRole toBean();
  
  public abstract CrossServerFriendsCircleBlackRole toDataIf();
  
  public abstract CrossServerFriendsCircleBlackRole toBeanIf();
  
  public abstract int getOperator();
  
  public abstract int getRole_server_id();
  
  public abstract void setOperator(int paramInt);
  
  public abstract void setRole_server_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossServerFriendsCircleBlackRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */