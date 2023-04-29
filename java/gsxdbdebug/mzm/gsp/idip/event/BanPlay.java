/*    */ package mzm.gsp.idip.event;
/*    */ 
/*    */ import mzm.event.EventManager;
/*    */ 
/*    */ public class BanPlay extends mzm.event.BasicEvent<BanPlayArg>
/*    */ {
/*  7 */   private static EventManager<BanPlayArg> manager = new EventManager();
/*    */   
/*    */   public EventManager<BanPlayArg> getEventManager()
/*    */   {
/* 11 */     return manager;
/*    */   }
/*    */   
/*    */   static {
/* 15 */     manager.register(new mzm.gsp.shimen.main.POnBanPlay());
/* 16 */     manager.register(new mzm.gsp.baotu.main.POnBanPlay());
/* 17 */     manager.register(new mzm.gsp.zhenyao.main.POnBanPlay());
/* 18 */     manager.register(new mzm.gsp.scochallenge.main.POnBanPlay());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\event\BanPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */