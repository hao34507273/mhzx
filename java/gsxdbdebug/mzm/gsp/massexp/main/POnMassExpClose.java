/*    */ package mzm.gsp.massexp.main;
/*    */ 
/*    */ import mzm.gsp.massexp.confbean.SMassExpCfgConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnMassExpClose extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public POnMassExpClose(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     if (MassExpManager.isFunOpen(this.roleid, false))
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     int graphid = SMassExpCfgConsts.getInstance().TASK_ICON_ID;
/* 25 */     if (TaskInterface.isHaveGraphId(this.roleid, graphid))
/*    */     {
/* 27 */       TaskInterface.closeActivityGraphWithoutEvent(this.roleid, graphid);
/*    */     }
/*    */     
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\main\POnMassExpClose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */