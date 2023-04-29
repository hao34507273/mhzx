/*    */ package mzm.gsp.task.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ 
/*    */ public class POnPvEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     PVEFightEndArg pveArg = (PVEFightEndArg)this.arg;
/* 10 */     return RoleTaskManager.updatePVEBattleWin(pveArg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\POnPvEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */