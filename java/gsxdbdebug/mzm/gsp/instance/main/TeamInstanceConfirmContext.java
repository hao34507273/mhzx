/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ public class TeamInstanceConfirmContext
/*    */   implements TeamConfirmContext
/*    */ {
/*    */   private final int instanceCfgid;
/*    */   private final int leaderProcess;
/*    */   private final List<Long> roleids;
/*    */   
/*    */   public TeamInstanceConfirmContext(int instanceCfgid, int leaderProcess, List<Long> roleids)
/*    */   {
/* 15 */     this.instanceCfgid = instanceCfgid;
/* 16 */     this.leaderProcess = leaderProcess;
/* 17 */     this.roleids = roleids;
/*    */   }
/*    */   
/*    */   public int getInstanceCfgid()
/*    */   {
/* 22 */     return this.instanceCfgid;
/*    */   }
/*    */   
/*    */   public int getLeaderProcess()
/*    */   {
/* 27 */     return this.leaderProcess;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleids()
/*    */   {
/* 32 */     return this.roleids;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */