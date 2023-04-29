/*     */ package mzm.gsp.bigboss.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.bigboss.GetBigBossRemoteRankContext;
/*     */ import mzm.gsp.bigboss.GetBigBossRemoteRank_ClientReq;
/*     */ import mzm.gsp.bigboss.SGetBigBossRemoteRankFail;
/*     */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetBigBossRemoteRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int occupation;
/*     */   private final int startPos;
/*     */   private final int num;
/*     */   
/*     */   public PCGetBigBossRemoteRank(long roleid, int occupation, int startPos, int num)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.occupation = occupation;
/*  35 */     this.startPos = startPos;
/*  36 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SBigbossRemoteChartTypeCfg cfg = SBigbossRemoteChartTypeCfg.get(this.occupation);
/*  43 */     if (cfg == null)
/*     */     {
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*  49 */     SChartSubTypeCfg chartCfg = SChartSubTypeCfg.get(cfg.remote_chart_type);
/*  50 */     if (chartCfg == null)
/*     */     {
/*     */ 
/*  53 */       onFail(-3, null);
/*  54 */       return false;
/*     */     }
/*  56 */     if ((this.startPos <= 0) || (this.num <= 0) || (this.startPos + this.num - 1 > chartCfg.capacity))
/*     */     {
/*     */ 
/*  59 */       onFail(-3, null);
/*  60 */       return false;
/*     */     }
/*  62 */     if (!BigbossManager.isBigBossSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  65 */       onFail(-1, null);
/*  66 */       return false;
/*     */     }
/*  68 */     if (!BigbossManager.isBigBossRemoteChartSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  71 */       onFail(-1, null);
/*  72 */       return false;
/*     */     }
/*  74 */     if (!BigbossManager.isRoleStateCanJoinBigbossActivity(this.roleid))
/*     */     {
/*     */ 
/*  77 */       onFail(-2, null);
/*  78 */       return false;
/*     */     }
/*  80 */     long startTimestamp = BigbossManager.getActivityStarttime();
/*  81 */     if (startTimestamp <= 0L)
/*     */     {
/*  83 */       startTimestamp = BigbossManager.getNextActivityStartTime() - 604800000L;
/*     */     }
/*  85 */     if (startTimestamp <= 0L)
/*     */     {
/*     */ 
/*  88 */       onFail(-6, null);
/*  89 */       return false;
/*     */     }
/*  91 */     GetBigBossRemoteRankContext context = new GetBigBossRemoteRankContext();
/*  92 */     context.oper_type = 0;
/*  93 */     context.count = 1;
/*  94 */     context.extra_info.replace(new GetBigBossRemoteRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  95 */     if (!CrossServerInterface.getBigBossRankRange(CommonUtils.getLong(this.occupation, (int)(startTimestamp / 1000L)), this.startPos - 1, this.startPos - 1 + this.num - 1, context.marshal(new OctetsStream())))
/*     */     {
/*     */ 
/*     */ 
/*  99 */       onFail(1, null);
/* 100 */       return false;
/*     */     }
/* 102 */     GameServer.logger().info(String.format("[bigboss]PCGetBigBossRemoteRank.processImp@get big boss remote rank from grc|roleid=%d|occupation=%d|start_timestamp=%s|start_pos=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupation), DateTimeUtils.formatTimestamp(startTimestamp), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*     */     
/*     */ 
/*     */ 
/* 106 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 111 */     StringBuilder sb = new StringBuilder();
/* 112 */     sb.append(String.format("[bigboss]PCGetBigBossRemoteRank.processImp@get big boss remote rank fail|roleid=%d|occupation=%d|start_pos=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupation), Integer.valueOf(this.startPos), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 115 */     if (extraInfo != null)
/*     */     {
/* 117 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 119 */         sb.append("|").append((String)entry.getKey());
/* 120 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 123 */     GameServer.logger().info(sb.toString());
/* 124 */     if (res > 0)
/*     */     {
/* 126 */       SGetBigBossRemoteRankFail protocol = new SGetBigBossRemoteRankFail();
/* 127 */       protocol.res = res;
/* 128 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\PCGetBigBossRemoteRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */