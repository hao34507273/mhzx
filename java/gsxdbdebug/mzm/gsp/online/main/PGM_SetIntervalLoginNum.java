/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class PGM_SetIntervalLoginNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int intervalLoginNum;
/*    */   
/*    */   public PGM_SetIntervalLoginNum(int intervalLoginNum)
/*    */   {
/* 11 */     this.intervalLoginNum = intervalLoginNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     LoginManager.getInstance().setIntervalLoginNum(this.intervalLoginNum);
/* 17 */     GameServer.logger().info("当前的每次登陆间隔登陆的人数:" + this.intervalLoginNum);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\PGM_SetIntervalLoginNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */