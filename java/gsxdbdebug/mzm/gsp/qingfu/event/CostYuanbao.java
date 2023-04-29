/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class CostYuanbao extends mzm.event.BasicEvent<CostYuanbaoArg>
/*    */ {
/*  7 */   private static EventManager<CostYuanbaoArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<CostYuanbaoArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.qingfu.main.ROnUserCostYuanbao());
/* 16 */     manager.register(new mzm.gsp.msdkprofile.main.POnUserCostYuanbao());
/* 17 */     manager.register(new mzm.gsp.achievement.main.POnUserCostYuanbao());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\CostYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */