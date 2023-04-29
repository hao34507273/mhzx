/*    */ package mzm.gsp.gangrace.main.game;
/*    */ 
/*    */ import java.util.TreeMap;
/*    */ 
/*    */ public class RaceBase
/*    */ {
/*  7 */   private static java.util.Random rand = new java.util.Random();
/*  8 */   private int maxRandValue = 0;
/*  9 */   private TreeMap<Integer, RaceBaseAction> actions = new TreeMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public RaceBaseAction getNextAction()
/*    */   {
/* 15 */     return (RaceBaseAction)this.actions.higherEntry(Integer.valueOf(rand.nextInt(this.maxRandValue))).getValue();
/*    */   }
/*    */   
/*    */   public void addAction(int _randValue, RaceBaseAction _action) {
/* 19 */     this.maxRandValue += _randValue;
/* 20 */     this.actions.put(Integer.valueOf(this.maxRandValue), _action);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */