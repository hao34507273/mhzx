/*    */ package mzm.gsp.crossfield.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.crossfield.GetRoleCrossFieldRankContext;
/*    */ import mzm.gsp.crossfield.SGetRoleCrossFieldRankFail;
/*    */ import mzm.gsp.crossfield.SGetRoleCrossFieldRankSuccess;
/*    */ import mzm.gsp.crossserver.event.GetRoleSingleCrossFieldRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.GetRoleSingleCrossFieldRankInfoDoneProcedure;
/*    */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnGetRoleSingleCrossFieldRankInfoDone
/*    */   extends GetRoleSingleCrossFieldRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     GetRoleCrossFieldRankContext context = new GetRoleCrossFieldRankContext();
/* 24 */     context.unmarshal(OctetsStream.wrap(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getContext()));
/* 25 */     switch (context.oper_type)
/*    */     {
/*    */ 
/*    */     case 0: 
/* 29 */       if (((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).isSucceed())
/*    */       {
/* 31 */         SGetRoleCrossFieldRankSuccess protocol = new SGetRoleCrossFieldRankSuccess();
/* 32 */         protocol.rank_type = 40;
/* 33 */         protocol.rank = (((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRank() + 1);
/* 34 */         OnlineManager.getInstance().send(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid(), protocol);
/* 35 */         CrossFieldManager.logger.info(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@get role single crossfield rank success|count=%d|roleid=%d|rankid=%d|rank=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()), Integer.valueOf(protocol.rank) }));
/*    */         
/*    */ 
/* 38 */         return true;
/*    */       }
/* 40 */       if (((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).isNotInRank())
/*    */       {
/* 42 */         SGetRoleCrossFieldRankSuccess protocol = new SGetRoleCrossFieldRankSuccess();
/* 43 */         protocol.rank_type = 40;
/* 44 */         protocol.rank = 0;
/* 45 */         OnlineManager.getInstance().send(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid(), protocol);
/* 46 */         CrossFieldManager.logger.info(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@get role single cross field rank success|count=%d|roleid=%d|rankid=%d|rank=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()), Integer.valueOf(protocol.rank) }));
/*    */         
/*    */ 
/* 49 */         return true;
/*    */       }
/* 51 */       if (!((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).isTimeout())
/*    */       {
/* 53 */         SGetRoleCrossFieldRankFail protocol = new SGetRoleCrossFieldRankFail();
/* 54 */         protocol.res = 9;
/* 55 */         OnlineManager.getInstance().sendAtOnce(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid(), protocol);
/* 56 */         CrossFieldManager.logger.error(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@get role single cross field rank fail|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()) }));
/*    */         
/*    */ 
/* 59 */         return false;
/*    */       }
/* 61 */       CrossFieldManager.logger.error(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@get role single cross field rank timeout|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()) }));
/*    */       
/*    */ 
/* 64 */       if (context.count < CrossFieldManager.GRC_MAX_TRY_TIMES)
/*    */       {
/* 66 */         GetRoleCrossFieldRankContext tmp469_468 = context;tmp469_468.count = ((byte)(tmp469_468.count + 1));
/* 67 */         if (!CrossServerInterface.getRoleSingleCrossFieldRankInfo(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid(), ((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid(), context.marshal(new OctetsStream())))
/*    */         {
/*    */ 
/*    */ 
/* 71 */           SGetRoleCrossFieldRankFail protocol = new SGetRoleCrossFieldRankFail();
/* 72 */           protocol.res = 9;
/* 73 */           OnlineManager.getInstance().sendAtOnce(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid(), protocol);
/* 74 */           CrossFieldManager.logger.error(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@communication error|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()) }));
/*    */           
/*    */ 
/* 77 */           return false;
/*    */         }
/* 79 */         CrossFieldManager.logger.info(String.format("[crossfield]POnGetRoleSingleCrossFieldRankInfoDone.processImp@get role single cross field rank from grc|count=%d|roleid=%d|rankid=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRoleid()), Long.valueOf(((GetRoleSingleCrossFieldRankInfoDoneArg)this.arg).getRankid()) }));
/*    */       }
/*    */       
/*    */ 
/* 83 */       return true;
/*    */     }
/*    */     
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\POnGetRoleSingleCrossFieldRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */