/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ public class PGM_AwardLottery
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int lotteryviewid;
/*    */   
/*    */   public PGM_AwardLottery(long roleid, int lotteryviewid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.lotteryviewid = lotteryviewid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     List<Long> roleList = new ArrayList();
/* 26 */     roleList.add(Long.valueOf(this.roleid));
/* 27 */     AwardPoolInterface.awardLottery(roleList, this.lotteryviewid, new TLogArg(LogReason.GM_ADD));
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\PGM_AwardLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */