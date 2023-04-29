/*    */ package mzm.gsp.shanggong.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ShangGongSuccess extends mzm.event.BasicEvent<ShangGongSuccessArg>
/*    */ {
/*  7 */   private static EventManager<ShangGongSuccessArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ShangGongSuccessArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.children.guanyin.POnShangGongSuccess());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\event\ShangGongSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */