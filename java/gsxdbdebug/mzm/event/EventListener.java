package mzm.event;

abstract interface EventListener<Args>
  extends Cloneable
{
  public abstract Object clone()
    throws CloneNotSupportedException;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\event\EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */