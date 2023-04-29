/*    */ package mzm.gsp.drawandguess.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.timer.main.Session;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class DrawAndGuessApplyJoinSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final List<Long> teamMembers;
/*    */   private List<Long> unsuerMembers;
/*    */   
/*    */   public DrawAndGuessApplyJoinSession(long interval, long roleId, int activityCfgid, List<Long> teamMembers)
/*    */   {
/* 35 */     super(interval, roleId);
/* 36 */     this.activityCfgid = activityCfgid;
/* 37 */     this.teamMembers = Collections.unmodifiableList(teamMembers);
/* 38 */     this.unsuerMembers = new ArrayList(teamMembers);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public int getActivityCfgid()
/*    */   {
/* 49 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public List<Long> getTeamMembers()
/*    */   {
/* 54 */     return this.teamMembers;
/*    */   }
/*    */   
/*    */   public List<Long> getUnsuerMembers()
/*    */   {
/* 59 */     return this.unsuerMembers;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void agree(Long membersId)
/*    */   {
/* 70 */     this.unsuerMembers.remove(membersId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\DrawAndGuessApplyJoinSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */