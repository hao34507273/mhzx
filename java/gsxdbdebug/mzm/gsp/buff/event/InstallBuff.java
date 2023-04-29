/*    */ package mzm.gsp.buff.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class InstallBuff extends mzm.event.BasicEvent<InstallBuffArg>
/*    */ {
/*  7 */   private static EventManager<InstallBuffArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<InstallBuffArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.buff.main.POnInstallBuff());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\event\InstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */