/*    */ package mzm.gsp.cake.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class FactionSceneCreate extends mzm.event.BasicEvent<FactionSceneCreateArg>
/*    */ {
/*  7 */   private static EventManager<FactionSceneCreateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<FactionSceneCreateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.cake.main.POnFactionSceneCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\event\FactionSceneCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */