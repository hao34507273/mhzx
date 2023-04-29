/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckNewEnough
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public CheckNewEnough(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 27 */     if (teamInfo == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     MJoinTeamOnNewGuy.getInstance().afterJoinTeam(this.roleId, teamInfo);
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\CheckNewEnough.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */