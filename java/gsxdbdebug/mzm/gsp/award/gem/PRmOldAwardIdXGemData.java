/*    */ package mzm.gsp.award.gem;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Award2countinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmOldAwardIdXGemData
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int awardId;
/*    */   
/*    */   public PRmOldAwardIdXGemData(int awardId)
/*    */   {
/* 17 */     this.awardId = awardId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     Award2countinfo.remove(Integer.valueOf(this.awardId));
/* 24 */     GameServer.logger().info(String.format("[awardGem]PRmOldAwardIdXGemData.processImp@ rm awardId xData!|awardId=%d", new Object[] { Integer.valueOf(this.awardId) }));
/*    */     
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\PRmOldAwardIdXGemData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */