/*    */ package mzm.gsp.husong.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Random;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*    */ import mzm.gsp.activity.confbean.SHuSongConst;
/*    */ import mzm.gsp.activity.confbean.SHuSongMoneyCfg;
/*    */ import mzm.gsp.activity.confbean.SHuSongType2Cfgid;
/*    */ import mzm.gsp.activity.confbean.SHuSongType2MoneyCfgid;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ import mzm.gsp.item.main.access.ItemAccessManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ class HuSongCfgManager
/*    */ {
/*    */   static final int RATE = 10000;
/*    */   
/*    */   static void init()
/*    */   {
/* 24 */     mzm.gsp.activity.main.ActivityInterface.registerActivityByLogicType(5, new HusongActivityHandler());
/*    */     
/* 26 */     ActivityCompensateInterface.registerCompensateHandler(5, new HuSongCompensateHandler());
/*    */     
/*    */ 
/*    */ 
/* 30 */     int activityid = SHuSongConst.getInstance().activity;
/* 31 */     for (SHuSongCfg cfg : SHuSongCfg.getAll().values())
/*    */     {
/* 33 */       ItemAccessManager.registerActivityReward(activityid, cfg.awardid);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static SHuSongMoneyCfg getHuSongMoneyCfgByLevelType(int level, int type)
/*    */   {
/* 47 */     Set<Integer> moneyCfgids = SHuSongType2MoneyCfgid.get(type).moneyCfgids;
/* 48 */     for (Iterator i$ = moneyCfgids.iterator(); i$.hasNext();) { int moneycfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 50 */       SHuSongMoneyCfg huSongMoneyCfg = SHuSongMoneyCfg.get(moneycfgid);
/* 51 */       if ((huSongMoneyCfg.levelMax >= level) && (huSongMoneyCfg.levelMin <= level))
/*    */       {
/* 53 */         return huSongMoneyCfg;
/*    */       }
/*    */     }
/* 56 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static SHuSongCfg randomHuSongCfg(int type)
/*    */   {
/* 67 */     List<Integer> husongCfgids = SHuSongType2Cfgid.get(type).cfgids;
/* 68 */     int random = Xdb.random().nextInt(husongCfgids.size());
/* 69 */     int id = ((Integer)husongCfgids.get(random)).intValue();
/* 70 */     return SHuSongCfg.get(id);
/*    */   }
/*    */   
/*    */   static int getHusongFightSec()
/*    */   {
/* 75 */     int interval = SHuSongConst.getInstance().maxFightTime - SHuSongConst.getInstance().minFightTime;
/* 76 */     if (interval > 0)
/*    */     {
/* 78 */       interval = Xdb.random().nextInt(interval + 1) + SHuSongConst.getInstance().minFightTime;
/*    */     }
/*    */     else
/*    */     {
/* 82 */       interval = Math.max(SHuSongConst.getInstance().minFightTime, 1);
/*    */     }
/* 84 */     return interval;
/*    */   }
/*    */   
/*    */   static void postInit()
/*    */   {
/* 89 */     for (SHuSongCfg huSongCfg : SHuSongCfg.getAll().values())
/*    */     {
/* 91 */       if (!MapInterface.isNpcExist(huSongCfg.handupNPCid))
/*    */       {
/* 93 */         throw new RuntimeException("配置的护送到达npc没有配置在地图上,npcid:" + huSongCfg.handupNPCid);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */