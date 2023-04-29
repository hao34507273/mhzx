/*    */ package mzm.gsp.cat.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CatRename extends mzm.event.BasicEvent<CatRenameArg>
/*    */ {
/*  7 */   private static EventManager<CatRenameArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CatRenameArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnCatRename());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\event\CatRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */