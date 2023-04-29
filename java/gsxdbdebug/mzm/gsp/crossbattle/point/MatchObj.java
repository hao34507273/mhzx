/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MatchObj implements Comparable<MatchObj>
/*    */ {
/*    */   public final long corpsid;
/* 11 */   public final List<Long> roleids = new ArrayList();
/*    */   
/*    */   public final int fight;
/* 14 */   public final Map<Long, Integer> corpsFightInfos = new HashMap();
/*    */   
/*    */   public MatchObj(long corpsid, List<Long> roleids, int fight)
/*    */   {
/* 18 */     this.corpsid = corpsid;
/* 19 */     if (roleids != null)
/*    */     {
/* 21 */       this.roleids.addAll(roleids);
/*    */     }
/* 23 */     this.fight = fight;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(MatchObj o)
/*    */   {
/* 29 */     return this.fight - o.fight;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\MatchObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */