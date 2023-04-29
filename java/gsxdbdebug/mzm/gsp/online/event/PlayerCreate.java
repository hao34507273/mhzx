/*    */ package mzm.gsp.online.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class PlayerCreate extends mzm.event.BasicEvent<Long>
/*    */ {
/*  7 */   private static EventManager<Long> manager = new EventManager();
/*    */   
/*    */   public EventManager<Long> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.msdkprofile.main.POnPlayerCreate());
/* 16 */     manager.register(new mzm.gsp.grc.main.ROnPlayerCreate());
/* 17 */     manager.register(new mzm.gsp.activitycompensate.main.POnPlayerCreate());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\event\PlayerCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */