/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_AddBaotu
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleid;
/*    */   private final int itemid;
/*    */   private final int mapid;
/*    */   private final int x;
/*    */   private final int y;
/*    */   
/*    */   public PGM_AddBaotu(long gmRoleId, long roleid, int itemid, int mapid, int x, int y)
/*    */   {
/* 30 */     this.gmRoleId = gmRoleId;
/* 31 */     this.roleid = roleid;
/* 32 */     this.itemid = itemid;
/* 33 */     this.mapid = mapid;
/* 34 */     this.x = x;
/* 35 */     this.y = y;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 41 */     if (SItemCangBaoTuCfg.get(this.itemid) != null)
/*    */     {
/* 43 */       List<Item> xItems = ItemManager.createXItem(this.itemid, 1);
/* 44 */       if ((xItems == null) || (xItems.isEmpty()))
/*    */       {
/* 46 */         return false;
/*    */       }
/* 48 */       BaoTuItem baoTuItem = (BaoTuItem)ItemManager.getBasicItem((Item)xItems.get(0));
/*    */       
/* 50 */       baoTuItem.setExtra(ItemStoreEnum.BAO_TU_X, this.x * 16);
/* 51 */       baoTuItem.setExtra(ItemStoreEnum.BAO_TU_Y, this.y * 16);
/* 52 */       baoTuItem.setExtra(ItemStoreEnum.BAO_TU_MAP_ID, this.mapid);
/*    */       
/* 54 */       TLogArg logArg = new TLogArg(LogReason.GM_ADD);
/* 55 */       ItemOperateResult result = ItemInterface.addItemActive(this.roleid, Arrays.asList(new Item[] { baoTuItem.getItem() }), false, true, logArg);
/* 56 */       if (result.success())
/*    */       {
/* 58 */         GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d增加宝图%d成功", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemid) }));
/* 59 */         return true;
/*    */       }
/* 61 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 65 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d不是宝图，增加失败", new Object[] { Integer.valueOf(this.itemid) }));
/*    */     
/*    */ 
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_AddBaotu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */