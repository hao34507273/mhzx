/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ 
/*    */ public class InitGoldStatueWatchDog
/*    */   extends MilliObserver
/*    */ {
/*    */   public InitGoldStatueWatchDog()
/*    */   {
/* 10 */     super(60000L);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 16 */     GoldStatueManager.getInstance().onInitGoldStatueTimeout();
/*    */     
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\InitGoldStatueWatchDog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */