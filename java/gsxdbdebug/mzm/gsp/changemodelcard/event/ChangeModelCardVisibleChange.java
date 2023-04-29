/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChangeModelCardVisibleChange extends mzm.event.BasicEvent<ChangeModelCardStateArg>
/*    */ {
/*  7 */   private static EventManager<ChangeModelCardStateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChangeModelCardStateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.map.main.POnChangeModelCardVisibleChange());
/* 16 */     manager.register(new mzm.gsp.team.main.POnChangeModelCardVisibleChange());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardVisibleChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */