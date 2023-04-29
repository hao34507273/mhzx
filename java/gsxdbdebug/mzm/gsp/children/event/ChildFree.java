/*    */ package mzm.gsp.children.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChildFree extends mzm.event.BasicEvent<ChildFreeArg>
/*    */ {
/*  7 */   private static EventManager<ChildFreeArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChildFreeArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.fight.main.POnChildFree());
/* 16 */     manager.register(new mzm.gsp.achievement.main.POnChildFree());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\event\ChildFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */