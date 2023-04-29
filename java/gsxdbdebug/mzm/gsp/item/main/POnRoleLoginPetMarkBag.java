/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLoginPetMarkBag
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 13 */     if (null == ItemManager.getBag(roleId, 340600009))
/*    */     {
/* 15 */       if (!ItemManager.createRoleItemBag(roleId, 340600009))
/*    */       {
/* 17 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 22 */     ItemManager.syncBagInfo(roleId, 340600009);
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginPetMarkBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */