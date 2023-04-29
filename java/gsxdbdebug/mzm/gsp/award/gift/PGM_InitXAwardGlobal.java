/*    */ package mzm.gsp.award.gift;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.giftaward.confbean.SClientGetGiftCfg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_InitXAwardGlobal
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int useType;
/*    */   public ResetGiftRes res;
/*    */   
/*    */   public PGM_InitXAwardGlobal(int useType)
/*    */   {
/* 20 */     this.useType = useType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     SClientGetGiftCfg cfg = SClientGetGiftCfg.get(this.useType);
/* 27 */     if (cfg == null)
/*    */     {
/* 29 */       GameServer.logger().error(String.format("[gift]PGM_InitXAwardGlobal.processImp@ illegal useType!|useType=%d|", new Object[] { Integer.valueOf(this.useType) }));
/*    */       
/* 31 */       return false;
/*    */     }
/* 33 */     if (cfg.activityId > 0)
/*    */     {
/*    */ 
/* 36 */       GameServer.logger().error(String.format("[gift]PGM_InitXAwardGlobal.processImp@ forbid init for being contorlled by activity!|useType=%d|activityId=%d", new Object[] { Integer.valueOf(this.useType), Integer.valueOf(cfg.activityId) }));
/*    */       
/*    */ 
/*    */ 
/* 40 */       return false;
/*    */     }
/* 42 */     this.res = GlobalGiftManager.initXAwardGlobal(this.useType);
/* 43 */     return this.res.isbSucceed();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gift\PGM_InitXAwardGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */