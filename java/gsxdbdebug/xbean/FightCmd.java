package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import xdb.Bean;

public abstract interface FightCmd
  extends Bean
{
  public abstract FightCmd copy();
  
  public abstract FightCmd toData();
  
  public abstract FightCmd toBean();
  
  public abstract FightCmd toDataIf();
  
  public abstract FightCmd toBeanIf();
  
  public abstract int getFighterid();
  
  public abstract int getOp_type();
  
  public abstract <T extends Marshal> T getContent(T paramT);
  
  public abstract boolean isContentEmpty();
  
  public abstract byte[] getContentCopy();
  
  public abstract void setFighterid(int paramInt);
  
  public abstract void setOp_type(int paramInt);
  
  public abstract void setContent(Marshal paramMarshal);
  
  public abstract void setContentCopy(byte[] paramArrayOfByte);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FightCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */