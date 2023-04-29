/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetMaxPalyerNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int maxNum;
/*    */   
/*    */   public PGM_SetMaxPalyerNum(int maxNum)
/*    */   {
/* 11 */     this.maxNum = maxNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setMaxPlayerNumber(this.maxNum);
/* 17 */     GameServer.logger().info("当前允许的最大在线人数:" + this.maxNum);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetMaxPalyerNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */