package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface TitleAppellation
  extends Bean
{
  public static final int DIY_APP_NORMAL = 0;
  public static final int DIY_APP_GANG = 1;
  public static final int DIY_APP_COUPLE = 2;
  public static final int DIY_APP_JIEYI = 3;
  public static final int DIY_APP_MASTER = 4;
  
  public abstract TitleAppellation copy();
  
  public abstract TitleAppellation toData();
  
  public abstract TitleAppellation toBean();
  
  public abstract TitleAppellation toDataIf();
  
  public abstract TitleAppellation toBeanIf();
  
  public abstract List<TitleInfo> getOwntitle();
  
  public abstract List<TitleInfo> getOwntitleAsData();
  
  public abstract int getActivetitle();
  
  public abstract int getActiveappellation();
  
  public abstract int getPro2appellationid();
  
  public abstract Map<Integer, AppellationInfo> getAppellations();
  
  public abstract Map<Integer, AppellationInfo> getAppellationsAsData();
  
  public abstract void setActivetitle(int paramInt);
  
  public abstract void setActiveappellation(int paramInt);
  
  public abstract void setPro2appellationid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\TitleAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */