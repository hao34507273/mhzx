/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRolesJoinTeam
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final List<Long> roleList;
/*    */   private final long teamId;
/*    */   
/*    */   public PRolesJoinTeam(List<Long> roleList, long teamId)
/*    */   {
/* 22 */     this.roleList = roleList;
/* 23 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 31 */       if (TeamInterface.getTeamMemberCount(this.teamId, false) >= TeamConsts.getInstance().TEAM_CAPACITY) {
/*    */         break;
/*    */       }
/*    */       
/*    */ 
/* 36 */       PJoinTeam pJoinTeam = new PJoinTeam(roleId, this.teamId);
/* 37 */       pJoinTeam.call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRolesJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */