/*    */ package mzm.gsp.fight.fighter.comparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MAGDEFComparator implements Comparator<Fighter>
/*    */ {
/*    */   private boolean fromLowToHigh;
/*    */   
/*    */   public MAGDEFComparator(boolean fromLowToHigh)
/*    */   {
/* 12 */     this.fromLowToHigh = fromLowToHigh;
/*    */   }
/*    */   
/*    */   public int compare(Fighter o1, Fighter o2)
/*    */   {
/* 17 */     if (this.fromLowToHigh) {
/* 18 */       return o1.getMAGDEF() - o2.getMAGDEF();
/*    */     }
/* 20 */     return o2.getMAGDEF() - o1.getMAGDEF();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\comparator\MAGDEFComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */