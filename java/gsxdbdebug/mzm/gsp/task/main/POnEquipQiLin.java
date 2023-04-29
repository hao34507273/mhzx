/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.item.event.EquipQiLinProcedure;
/*    */ import mzm.gsp.item.main.EquipQiLinArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnEquipQiLin
/*    */   extends EquipQiLinProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     TaskInterface.updateTaskCondition(((EquipQiLinArg)this.arg).roleid, 9, new Object());
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */