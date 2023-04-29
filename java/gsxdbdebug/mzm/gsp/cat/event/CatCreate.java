/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CatCreate extends mzm.event.BasicEvent<CatCreateArg>
/*    */ {
/*  7 */   private static EventManager<CatCreateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CatCreateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.PRestoreCatIntoYardOnCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\CatCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */