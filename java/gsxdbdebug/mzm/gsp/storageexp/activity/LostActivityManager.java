/*     */ package mzm.gsp.storageexp.activity;
/*     */ 
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.bounty.main.BountyInterface;
/*     */ import mzm.gsp.jingji.main.JingjiInterface;
/*     */ import mzm.gsp.question.main.QYXTQuestionActivity;
/*     */ import mzm.gsp.question.main.QuestionInterface;
/*     */ import mzm.gsp.seasontask.main.SeasonTaskInterface;
/*     */ import mzm.gsp.shimen.main.ShimenInterface;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SLuanShiYaoMoConsts;
/*     */ import mzm.gsp.visiblemonsterfight.main.LuanShiYaoMoActivity;
/*     */ import mzm.gsp.zhenyao.main.ZhenyaoInterface;
/*     */ 
/*     */ public class LostActivityManager
/*     */ {
/*  16 */   private static final LostActivityManager instance = new LostActivityManager();
/*     */   
/*     */   public static LostActivityManager getInstance()
/*     */   {
/*  20 */     return instance;
/*     */   }
/*     */   
/*     */   public void rgAllActivityHandler()
/*     */   {
/*  25 */     LostAwardManager.rgActivityHandler(QYXTQuestionActivity.getQYXTActivityCfgId(), new QYXTHandler());
/*  26 */     LostAwardManager.rgActivityHandler(BountyInterface.getBountyActivityId(), new BountyHandler());
/*  27 */     LostAwardManager.rgActivityHandler(SeasonTaskInterface.getSeasonSingleActivityId(), new SingleSeasonHandler());
/*  28 */     LostAwardManager.rgActivityHandler(JingjiActivityCfgConsts.getInstance().ACTIVITYID, new JingjiHandler());
/*  29 */     LostAwardManager.rgActivityHandler(SLuanShiYaoMoConsts.getInstance().ACTIVITYID, new KillLuanShiYaoMoHandler());
/*  30 */     LostAwardManager.rgActivityHandler(QuestionInterface.getZhuXianQiYuanActivityId(), new ZhuXianQiYuanHandler());
/*  31 */     LostAwardManager.rgActivityHandler(ShimenInterface.getShimenActivityId(), new ShiMenHandler());
/*  32 */     LostAwardManager.rgActivityHandler(ZhenyaoInterface.getZhenYaoActivityId(), new ZhenYaoHandler());
/*     */   }
/*     */   
/*     */   class QYXTHandler implements ActivityLostExpHandler
/*     */   {
/*     */     QYXTHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/*  41 */       return QYXTQuestionActivity.getActivityCount2StorageExp(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/*  47 */       return QYXTQuestionActivity.getCanGetStorageExp(roleId, 0);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/*  53 */       return "青云学堂";
/*     */     }
/*     */   }
/*     */   
/*     */   class BountyHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     BountyHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/*  64 */       return BountyInterface.getOneBountyCanGetStorageExp(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/*  70 */       return BountyInterface.getSingleCircleCanGetStorageExp(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/*  76 */       return "赏金猎人";
/*     */     }
/*     */   }
/*     */   
/*     */   class SingleSeasonHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     SingleSeasonHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/*  87 */       return SeasonTaskInterface.getSingleCountStorageExp(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/*  93 */       return SeasonTaskInterface.getAllSingleStorageExp(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/*  99 */       return "夏日单人";
/*     */     }
/*     */   }
/*     */   
/*     */   class JingjiHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     JingjiHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/* 110 */       return JingjiInterface.getExpByRing(roleId, false);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/* 116 */       return JingjiInterface.getCanGetStorageExp(roleId, 0);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/* 122 */       return "竞技场";
/*     */     }
/*     */   }
/*     */   
/*     */   class KillLuanShiYaoMoHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     KillLuanShiYaoMoHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/* 133 */       return LuanShiYaoMoActivity.getStoreExp(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/* 139 */       return LuanShiYaoMoActivity.getStoreExpOneTurn(roleId, 1);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/* 145 */       return "乱世妖魔";
/*     */     }
/*     */   }
/*     */   
/*     */   class ZhuXianQiYuanHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     ZhuXianQiYuanHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/* 156 */       return QuestionInterface.getExpByRing(roleId, false);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/* 162 */       return QuestionInterface.getCanGetStorageExp(roleId, 0);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/* 168 */       return "诛仙奇缘";
/*     */     }
/*     */   }
/*     */   
/*     */   class ShiMenHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     ShiMenHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/* 179 */       return ShimenInterface.getShimeExpByRing(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/* 185 */       return ShimenInterface.getCanGetStorageExp(roleId, 0);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/* 191 */       return "师门";
/*     */     }
/*     */   }
/*     */   
/*     */   class ZhenYaoHandler
/*     */     implements ActivityLostExpHandler
/*     */   {
/*     */     ZhenYaoHandler() {}
/*     */     
/*     */     public int getCanGetStorageExpValue(long roleId, int activiyId, int activityLittleNum)
/*     */     {
/* 202 */       return ZhenyaoInterface.getZhenyaoExpByRing(roleId, activityLittleNum);
/*     */     }
/*     */     
/*     */ 
/*     */     public int getAllStorageExpValue(long roleId, int activityId)
/*     */     {
/* 208 */       return ZhenyaoInterface.getCanGetStorageExp(roleId, 0);
/*     */     }
/*     */     
/*     */ 
/*     */     public String getActivityCHNName()
/*     */     {
/* 214 */       return "镇妖";
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\LostActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */