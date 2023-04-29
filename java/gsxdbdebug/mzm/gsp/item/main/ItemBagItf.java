package mzm.gsp.item.main;

import java.util.Map;

public abstract interface ItemBagItf
  extends BagItf<BasicItem>
{
  public abstract ItemOperateResult addItem(BasicItem paramBasicItem);
  
  public abstract ItemOperateResult addItem(BasicItem paramBasicItem, boolean paramBoolean);
  
  public abstract ItemOperateResult removeItemsByItemId(int paramInt1, int paramInt2);
  
  public abstract ItemOperateResult removeItemByGrid(int paramInt1, int paramInt2);
  
  public abstract BasicItem getItemByUuid(long paramLong);
  
  public abstract Map<Integer, BasicItem> getItemBycfgId(int paramInt);
  
  public abstract int getItemNumberBycfgId(int paramInt);
  
  public abstract int getItemNumberByGrid(int paramInt);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemBagItf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */