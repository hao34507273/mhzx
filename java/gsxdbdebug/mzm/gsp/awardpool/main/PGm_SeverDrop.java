/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.awardpool.confbean.SItemPoolSub;
/*    */ import mzm.gsp.awardpool.confbean.SRandomTextTableCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGm_SeverDrop
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final int itemsubid;
/*    */   
/*    */   public PGm_SeverDrop(long gmRoleid, int itemsubid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.itemsubid = itemsubid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     int precoiusId = AwardPoolManager.getPreciousCfgId(this.itemsubid);
/* 25 */     if (precoiusId == -1)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d 错误，没有稀有掉落", new Object[] { Integer.valueOf(this.itemsubid) }));
/* 28 */       return false;
/*    */     }
/* 30 */     String itemName = "";
/* 31 */     SItemPoolSub sItemPoolSub = SItemPoolSub.get(this.itemsubid);
/* 32 */     if (sItemPoolSub != null)
/*    */     {
/* 34 */       itemName = ItemInterface.getItemName(sItemPoolSub.itemId);
/*    */     }
/*    */     else
/*    */     {
/* 38 */       SRandomTextTableCfg sRandomTextTableCfg = SRandomTextTableCfg.get(this.itemsubid);
/* 39 */       itemName = ItemInterface.getItemName(sRandomTextTableCfg.itemId);
/*    */     }
/* 41 */     ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(this.itemsubid);
/* 42 */     if (itemSubidObject != null)
/*    */     {
/*    */ 
/* 45 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d ：%s 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(itemSubidObject.getUnHitCount()), Integer.valueOf(itemSubidObject.getDropCount()), Integer.valueOf(itemSubidObject.getHistoryDropCount()), Integer.valueOf(precoiusId) }));
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/*    */ 
/* 54 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("物品子表%d ：%s 未命中次数 %d 已经掉落次数 %d、历史累计掉落次数%d、稀有配置Id %d", new Object[] { Integer.valueOf(this.itemsubid), itemName, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(precoiusId) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGm_SeverDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */