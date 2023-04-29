/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCloseTeamMembersGraph
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int graphId;
/*    */   
/*    */   public PCloseTeamMembersGraph(long roleId, int graphId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.graphId = graphId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     List<Long> roleIds = new ArrayList();
/* 30 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 31 */     if (teamInfo == null) {
/* 32 */       roleIds.add(Long.valueOf(this.roleId));
/*    */     } else {
/* 34 */       roleIds.addAll(teamInfo.getTeamNormalList());
/*    */     }
/* 36 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long eachRoleId = ((Long)i$.next()).longValue();
/* 37 */       new PCloseGraph(eachRoleId, this.graphId).execute();
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PCloseTeamMembersGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */