/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class GuideTaskHand
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   private final int taskId;
/*    */   private final int state;
/*    */   private final boolean isEnd;
/*    */   
/*    */   public GuideTaskHand(long roleId, int graphId, int taskId, int state, boolean isEnd)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.graphId = graphId;
/* 24 */     this.taskId = taskId;
/* 25 */     this.state = state;
/* 26 */     this.isEnd = isEnd;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!this.isEnd)
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (this.state != 8)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 43 */     String userid = RoleInterface.getUserId(this.roleId);
/* 44 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 46 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*    */     
/* 48 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleId, this.graphId);
/* 49 */     TaskInterface.activeGraph(Long.valueOf(this.roleId), this.graphId);
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\GuideTaskHand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */