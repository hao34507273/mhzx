/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.item.main.POfferLotteryResult;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PCTakeSingleBoss extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public PCTakeSingleBoss(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     boolean ret = new POfferLotteryResult(this.roleid, 3).call();
/* 19 */     if (!ret) {
/* 20 */       GameServer.logger().info(String.format("[SingleInstance]PCTakeSingleBoss@lottery award false|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */     }
/*    */     
/* 23 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\PCTakeSingleBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */