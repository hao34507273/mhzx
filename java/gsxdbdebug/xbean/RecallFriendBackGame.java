package xbean;

import java.util.List;
import xdb.Bean;

public abstract interface RecallFriendBackGame
  extends Bean
{
  public abstract RecallFriendBackGame copy();
  
  public abstract RecallFriendBackGame toData();
  
  public abstract RecallFriendBackGame toBean();
  
  public abstract RecallFriendBackGame toDataIf();
  
  public abstract RecallFriendBackGame toBeanIf();
  
  public abstract List<RecallUserInfo> getRecall_friend_list();
  
  public abstract List<RecallUserInfo> getRecall_friend_listAsData();
  
  public abstract int getRecall_friend_num();
  
  public abstract long getLast_recall_friend_time();
  
  public abstract int getRecall_friend_times_today();
  
  public abstract int getRecall_friend_num_award_serial_no();
  
  public abstract BeRecalledBackGameInfo getBe_recalled_back_game();
  
  public abstract RebateInfo getRebate_info();
  
  public abstract int getCross_recall_friend_times_today();
  
  public abstract void setRecall_friend_num(int paramInt);
  
  public abstract void setLast_recall_friend_time(long paramLong);
  
  public abstract void setRecall_friend_times_today(int paramInt);
  
  public abstract void setRecall_friend_num_award_serial_no(int paramInt);
  
  public abstract void setCross_recall_friend_times_today(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\RecallFriendBackGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */