package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface GangMember
  extends Bean
{
  public abstract GangMember copy();
  
  public abstract GangMember toData();
  
  public abstract GangMember toBean();
  
  public abstract GangMember toDataIf();
  
  public abstract GangMember toBeanIf();
  
  public abstract int getDuty();
  
  public abstract long getBanggong();
  
  public abstract long getHistorybanggong();
  
  public abstract long getGangid();
  
  public abstract long getJointime();
  
  public abstract long getForbiddentalkend();
  
  public abstract long getLastreadannouncementtimestamp();
  
  public abstract long getRedeembanggong();
  
  public abstract long getNextupdateredeemtimestamp();
  
  public abstract int getMakemifangcount();
  
  public abstract int getTotalmakemifangcount();
  
  public abstract long getLasthavemifangtime();
  
  public abstract long getLastgetfulitime();
  
  public abstract long getLastgetlihetime();
  
  public abstract int getGongxun();
  
  public abstract long getGongxun_timestamp();
  
  public abstract int getIssign();
  
  public abstract long getSigntime();
  
  public abstract String getSignstr();
  
  public abstract Octets getSignstrOctets();
  
  public abstract boolean getIspassiveleaved();
  
  public abstract int getWeekbanggong();
  
  public abstract long getAddbanggong_time();
  
  public abstract int getWeekitem_banggong_count();
  
  public abstract long getItem_banggong_time();
  
  public abstract int getYuanbao_redeem_bang_gong();
  
  public abstract long getCreate_gang_team_time();
  
  public abstract boolean getIs_in_gang();
  
  public abstract void setDuty(int paramInt);
  
  public abstract void setBanggong(long paramLong);
  
  public abstract void setHistorybanggong(long paramLong);
  
  public abstract void setGangid(long paramLong);
  
  public abstract void setJointime(long paramLong);
  
  public abstract void setForbiddentalkend(long paramLong);
  
  public abstract void setLastreadannouncementtimestamp(long paramLong);
  
  public abstract void setRedeembanggong(long paramLong);
  
  public abstract void setNextupdateredeemtimestamp(long paramLong);
  
  public abstract void setMakemifangcount(int paramInt);
  
  public abstract void setTotalmakemifangcount(int paramInt);
  
  public abstract void setLasthavemifangtime(long paramLong);
  
  public abstract void setLastgetfulitime(long paramLong);
  
  public abstract void setLastgetlihetime(long paramLong);
  
  public abstract void setGongxun(int paramInt);
  
  public abstract void setGongxun_timestamp(long paramLong);
  
  public abstract void setIssign(int paramInt);
  
  public abstract void setSigntime(long paramLong);
  
  public abstract void setSignstr(String paramString);
  
  public abstract void setSignstrOctets(Octets paramOctets);
  
  public abstract void setIspassiveleaved(boolean paramBoolean);
  
  public abstract void setWeekbanggong(int paramInt);
  
  public abstract void setAddbanggong_time(long paramLong);
  
  public abstract void setWeekitem_banggong_count(int paramInt);
  
  public abstract void setItem_banggong_time(long paramLong);
  
  public abstract void setYuanbao_redeem_bang_gong(int paramInt);
  
  public abstract void setCreate_gang_team_time(long paramLong);
  
  public abstract void setIs_in_gang(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */