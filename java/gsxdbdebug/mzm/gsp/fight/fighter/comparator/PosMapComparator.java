/*    */ package mzm.gsp.fight.fighter.comparator;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ public class PosMapComparator
/*    */   implements Comparator<Fighter>
/*    */ {
/*    */   private Map<Integer, Integer> sortMap;
/*    */   
/*    */   public PosMapComparator(Map<Integer, Integer> sortMap)
/*    */   {
/* 15 */     this.sortMap = sortMap;
/*    */   }
/*    */   
/*    */   public int compare(Fighter o1, Fighter o2)
/*    */   {
/* 20 */     int order1 = ((Integer)this.sortMap.get(Integer.valueOf(o1.getPos()))).intValue();
/* 21 */     int order2 = ((Integer)this.sortMap.get(Integer.valueOf(o2.getPos()))).intValue();
/*    */     
/*    */ 
/* 24 */     return order1 - order2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\fighter\comparator\PosMapComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */