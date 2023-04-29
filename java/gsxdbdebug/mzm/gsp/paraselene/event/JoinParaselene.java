/*    */ package mzm.gsp.paraselene.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class JoinParaselene extends mzm.event.BasicEvent<JoinParaseleneArg>
/*    */ {
/*  7 */   private static EventManager<JoinParaseleneArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<JoinParaseleneArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.achievement.main.POnJoinParaselence());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\event\JoinParaselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */