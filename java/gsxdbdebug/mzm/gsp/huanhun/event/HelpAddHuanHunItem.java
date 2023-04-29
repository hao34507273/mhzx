/*    */ package mzm.gsp.huanhun.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class HelpAddHuanHunItem extends mzm.event.BasicEvent<HelpAddHuanHunItemArg>
/*    */ {
/*  7 */   private static EventManager<HelpAddHuanHunItemArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<HelpAddHuanHunItemArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnHelpAddHuanHunItem());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\event\HelpAddHuanHunItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */