/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.gang.SSyncGangMiFangTrigger;
/*     */ import mzm.gsp.gang.SYaoDianInfoRes;
/*     */ import mzm.gsp.gang.confbean.GangMiFangConst;
/*     */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*     */ import mzm.gsp.gang.confbean.SGangMiFangToolsCfgInfo;
/*     */ import mzm.gsp.gang.confbean.SGangYaoDianCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.Gang;
/*     */ import xbean.MiFang;
/*     */ import xdb.Procedure;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ public class YaoDian
/*     */   extends AbsGangBuilding
/*     */ {
/*     */   void init()
/*     */   {
/*  29 */     super.init();
/*  30 */     long endTime = this.xGang.getYaodian().getMifang().getMifangcfgendtime();
/*  31 */     if (endTime > DateTimeUtils.getCurrTimeInMillis()) {
/*  32 */       new MiFangObserver(this.gangId, endTime - DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */   }
/*     */   
/*     */   public YaoDian(long gangId, int buildingType, Gang xGang) {
/*  37 */     super(gangId, buildingType, xGang);
/*     */   }
/*     */   
/*     */   public long getLevelUpEndTime()
/*     */   {
/*  42 */     return this.xGang.getYaodian().getLevelupendtime();
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedMoney()
/*     */   {
/*  47 */     SGangYaoDianCfg sGangYaoDianCfg = SGangYaoDianCfg.get(getLevel());
/*  48 */     return sGangYaoDianCfg.levelUpNeedMoney;
/*     */   }
/*     */   
/*     */   public int getMaintainMoney()
/*     */   {
/*  53 */     SGangYaoDianCfg sGangYaoDianCfg = SGangYaoDianCfg.get(getLevel());
/*  54 */     return sGangYaoDianCfg.maintainCostMoneyPerDay;
/*     */   }
/*     */   
/*     */   public void onGanglevelDown()
/*     */   {
/*  59 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/*  60 */     if (sGangLevelCfg.yaoDianMaxLevel <= getLevel()) {
/*  61 */       setLevel(sGangLevelCfg.yaoDianMaxLevel);
/*  62 */       stopObserver();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/*  68 */     return this.xGang.getYaodian().getLevel();
/*     */   }
/*     */   
/*     */   public boolean isMaxLv()
/*     */   {
/*  73 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/*  74 */     return sGangLevelCfg.yaoDianMaxLevel == getLevel();
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedTimeMInCfg()
/*     */   {
/*  79 */     SGangYaoDianCfg sGangYaoDianCfg = SGangYaoDianCfg.get(getLevel());
/*  80 */     return sGangYaoDianCfg.levelUpNeedTimeM;
/*     */   }
/*     */   
/*     */   public void setLevelupendtime(long newEndTime)
/*     */   {
/*  85 */     this.xGang.getYaodian().setLevelupendtime(newEndTime);
/*     */   }
/*     */   
/*     */   public void setLevel(int newLevel)
/*     */   {
/*  90 */     this.xGang.getYaodian().setLevel(newLevel);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void freshYaoCai()
/*     */   {
/*  97 */     SGangYaoDianCfg cfg = SGangYaoDianCfg.get(getLevel());
/*  98 */     List<Integer> randomIdList = new ArrayList();
/*  99 */     CommonUtils.regionRandom(cfg.itemIdList, cfg.itemKindNum, randomIdList);
/* 100 */     this.xGang.getYaodian().getYaocaimap().clear();
/* 101 */     for (Iterator i$ = randomIdList.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/* 102 */       this.xGang.getYaodian().getYaocaimap().put(Integer.valueOf(id), Integer.valueOf(cfg.itemNum));
/*     */     }
/*     */     
/* 105 */     brocadCastYaoDianYinfo();
/* 106 */     tryTriggerMiYao();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void brocadCastYaoDianYinfo()
/*     */   {
/* 113 */     xbean.YaoDian xYaoDian = this.xGang.getYaodian();
/* 114 */     SYaoDianInfoRes res = new SYaoDianInfoRes();
/* 115 */     GangManager.fillYaoDian(xYaoDian, res.yaodianinfo);
/* 116 */     GangManager.broadcast(this.xGang, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tryTriggerMiYao()
/*     */   {
/* 123 */     if (!PYaoDianMiFangDurationObserver.getInstance().isStart()) {
/* 124 */       return;
/*     */     }
/*     */     
/*     */ 
/* 128 */     if (PYaoDianMiFangDurationObserver.getInstance().isBetween(this.xGang.getYaodian().getMifang().getMifangcfgstarttime())) {
/* 129 */       return;
/*     */     }
/* 131 */     SGangYaoDianCfg cfg = SGangYaoDianCfg.get(getLevel());
/* 132 */     int prop = Xdb.random().nextInt(10000);
/*     */     
/* 134 */     if (prop >= cfg.triggerMiFangProp) {
/* 135 */       return;
/*     */     }
/*     */     
/* 138 */     doInitMiYao();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void doInitMiYao()
/*     */   {
/* 145 */     SGangMiFangToolsCfgInfo miFangCfg = GangManager.randomMiFangCfg(getLevel());
/* 146 */     if (miFangCfg == null) {
/* 147 */       return;
/*     */     }
/* 149 */     List<Integer> musthavItemIdList = ItemInterface.getSamePriceItems(miFangCfg.mustItemSiftId);
/* 150 */     List<Integer> haveItemIdList = ItemInterface.getSamePriceItems(miFangCfg.otherItemSiftId);
/* 151 */     List<Integer> yaoCaiList = randomItemIdList(musthavItemIdList, haveItemIdList, GangMiFangConst.getInstance().NEED_MATERIAL_NUM - 1);
/* 152 */     MiFang xMiFang = this.xGang.getYaodian().getMifang();
/* 153 */     xMiFang.setMifangcfgid(miFangCfg.id);
/* 154 */     xMiFang.getMifangyaocailist().clear();
/* 155 */     xMiFang.getMifangyaocailist().addAll(yaoCaiList);
/* 156 */     xMiFang.setMifangcfgstarttime(DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 158 */     long interval = TimeUnit.MINUTES.toMillis(CommonUtils.random(miFangCfg.lowPersistTimeM, miFangCfg.hightPersistTimeM));
/* 159 */     xMiFang.setMifangcfgendtime(DateTimeUtils.getCurrTimeInMillis() + interval);
/* 160 */     MiFangObserver.stopObserver(this.gangId);
/* 161 */     new MiFangObserver(this.gangId, interval);
/* 162 */     SSyncGangMiFangTrigger sSyncGangMiFangTrigger = new SSyncGangMiFangTrigger();
/* 163 */     sSyncGangMiFangTrigger.cfgid = miFangCfg.id;
/* 164 */     GangManager.broadcast(this.xGang, sSyncGangMiFangTrigger);
/*     */     
/* 166 */     long bangzhuId = this.xGang.getBangzhuid();
/* 167 */     long gangid = this.gangId;
/* 168 */     int gangLevel = this.xGang.getLevel();
/* 169 */     int gangYaoDianLevel = this.xGang.getYaodian().getLevel();
/* 170 */     int mifangcfg = xMiFang.getMifangcfgid();
/* 171 */     long gangDisplayId = this.xGang.getDisplayid();
/*     */     
/* 173 */     Procedure.execute(new PGangMiFangStartTlog(gangid, bangzhuId, gangLevel, gangYaoDianLevel, mifangcfg, gangDisplayId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Integer> randomItemIdList(List<Integer> mustHave, List<Integer> others, int othersNum)
/*     */   {
/* 182 */     List<Integer> randomList = new ArrayList();
/* 183 */     CommonUtils.regionRandom(others, othersNum, randomList);
/* 184 */     int idx = Xdb.random().nextInt(mustHave.size());
/* 185 */     randomList.add(mustHave.get(idx));
/* 186 */     return randomList;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\YaoDian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */