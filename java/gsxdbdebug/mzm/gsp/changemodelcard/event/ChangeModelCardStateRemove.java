/*    */ package mzm.gsp.changemodelcard.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class ChangeModelCardStateRemove extends mzm.event.BasicEvent<ChangeModelCardStateArg>
/*    */ {
/*  7 */   private static EventManager<ChangeModelCardStateArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<ChangeModelCardStateArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.role.main.POnChangeModelCardStateRemove());
/* 16 */     manager.register(new mzm.gsp.map.main.POnChangeModelCardStateRemove());
/* 17 */     manager.register(new mzm.gsp.team.main.POnChangeModelCardStateRemove());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\event\ChangeModelCardStateRemove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */