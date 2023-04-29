/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLoginTreasureBag
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 11 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 13 */     RoleItemBag newBag = ItemManager.getBag(roleId, 340600008);
/*    */     
/*    */ 
/* 16 */     if (newBag == null)
/*    */     {
/*    */ 
/* 19 */       if (!ItemManager.createRoleItemBag(roleId, 340600008))
/*    */       {
/* 21 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 26 */     ItemManager.syncBagInfo(roleId, 340600008);
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginTreasureBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */