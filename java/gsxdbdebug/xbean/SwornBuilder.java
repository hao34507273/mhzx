package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import mzm.gsp.sworn.main.SwornWaitSession;
import xdb.Bean;

public abstract interface SwornBuilder
  extends Bean
{
  public static final int STATUS_AGREE_CREATE = 0;
  public static final int STATUS_SET_NAME = 1;
  public static final int STATUS_AGREE_NAME = 2;
  public static final int STATUS_SET_TITLE = 3;
  public static final int STATUS_CONFIRM_CREATE = 4;
  
  public abstract SwornBuilder copy();
  
  public abstract SwornBuilder toData();
  
  public abstract SwornBuilder toBean();
  
  public abstract SwornBuilder toDataIf();
  
  public abstract SwornBuilder toBeanIf();
  
  public abstract int getStatus();
  
  public abstract long getLeaderid();
  
  public abstract List<Long> getRoleids();
  
  public abstract List<Long> getRoleidsAsData();
  
  public abstract List<Long> getAgreeids();
  
  public abstract List<Long> getAgreeidsAsData();
  
  public abstract long getConfirmtime();
  
  public abstract String getName1();
  
  public abstract Octets getName1Octets();
  
  public abstract String getName2();
  
  public abstract Octets getName2Octets();
  
  public abstract Map<Long, String> getTitles();
  
  public abstract Map<Long, String> getTitlesAsData();
  
  public abstract SwornWaitSession getTimer();
  
  public abstract void setStatus(int paramInt);
  
  public abstract void setLeaderid(long paramLong);
  
  public abstract void setConfirmtime(long paramLong);
  
  public abstract void setName1(String paramString);
  
  public abstract void setName1Octets(Octets paramOctets);
  
  public abstract void setName2(String paramString);
  
  public abstract void setName2Octets(Octets paramOctets);
  
  public abstract void setTimer(SwornWaitSession paramSwornWaitSession);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\SwornBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */