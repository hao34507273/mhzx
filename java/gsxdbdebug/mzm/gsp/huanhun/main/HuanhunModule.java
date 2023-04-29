/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*     */ import mzm.gsp.activity.confbean.SHuanHunMiShuItemCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.item.GetQuality;
/*     */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*     */ import mzm.gsp.item.main.ItemGetQuality;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class HuanhunModule
/*     */   implements Module, PostModuleInitListner
/*     */ {
/*  24 */   private final Logger logger = Logger.getLogger(HuanhunModule.class);
/*     */   
/*     */ 
/*     */ 
/*  28 */   private static Map<Integer, List<Integer>> selectTypeId2itemIdList = new HashMap();
/*     */   
/*     */   private static long lastTimeLength;
/*     */   
/*     */   public static long getLastTimeLength()
/*     */   {
/*  34 */     return lastTimeLength;
/*     */   }
/*     */   
/*     */ 
/*     */   public void postInit()
/*     */   {
/*  40 */     int needRank = HuanHunMiShuConsts.getInstance().COOK_LIANYAO_AWARD_RANK;
/*  41 */     HuanHunArgs huanHunArgs = HuanHunArgs.getInstance();
/*  42 */     for (SHuanHunMiShuItemCfg huanHunMiShuItemCfg : SHuanHunMiShuItemCfg.getAll().values())
/*     */     {
/*  44 */       int huanHunItemType = huanHunMiShuItemCfg.huanHunItemType;
/*     */       
/*     */ 
/*  47 */       if ((huanHunArgs.cookType == huanHunItemType) || (huanHunArgs.lianyaoType == huanHunItemType))
/*     */       {
/*  49 */         SItemSiftCfg sItemSiftCfg = SItemSiftCfg.get(huanHunMiShuItemCfg.selectCfgId);
/*  50 */         List<Integer> itemList = new ArrayList();
/*     */         
/*  52 */         for (IdTypeValueBean bean : sItemSiftCfg.idTypeValueBeans)
/*     */         {
/*  54 */           int itemCfgId = bean.idvalue;
/*  55 */           SItemCfg sItemCfg = ItemInterface.getSItemCfg(itemCfgId);
/*  56 */           GetQuality getQuality = (GetQuality)ItemGetQuality.type2GetQuality.get(Integer.valueOf(sItemCfg.type));
/*  57 */           if (getQuality == null)
/*     */           {
/*  59 */             this.logger.error("还魂解析奖励配置失败,配置的奖励还魂物品类型不匹配！");
/*     */           }
/*     */           else {
/*  62 */             int rank = getQuality.getQuality(itemCfgId);
/*  63 */             if (rank == -1)
/*     */             {
/*  65 */               this.logger.error("还魂解析奖励配置失败,配置的奖励筛选表itemId不存在");
/*     */ 
/*     */ 
/*     */             }
/*  69 */             else if (rank == needRank)
/*     */             {
/*  71 */               itemList.add(Integer.valueOf(itemCfgId));
/*     */             }
/*     */           }
/*     */         }
/*  75 */         if (itemList.size() != 0)
/*     */         {
/*  77 */           selectTypeId2itemIdList.put(Integer.valueOf(huanHunMiShuItemCfg.selectCfgId), itemList);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  82 */     lastTimeLength = getHunTimeLength();
/*  83 */     if (lastTimeLength < 0L)
/*     */     {
/*  85 */       throw new RuntimeException("还魂秘术配置时长错误！活动id:" + HuanHunMiShuConsts.getInstance().ACTIVITYID);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  93 */     HuanHunArgs.init();
/*     */     
/*  95 */     HuanhunInitManager.init();
/*     */     
/*  97 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/* 109 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 115 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getHuanHunAwardId(int selectItemCfgId)
/*     */   {
/* 127 */     return (List)selectTypeId2itemIdList.get(Integer.valueOf(selectItemCfgId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getHunTimeLength()
/*     */   {
/* 137 */     long min = ActivityInterface.getActivityDurationMinute(HuanHunMiShuConsts.getInstance().ACTIVITYID);
/* 138 */     if (min < 0L)
/*     */     {
/* 140 */       return -1L;
/*     */     }
/* 142 */     long mills = min * 1000L;
/* 143 */     return mills;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanhunModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */