/*     */ package mzm.gsp.genius.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.genius.SSwitchPlanFailed;
/*     */ import mzm.gsp.genius.SSwitchPlanSuccess;
/*     */ import mzm.gsp.genius.confbean.SGeniusConst;
/*     */ import mzm.gsp.genius.confbean.SGeniusSeriesCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GeniusSeries;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCSwitchPlan extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int geniusSeriesCfgid;
/*     */   
/*     */   public PCSwitchPlan(long roleid, int geniusSeriesCfgid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.geniusSeriesCfgid = geniusSeriesCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (this.geniusSeriesCfgid <= 0)
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     if (!GeniusManager.canDoAction(this.roleid, 1073, false))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (!GeniusManager.isFunOpen(this.roleid))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     if (!GeniusManager.isDoubleSeriesFunOpen(this.roleid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     int level = RoleInterface.getLevel(this.roleid);
/*  57 */     if (level < SGeniusConst.getInstance().OPEN_LEVEL)
/*     */     {
/*  59 */       onFailed(4);
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/*  65 */     SGeniusSeriesCfg geniusSeriesCfg = SGeniusSeriesCfg.get(ocpid);
/*  66 */     if (geniusSeriesCfg == null)
/*     */     {
/*  68 */       Map<String, Object> extras = new HashMap();
/*  69 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  70 */       onFailed(3, extras);
/*  71 */       return false;
/*     */     }
/*  73 */     if (geniusSeriesCfg.series.get(Integer.valueOf(this.geniusSeriesCfgid)) == null)
/*     */     {
/*  75 */       Map<String, Object> extras = new HashMap();
/*  76 */       extras.put("occupationid", Integer.valueOf(ocpid));
/*  77 */       onFailed(3, extras);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     String userid = RoleInterface.getUserId(this.roleid);
/*  82 */     if (userid == null)
/*     */     {
/*  84 */       onFailed(2);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     lock(Lockeys.get(User.getTable(), userid));
/*  90 */     GeniusSeries xGeniusSeries = GeniusManager.getGeniusSeries(this.roleid, ocpid);
/*  91 */     if (xGeniusSeries == null)
/*     */     {
/*  93 */       onFailed(1);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     int oldGeniusSeriesCfgid = xGeniusSeries.getCur_series();
/*  99 */     if (oldGeniusSeriesCfgid == this.geniusSeriesCfgid)
/*     */     {
/* 101 */       onFailed(6);
/* 102 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 106 */     int gold = SGeniusConst.getInstance().SWITCH_COST_GOLD;
/* 107 */     TLogArg tLogArg = new TLogArg(LogReason.GENIUS_SWITCH_PLAN);
/* 108 */     if (!RoleInterface.cutGold(this.roleid, gold, tLogArg))
/*     */     {
/* 110 */       onFailed(-1);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 115 */     xGeniusSeries.setCur_series(this.geniusSeriesCfgid);
/*     */     
/*     */ 
/* 118 */     GeniusManager.triggerGeniusSkillChangeEvent(this.roleid, GeniusSkillChangeReason.SWITCH_GENIUS);
/*     */     
/* 120 */     SSwitchPlanSuccess rsp = new SSwitchPlanSuccess();
/* 121 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 122 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/*     */ 
/* 125 */     GeniusManager.addTLog(this.roleid, "GeniusSwitchPlanForServer", new Object[] { Integer.valueOf(ocpid), Integer.valueOf(oldGeniusSeriesCfgid), Integer.valueOf(this.geniusSeriesCfgid), Integer.valueOf(gold), Integer.valueOf(1) });
/*     */     
/*     */ 
/* 128 */     GameServer.logger().info(String.format("[genius]PCSwitchPlan.processImp@switch plan success|roleid=%d|ocpid=%d|old_genius_series_cfgid|genius_series_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid), Integer.valueOf(oldGeniusSeriesCfgid), Integer.valueOf(this.geniusSeriesCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 132 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 137 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 142 */     SSwitchPlanFailed rsp = new SSwitchPlanFailed();
/* 143 */     rsp.genius_series_id = this.geniusSeriesCfgid;
/* 144 */     rsp.retcode = retcode;
/* 145 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 147 */     StringBuffer logBuilder = new StringBuffer();
/* 148 */     logBuilder.append("[genius]PCSwitchPlan.onFailed@switch plan failed");
/* 149 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 150 */     logBuilder.append('|').append("genius_series_cfgid=").append(this.geniusSeriesCfgid);
/* 151 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 153 */     if (extraParams != null)
/*     */     {
/* 155 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 157 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 161 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\PCSwitchPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */