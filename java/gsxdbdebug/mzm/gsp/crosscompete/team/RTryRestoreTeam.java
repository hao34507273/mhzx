/*    */ package mzm.gsp.crosscompete.team;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RTryRestoreTeam extends LogicRunnable
/*    */ {
/*    */   private final long loginRoleid;
/*    */   private final List<Long> memberList;
/*    */   
/*    */   public RTryRestoreTeam(long loginRoleid, List<Long> memberList)
/*    */   {
/* 15 */     this.loginRoleid = loginRoleid;
/* 16 */     this.memberList = memberList;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 21 */     long srcLeaderid = ((Long)this.memberList.get(0)).longValue();
/*    */     
/* 23 */     Long teamid = TeamInterface.getTeamidByRoleid(this.loginRoleid, false);
/*    */     
/* 25 */     if (teamid == null) {
/* 26 */       if (this.loginRoleid != srcLeaderid) {
/* 27 */         this.memberList.remove(Long.valueOf(this.loginRoleid));
/* 28 */         this.memberList.add(0, Long.valueOf(this.loginRoleid));
/*    */       }
/* 30 */       TeamInterface.formatCreateTeamAsTmpLeave(srcLeaderid, this.memberList);
/*    */       
/*    */ 
/* 33 */       teamid = TeamInterface.getTeamidByRoleid(this.loginRoleid, false);
/* 34 */       if (teamid == null) {
/* 35 */         CrossCompeteManager.logError("RTryRestoreTeam.tryRestoreTeam@try format team failed|login_roleid=%d|src_leaderid=%d|members=%s", new Object[] { Long.valueOf(this.loginRoleid), Long.valueOf(srcLeaderid), this.memberList });
/*    */         
/*    */ 
/* 38 */         return;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 43 */     new PReturnTeam(this.loginRoleid).call();
/*    */     
/*    */ 
/* 46 */     if (srcLeaderid == this.loginRoleid) {
/* 47 */       new PAppointLeader(teamid.longValue(), this.loginRoleid).call();
/*    */     }
/*    */     
/* 50 */     CrossCompeteManager.logInfo("RTryRestoreTeam.tryRestoreTeam@try format team|login_roleid=%d|src_leaderid=%d|members=%s", new Object[] { Long.valueOf(this.loginRoleid), Long.valueOf(srcLeaderid), this.memberList });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\team\RTryRestoreTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */