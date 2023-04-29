/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CorpsFightValueChartObj
/*    */   implements Comparable<CorpsFightValueChartObj>
/*    */ {
/*    */   private final long cropsid;
/*    */   
/*    */ 
/*    */   private final int fight;
/*    */   
/*    */ 
/*    */   public CorpsFightValueChartObj(long cropsid, int fight)
/*    */   {
/* 16 */     this.cropsid = cropsid;
/* 17 */     this.fight = fight;
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(CorpsFightValueChartObj o)
/*    */   {
/* 23 */     if (this.fight != o.fight)
/*    */     {
/* 25 */       return o.fight - this.fight;
/*    */     }
/* 27 */     return (int)(this.cropsid - o.cropsid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\CorpsFightValueChartObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */