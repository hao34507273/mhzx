/*    */ package mzm.gsp.jiuxiao.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinJiuXiaoEvent extends mzm.event.BasicEvent<JoinJiuXiaoArg>
/*    */ {
/*  7 */   private static EventManager<JoinJiuXiaoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinJiuXiaoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnJoinJiuXiao());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\event\JoinJiuXiaoEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */