/*   */ package mzm.gsp.task.surprise;
/*   */ 
/*   */ import mzm.gsp.map.event.PlayerPlayExpressionActionArg;
/*   */ 
/*   */ public class POnPlayExpressionAction extends mzm.gsp.map.event.PlayerPlayExpressionActionProcedure
/*   */ {
/*   */   protected boolean processImp() throws Exception
/*   */   {
/* 9 */     return new PFinishAction(((PlayerPlayExpressionActionArg)this.arg).roleid, ((PlayerPlayExpressionActionArg)this.arg).pos.getMapCfgid(), ((PlayerPlayExpressionActionArg)this.arg).pos.getX(), ((PlayerPlayExpressionActionArg)this.arg).pos.getY(), ((PlayerPlayExpressionActionArg)this.arg).action).call();
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\POnPlayExpressionAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */