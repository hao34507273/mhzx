package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Corps
  extends Bean
{
  public abstract Corps copy();
  
  public abstract Corps toData();
  
  public abstract Corps toBean();
  
  public abstract Corps toDataIf();
  
  public abstract Corps toBeanIf();
  
  public abstract long getCorpsid();
  
  public abstract String getCorpsname();
  
  public abstract Octets getCorpsnameOctets();
  
  public abstract String getCorpsdeclaration();
  
  public abstract Octets getCorpsdeclarationOctets();
  
  public abstract int getCorpsbadge();
  
  public abstract long getCreatetime();
  
  public abstract Map<Integer, CorpsDutyMembers> getDuty2members();
  
  public abstract Map<Integer, CorpsDutyMembers> getDuty2membersAsData();
  
  public abstract List<CorpsHistory> getHistorylist();
  
  public abstract List<CorpsHistory> getHistorylistAsData();
  
  public abstract int getNexthistoryid();
  
  public abstract void setCorpsid(long paramLong);
  
  public abstract void setCorpsname(String paramString);
  
  public abstract void setCorpsnameOctets(Octets paramOctets);
  
  public abstract void setCorpsdeclaration(String paramString);
  
  public abstract void setCorpsdeclarationOctets(Octets paramOctets);
  
  public abstract void setCorpsbadge(int paramInt);
  
  public abstract void setCreatetime(long paramLong);
  
  public abstract void setNexthistoryid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Corps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */