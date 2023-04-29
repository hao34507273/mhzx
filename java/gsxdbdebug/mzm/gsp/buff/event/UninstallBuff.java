/*    */ package mzm.gsp.buff.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class UninstallBuff extends mzm.event.BasicEvent<UninstallBuffArg>
/*    */ {
/*  7 */   private static EventManager<UninstallBuffArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<UninstallBuffArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.buff.main.POnUninstallBuff());
/* 16 */     manager.register(new mzm.gsp.singlebattle.buff.POnUninstallBuff());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\event\UninstallBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */