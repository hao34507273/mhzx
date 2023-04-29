/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import mzm.gsp.task.main.GraphFinishArg;
/*    */ 
/*    */ public class POnGraphFinish extends mzm.gsp.task.event.GraphFinishProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     if (((GraphFinishArg)this.arg).graphId != mzm.gsp.circletask.confbean.CircleTaskConsts.getInstance().TASK_GRAPHIC_ID) {
/* 10 */       return false;
/*    */     }
/* 12 */     xbean.CircleTask xCircleTask = xtable.Role2circletask.get(Long.valueOf(((GraphFinishArg)this.arg).roleId));
/* 13 */     xCircleTask.setLegendendtime(0L);
/* 14 */     xCircleTask.setRenxingcounter(0);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\POnGraphFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */