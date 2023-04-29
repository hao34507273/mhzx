/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangCangKuCfg;
/*    */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*    */ import xbean.Gang;
/*    */ 
/*    */ 
/*    */ public class CangKu
/*    */   extends AbsGangBuilding
/*    */ {
/*    */   public CangKu(long gangId, int buildingType, Gang xGang)
/*    */   {
/* 13 */     super(gangId, buildingType, xGang);
/*    */   }
/*    */   
/*    */   public long getLevelUpEndTime()
/*    */   {
/* 18 */     return this.xGang.getCangku().getLevelupendtime();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedMoney()
/*    */   {
/* 23 */     SGangCangKuCfg sGangLevelCfg = SGangCangKuCfg.get(getLevel());
/* 24 */     return sGangLevelCfg.levelUpNeedMoney;
/*    */   }
/*    */   
/*    */   public int getMaintainMoney()
/*    */   {
/* 29 */     SGangCangKuCfg sGangCangKuCfg = SGangCangKuCfg.get(getLevel());
/* 30 */     return sGangCangKuCfg.maintainCostMoneyPerDay;
/*    */   }
/*    */   
/*    */   public void onGanglevelDown()
/*    */   {
/* 35 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 36 */     if (sGangLevelCfg.cangKuMaxLevel <= getLevel()) {
/* 37 */       setLevel(sGangLevelCfg.cangKuMaxLevel);
/* 38 */       stopObserver();
/*    */     }
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 44 */     return this.xGang.getCangku().getLevel();
/*    */   }
/*    */   
/*    */   public boolean isMaxLv()
/*    */   {
/* 49 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 50 */     return sGangLevelCfg.cangKuMaxLevel == getLevel();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedTimeMInCfg()
/*    */   {
/* 55 */     SGangCangKuCfg sGangCangKuCfg = SGangCangKuCfg.get(getLevel());
/* 56 */     return sGangCangKuCfg.levelUpNeedTimeM;
/*    */   }
/*    */   
/*    */   public void setLevelupendtime(long newEndTime)
/*    */   {
/* 61 */     this.xGang.getCangku().setLevelupendtime(newEndTime);
/*    */   }
/*    */   
/*    */   public void setLevel(int newLevel)
/*    */   {
/* 66 */     this.xGang.getCangku().setLevel(newLevel);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\CangKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */