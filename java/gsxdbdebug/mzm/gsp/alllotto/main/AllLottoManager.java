/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AllLottoManager
/*     */ {
/*  19 */   static volatile boolean postInitFlag = false;
/*     */   
/*     */   static final String ROLE_ID = "roleid";
/*     */   
/*     */   static final String ROLE_NAME = "role_name";
/*     */   static final String OCCUPATION = "occupation";
/*     */   static final String GENDER = "gender";
/*     */   static final String LEVEL = "level";
/*     */   static final String AVATAR_ID = "avatarid";
/*     */   static final String AVATAR_FRAME_ID = "avatar_frameid";
/*     */   static final int INITIAL_CANDIDATE_LEVEL = 0;
/*  30 */   static int MAX_LOG_NUM = 1000;
/*  31 */   static int SEND_AWARD_DELAY_IN_SECOND = 60;
/*  32 */   static int TURN_PROTECT_DURATION_IN_SECOND = 300;
/*  33 */   static int GRC_MIN_DELAY_IN_SECOND = 180;
/*  34 */   static int GRC_MAX_DELAY_IN_SECOND = 300;
/*     */   
/*     */   static void init()
/*     */   {
/*  38 */     ActivityInterface.registerActivityByLogicType(136, new AllLottoActivityHandler());
/*     */   }
/*     */   
/*     */   static void postInit()
/*     */   {
/*  43 */     postInitFlag = true;
/*  44 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  46 */       return;
/*     */     }
/*  48 */     for (Iterator i$ = SAllLottoCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  50 */       new PCheckAndGetAwardRoleInfo(activityCfgid).call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAllLottoSwitchOpen()
/*     */   {
/*  61 */     if (!OpenInterface.getOpenStatus(537))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isAllLottoSwitchOpenForRole(long roleid)
/*     */   {
/*  76 */     if (!OpenInterface.getOpenStatus(537))
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     if (OpenInterface.isBanPlay(roleid, 537))
/*     */     {
/*  82 */       OpenInterface.sendBanPlayMsg(roleid, 537);
/*  83 */       return false;
/*     */     }
/*  85 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getFixAwardItemCfgid(long roleid, int fixAwardid)
/*     */   {
/*  97 */     if (fixAwardid <= 0)
/*     */     {
/*  99 */       return 0;
/*     */     }
/* 101 */     List<Integer> itemCfgids = AwardInterface.getFixAwardItems(roleid, fixAwardid);
/* 102 */     if ((itemCfgids == null) || (itemCfgids.isEmpty()))
/*     */     {
/* 104 */       return 0;
/*     */     }
/* 106 */     return ((Integer)itemCfgids.get(0)).intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */