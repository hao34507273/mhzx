/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*    */ import mzm.gsp.gang.confbean.SGangShuyuanCfg;
/*    */ import xbean.Gang;
/*    */ 
/*    */ 
/*    */ public class ShuYuan
/*    */   extends AbsGangBuilding
/*    */ {
/*    */   public ShuYuan(long gangId, int buildingType, Gang xGang)
/*    */   {
/* 13 */     super(gangId, buildingType, xGang);
/*    */   }
/*    */   
/*    */   public long getLevelUpEndTime()
/*    */   {
/* 18 */     return this.xGang.getShuyuan().getLevelupendtime();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedMoney()
/*    */   {
/* 23 */     SGangShuyuanCfg sGangShuyuanCfg = SGangShuyuanCfg.get(getLevel());
/* 24 */     return sGangShuyuanCfg.levelUpNeedMoney;
/*    */   }
/*    */   
/*    */   public int getMaintainMoney()
/*    */   {
/* 29 */     SGangShuyuanCfg sGangShuyuanCfg = SGangShuyuanCfg.get(getLevel());
/* 30 */     return sGangShuyuanCfg.maintainNeedMoney;
/*    */   }
/*    */   
/*    */   public void onGanglevelDown()
/*    */   {
/* 35 */     SGangLevelCfg gangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 36 */     if (gangLevelCfg.shuYuanMaxLevel <= getLevel()) {
/* 37 */       setLevel(gangLevelCfg.shuYuanMaxLevel);
/* 38 */       stopObserver();
/*    */     }
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 44 */     return this.xGang.getShuyuan().getLevel();
/*    */   }
/*    */   
/*    */   public boolean isMaxLv()
/*    */   {
/* 49 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 50 */     return sGangLevelCfg.shuYuanMaxLevel == getLevel();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedTimeMInCfg()
/*    */   {
/* 55 */     SGangShuyuanCfg sGangShuyuanCfg = SGangShuyuanCfg.get(getLevel());
/* 56 */     return sGangShuyuanCfg.levelUpNeedMin;
/*    */   }
/*    */   
/*    */   public void setLevelupendtime(long newEndTime)
/*    */   {
/* 61 */     this.xGang.getShuyuan().setLevelupendtime(newEndTime);
/*    */   }
/*    */   
/*    */   public void setLevel(int newLevel)
/*    */   {
/* 66 */     this.xGang.getShuyuan().setLevel(newLevel);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\ShuYuan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */