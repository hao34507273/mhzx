/*    */ package mzm.gsp.gangrace.event;
/*    */ 
/*    */ import java.util.Collection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GangRaceEndArg
/*    */ {
/*    */   public final long winnerRoleId;
/*    */   public final Collection<Long> voteRoleIds;
/*    */   
/*    */   public GangRaceEndArg(long winnerRoleId, Collection<Long> voteRoleIds)
/*    */   {
/* 20 */     this.winnerRoleId = winnerRoleId;
/* 21 */     this.voteRoleIds = voteRoleIds;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\event\GangRaceEndArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */