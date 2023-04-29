/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChangeMemberTempStatus
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long teamId;
/*    */   private final int tempStatus;
/*    */   
/*    */   public ChangeMemberTempStatus(long roleId, long teamId, int tempStatus)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.teamId = teamId;
/* 22 */     this.tempStatus = tempStatus;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     Long teamidNow = Role2team.get(Long.valueOf(this.roleId));
/* 29 */     if (teamidNow == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     if (teamidNow.longValue() != this.teamId)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(this.teamId));
/* 39 */     if (xTeam == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     return TeamManager.changeMemberTempStatus(this.teamId, xTeam, this.roleId, this.tempStatus);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ChangeMemberTempStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */