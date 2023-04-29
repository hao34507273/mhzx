/*    */ package mzm.gsp.teamplatform.matchcomparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.teamplatform.memberbean.TeamMatchMember;
/*    */ 
/*    */ public class TeamTimeComparator
/*    */   implements Comparator<TeamMatchMember>
/*    */ {
/*    */   public int compare(TeamMatchMember o1, TeamMatchMember o2)
/*    */   {
/* 11 */     if (o1.hashCode() == o2.hashCode()) {
/* 12 */       return 0;
/*    */     }
/* 14 */     long sg = o1.getStartTime() - o2.getStartTime();
/* 15 */     int ret = sg >= 0L ? 1 : -1;
/* 16 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\matchcomparator\TeamTimeComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */