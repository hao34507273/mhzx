package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Gang
  extends Bean
{
  public abstract Gang copy();
  
  public abstract Gang toData();
  
  public abstract Gang toBean();
  
  public abstract Gang toDataIf();
  
  public abstract Gang toBeanIf();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract int getLevel();
  
  public abstract long getCreatetime();
  
  public abstract String getPurpose();
  
  public abstract Octets getPurposeOctets();
  
  public abstract long getBangzhuid();
  
  public abstract int getDesigntitlecaseid();
  
  public abstract int getVitality();
  
  public abstract long getLeveluptime();
  
  public abstract List<GangAnnouncement> getAnnouncementhistorylist();
  
  public abstract List<GangAnnouncement> getAnnouncementhistorylistAsData();
  
  public abstract int getApprenticemaxlv();
  
  public abstract long getTimestamp();
  
  public abstract long getLastrename();
  
  public abstract int getForbiddentalkcount();
  
  public abstract long getTanheroleid();
  
  public abstract long getTanheendtime();
  
  public abstract int getJuanzhongnum();
  
  public abstract long getNextid();
  
  public abstract int getPublishtime();
  
  public abstract List<GangHelper> getGanghelperlist();
  
  public abstract List<GangHelper> getGanghelperlistAsData();
  
  public abstract XiangFang getXiangfang();
  
  public abstract JinKu getJinku();
  
  public abstract YaoDian getYaodian();
  
  public abstract CangKu getCangku();
  
  public abstract ShuYuan getShuyuan();
  
  public abstract Map<Integer, GangDutyMembers> getDuty2members();
  
  public abstract Map<Integer, GangDutyMembers> getDuty2membersAsData();
  
  public abstract int getPeriodmoney();
  
  public abstract long getGrouproleid();
  
  public abstract String getGroupopenid();
  
  public abstract Octets getGroupopenidOctets();
  
  public abstract long getDisplayid();
  
  public abstract Map<Long, GangTeam> getTeams();
  
  public abstract Map<Long, GangTeam> getTeamsAsData();
  
  public abstract Map<Long, Long> getMember2teamid();
  
  public abstract Map<Long, Long> getMember2teamidAsData();
  
  public abstract long getNext_teamid();
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setLevel(int paramInt);
  
  public abstract void setCreatetime(long paramLong);
  
  public abstract void setPurpose(String paramString);
  
  public abstract void setPurposeOctets(Octets paramOctets);
  
  public abstract void setBangzhuid(long paramLong);
  
  public abstract void setDesigntitlecaseid(int paramInt);
  
  public abstract void setVitality(int paramInt);
  
  public abstract void setLeveluptime(long paramLong);
  
  public abstract void setApprenticemaxlv(int paramInt);
  
  public abstract void setTimestamp(long paramLong);
  
  public abstract void setLastrename(long paramLong);
  
  public abstract void setForbiddentalkcount(int paramInt);
  
  public abstract void setTanheroleid(long paramLong);
  
  public abstract void setTanheendtime(long paramLong);
  
  public abstract void setJuanzhongnum(int paramInt);
  
  public abstract void setNextid(long paramLong);
  
  public abstract void setPublishtime(int paramInt);
  
  public abstract void setPeriodmoney(int paramInt);
  
  public abstract void setGrouproleid(long paramLong);
  
  public abstract void setGroupopenid(String paramString);
  
  public abstract void setGroupopenidOctets(Octets paramOctets);
  
  public abstract void setDisplayid(long paramLong);
  
  public abstract void setNext_teamid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */