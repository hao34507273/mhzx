/*    */ package mzm.gsp.teamplatform.matchcomparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.teamplatform.memberbean.TeamMatchMember;
/*    */ 
/*    */ public class TeamComparator
/*    */   implements Comparator<TeamMatchMember>
/*    */ {
/*    */   public int compare(TeamMatchMember o1, TeamMatchMember o2)
/*    */   {
/* 11 */     if (o1.hashCode() == o2.hashCode()) {
/* 12 */       return 0;
/*    */     }
/* 14 */     int sg = o1.getLevel() - o2.getLevel();
/* 15 */     int ret = sg > 0 ? 1 : -1;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 22 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\matchcomparator\TeamComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */