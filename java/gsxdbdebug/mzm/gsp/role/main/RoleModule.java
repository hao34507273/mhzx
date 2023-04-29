/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.role.main.expression.ExpressionManager;
/*     */ import mzm.gsp.role.moneywatchdog.MoneyWatchDogManager;
/*     */ import mzm.gsp.role.multirank.MultiFightValueRankObserver;
/*     */ import mzm.gsp.role.multirank.MultiRankManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoleModule
/*     */   implements Module, PostModuleInitListner
/*     */ {
/*  19 */   private static final Logger logger = Logger.getLogger(RoleModule.class);
/*  20 */   public static int REFRESH_POINT_ITEM_ID = -1;
/*     */   
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*     */     try
/*     */     {
/*  27 */       RoleCfgArgs.init();
/*  28 */       ExpressionManager.getInstance().init();
/*  29 */       OccupationManager.getInstance().init(envs);
/*  30 */       RoleManager.init(envs);
/*  31 */       RoleManager.getInstance().registerXdbListener();
/*  32 */       RoleVigorManager.getInstance().init();
/*  33 */       PropertyManager.initProperty();
/*  34 */       MoneyWatchDogManager.registerLogreason();
/*     */       
/*  36 */       FightValueRankManager.init();
/*     */       
/*  38 */       NoneRealFightValueRankManager.init();
/*     */       
/*  40 */       RoleLevelRankManager.init();
/*     */       
/*  42 */       NoneRealTimeRoleLevelRankManager.init();
/*     */       
/*  44 */       MultiRankManager.initMFV();
/*     */       
/*     */ 
/*  47 */       int fightValueRankSec = Integer.parseInt(((String)envs.get("fightValueRankSec")).trim());
/*  48 */       new FightValueRankObserver(fightValueRankSec);
/*     */       
/*     */ 
/*  51 */       int mfvRankSec = Integer.parseInt(((String)envs.get("multiFightValueRankSec")).trim());
/*  52 */       new MultiFightValueRankObserver(mfvRankSec);
/*     */       
/*  54 */       logger.info("初始化职业数据成功");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  58 */       logger.error("初始化职业配置数据出错！");
/*  59 */       throw new RuntimeException(e);
/*     */     }
/*  61 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  67 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  73 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  79 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/*  85 */     for (SItemCfg cfg : SItemCfg.getAll().values())
/*     */     {
/*  87 */       if (cfg.type == 10)
/*     */       {
/*  89 */         REFRESH_POINT_ITEM_ID = cfg.id;
/*  90 */         break;
/*     */       }
/*     */     }
/*  93 */     if (REFRESH_POINT_ITEM_ID == -1)
/*     */     {
/*  95 */       throw new RuntimeException("未找到洗点道具!");
/*     */     }
/*  97 */     OccupationManager.getInstance().postInit();
/*  98 */     RoleVigorManager.postInit();
/*     */     
/* 100 */     new KeepAliveObserver();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\RoleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */