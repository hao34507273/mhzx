/*    */ package mzm.gsp.teamplatform.matchcomparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.teamplatform.memberbean.RoleMatchMember;
/*    */ 
/*    */ public class RoleTimeComparator implements Comparator<RoleMatchMember>
/*    */ {
/*    */   private final int occupation;
/*    */   
/*    */   public RoleTimeComparator(int occupation)
/*    */   {
/* 13 */     this.occupation = occupation;
/*    */   }
/*    */   
/*    */   public int compare(RoleMatchMember o1, RoleMatchMember o2) {
/* 17 */     if (o1.hashCode() == o2.hashCode()) {
/* 18 */       return 0;
/*    */     }
/*    */     
/* 21 */     int op1 = RoleInterface.getOccupationId(o1.getRoleId());
/* 22 */     int op2 = RoleInterface.getOccupationId(o2.getRoleId());
/*    */     
/* 24 */     if (this.occupation != 0) {
/* 25 */       if ((op1 == this.occupation) && (op2 != this.occupation)) {
/* 26 */         return -1;
/*    */       }
/*    */       
/* 29 */       if ((op1 != this.occupation) && (op2 == this.occupation)) {
/* 30 */         return 1;
/*    */       }
/*    */     }
/*    */     
/* 34 */     long sg = o1.getStartTime() - o2.getStartTime();
/* 35 */     int ret = sg >= 0L ? 1 : -1;
/* 36 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\matchcomparator\RoleTimeComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */