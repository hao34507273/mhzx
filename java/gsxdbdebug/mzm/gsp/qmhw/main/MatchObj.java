/*    */ package mzm.gsp.qmhw.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class MatchObj implements Comparable<MatchObj>
/*    */ {
/*    */   private final List<Long> roleids;
/*    */   public final int score;
/*    */   public final int times;
/*    */   
/*    */   public MatchObj(List<Long> roleids, int score, int times) {
/* 12 */     this.roleids = roleids;
/* 13 */     this.score = score;
/* 14 */     this.times = times;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleids() {
/* 18 */     return this.roleids;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int compareTo(MatchObj o)
/*    */   {
/* 28 */     int diffRoles = o.getRoleids().size() - this.roleids.size();
/* 29 */     if (diffRoles != 0) {
/* 30 */       return diffRoles;
/*    */     }
/* 32 */     int diffTime = this.times - o.times;
/* 33 */     if (diffTime != 0) {
/* 34 */       return diffTime;
/*    */     }
/* 36 */     return o.score - this.score;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\MatchObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */