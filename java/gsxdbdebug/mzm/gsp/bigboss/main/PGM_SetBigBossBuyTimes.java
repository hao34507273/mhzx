/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetBigBossBuyTimes extends LogicProcedure
/*    */ {
/*    */   private int value;
/*    */   
/*    */   public PGM_SetBigBossBuyTimes(int value)
/*    */   {
/* 12 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     SBigbossCfgConsts.getInstance().MAX_BUY_COUNT = this.value;
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PGM_SetBigBossBuyTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */