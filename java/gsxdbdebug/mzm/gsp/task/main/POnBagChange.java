/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.item.event.PlayerBagChangeProcedure;
/*    */ import mzm.gsp.item.main.ItemEventArg;
/*    */ 
/*    */ 
/*    */ public class POnBagChange
/*    */   extends PlayerBagChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     long roleId = ((ItemEventArg)this.arg).roleid;
/* 14 */     int bagId = ((ItemEventArg)this.arg).bagid;
/* 15 */     if (bagId == 340600000)
/*    */     {
/* 17 */       TaskInterface.updateTaskCondition(roleId, 9, new Object());
/*    */     }
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnBagChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */