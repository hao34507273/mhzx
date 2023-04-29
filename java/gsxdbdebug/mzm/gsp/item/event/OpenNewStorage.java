/*    */ package mzm.gsp.item.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class OpenNewStorage extends mzm.event.BasicEvent<OpenNewStorageArg>
/*    */ {
/*  7 */   private static EventManager<OpenNewStorageArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<OpenNewStorageArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnOpenNewStorage());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\event\OpenNewStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */