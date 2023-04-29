/*    */ package mzm.gsp.fight.fighter.comparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MpPercentRateComparator implements Comparator<Fighter>
/*    */ {
/*    */   private boolean fromLowToHigh;
/*    */   
/*    */   public MpPercentRateComparator(boolean fromLowToHigh)
/*    */   {
/* 12 */     this.fromLowToHigh = fromLowToHigh;
/*    */   }
/*    */   
/*    */   public int compare(Fighter o1, Fighter o2)
/*    */   {
/* 17 */     if (this.fromLowToHigh) {
/* 18 */       return (int)(o1.getCurMpRateValue() - o2.getCurMpRateValue());
/*    */     }
/* 20 */     return (int)(o2.getCurMpRateValue() - o1.getCurMpRateValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\comparator\MpPercentRateComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */