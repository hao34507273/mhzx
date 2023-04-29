/*    */ package mzm.gsp.fight.fighter.comparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class HpPercentRateComparator implements Comparator<Fighter>
/*    */ {
/*    */   private boolean fromLowToHigh;
/*    */   
/*    */   public HpPercentRateComparator(boolean fromLowToHigh)
/*    */   {
/* 12 */     this.fromLowToHigh = fromLowToHigh;
/*    */   }
/*    */   
/*    */   public int compare(Fighter o1, Fighter o2)
/*    */   {
/* 17 */     if (this.fromLowToHigh) {
/* 18 */       return (int)(o1.getCurHpRateValue() - o2.getCurHpRateValue());
/*    */     }
/* 20 */     return (int)(o2.getCurHpRateValue() - o1.getCurHpRateValue());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\comparator\HpPercentRateComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */