/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bigboss.GetRoleBigBossRemoteRankContext;
/*     */ import mzm.gsp.bigboss.SGetRoleBigBossRemoteRankFail;
/*     */ import mzm.gsp.bigboss.SGetRoleBigBossRemoteRankSuccess;
/*     */ import mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDoneArg;
/*     */ import mzm.gsp.crossserver.event.GetRoleBigBossRankInfoDoneProcedure;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POnGetRoleBigBossRankInfoDone
/*     */   extends GetRoleBigBossRankInfoDoneProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  25 */     int occupation = CommonUtils.getLongHigh(((GetRoleBigBossRankInfoDoneArg)this.arg).getRankid());
/*  26 */     long startTimestamp = CommonUtils.getLongLow(((GetRoleBigBossRankInfoDoneArg)this.arg).getRankid()) * 1000L;
/*  27 */     GetRoleBigBossRemoteRankContext context = new GetRoleBigBossRemoteRankContext();
/*  28 */     context.unmarshal(OctetsStream.wrap(((GetRoleBigBossRankInfoDoneArg)this.arg).getContext()));
/*  29 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  33 */       if ((!((GetRoleBigBossRankInfoDoneArg)this.arg).isSucceed()) && (!((GetRoleBigBossRankInfoDoneArg)this.arg).isNotInRank()))
/*     */       {
/*  35 */         if (!((GetRoleBigBossRankInfoDoneArg)this.arg).isTimeout())
/*     */         {
/*  37 */           SGetRoleBigBossRemoteRankFail protocol = new SGetRoleBigBossRemoteRankFail();
/*  38 */           protocol.res = 1;
/*  39 */           OnlineManager.getInstance().sendAtOnce(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  40 */           GameServer.logger().error(String.format("[bigboss]POnGetRoleBigBossRankInfoDone.processImp@get role big boss remote rank fail|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  45 */           return false;
/*     */         }
/*  47 */         GameServer.logger().error(String.format("[bigboss]POnGetRoleBigBossRankInfoDone.processImp@get role big boss remote rank timeout|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  52 */         if (context.count < BigbossManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  54 */           GetRoleBigBossRemoteRankContext tmp284_282 = context;tmp284_282.count = ((byte)(tmp284_282.count + 1));
/*  55 */           if (!CrossServerInterface.getRoleBigBossRankInfo(((GetRoleBigBossRankInfoDoneArg)this.arg).getRankid(), ((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  59 */             SGetRoleBigBossRemoteRankFail protocol = new SGetRoleBigBossRemoteRankFail();
/*  60 */             protocol.res = 1;
/*  61 */             OnlineManager.getInstance().sendAtOnce(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  62 */             GameServer.logger().error(String.format("[bigboss]POnGetRoleBigBossRankInfoDone.processImp@communication error|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*  67 */             return false;
/*     */           }
/*  69 */           GameServer.logger().info(String.format("[bigboss]POnGetRoleBigBossRankInfoDone.processImp@get role big boss remote rank from grc|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*  77 */           SGetRoleBigBossRemoteRankFail protocol = new SGetRoleBigBossRemoteRankFail();
/*  78 */           protocol.res = 1;
/*  79 */           OnlineManager.getInstance().sendAtOnce(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*     */         }
/*  81 */         return false;
/*     */       }
/*  83 */       SGetRoleBigBossRemoteRankSuccess protocol = new SGetRoleBigBossRemoteRankSuccess();
/*  84 */       protocol.occupation = occupation;
/*  85 */       protocol.damage_point = BigbossManager.getDamagePoint(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), occupation);
/*  86 */       if (((GetRoleBigBossRankInfoDoneArg)this.arg).isSucceed())
/*     */       {
/*  88 */         protocol.rank = (((GetRoleBigBossRankInfoDoneArg)this.arg).getRank() + 1);
/*     */       }
/*     */       else
/*     */       {
/*  92 */         protocol.rank = 0;
/*     */       }
/*  94 */       OnlineManager.getInstance().send(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), protocol);
/*  95 */       GameServer.logger().info(String.format("[bigboss]POnGetRoleBigBossRankInfoDone.processImp@get role big boss remote rank success|count=%d|roleid=%d|occupation=%d|start_timestamp=%s|rank=%d", new Object[] { Byte.valueOf(context.count), Long.valueOf(((GetRoleBigBossRankInfoDoneArg)this.arg).getRoleid()), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Integer.valueOf(protocol.rank) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 100 */       return true;
/*     */     }
/*     */     
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnGetRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */