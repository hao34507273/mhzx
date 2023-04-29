/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*    */ import mzm.gsp.cat.confbean.SHomelandCatCfg;
/*    */ import mzm.gsp.item.confbean.SCatItemCfg;
/*    */ import xbean.Item;
/*    */ 
/*    */ public class CatItem extends BasicItem
/*    */ {
/*    */   public CatItem(Item xItem)
/*    */   {
/* 12 */     super(xItem);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean onCreateItem()
/*    */   {
/* 21 */     SCatItemCfg catItemCfg = SCatItemCfg.get(getCfgId());
/* 22 */     if (catItemCfg == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     SHomelandCatCfg homelandCatCfg = SHomelandCatCfg.get(catItemCfg.homelandCatCfgid);
/* 27 */     setLevel(homelandCatCfg.level);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public void setLevel(int level)
/*    */   {
/* 33 */     setExtra(ItemStoreEnum.CAT_LEVEL, level);
/*    */   }
/*    */   
/*    */   public Integer getLevel()
/*    */   {
/* 38 */     return getExtra(ItemStoreEnum.CAT_LEVEL);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean canSell(long roleid)
/*    */   {
/* 44 */     if (getLevel().intValue() >= SCatCfgConsts.getInstance().CAT_ITEM_SELL_LEVEL)
/*    */     {
/* 46 */       ItemManager.sendWrongInfo(roleid, 1155, new String[0]);
/* 47 */       return false;
/*    */     }
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\CatItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */