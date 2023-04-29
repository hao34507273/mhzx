/*    */ package mzm.gsp.teamplatform.matchcomparator;
/*    */ 
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ public class MemberComparator implements java.util.Comparator<Long>
/*    */ {
/*    */   private xbean.MatchQueue xMatchQueue;
/*    */   
/*    */   public MemberComparator(xbean.MatchQueue xMatchQueue) {
/* 10 */     this.xMatchQueue = xMatchQueue;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compare(Long o1, Long o2)
/*    */   {
/* 16 */     long r1 = o1.longValue();
/* 17 */     long r2 = o2.longValue();
/* 18 */     MatchActivityCfg c1 = (MatchActivityCfg)this.xMatchQueue.getRoleinfo().get(Long.valueOf(r1));
/* 19 */     MatchActivityCfg c2 = (MatchActivityCfg)this.xMatchQueue.getRoleinfo().get(Long.valueOf(r2));
/*    */     
/* 21 */     return (int)(c1.getStarttime() - c2.getStarttime());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\matchcomparator\MemberComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */