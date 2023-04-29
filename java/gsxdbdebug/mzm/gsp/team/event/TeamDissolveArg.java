/*    */ package mzm.gsp.team.event;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamDissolveArg
/*    */ {
/*    */   public final long teamid;
/*    */   public final List<Long> members;
/*    */   
/*    */   public TeamDissolveArg(long teamid, List<Long> members)
/*    */   {
/* 16 */     this.teamid = teamid;
/* 17 */     this.members = members;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getLeader()
/*    */   {
/* 25 */     if (this.members.size() >= 1) {
/* 26 */       return ((Long)this.members.get(0)).longValue();
/*    */     }
/* 28 */     return -1L;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\event\TeamDissolveArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */