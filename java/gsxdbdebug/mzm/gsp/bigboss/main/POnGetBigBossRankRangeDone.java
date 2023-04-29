/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bigboss.BigbossRankData;
/*     */ import mzm.gsp.bigboss.GetBigBossRemoteRankContext;
/*     */ import mzm.gsp.bigboss.GetBigBossRemoteRank_ClientReq;
/*     */ import mzm.gsp.bigboss.SGetBigBossRemoteRankFail;
/*     */ import mzm.gsp.bigboss.SGetBigBossRemoteRankSuccess;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*     */ import mzm.gsp.bigboss.event.RoleGetBigBossRemoteChartAward;
/*     */ import mzm.gsp.bigboss.event.RoleGetBigBossRemoteChartAwardArg;
/*     */ import mzm.gsp.crossserver.event.GetBigBossRankRangeDoneArg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class POnGetBigBossRankRangeDone extends mzm.gsp.crossserver.event.GetBigBossRankRangeDoneProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     int occupation = CommonUtils.getLongHigh(((GetBigBossRankRangeDoneArg)this.arg).getRankid());
/*  31 */     long startTimestamp = CommonUtils.getLongLow(((GetBigBossRankRangeDoneArg)this.arg).getRankid()) * 1000L;
/*  32 */     GetBigBossRemoteRankContext context = new GetBigBossRemoteRankContext();
/*  33 */     context.unmarshal(OctetsStream.wrap(((GetBigBossRankRangeDoneArg)this.arg).getContext()));
/*  34 */     switch (context.oper_type)
/*     */     {
/*     */ 
/*     */     case 0: 
/*  38 */       GetBigBossRemoteRank_ClientReq extraInfo = new GetBigBossRemoteRank_ClientReq();
/*  39 */       extraInfo.unmarshal(OctetsStream.wrap(context.extra_info));
/*  40 */       long roleid = extraInfo.roleid;
/*  41 */       if ((!((GetBigBossRankRangeDoneArg)this.arg).isSucceed()) && (!((GetBigBossRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/*  43 */         if (!((GetBigBossRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/*  45 */           SGetBigBossRemoteRankFail protocol = new SGetBigBossRemoteRankFail();
/*  46 */           protocol.res = 1;
/*  47 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  48 */           GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range fail|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */           
/*     */ 
/*     */ 
/*  52 */           return false;
/*     */         }
/*  54 */         GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range timeout|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/*  58 */         if (context.count < BigbossManager.GRC_MAX_TRY_TIMES)
/*     */         {
/*  60 */           GetBigBossRemoteRankContext tmp298_296 = context;tmp298_296.count = ((byte)(tmp298_296.count + 1));
/*  61 */           if (!CrossServerInterface.getBigBossRankRange(((GetBigBossRankRangeDoneArg)this.arg).getRankid(), ((GetBigBossRankRangeDoneArg)this.arg).getFrom(), ((GetBigBossRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/*  65 */             SGetBigBossRemoteRankFail protocol = new SGetBigBossRemoteRankFail();
/*  66 */             protocol.res = 1;
/*  67 */             OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*  68 */             GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@communication error|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*  73 */             return false;
/*     */           }
/*  75 */           GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range from grc|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*  82 */           SGetBigBossRemoteRankFail protocol = new SGetBigBossRemoteRankFail();
/*  83 */           protocol.res = 1;
/*  84 */           OnlineManager.getInstance().sendAtOnce(roleid, protocol);
/*     */         }
/*  86 */         return false;
/*     */       }
/*  88 */       sendResult(roleid, occupation, ((GetBigBossRankRangeDoneArg)this.arg).getFrom() + 1, ((GetBigBossRankRangeDoneArg)this.arg).getTo() - ((GetBigBossRankRangeDoneArg)this.arg).getFrom() + 1, ((GetBigBossRankRangeDoneArg)this.arg).getRankRange());
/*     */       
/*  90 */       GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range success|count=%d|roleid=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Long.valueOf(roleid), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */       
/*     */ 
/*     */ 
/*  94 */       return true;
/*     */     
/*     */ 
/*     */     case 1: 
/*  98 */       if ((!((GetBigBossRankRangeDoneArg)this.arg).isSucceed()) && (!((GetBigBossRankRangeDoneArg)this.arg).isNoRankData()))
/*     */       {
/* 100 */         if (!((GetBigBossRankRangeDoneArg)this.arg).isTimeout())
/*     */         {
/* 102 */           GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range fail|count=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 107 */           new GetBigBossRemoteRankRangeSession(BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(BigbossManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), ((GetBigBossRankRangeDoneArg)this.arg).getRankid());
/*     */           
/*     */ 
/*     */ 
/* 111 */           return false;
/*     */         }
/* 113 */         GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range timeout|count=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */         
/*     */ 
/*     */ 
/* 117 */         if (context.count < BigbossManager.GRC_MAX_TRY_TIMES)
/*     */         {
/* 119 */           GetBigBossRemoteRankContext tmp783_781 = context;tmp783_781.count = ((byte)(tmp783_781.count + 1));
/* 120 */           if (!CrossServerInterface.getBigBossRankRange(((GetBigBossRankRangeDoneArg)this.arg).getRankid(), ((GetBigBossRankRangeDoneArg)this.arg).getFrom(), ((GetBigBossRankRangeDoneArg)this.arg).getTo(), context.marshal(new OctetsStream())))
/*     */           {
/*     */ 
/*     */ 
/* 124 */             GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@communication error|count=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 129 */             new GetBigBossRemoteRankRangeSession(BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(BigbossManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), ((GetBigBossRankRangeDoneArg)this.arg).getRankid());
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 134 */             return false;
/*     */           }
/* 136 */           GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@get big boss remote rank range from grc|count=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/* 144 */           new GetBigBossRemoteRankRangeSession(BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND + Xdb.random().nextInt(BigbossManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND - BigbossManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND), ((GetBigBossRankRangeDoneArg)this.arg).getRankid());
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 149 */         return false;
/*     */       }
/* 151 */       SBigbossRemoteChartTypeCfg cfg = SBigbossRemoteChartTypeCfg.get(occupation);
/* 152 */       if (cfg == null)
/*     */       {
/*     */ 
/* 155 */         return false;
/*     */       }
/* 157 */       int rank = mzm.gsp.chart.main.RankInterface.getAwardRank(cfg.remote_chart_type);
/* 158 */       if (rank < 0)
/*     */       {
/*     */ 
/* 161 */         return false;
/*     */       }
/* 163 */       for (int i = 0; (i < ((GetBigBossRankRangeDoneArg)this.arg).getRankRange().size()) && (i <= rank); i++)
/*     */       {
/* 165 */         long roleid = ((BigbossRankData)((GetBigBossRankRangeDoneArg)this.arg).getRankRange().get(i)).roleid;
/* 166 */         if (GameServerInfoManager.isRoleInOwnServer(roleid))
/*     */         {
/*     */ 
/*     */ 
/* 170 */           TriggerEventsManger.getInstance().triggerEvent(new RoleGetBigBossRemoteChartAward(), new RoleGetBigBossRemoteChartAwardArg((int)(startTimestamp / 1000L), occupation, roleid, i), BigBossRemoteChartTaskOneByOne.getInstance());
/*     */         }
/*     */       }
/*     */       
/* 174 */       GameServer.logger().info(String.format("[bigboss]POnGetBigBossRankRangeDone.processImp@send big boss remote rank award|count=%d|occupation=%d|start_timestamp=%s", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp) }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       return true;
/*     */     }
/*     */     
/* 181 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendResult(long roleid, int occupation, int startPos, int num, List<BigbossRankData> rankRange)
/*     */   {
/* 188 */     SGetBigBossRemoteRankSuccess protocol = new SGetBigBossRemoteRankSuccess();
/* 189 */     protocol.occupation = occupation;
/* 190 */     protocol.startpos = startPos;
/* 191 */     protocol.num = num;
/* 192 */     for (int i = 0; i < rankRange.size(); i++)
/*     */     {
/* 194 */       BigbossRankData rankData = (BigbossRankData)rankRange.get(i);
/* 195 */       rankData.rank = (startPos + i);
/*     */     }
/* 197 */     protocol.rank_list.addAll(rankRange);
/* 198 */     OnlineManager.getInstance().send(roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnGetBigBossRankRangeDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */