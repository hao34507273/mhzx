/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.HomeOperate;
/*    */ 
/*    */ public class PGM_MoveFurnitureShop extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_MoveFurnitureShop(long gmRoleId, long roleid)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleid);
/* 23 */     if (xHomeOperate == null)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d 没有家具商店数据", new Object[] { Long.valueOf(this.roleid) }));
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if (!xHomeOperate.getCanbuyitems().isEmpty())
/*    */     {
/* 31 */       for (java.util.Iterator i$ = xHomeOperate.getCanbuyitems().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*    */         
/* 33 */         int num = 1;
/* 34 */         mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg s = mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg.get(itemId);
/* 35 */         if (s != null)
/*    */         {
/* 37 */           num = s.freshNum;
/*    */         }
/* 39 */         xHomeOperate.getCanbuyitem2num().put(Integer.valueOf(itemId), Integer.valueOf(num));
/*    */       }
/*    */       
/* 42 */       xHomeOperate.getCanbuyitems().clear();
/* 43 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d 家具商店数据恢复成功", new Object[] { Long.valueOf(this.roleid) }));
/* 44 */       return true;
/*    */     }
/* 46 */     if (!xHomeOperate.getCanbuyitem2num().isEmpty())
/*    */     {
/* 48 */       xHomeOperate.getCanbuyitems().addAll(xHomeOperate.getCanbuyitem2num().keySet());
/* 49 */       xHomeOperate.getCanbuyitem2num().clear();
/* 50 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("%d 家具商店数据已经移除", new Object[] { Long.valueOf(this.roleid) }));
/* 51 */       return true;
/*    */     }
/* 53 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PGM_MoveFurnitureShop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */