package xbean;

import xdb.Bean;

public abstract interface ThingBean
  extends Bean
{
  public static final int SIGN_UN_BIND = 0;
  public static final int SIGN_BIND = 1;
  
  public abstract ThingBean copy();
  
  public abstract ThingBean toData();
  
  public abstract ThingBean toBean();
  
  public abstract ThingBean toDataIf();
  
  public abstract ThingBean toBeanIf();
  
  public abstract int getId();
  
  public abstract int getCount();
  
  public abstract int getSign();
  
  public abstract int getThingtype();
  
  public abstract void setId(int paramInt);
  
  public abstract void setCount(int paramInt);
  
  public abstract void setSign(int paramInt);
  
  public abstract void setThingtype(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\ThingBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */