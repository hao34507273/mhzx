package xbean;

import java.util.Map;
import java.util.Set;
import xdb.Bean;

public abstract interface IndianaAwardInfo
  extends Bean
{
  public abstract IndianaAwardInfo copy();
  
  public abstract IndianaAwardInfo toData();
  
  public abstract IndianaAwardInfo toBean();
  
  public abstract IndianaAwardInfo toDataIf();
  
  public abstract IndianaAwardInfo toBeanIf();
  
  public abstract int getAttend_role_num();
  
  public abstract long getAttend_role_num_timestamp();
  
  public abstract boolean getGot_award_number();
  
  public abstract Map<Integer, IndianaAwardRoleInfo> getAward_number_infos();
  
  public abstract Map<Integer, IndianaAwardRoleInfo> getAward_number_infosAsData();
  
  public abstract Set<Integer> getNeed_broadcast_numbers();
  
  public abstract Set<Integer> getNeed_broadcast_numbersAsData();
  
  public abstract void setAttend_role_num(int paramInt);
  
  public abstract void setAttend_role_num_timestamp(long paramLong);
  
  public abstract void setGot_award_number(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IndianaAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */