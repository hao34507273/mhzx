/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoinGangTeamArg
/*    */ {
/*    */   public final long gangid;
/*    */   public final long newMemberid;
/*    */   public final long gangTeamid;
/* 17 */   public final List<Long> members = new ArrayList();
/*    */   
/*    */   public JoinGangTeamArg(long gangid, long newMemberid, long gangTeamid, Collection<Long> members) {
/* 20 */     this.gangid = gangid;
/* 21 */     this.newMemberid = newMemberid;
/* 22 */     this.gangTeamid = gangTeamid;
/* 23 */     this.members.addAll(members);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\JoinGangTeamArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */