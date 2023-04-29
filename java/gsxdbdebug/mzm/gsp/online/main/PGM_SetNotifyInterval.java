/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetNotifyInterval extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int intervalSec;
/*    */   
/*    */   public PGM_SetNotifyInterval(int intervalSec)
/*    */   {
/* 11 */     this.intervalSec = intervalSec;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setNotifyLoginInterval(this.intervalSec);
/* 17 */     GameServer.logger().info("当前通知排队等待的间隔时间为:" + this.intervalSec + "秒");
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetNotifyInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */