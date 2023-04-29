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
/*    */ public class GangTeamDissolvedArg
/*    */ {
/*    */   public final long gangid;
/*    */   public final long gangTeamid;
/* 16 */   public final List<Long> members = new ArrayList();
/*    */   
/*    */   public GangTeamDissolvedArg(long gangid, long gangTeamid, Collection<Long> members) {
/* 19 */     this.gangid = gangid;
/* 20 */     this.gangTeamid = gangTeamid;
/* 21 */     this.members.addAll(members);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangTeamDissolvedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */