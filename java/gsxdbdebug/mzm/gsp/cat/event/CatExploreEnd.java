/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CatExploreEnd extends mzm.event.BasicEvent<CatExploreEndArg>
/*    */ {
/*  7 */   private static EventManager<CatExploreEndArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CatExploreEndArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.PRestoreCatIntoYardOnExploreEnd());
/* 16 */     manager.register(new mzm.gsp.achievement.main.PRestoreCatIntoYardOnExploreEnd());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\CatExploreEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */