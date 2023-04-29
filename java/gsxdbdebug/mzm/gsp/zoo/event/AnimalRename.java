/*    */ package mzm.gsp.zoo.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class AnimalRename extends mzm.event.BasicEvent<AnimalRenameArg>
/*    */ {
/*  7 */   private static EventManager<AnimalRenameArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<AnimalRenameArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.homeland.main.POnAnimalRename());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\event\AnimalRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */