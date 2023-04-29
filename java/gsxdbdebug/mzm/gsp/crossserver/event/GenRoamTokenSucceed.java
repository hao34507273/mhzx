/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GenRoamTokenSucceed extends mzm.event.BasicEvent<GenRoamTokenSucceedArg>
/*    */ {
/*  7 */   private static EventManager<GenRoamTokenSucceedArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GenRoamTokenSucceedArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.POnGenRoamTokenSucceed());
/* 16 */     manager.register(new mzm.gsp.crosscompete.main.POnGenRoamTokenSucceed());
/* 17 */     manager.register(new mzm.gsp.crossbattle.point.POnGenRoamTokenSucceed());
/* 18 */     manager.register(new mzm.gsp.crossbattle.knockout.POnGenRoamTokenSucceed());
/* 19 */     manager.register(new mzm.gsp.crossfield.main.POnGenRoamTokenSucceed());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GenRoamTokenSucceed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */