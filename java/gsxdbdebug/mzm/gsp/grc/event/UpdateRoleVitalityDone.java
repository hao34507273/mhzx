/*    */ package mzm.gsp.grc.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UpdateRoleVitalityDone extends mzm.event.BasicEvent<UpdateRoleVitalityDoneArg>
/*    */ {
/*  7 */   private static EventManager<UpdateRoleVitalityDoneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UpdateRoleVitalityDoneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.grc.main.POnUpdateRoleVitalityDone());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\event\UpdateRoleVitalityDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */