/*    */ package mzm.gsp.fight.fighter.comparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class PHYDEFComparator implements Comparator<Fighter>
/*    */ {
/*    */   private boolean fromLowToHigh;
/*    */   
/*    */   public PHYDEFComparator(boolean fromLowToHigh)
/*    */   {
/* 12 */     this.fromLowToHigh = fromLowToHigh;
/*    */   }
/*    */   
/*    */   public int compare(Fighter o1, Fighter o2)
/*    */   {
/* 17 */     if (this.fromLowToHigh) {
/* 18 */       return o1.getPHYDEF() - o2.getPHYDEF();
/*    */     }
/* 20 */     return o2.getPHYDEF() - o1.getPHYDEF();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\comparator\PHYDEFComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */