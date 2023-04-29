/*    */ package mzm.gsp.teamplatform.matchcomparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.teamplatform.memberbean.RoleMatchMember;
/*    */ 
/*    */ public class RoleComparator
/*    */   implements Comparator<RoleMatchMember>
/*    */ {
/*    */   public int compare(RoleMatchMember o1, RoleMatchMember o2)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\matchcomparator\RoleComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */