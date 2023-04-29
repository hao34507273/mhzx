/*    */ package mzm.gsp.shitu.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BaiShi extends mzm.event.BasicEvent<BaiShiArg>
/*    */ {
/*  7 */   private static EventManager<BaiShiArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BaiShiArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.guide.main.POnBaiShi());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\event\BaiShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */