/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SOperaInstanceCfg;
/*     */ import xbean.InstanceBean;
/*     */ import xbean.TeamInstance;
/*     */ import xtable.Role2instance;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamInstanceActivityCompensateHandler
/*     */   implements ActivityCompensateHandler
/*     */ {
/*     */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*     */   {
/*  24 */     if (count < 0)
/*     */     {
/*  26 */       return 0;
/*     */     }
/*  28 */     int instanceCfgid = InstanceCfgManager.getOperaInstanceCfgIdByActivityid(activityid);
/*  29 */     if (instanceCfgid <= 0)
/*     */     {
/*  31 */       return 0;
/*     */     }
/*  33 */     SInstanceCfg cfg = SInstanceCfg.get(instanceCfgid);
/*  34 */     if ((cfg == null) || (cfg.instanceType != 2))
/*     */     {
/*  36 */       return 0;
/*     */     }
/*  38 */     SActivityCfg activityCfg = SActivityCfg.get(activityid);
/*  39 */     if ((activityCfg == null) || (activityCfg.count <= 0))
/*     */     {
/*  41 */       return 0;
/*     */     }
/*  43 */     InstanceBean xInstanceBean = Role2instance.get(Long.valueOf(roleid));
/*  44 */     if (xInstanceBean == null)
/*     */     {
/*  46 */       return Math.max(0, activityCfg.count - count);
/*     */     }
/*  48 */     TeamInstance xTeamInstance = (TeamInstance)xInstanceBean.getTeaminstancemap().get(Integer.valueOf(instanceCfgid));
/*  49 */     if (xTeamInstance == null)
/*     */     {
/*  51 */       return Math.max(0, activityCfg.count - count);
/*     */     }
/*  53 */     if (xTeamInstance.getSign() == 0)
/*     */     {
/*  55 */       return 0;
/*     */     }
/*  57 */     if (xTeamInstance.getToprocess() > 0)
/*     */     {
/*  59 */       return Math.max(0, activityCfg.count - count - 1);
/*     */     }
/*  61 */     return Math.max(0, activityCfg.count - count);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getActivitySwitchList(int activityid)
/*     */   {
/*  67 */     int instanceCfgid = InstanceCfgManager.getOperaInstanceCfgIdByActivityid(activityid);
/*  68 */     if (instanceCfgid <= 0)
/*     */     {
/*  70 */       return null;
/*     */     }
/*  72 */     SInstanceCfg cfg = SInstanceCfg.get(instanceCfgid);
/*  73 */     if ((cfg == null) || (cfg.instanceType != 2))
/*     */     {
/*  75 */       return null;
/*     */     }
/*  77 */     SOperaInstanceCfg operaInstanceCfg = InstanceCfgManager.getOperaInstanceCfg(instanceCfgid);
/*  78 */     if (operaInstanceCfg == null)
/*     */     {
/*  80 */       return null;
/*     */     }
/*  82 */     List<Integer> switches = new ArrayList();
/*  83 */     switches.add(Integer.valueOf(7));
/*  84 */     switch (operaInstanceCfg.disType)
/*     */     {
/*     */     case 1: 
/*  87 */       switches.add(Integer.valueOf(388));
/*  88 */       break;
/*     */     case 2: 
/*  90 */       switches.add(Integer.valueOf(389));
/*  91 */       break;
/*     */     case 3: 
/*  93 */       switches.add(Integer.valueOf(390));
/*  94 */       break;
/*     */     case 4: 
/*  96 */       switches.add(Integer.valueOf(391));
/*  97 */       break;
/*     */     case 5: 
/*  99 */       switches.add(Integer.valueOf(392));
/* 100 */       break;
/*     */     default: 
/* 102 */       return null;
/*     */     }
/* 104 */     return switches;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceActivityCompensateHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */