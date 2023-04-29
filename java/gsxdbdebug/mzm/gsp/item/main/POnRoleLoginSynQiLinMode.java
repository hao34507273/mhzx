/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import xbean.EquipMode;
/*    */ 
/*    */ public class POnRoleLoginSynQiLinMode
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     EquipMode xEquipMode = ItemManager.getXEquipMode(((Long)this.arg).longValue());
/*    */     
/* 15 */     if (OpenInterface.getOpenStatus(235))
/*    */     {
/* 17 */       if (!xEquipMode.getIsset())
/*    */       {
/* 19 */         xEquipMode.setIsset(true);
/* 20 */         xEquipMode.setMode(1);
/*    */       }
/*    */     }
/* 23 */     ItemManager.sendSSynEquipQilinModeRes(((Long)this.arg).longValue(), xEquipMode.getMode());
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginSynQiLinMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */