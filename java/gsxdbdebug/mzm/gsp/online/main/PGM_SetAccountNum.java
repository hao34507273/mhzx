/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetAccountNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int accountNum;
/*    */   
/*    */   public PGM_SetAccountNum(int accountNum)
/*    */   {
/* 11 */     this.accountNum = accountNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setAccountNum(this.accountNum);
/* 17 */     GameServer.logger().info("当前限制帐号的数目:" + this.accountNum);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetAccountNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */