package xbean;

import xdb.Bean;

public abstract interface Sign
  extends Bean
{
  public static final int NO_FIRST_BOX = 0;
  public static final int FIRST_BOX_NO_TRIGGER_LUCKY = 1;
  public static final int NO_TRIGGER_LUCKY = 2;
  public static final int NORMAL_ARRIVE_TRIGGER_LUCKY = 3;
  public static final int YUAN_BAO_ARRIVE_TRIGGER_LUCKY = 4;
  
  public abstract Sign copy();
  
  public abstract Sign toData();
  
  public abstract Sign toBean();
  
  public abstract Sign toDataIf();
  
  public abstract Sign toBeanIf();
  
  public abstract int getSigncount();
  
  public abstract long getSigntime();
  
  public abstract int getSignday();
  
  public abstract int getFillincount();
  
  public abstract int getAwardedfillincount();
  
  public abstract int getBox_sign_award_state();
  
  public abstract int getCurrent_precious_cell_num();
  
  public abstract int getCurrent_precious_box_buff_id();
  
  public abstract int getLucky_box_sign_box_buff_id();
  
  public abstract int getLucky_box_gold_precious_cfg_id();
  
  public abstract void setSigncount(int paramInt);
  
  public abstract void setSigntime(long paramLong);
  
  public abstract void setSignday(int paramInt);
  
  public abstract void setFillincount(int paramInt);
  
  public abstract void setAwardedfillincount(int paramInt);
  
  public abstract void setBox_sign_award_state(int paramInt);
  
  public abstract void setCurrent_precious_cell_num(int paramInt);
  
  public abstract void setCurrent_precious_box_buff_id(int paramInt);
  
  public abstract void setLucky_box_sign_box_buff_id(int paramInt);
  
  public abstract void setLucky_box_gold_precious_cfg_id(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\Sign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */