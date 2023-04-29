/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ 
/*    */ public class POnRoleLoginChangeModelCardBag
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/* 12 */     RoleItemBag newBag = ItemManager.getBag(roleId, 340600007);
/*    */     
/*    */ 
/* 15 */     if (newBag == null)
/*    */     {
/* 17 */       if (!ItemManager.createRoleItemBag(roleId, 340600007))
/*    */       {
/* 19 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 24 */     ItemManager.syncBagInfo(roleId, 340600007);
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginChangeModelCardBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */