package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface User
  extends Bean
{
  public static final int INVITEE_STATUS_INIT = 0;
  public static final int INVITEE_STATUS_INVALID = 1;
  public static final int INVITEE_STATUS_FRESHMAN_AWARD = 2;
  public static final int INVITEE_STATUS_PRESENT_GIFT_TIMES = 4;
  
  public abstract User copy();
  
  public abstract User toData();
  
  public abstract User toBean();
  
  public abstract User toDataIf();
  
  public abstract User toBeanIf();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
  
  public abstract boolean getActivated();
  
  public abstract long getLastlogintime();
  
  public abstract long getLast_login_roleid();
  
  public abstract long getMax_fighting_capacity();
  
  public abstract long getMax_fighting_capacity_roleid();
  
  public abstract int getGrc_friends_count();
  
  public abstract int getGrc_friends_count_award_serial_no();
  
  public abstract int getSn();
  
  public abstract String getFinal_success_order_id();
  
  public abstract Octets getFinal_success_order_idOctets();
  
  public abstract long getFinal_transfer_success_time();
  
  public abstract Set<Long> getCompensates();
  
  public abstract Set<Long> getCompensatesAsData();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getPrivilege_award_infos();
  
  public abstract Map<Integer, PrivilegeAwardInfo> getPrivilege_award_infosAsData();
  
  public abstract int getInvitee_status();
  
  public abstract String getInvitee_code();
  
  public abstract Octets getInvitee_codeOctets();
  
  public abstract long getInvitee_total_present_rebate_bind_yuanbao();
  
  public abstract String getInviter_code();
  
  public abstract Octets getInviter_codeOctets();
  
  public abstract long getInviter_total_rebate_bind_yuanbao();
  
  public abstract long getInviter_total_gift_times();
  
  public abstract long getInvitee_save_amt();
  
  public abstract long getRegister_time();
  
  public abstract long getInvitee_confirm_total_present_rebate_bind_yuanbao();
  
  public abstract int getInvitee_done_shimen_total_days();
  
  public abstract long getInvitee_done_shimen_timestamp();
  
  public abstract RecallFriendBackGame getRecall_friend_back_game();
  
  public abstract String getFigure_url();
  
  public abstract Octets getFigure_urlOctets();
  
  public abstract String getNick_name();
  
  public abstract Octets getNick_nameOctets();
  
  public abstract void setActivated(boolean paramBoolean);
  
  public abstract void setLastlogintime(long paramLong);
  
  public abstract void setLast_login_roleid(long paramLong);
  
  public abstract void setMax_fighting_capacity(long paramLong);
  
  public abstract void setMax_fighting_capacity_roleid(long paramLong);
  
  public abstract void setGrc_friends_count(int paramInt);
  
  public abstract void setGrc_friends_count_award_serial_no(int paramInt);
  
  public abstract void setSn(int paramInt);
  
  public abstract void setFinal_success_order_id(String paramString);
  
  public abstract void setFinal_success_order_idOctets(Octets paramOctets);
  
  public abstract void setFinal_transfer_success_time(long paramLong);
  
  public abstract void setInvitee_status(int paramInt);
  
  public abstract void setInvitee_code(String paramString);
  
  public abstract void setInvitee_codeOctets(Octets paramOctets);
  
  public abstract void setInvitee_total_present_rebate_bind_yuanbao(long paramLong);
  
  public abstract void setInviter_code(String paramString);
  
  public abstract void setInviter_codeOctets(Octets paramOctets);
  
  public abstract void setInviter_total_rebate_bind_yuanbao(long paramLong);
  
  public abstract void setInviter_total_gift_times(long paramLong);
  
  public abstract void setInvitee_save_amt(long paramLong);
  
  public abstract void setRegister_time(long paramLong);
  
  public abstract void setInvitee_confirm_total_present_rebate_bind_yuanbao(long paramLong);
  
  public abstract void setInvitee_done_shimen_total_days(int paramInt);
  
  public abstract void setInvitee_done_shimen_timestamp(long paramLong);
  
  public abstract void setFigure_url(String paramString);
  
  public abstract void setFigure_urlOctets(Octets paramOctets);
  
  public abstract void setNick_name(String paramString);
  
  public abstract void setNick_nameOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */