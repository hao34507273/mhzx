package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface GangAnnouncement
  extends Bean
{
  public abstract GangAnnouncement copy();
  
  public abstract GangAnnouncement toData();
  
  public abstract GangAnnouncement toBean();
  
  public abstract GangAnnouncement toDataIf();
  
  public abstract GangAnnouncement toBeanIf();
  
  public abstract String getAnnouncement();
  
  public abstract Octets getAnnouncementOctets();
  
  public abstract long getModifytime();
  
  public abstract long getModifierid();
  
  public abstract void setAnnouncement(String paramString);
  
  public abstract void setAnnouncementOctets(Octets paramOctets);
  
  public abstract void setModifytime(long paramLong);
  
  public abstract void setModifierid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\GangAnnouncement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */