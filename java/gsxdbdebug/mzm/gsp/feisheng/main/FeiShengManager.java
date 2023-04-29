/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.feisheng.confbean.FeiShengLevelCfg;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengInfo;
/*     */ import xbean.RoleFeiShengInfo;
/*     */ import xtable.Role_fei_sheng_infos;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FeiShengManager
/*     */ {
/*  17 */   public static final Logger logger = Logger.getLogger("feisheng");
/*  18 */   static volatile boolean postInitFlag = false;
/*     */   
/*     */   static void init()
/*     */   {
/*  22 */     ActivityInterface.registerActivityByLogicType(81, new FeiShengActivityHandler());
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  27 */     postInitFlag = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFeiShengActivitySwitchOpen(int activityCfgid)
/*     */   {
/*  38 */     SFeiShengCfg cfg = SFeiShengCfg.get(activityCfgid);
/*  39 */     if (cfg == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  45 */       return false;
/*     */     }
/*  47 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFeiShengActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/*  58 */     SFeiShengCfg cfg = SFeiShengCfg.get(activityCfgid);
/*  59 */     if (cfg == null)
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  69 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  70 */       return false;
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isFeiShengActivityComplete(long roleid, int level, boolean isRetainLock)
/*     */   {
/*  87 */     if (FeiShengLevelCfg.get(level) == null)
/*     */     {
/*  89 */       return true;
/*     */     }
/*  91 */     int activityCfgid = FeiShengLevelCfg.get(level).activity_cfg_id;
/*  92 */     RoleFeiShengInfo xRoleFeiShengInfo = null;
/*  93 */     if (isRetainLock)
/*     */     {
/*  95 */       xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/*  99 */       xRoleFeiShengInfo = Role_fei_sheng_infos.select(Long.valueOf(roleid));
/*     */     }
/* 101 */     if (xRoleFeiShengInfo == null)
/*     */     {
/* 103 */       return false;
/*     */     }
/* 105 */     FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(activityCfgid));
/* 106 */     if (xFeiShengInfo == null)
/*     */     {
/* 108 */       return false;
/*     */     }
/* 110 */     return xFeiShengInfo.getIs_activity_complete();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */