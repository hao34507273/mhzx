/*     */ package mzm.gsp.axe.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.axe.confbean.SAxeAvtivityCfg;
/*     */ import mzm.gsp.axe.confbean.SAxeResultInfo;
/*     */ import mzm.gsp.axe.confbean.SAxeSectionInfo;
/*     */ import mzm.gsp.item.confbean.AxeItemConsts;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AxeActivityInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.UserAxeActivityInfo;
/*     */ import xtable.User_axe_activity_infos;
/*     */ 
/*     */ public class AxeManager
/*     */ {
/*  19 */   static Logger logger = Logger.getLogger("axe");
/*  20 */   private static int WAN = 10000;
/*     */   
/*     */   static void init()
/*     */   {
/*  24 */     mzm.gsp.activity.main.ActivityInterface.registerActivityByLogicType(91, new AxeActivityHandler(), true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAxeActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*     */   {
/*  36 */     SAxeAvtivityCfg cfg = SAxeAvtivityCfg.get(activityCfgid);
/*  37 */     if (cfg == null)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*     */     {
/*  47 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/*  48 */       return false;
/*     */     }
/*  50 */     return true;
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
/*     */   static SAxeResultInfo getAxeActivityResult(int activityCfgid, int sectionid, boolean needBaodi)
/*     */   {
/*  65 */     SAxeAvtivityCfg cfg = SAxeAvtivityCfg.get(activityCfgid);
/*  66 */     if (cfg == null)
/*     */     {
/*  68 */       return null;
/*     */     }
/*  70 */     SAxeSectionInfo sectionInfo = (SAxeSectionInfo)cfg.section_infos.get(Integer.valueOf(sectionid));
/*  71 */     if (sectionInfo == null)
/*     */     {
/*  73 */       return null;
/*     */     }
/*  75 */     if (needBaodi)
/*     */     {
/*  77 */       for (SAxeResultInfo resultInfo : sectionInfo.results.values())
/*     */       {
/*  79 */         if ((resultInfo.axe_item_cfg_id == AxeItemConsts.getInstance().GOLD_AXE_ITEM_CFG_ID) || (resultInfo.axe_item_cfg_id == AxeItemConsts.getInstance().GOLD_AXE_GOLD_ITEM_CFG_ID))
/*     */         {
/*     */ 
/*  82 */           return resultInfo;
/*     */         }
/*     */       }
/*     */     }
/*  86 */     return (SAxeResultInfo)sectionInfo.results.ceilingEntry(Integer.valueOf(xdb.Xdb.random().nextInt(WAN) + 1)).getValue();
/*     */   }
/*     */   
/*     */   static void initData(String userid, int activityCfgid)
/*     */   {
/*  91 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  92 */     UserAxeActivityInfo xUserAxeActivityInfo = User_axe_activity_infos.get(userid);
/*  93 */     if (xUserAxeActivityInfo == null)
/*     */     {
/*  95 */       xUserAxeActivityInfo = Pod.newUserAxeActivityInfo();
/*  96 */       User_axe_activity_infos.insert(userid, xUserAxeActivityInfo);
/*     */     }
/*  98 */     AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(activityCfgid));
/*  99 */     if (xAxeActivityInfo == null)
/*     */     {
/* 101 */       xAxeActivityInfo = Pod.newAxeActivityInfo();
/* 102 */       xAxeActivityInfo.setContinuous_not_gold_times(0);
/* 103 */       xAxeActivityInfo.setStart_timestamp(now);
/* 104 */       xUserAxeActivityInfo.getAxe_activity_infos().put(Integer.valueOf(activityCfgid), xAxeActivityInfo);
/* 105 */       StringBuilder sb = new StringBuilder();
/* 106 */       sb.append(String.format("[axe]AxeManager.initData@axe activity start|userid=%s|activity_cfg_id=%d|start_timestamp=%d", new Object[] { userid, Integer.valueOf(activityCfgid), Long.valueOf(now) }));
/*     */       
/*     */ 
/* 109 */       logger.info(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\AxeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */