/*     */ package mzm.gsp.genius.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.genius.SResetPlanFailed;
/*     */ import mzm.gsp.genius.SResetPlanSuccess;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.confbean.SGeniusSeriesCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GeniusSeries;
/*     */ import xbean.GeniusSeriesInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCResetPlan extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int geniusSeriesCfgid;
/*     */   
/*     */   public PCResetPlan(long roleid, int geniusSeriesCfgid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.geniusSeriesCfgid = geniusSeriesCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.geniusSeriesCfgid <= 0)
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!GeniusManager.canDoAction(this.roleid, 1074, false))
/*     */     {
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!GeniusManager.isFunOpen(this.roleid))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     int level = RoleInterface.getLevel(this.roleid);
/*  51 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  53 */       onFailed(4);
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  59 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/*  60 */     if (geniusSeriesCfg == null)
/*     */     {
/*  62 */       Map<String, Object> extras = new HashMap();
/*  63 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  64 */       onFailed(3, extras);
/*  65 */       return false;
/*     */     }
/*  67 */     if (geniusSeriesCfg.series.get(Integer.valueOf(this.geniusSeriesCfgid)) == null)
/*     */     {
/*  69 */       Map<String, Object> extras = new HashMap();
/*  70 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  71 */       onFailed(3, extras);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     String userid = RoleInterface.getUserId(this.roleid);
/*  76 */     if (userid == null)
/*     */     {
/*  78 */       onFailed(2);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     lock(Lockeys.get(User.getTable(), userid));
/*  84 */     GeniusSeries xGeniusSeries = GeniusManager.getGeniusSeries(this.roleid, ocpid);
/*  85 */     if (xGeniusSeries == null)
/*     */     {
/*  87 */       onFailed(1);
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     GeniusSeriesInfo xGeniusSeriesInfo = (GeniusSeriesInfo)xGeniusSeries.getSeries().get(Integer.valueOf(this.geniusSeriesCfgid));
/*  93 */     if (xGeniusSeriesInfo == null)
/*     */     {
/*  95 */       onFailed(5);
/*  96 */       return false;
/*     */     }
/*  98 */     if (xGeniusSeriesInfo.getGenius_skills().isEmpty())
/*     */     {
/* 100 */       onFailed(5);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     TLogArg tLogArg = new TLogArg(mzm.gsp.tlog.LogReason.GENIUS_RESET_PLAN);
/* 106 */     int gold = SGeniusConst.getInstance().RESET_GENIUS_COST_GOLD;
/* 107 */     if (!RoleInterface.cutGold(this.roleid, gold, tLogArg))
/*     */     {
/* 109 */       onFailed(-1);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     xGeniusSeriesInfo.getGenius_skills().clear();
/*     */     
/*     */ 
/* 117 */     GeniusManager.triggerGeniusSkillChangeEvent(this.roleid, GeniusSkillChangeReason.RESET_GENIUS);
/*     */     
/* 119 */     SResetPlanSuccess rsp = new SResetPlanSuccess();
/* 120 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 121 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*     */ 
/* 124 */     GeniusManager.addTLog(this.roleid, "GeniusResetPlanForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(this.geniusSeriesCfgid), Integer.valueOf(gold) });
/*     */     
/* 126 */     GameServer.logger().info(String.format("[genius]PCResetPlan.processImp@rest plan success|roleid=%d|ocpid=%d|genius_series_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid), Integer.valueOf(this.geniusSeriesCfgid) }));
/*     */     
/*     */ 
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 134 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 139 */     SResetPlanFailed rsp = new SResetPlanFailed();
/* 140 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 141 */     rsp.retcode = retcode;
/* 142 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 144 */     StringBuffer logBuilder = new StringBuffer();
/* 145 */     logBuilder.append("[genius]PCResetPlan.onFailed@reset plan failed");
/* 146 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 147 */     logBuilder.append('|').append("genius_series_cfgid=").append(this.geniusSeriesCfgid);
/* 148 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 150 */     if (extraParams != null)
/*     */     {
/* 152 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 154 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 158 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PCResetPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */