/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CatRecoveryToItem extends mzm.event.BasicEvent<CatRecoveryToItemArg>
/*    */ {
/*  7 */   private static EventManager<CatRecoveryToItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CatRecoveryToItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnCatRecycle());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\CatRecoveryToItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */