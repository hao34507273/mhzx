/*     */ package mzm.gsp.festival.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.confbean.FestivalAwardOwnCfg;
/*     */ import mzm.gsp.activity.confbean.SFestivalAwardOwnCfg;
/*     */ import mzm.gsp.festival.SFestivalNormalRet;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.FestivalAward;
/*     */ import xtable.Role2festivalaward;
/*     */ 
/*     */ class FestivalManager
/*     */ {
/*     */   static void init() {}
/*     */   
/*     */   static SFestivalAwardOwnCfg getAllFestivalCfg()
/*     */   {
/*  27 */     Iterator i$ = SFestivalAwardOwnCfg.getAll().entrySet().iterator(); if (i$.hasNext()) { Map.Entry<Integer, SFestivalAwardOwnCfg> entry = (Map.Entry)i$.next();
/*  28 */       return (SFestivalAwardOwnCfg)entry.getValue();
/*     */     }
/*  30 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FestivalAwardOwnCfg getNextFestivalAwardCfg()
/*     */   {
/*  39 */     SFestivalAwardOwnCfg sfestivalAwardOwnCfg = getAllFestivalCfg();
/*  40 */     if (sfestivalAwardOwnCfg == null) {
/*  41 */       return null;
/*     */     }
/*  43 */     long curTimeSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  44 */     for (int i = 0; i < sfestivalAwardOwnCfg.festivalAwardOwnCfgs.size(); i++) {
/*  45 */       FestivalAwardOwnCfg festivalAwardOwnCfg = (FestivalAwardOwnCfg)sfestivalAwardOwnCfg.festivalAwardOwnCfgs.get(i);
/*  46 */       if (curTimeSec < festivalAwardOwnCfg.startTimeSec) {
/*  47 */         return festivalAwardOwnCfg;
/*     */       }
/*     */     }
/*  50 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FestivalAwardOwnCfg getCurrentFestivalAwardCfg()
/*     */   {
/*  59 */     long currentTimeSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  60 */     SFestivalAwardOwnCfg sfestivalAwardOwnCfg = getAllFestivalCfg();
/*  61 */     if (sfestivalAwardOwnCfg == null) {
/*  62 */       return null;
/*     */     }
/*  64 */     for (int i = 0; i < sfestivalAwardOwnCfg.festivalAwardOwnCfgs.size(); i++) {
/*  65 */       FestivalAwardOwnCfg festivalAwardOwnCfg = (FestivalAwardOwnCfg)sfestivalAwardOwnCfg.festivalAwardOwnCfgs.get(i);
/*  66 */       if ((festivalAwardOwnCfg.startTimeSec < currentTimeSec) && (festivalAwardOwnCfg.endTimeSec > currentTimeSec)) {
/*  67 */         return festivalAwardOwnCfg;
/*     */       }
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   static void sendNormalRet(long roleid, int ret, String... args) {
/*  74 */     SFestivalNormalRet festivalNormalRet = new SFestivalNormalRet();
/*  75 */     festivalNormalRet.ret = ret;
/*  76 */     for (String arg : args) {
/*  77 */       festivalNormalRet.args.add(arg);
/*     */     }
/*  79 */     OnlineManager.getInstance().sendAtOnce(roleid, festivalNormalRet);
/*     */   }
/*     */   
/*     */   static boolean pgm_startFestivalAwardCfg(int festivalAwardid) {
/*  83 */     int currentTimeSec = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  84 */     SFestivalAwardOwnCfg sFestivalAwardOwnCfg = getAllFestivalCfg();
/*  85 */     if (sFestivalAwardOwnCfg == null) {
/*  86 */       return false;
/*     */     }
/*  88 */     for (int i = 0; i < sFestivalAwardOwnCfg.festivalAwardOwnCfgs.size(); i++) {
/*  89 */       FestivalAwardOwnCfg festivalAwardOwnCfg = (FestivalAwardOwnCfg)sFestivalAwardOwnCfg.festivalAwardOwnCfgs.get(i);
/*  90 */       if (festivalAwardOwnCfg.cfgid == festivalAwardid) {
/*  91 */         festivalAwardOwnCfg.startTimeSec = currentTimeSec;
/*  92 */         festivalAwardOwnCfg.endTimeSec = (currentTimeSec + 86400);
/*  93 */         onFestivalIndexStart(festivalAwardOwnCfg.cfgid);
/*  94 */         return true;
/*     */       }
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   static void postInit() {
/* 101 */     long currentTimeSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 102 */     SFestivalAwardOwnCfg sFestivalAwardOwnCfg = getAllFestivalCfg();
/* 103 */     if (sFestivalAwardOwnCfg == null) {
/* 104 */       return;
/*     */     }
/* 106 */     for (int i = 0; i < sFestivalAwardOwnCfg.festivalAwardOwnCfgs.size(); i++) {
/* 107 */       FestivalAwardOwnCfg festivalAwardOwnCfg = (FestivalAwardOwnCfg)sFestivalAwardOwnCfg.festivalAwardOwnCfgs.get(i);
/* 108 */       long startTimeSec = festivalAwardOwnCfg.startTimeSec;
/* 109 */       if (startTimeSec > currentTimeSec) {
/* 110 */         long intervalSec = startTimeSec - currentTimeSec + 1L;
/* 111 */         new FestivalStartSession(intervalSec, festivalAwardOwnCfg.cfgid);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void onFestivalIndexStart(int festivalAwardCfgid) {
/* 117 */     SFestivalAwardOwnCfg sFestivalAwardOwnCfg = getAllFestivalCfg();
/* 118 */     if (sFestivalAwardOwnCfg == null) {
/* 119 */       return;
/*     */     }
/* 121 */     FestivalAwardOwnCfg festivalAwardOwnCfg = null;
/* 122 */     for (FestivalAwardOwnCfg temp : sFestivalAwardOwnCfg.festivalAwardOwnCfgs) {
/* 123 */       if (temp.cfgid == festivalAwardCfgid) {
/* 124 */         festivalAwardOwnCfg = temp;
/* 125 */         break;
/*     */       }
/*     */     }
/* 128 */     if (festivalAwardOwnCfg == null) {
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     FestivalAwardOwnCfg finalAwardOwnCfg = festivalAwardOwnCfg;
/* 133 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 134 */       NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 138 */           FestivalAward xFestivalAward = Role2festivalaward.get(Long.valueOf(this.val$roleid));
/* 139 */           FestivalManager.sendFestivalMail(this.val$roleid, xFestivalAward, this.val$finalAwardOwnCfg);
/* 140 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendFestivalMail(long roleid, FestivalAward xFestivalAward, FestivalAwardOwnCfg festivalAwardCfg)
/*     */   {
/* 148 */     if (xFestivalAward == null) {
/* 149 */       xFestivalAward = xbean.Pod.newFestivalAward();
/* 150 */       Role2festivalaward.insert(Long.valueOf(roleid), xFestivalAward);
/*     */     }
/* 152 */     if (xFestivalAward.getLastestmailawardcfgid() == festivalAwardCfg.cfgid) {
/* 153 */       return;
/*     */     }
/* 155 */     if (festivalAwardCfg.minLevel > 0) {
/* 156 */       int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 157 */       if (roleLevel < festivalAwardCfg.minLevel) {
/* 158 */         return;
/*     */       }
/*     */     }
/* 161 */     xFestivalAward.setLastestmailawardcfgid(festivalAwardCfg.cfgid);
/* 162 */     long endTime = festivalAwardCfg.endTimeSec * 1000L;
/*     */     
/* 164 */     MailInterface.synBuildAndSendMail(roleid, festivalAwardCfg.notifyMailid, new ArrayList(), Arrays.asList(new String[] { festivalAwardCfg.festivalName }), new TLogArg(LogReason.FESTIVAL_NOTIFY_MAIL), endTime);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\festival\main\FestivalManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */