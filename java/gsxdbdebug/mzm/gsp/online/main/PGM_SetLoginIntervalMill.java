/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetLoginIntervalMill extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int millSec;
/*    */   
/*    */   public PGM_SetLoginIntervalMill(int millSec)
/*    */   {
/* 11 */     this.millSec = millSec;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setTryLoginInterval(this.millSec);
/* 17 */     GameServer.logger().info("当前排队中尝试登录间隔:" + this.millSec + "毫秒");
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetLoginIntervalMill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */