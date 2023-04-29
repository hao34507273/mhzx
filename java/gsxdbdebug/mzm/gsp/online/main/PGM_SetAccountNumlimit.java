/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetAccountNumlimit extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private boolean accountNumLimit;
/*    */   
/*    */   public PGM_SetAccountNumlimit(boolean accountNumLimit)
/*    */   {
/* 11 */     this.accountNumLimit = accountNumLimit;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setAccountNumLimit(this.accountNumLimit);
/* 17 */     GameServer.logger().info("是否开启了账号数目限制标志:" + this.accountNumLimit);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetAccountNumlimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */