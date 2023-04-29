/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangJinKuCfg;
/*    */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*    */ import xbean.Gang;
/*    */ 
/*    */ 
/*    */ public class JinKu
/*    */   extends AbsGangBuilding
/*    */ {
/*    */   public JinKu(long gangId, int buildingType, Gang xGang)
/*    */   {
/* 13 */     super(gangId, buildingType, xGang);
/*    */   }
/*    */   
/*    */   public long getLevelUpEndTime()
/*    */   {
/* 18 */     return this.xGang.getJinku().getLevelupendtime();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedMoney()
/*    */   {
/* 23 */     SGangJinKuCfg sGangJinKuCfg = SGangJinKuCfg.get(getLevel());
/* 24 */     return sGangJinKuCfg.levelUpNeedMoney;
/*    */   }
/*    */   
/*    */   public int getMaintainMoney()
/*    */   {
/* 29 */     SGangJinKuCfg sGangJinKuCfg = SGangJinKuCfg.get(getLevel());
/* 30 */     return sGangJinKuCfg.maintainCostMoneyPerDay;
/*    */   }
/*    */   
/*    */   public void onGanglevelDown()
/*    */   {
/* 35 */     SGangLevelCfg gangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 36 */     SGangJinKuCfg sGangJinKuCfg = SGangJinKuCfg.get(getLevel());
/* 37 */     if (gangLevelCfg.jinKuMaxLevel <= getLevel()) {
/* 38 */       setLevel(gangLevelCfg.jinKuMaxLevel);
/* 39 */       stopObserver();
/* 40 */       this.xGang.getJinku().setGangmoney(Math.min(sGangJinKuCfg.gangMoneyLimit, this.xGang.getJinku().getGangmoney()));
/*    */     }
/*    */   }
/*    */   
/*    */   public int getLevel()
/*    */   {
/* 46 */     return this.xGang.getJinku().getLevel();
/*    */   }
/*    */   
/*    */   public boolean isMaxLv()
/*    */   {
/* 51 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 52 */     return sGangLevelCfg.jinKuMaxLevel == getLevel();
/*    */   }
/*    */   
/*    */   public int getLevelUpNeedTimeMInCfg()
/*    */   {
/* 57 */     SGangJinKuCfg sGangJinKuCfg = SGangJinKuCfg.get(getLevel());
/* 58 */     return sGangJinKuCfg.levelUpNeedTimeM;
/*    */   }
/*    */   
/*    */   public void setLevelupendtime(long newEndTime)
/*    */   {
/* 63 */     this.xGang.getJinku().setLevelupendtime(newEndTime);
/*    */   }
/*    */   
/*    */   public void setLevel(int newLevel)
/*    */   {
/* 68 */     this.xGang.getJinku().setLevel(newLevel);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\JinKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */