/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GangBingingQQ extends mzm.event.BasicEvent<GangBingingQQArg>
/*    */ {
/*  7 */   private static EventManager<GangBingingQQArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GangBingingQQArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.gang.main.POnGangBingingQQ());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnGangBingingQQ());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\GangBingingQQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */