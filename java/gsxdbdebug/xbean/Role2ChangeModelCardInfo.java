package xbean;

import java.util.List;
import java.util.Map;
import xdb.Bean;

public abstract interface Role2ChangeModelCardInfo
  extends Bean
{
  public abstract Role2ChangeModelCardInfo copy();
  
  public abstract Role2ChangeModelCardInfo toData();
  
  public abstract Role2ChangeModelCardInfo toBean();
  
  public abstract Role2ChangeModelCardInfo toDataIf();
  
  public abstract Role2ChangeModelCardInfo toBeanIf();
  
  public abstract List<Long> getCard_ids();
  
  public abstract List<Long> getCard_idsAsData();
  
  public abstract int getCurrent_card_cfg_id();
  
  public abstract int getCurrent_card_level();
  
  public abstract boolean getVisible();
  
  public abstract int getFight_count();
  
  public abstract long getStart_time();
  
  public abstract int getOverlay_count();
  
  public abstract long getNext_card_id();
  
  public abstract Map<Long, ChangeModelCardInfo> getCardid2info();
  
  public abstract Map<Long, ChangeModelCardInfo> getCardid2infoAsData();
  
  public abstract boolean getActivated_in_fight();
  
  public abstract void setCurrent_card_cfg_id(int paramInt);
  
  public abstract void setCurrent_card_level(int paramInt);
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setFight_count(int paramInt);
  
  public abstract void setStart_time(long paramLong);
  
  public abstract void setOverlay_count(int paramInt);
  
  public abstract void setNext_card_id(long paramLong);
  
  public abstract void setActivated_in_fight(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Role2ChangeModelCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */