/*    */ package mzm.gsp.confirm.main;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xtable.Role2teamconf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamConfirmInterface
/*    */ {
/*    */   public static void startTeamConfirm(long teamId, int confirmType, TeamConfirmContext context)
/*    */   {
/* 22 */     ConfirmManager.startTeamConfirm(teamId, confirmType, context);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void registerConfirmHandler(int confirmType, TeamConfirmHandler handler)
/*    */   {
/* 37 */     ConfirmManager.registerConfirmHandler(confirmType, handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean inConfirmIng(long teamId)
/*    */   {
/* 52 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId, false);
/* 53 */     if (teamInfo == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     return Role2teamconf.selectSessionid(Long.valueOf(teamInfo.getLeaderId())) != null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\main\TeamConfirmInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */