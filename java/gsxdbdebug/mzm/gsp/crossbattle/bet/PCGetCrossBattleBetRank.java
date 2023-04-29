/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.crossbattle.GetCrossBattleBetRankContext;
/*     */ import mzm.gsp.crossbattle.GetCrossBattleBetRank_ClientReq;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleBetRankFail;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleStageDurationCfg;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetCrossBattleBetRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int chartType;
/*     */   private final int activityCfgid;
/*     */   private final int startPos;
/*     */   private final int num;
/*     */   
/*     */   public PCGetCrossBattleBetRank(long roleid, int chartType, int activityCfgid, int startPos, int num)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.chartType = chartType;
/*  36 */     this.activityCfgid = activityCfgid;
/*  37 */     this.startPos = startPos;
/*  38 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (SCrossBattleStageDurationCfg.get(this.activityCfgid) == null)
/*     */     {
/*     */ 
/*  47 */       onFail(-3, null);
/*  48 */       return false;
/*     */     }
/*  50 */     SChartSubTypeCfg cfg = SChartSubTypeCfg.get(this.chartType);
/*  51 */     if (cfg == null)
/*     */     {
/*     */ 
/*  54 */       onFail(-3, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if ((this.startPos <= 0) || (this.num <= 0) || (this.startPos + this.num - 1 > cfg.capacity))
/*     */     {
/*     */ 
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (!CrossBattleBetManager.isCrossBattleBetRankSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  66 */       onFail(-1, null);
/*  67 */       return false;
/*     */     }
/*  69 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1417, true))
/*     */     {
/*     */ 
/*  72 */       onFail(-2, null);
/*  73 */       return false;
/*     */     }
/*  75 */     switch (this.chartType)
/*     */     {
/*     */ 
/*     */     case 50: 
/*  79 */       GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  80 */       context.oper_type = 0;
/*  81 */       context.count = 1;
/*  82 */       context.extra_info.replace(new GetCrossBattleBetRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  83 */       if (!CrossServerInterface.getCrossBattleBetWinRankRange(this.activityCfgid, this.startPos - 1, this.startPos - 1 + this.num - 1, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/*  87 */         onFail(10, null);
/*  88 */         return false;
/*     */       }
/*  90 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]PCGetCrossBattleBetRank.processImp@get cross battle bet rank from grc|roleid=%d|chart_type=%d|activity_cfg_id=%d|start_pos=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*     */       
/*     */ 
/*  93 */       return true;
/*     */     
/*     */ 
/*     */     case 51: 
/*  97 */       GetCrossBattleBetRankContext context = new GetCrossBattleBetRankContext();
/*  98 */       context.oper_type = 0;
/*  99 */       context.count = 1;
/* 100 */       context.extra_info.replace(new GetCrossBattleBetRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/* 101 */       if (!CrossServerInterface.getCrossBattleBetLoseRankRange(this.activityCfgid, this.startPos - 1, this.startPos - 1 + this.num - 1, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/* 105 */         onFail(10, null);
/* 106 */         return false;
/*     */       }
/* 108 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]PCGetCrossBattleBetRank.processImp@get cross battle bet rank from grc|roleid=%d|chart_type=%d|activity_cfg_id=%d|start_pos=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.startPos), Integer.valueOf(this.num) }));
/*     */       
/*     */ 
/* 111 */       return true;
/*     */     }
/*     */     
/*     */     
/* 115 */     onFail(-3, null);
/* 116 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 123 */     StringBuilder sb = new StringBuilder();
/* 124 */     sb.append(String.format("[crossbattle]PCGetCrossBattleBetRank.processImp@get cross battle bet rank fail|roleid=%d|chart_type=%d|activity_cfg_id=%d|start_pos=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.startPos), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 127 */     if (extraInfo != null)
/*     */     {
/* 129 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 131 */         sb.append("|").append((String)entry.getKey());
/* 132 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 135 */     CrossBattleBetManager.logger.info(sb.toString());
/* 136 */     if (res > 0)
/*     */     {
/* 138 */       SGetCrossBattleBetRankFail protocol = new SGetCrossBattleBetRankFail();
/* 139 */       protocol.res = res;
/* 140 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCGetCrossBattleBetRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */