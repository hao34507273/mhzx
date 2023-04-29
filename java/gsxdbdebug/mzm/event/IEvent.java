package mzm.event;

public abstract interface IEvent<Args>
{
  public abstract void setSequential(boolean paramBoolean);
  
  public abstract boolean getSequential();
  
  public abstract Args getArg();
  
  public abstract void setArg(Args paramArgs);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\IEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */