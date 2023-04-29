/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.RemoveLadderRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.RemoveLadderRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.ladder.RemoveLadderRankInfoContext;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRemoveLadderRankInfoDone extends RemoveLadderRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     RemoveLadderRankInfoContext context = new RemoveLadderRankInfoContext();
/* 17 */     context.unmarshal(new OctetsStream(((RemoveLadderRankInfoDoneArg)this.arg).getContext()));
/* 18 */     if (((RemoveLadderRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 20 */       GameServer.logger().info(String.format("[Ladder]POnRemoveLadderRankInfoDone.processImp@remove ladder rank info success|roleid=%d|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(((RemoveLadderRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(context.count), Integer.valueOf(((RemoveLadderRankInfoDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((RemoveLadderRankInfoDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((RemoveLadderRankInfoDoneArg)this.arg).getRankid())) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 25 */       return true;
/*    */     }
/*    */     
/* 28 */     GameServer.logger().info(String.format("[Ladder]POnRemoveLadderRankInfoDone.processImp@remove ladder rank info fail|roleid=%d|count=%d|code=%d|season_begin_timestamp=%d|level_range=%d", new Object[] { Long.valueOf(((RemoveLadderRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(context.count), Integer.valueOf(((RemoveLadderRankInfoDoneArg)this.arg).getRetCode()), Integer.valueOf(CommonUtils.getLongHigh(((RemoveLadderRankInfoDoneArg)this.arg).getRankid())), Integer.valueOf(CommonUtils.getLongLow(((RemoveLadderRankInfoDoneArg)this.arg).getRankid())) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */     if (!((RemoveLadderRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (context.count < LadderManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 40 */       context.count += 1;
/* 41 */       OctetsStream os = new OctetsStream();
/* 42 */       context.marshal(os);
/* 43 */       CrossServerInterface.asyncRemoveLadderRankInfo(((RemoveLadderRankInfoDoneArg)this.arg).getRankid(), ((RemoveLadderRankInfoDoneArg)this.arg).getRoleid(), os);
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnRemoveLadderRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */