/*     */ package mzm.gsp.crossbattle.bet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.GetRoleCrossBattleBetRankContext;
/*     */ import mzm.gsp.crossbattle.GetRoleCrossBattleBetRank_ClientReq;
/*     */ import mzm.gsp.crossbattle.SGetRoleCrossBattleBetRankFail;
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
/*     */ public class PCGetRoleCrossBattleBetRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int chartType;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCGetRoleCrossBattleBetRank(long roleid, int chartType, int activityCfgid)
/*     */   {
/*  30 */     this.roleid = roleid;
/*  31 */     this.chartType = chartType;
/*  32 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (SCrossBattleStageDurationCfg.get(this.activityCfgid) == null)
/*     */     {
/*     */ 
/*  41 */       onFail(-3, null);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!CrossBattleBetManager.isCrossBattleBetRankSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  47 */       onFail(-1, null);
/*  48 */       return false;
/*     */     }
/*  50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1417, true))
/*     */     {
/*     */ 
/*  53 */       onFail(-2, null);
/*  54 */       return false;
/*     */     }
/*  56 */     switch (this.chartType)
/*     */     {
/*     */ 
/*     */     case 50: 
/*  60 */       GetRoleCrossBattleBetRankContext context = new GetRoleCrossBattleBetRankContext();
/*  61 */       context.oper_type = 0;
/*  62 */       context.count = 1;
/*  63 */       context.extra_info.replace(new GetRoleCrossBattleBetRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  64 */       if (!CrossServerInterface.getRoleCrossBattleBetWinRankInfo(this.activityCfgid, this.roleid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/*  68 */         onFail(10, null);
/*  69 */         return false;
/*     */       }
/*  71 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]PCGetRoleCrossBattleBetRank.processImp@get role cross battle bet rank from grc|roleid=%d|chart_type=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  74 */       return true;
/*     */     
/*     */ 
/*     */     case 51: 
/*  78 */       GetRoleCrossBattleBetRankContext context = new GetRoleCrossBattleBetRankContext();
/*  79 */       context.oper_type = 0;
/*  80 */       context.count = 1;
/*  81 */       context.extra_info.replace(new GetRoleCrossBattleBetRank_ClientReq(this.roleid).marshal(new OctetsStream()));
/*  82 */       if (!CrossServerInterface.getRoleCrossBattleBetLoseRankInfo(this.activityCfgid, this.roleid, context.marshal(new OctetsStream())))
/*     */       {
/*     */ 
/*     */ 
/*  86 */         onFail(10, null);
/*  87 */         return false;
/*     */       }
/*  89 */       CrossBattleBetManager.logger.info(String.format("[crossbattle]PCGetRoleCrossBattleBetRank.processImp@get role cross battle bet rank from grc|roleid=%d|chart_type=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid) }));
/*     */       
/*     */ 
/*  92 */       return true;
/*     */     }
/*     */     
/*     */     
/*  96 */     onFail(-3, null);
/*  97 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 104 */     StringBuilder sb = new StringBuilder();
/* 105 */     sb.append(String.format("[crossbattle]PCGetRoleCrossBattleBetRank.processImp@get role cross battle bet rank fail|roleid=%d|chart_type=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 108 */     if (extraInfo != null)
/*     */     {
/* 110 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 112 */         sb.append("|").append((String)entry.getKey());
/* 113 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 116 */     CrossBattleBetManager.logger.info(sb.toString());
/* 117 */     if (res > 0)
/*     */     {
/* 119 */       SGetRoleCrossBattleBetRankFail protocol = new SGetRoleCrossBattleBetRankFail();
/* 120 */       protocol.res = res;
/* 121 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\PCGetRoleCrossBattleBetRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */