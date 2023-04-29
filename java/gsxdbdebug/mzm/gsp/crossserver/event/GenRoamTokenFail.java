/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class GenRoamTokenFail extends mzm.event.BasicEvent<GenRoamTokenFailArg>
/*    */ {
/*  7 */   private static EventManager<GenRoamTokenFailArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<GenRoamTokenFailArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.ladder.main.GenRoamTokenFail());
/* 16 */     manager.register(new mzm.gsp.crosscompete.main.POnGenRoamTokenFail());
/* 17 */     manager.register(new mzm.gsp.crossbattle.point.POnGenRoamTokenFail());
/* 18 */     manager.register(new mzm.gsp.crossbattle.knockout.POnGenRoamTokenFail());
/* 19 */     manager.register(new mzm.gsp.crossfield.main.POnGenRoamTokenFail());
/* 20 */     manager.register(new mzm.gsp.crossserver.main.POnGenRoamTokenFail());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\GenRoamTokenFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */