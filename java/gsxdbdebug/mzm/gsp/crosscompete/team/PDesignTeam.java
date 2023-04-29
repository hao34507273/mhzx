/*    */ package mzm.gsp.crosscompete.team;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PDesignTeam extends LogicProcedure
/*    */ {
/*    */   private final List<Long> roleids;
/*    */   
/*    */   public PDesignTeam(List<Long> roleids)
/*    */   {
/* 14 */     this.roleids = roleids;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (this.roleids.isEmpty()) {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     long leaderid = ((Long)this.roleids.get(0)).longValue();
/* 24 */     Long teamid = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 25 */     if (teamid == null) {
/* 26 */       CrossCompeteManager.logError("PDesignTeam.processImp@teamid is null|roleids=%s", new Object[] { this.roleids });
/*    */       
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     TeamInterface.designTeam(teamid.longValue(), this.roleids);
/*    */     
/* 33 */     CrossCompeteManager.logInfo("PDesignTeam.proccessImp@design team|teamid=%d|roleids=%s", new Object[] { Long.valueOf(teamid.longValue()), this.roleids });
/*    */     
/*    */ 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\team\PDesignTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */