package mzm.gsp.util;

public abstract interface IOrderedWithKey<TKey, TObj>
  extends IOrdered<TObj>
{
  public abstract TKey getKey();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\IOrderedWithKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */