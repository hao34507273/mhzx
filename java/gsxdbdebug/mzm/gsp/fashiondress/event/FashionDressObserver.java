/*    */ package mzm.gsp.fashiondress.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FashionDressObserver extends mzm.event.BasicEvent<FashionDressObserverArg>
/*    */ {
/*  7 */   private static EventManager<FashionDressObserverArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FashionDressObserverArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fashiondress.main.POnFashionDressObserver());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\event\FashionDressObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */