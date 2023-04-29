package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Group
  extends Bean
{
  public abstract Group copy();
  
  public abstract Group toData();
  
  public abstract Group toBean();
  
  public abstract Group toDataIf();
  
  public abstract Group toBeanIf();
  
  public abstract int getGroup_type();
  
  public abstract long getMasterid();
  
  public abstract long getCreate_time();
  
  public abstract String getGroup_name();
  
  public abstract Octets getGroup_nameOctets();
  
  public abstract String getAnnouncement();
  
  public abstract Octets getAnnouncementOctets();
  
  public abstract Map<Long, GroupMember> getGroupmembers();
  
  public abstract Map<Long, GroupMember> getGroupmembersAsData();
  
  public abstract List<Long> getMemberlist();
  
  public abstract List<Long> getMemberlistAsData();
  
  public abstract long getInfo_version();
  
  public abstract void setGroup_type(int paramInt);
  
  public abstract void setMasterid(long paramLong);
  
  public abstract void setCreate_time(long paramLong);
  
  public abstract void setGroup_name(String paramString);
  
  public abstract void setGroup_nameOctets(Octets paramOctets);
  
  public abstract void setAnnouncement(String paramString);
  
  public abstract void setAnnouncementOctets(Octets paramOctets);
  
  public abstract void setInfo_version(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Group.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */