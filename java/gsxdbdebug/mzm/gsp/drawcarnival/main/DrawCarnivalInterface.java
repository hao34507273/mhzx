/*     */ package mzm.gsp.drawcarnival.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.drawcarnival.SBroadcastYuanBaoChangeInfo;
/*     */ import mzm.gsp.drawcarnival.confbean.SOrigDrawCarnivalSpreadWealthCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.DrawCarnivalActivityInfo;
/*     */ import xbean.DrawCarnivalGlobalInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DrawCarnivalInterface
/*     */ {
/*     */   public static boolean setJackPot(long count)
/*     */   {
/*  23 */     if (count < 0L)
/*     */     {
/*  25 */       return false;
/*     */     }
/*     */     
/*  28 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/*     */     
/*  30 */     xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(count);
/*     */     
/*  32 */     SBroadcastYuanBaoChangeInfo sBroadcastYuanBaoChangeInfo = new SBroadcastYuanBaoChangeInfo();
/*  33 */     sBroadcastYuanBaoChangeInfo.award_pool_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/*  34 */     OnlineManager.getInstance().sendAll(sBroadcastYuanBaoChangeInfo);
/*     */     
/*  36 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getJackPot()
/*     */   {
/*  46 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/*  47 */     return xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
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
/*     */   public static int setExtraRate(int activityId, int passTypeId, int rate)
/*     */   {
/*  61 */     if (rate < 0)
/*     */     {
/*  63 */       return 63954;
/*     */     }
/*     */     
/*  66 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/*  67 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/*  69 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/*     */ 
/*  72 */       return 63956;
/*     */     }
/*     */     
/*  75 */     Map<Integer, Integer> xPassTypeId2extraRate = xDrawCarnivalActivityInfo.getPass_type_id2extra_rate_per_pass();
/*     */     
/*  77 */     Integer xExtraRate = (Integer)xPassTypeId2extraRate.get(Integer.valueOf(passTypeId));
/*  78 */     if ((xExtraRate == null) && (passTypeId != -1))
/*     */     {
/*  80 */       return 63955;
/*     */     }
/*     */     Iterator i$;
/*  83 */     if (passTypeId == -1)
/*     */     {
/*  85 */       for (i$ = xPassTypeId2extraRate.keySet().iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*     */         
/*  87 */         xPassTypeId2extraRate.put(Integer.valueOf(key), Integer.valueOf(rate));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/*  92 */       xPassTypeId2extraRate.put(Integer.valueOf(passTypeId), Integer.valueOf(rate));
/*     */     }
/*     */     
/*  95 */     return 0;
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
/*     */   public static String getExtraRate(int activityId, int passTypeId)
/*     */   {
/* 108 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 109 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 111 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/* 113 */       return null;
/*     */     }
/*     */     
/* 116 */     Map<Integer, Integer> xPassTypeId2extraRate = xDrawCarnivalActivityInfo.getPass_type_id2extra_rate_per_pass();
/*     */     
/* 118 */     Integer xExtraRate = (Integer)xPassTypeId2extraRate.get(Integer.valueOf(passTypeId));
/* 119 */     if ((xExtraRate == null) && (passTypeId != -1))
/*     */     {
/* 121 */       return null;
/*     */     }
/*     */     
/* 124 */     if (passTypeId == -1)
/*     */     {
/* 126 */       return xPassTypeId2extraRate.toString();
/*     */     }
/* 128 */     return String.valueOf(xExtraRate);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int setActivityAmt(int activityId, long count)
/*     */   {
/* 140 */     if (count < 0L)
/*     */     {
/* 142 */       return 63954;
/*     */     }
/*     */     
/* 145 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 146 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 148 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/*     */ 
/* 151 */       return 63956;
/*     */     }
/*     */     
/* 154 */     xDrawCarnivalActivityInfo.setAccumulate_yuan_bao_cost_count(count);
/* 155 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getActivityAmt(int activityId)
/*     */   {
/* 166 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 167 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 169 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/*     */ 
/* 172 */       return -1580L;
/*     */     }
/* 174 */     return xDrawCarnivalActivityInfo.getAccumulate_yuan_bao_cost_count();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int setActivityBigAwardCount(int activityId, int count)
/*     */   {
/* 186 */     if (count < 0)
/*     */     {
/* 188 */       return 63954;
/*     */     }
/*     */     
/* 191 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 192 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 194 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/* 196 */       return 63956;
/*     */     }
/* 198 */     xDrawCarnivalActivityInfo.setBig_award_count(count);
/* 199 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getActivityBigAwardCount(int activityId)
/*     */   {
/* 210 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 211 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 213 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/* 215 */       return 63956;
/*     */     }
/* 217 */     return xDrawCarnivalActivityInfo.getBig_award_count();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addJackPot(long count)
/*     */   {
/* 228 */     if (count <= 0L)
/*     */     {
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/*     */     
/* 235 */     xDrawCarnivalGlobalInfo.setAward_pool_yuan_bao_count(xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count() + count);
/*     */     
/* 237 */     SBroadcastYuanBaoChangeInfo sBroadcastYuanBaoChangeInfo = new SBroadcastYuanBaoChangeInfo();
/* 238 */     sBroadcastYuanBaoChangeInfo.award_pool_yuan_bao_count = xDrawCarnivalGlobalInfo.getAward_pool_yuan_bao_count();
/* 239 */     OnlineManager.getInstance().sendAll(sBroadcastYuanBaoChangeInfo);
/*     */     
/* 241 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getChestCount(int activityId, int randomTypeId)
/*     */   {
/* 253 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 254 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 256 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/* 258 */       return 63956;
/*     */     }
/* 260 */     Integer chestCount = (Integer)xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().get(Integer.valueOf(randomTypeId));
/* 261 */     if (chestCount == null)
/*     */     {
/* 263 */       return 0;
/*     */     }
/* 265 */     return chestCount.intValue();
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
/*     */   public static int setChestCount(int activityId, int randomTypeId, int chestCount)
/*     */   {
/* 278 */     if (chestCount < 0)
/*     */     {
/* 280 */       return 63954;
/*     */     }
/* 282 */     DrawCarnivalGlobalInfo xDrawCarnivalGlobalInfo = DrawCarnivalManager.getDrawCarnivalGlobalInfoCreateIfNotExist();
/* 283 */     DrawCarnivalActivityInfo xDrawCarnivalActivityInfo = (DrawCarnivalActivityInfo)xDrawCarnivalGlobalInfo.getActivity_id2info().get(Integer.valueOf(activityId));
/*     */     
/* 285 */     if (xDrawCarnivalActivityInfo == null)
/*     */     {
/* 287 */       return 63956;
/*     */     }
/* 289 */     xDrawCarnivalActivityInfo.getRandom_type_id2chest_count().put(Integer.valueOf(randomTypeId), Integer.valueOf(chestCount));
/*     */     
/* 291 */     SOrigDrawCarnivalSpreadWealthCfg sOrigDrawCarnivalSpreadWealthCfg = SOrigDrawCarnivalSpreadWealthCfg.get(randomTypeId);
/*     */     
/* 293 */     if (sOrigDrawCarnivalSpreadWealthCfg == null)
/*     */     {
/* 295 */       return 63954;
/*     */     }
/* 297 */     ControllerInterface.collectWorldController(1L, sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId);
/*     */     
/*     */ 
/* 300 */     ControllerInterface.triggerWorldControllerWithMaxSpawnNum(1L, sOrigDrawCarnivalSpreadWealthCfg.spreadWealthControllerId, chestCount);
/*     */     
/* 302 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */