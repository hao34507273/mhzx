/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class MatchObj implements Comparable<MatchObj>
/*    */ {
/*    */   private final List<Long> roles;
/*    */   private final int score;
/*    */   private final int times;
/*    */   
/*    */   MatchObj(List<Long> roles, int score, int times) {
/* 12 */     this.roles = roles;
/* 13 */     this.score = score;
/* 14 */     this.times = times;
/*    */   }
/*    */   
/*    */   public List<Long> getRoleList() {
/* 18 */     return this.roles;
/*    */   }
/*    */   
/*    */   public int getScore() {
/* 22 */     return this.score;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int compareTo(MatchObj other)
/*    */   {
/* 33 */     int ret = this.times - other.times;
/* 34 */     if (ret != 0) {
/* 35 */       return ret;
/*    */     }
/*    */     
/* 38 */     ret = other.score - this.score;
/* 39 */     if (ret != 0) {
/* 40 */       return ret;
/*    */     }
/*    */     
/* 43 */     ret = other.roles.size() - this.roles.size();
/* 44 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\MatchObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */