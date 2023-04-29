/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ public class TeamStableStateChangeArg
/*    */ {
/*    */   private long teamId;
/*    */   private List<Long> members;
/*    */   private boolean install;
/*    */   
/*    */   public TeamStableStateChangeArg()
/*    */   {
/* 15 */     this.members = new ArrayList();
/*    */   }
/*    */   
/*    */   public long getTeamId()
/*    */   {
/* 20 */     return this.teamId;
/*    */   }
/*    */   
/*    */   public void setTeamId(long teamId)
/*    */   {
/* 25 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */   public List<Long> getMembers()
/*    */   {
/* 30 */     return this.members;
/*    */   }
/*    */   
/*    */   public boolean isInstall()
/*    */   {
/* 35 */     return this.install;
/*    */   }
/*    */   
/*    */   public void setInstall(boolean install)
/*    */   {
/* 40 */     this.install = install;
/*    */   }
/*    */   
/*    */   public void setMembers(List<Long> members)
/*    */   {
/* 45 */     this.members = members;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamStableStateChangeArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */