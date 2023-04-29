package xbean;

import com.goldhuman.Common.Octets;
import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface MailInfo
  extends Bean
{
  public static final int ITEM_REASON_ID = 1;
  public static final int CURRENCY_REASON_ID = 2;
  public static final int MAIL_GET_ALL_THING = 3;
  public static final int MAIL_DEL_TIME_SEC = 4;
  public static final int ZERO_PROFIT = 5;
  
  public abstract MailInfo copy();
  
  public abstract MailInfo toData();
  
  public abstract MailInfo toBean();
  
  public abstract MailInfo toDataIf();
  
  public abstract MailInfo toBeanIf();
  
  public abstract MailContent getMailcontent();
  
  public abstract long getCreatetime();
  
  public abstract int getState();
  
  public abstract List<ThingBean> getNotitemlist();
  
  public abstract List<ThingBean> getNotitemlistAsData();
  
  public abstract List<Item> getItemlist();
  
  public abstract List<Item> getItemlistAsData();
  
  public abstract Map<Integer, Integer> getExtradatamap();
  
  public abstract Map<Integer, Integer> getExtradatamapAsData();
  
  public abstract String getTagid();
  
  public abstract Octets getTagidOctets();
  
  public abstract void setCreatetime(long paramLong);
  
  public abstract void setState(int paramInt);
  
  public abstract void setTagid(String paramString);
  
  public abstract void setTagidOctets(Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\MailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */