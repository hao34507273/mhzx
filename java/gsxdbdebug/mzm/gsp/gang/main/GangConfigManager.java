/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.gang.confbean.ApplyOldOnlineWeight;
/*     */ import mzm.gsp.gang.confbean.SDesignDutyNameCfg;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.gang.confbean.SGangPayCfg;
/*     */ import mzm.gsp.gang.confbean.SGangTeamConst;
/*     */ import mzm.gsp.gang.confbean.SGangVitalityCfg;
/*     */ import mzm.gsp.gang.confbean.SGangXiangFangCfg;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ 
/*     */ class GangConfigManager
/*     */ {
/*  22 */   private static GangConfigManager instance = new GangConfigManager();
/*     */   
/*     */   static GangConfigManager getInstance() {
/*  25 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean hasManageApplicantsRight(int duty)
/*     */   {
/*  36 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(duty);
/*  37 */     if (dutyCfg == null) {
/*  38 */       return false;
/*     */     }
/*  40 */     return dutyCfg.isCanMgeApplyList;
/*     */   }
/*     */   
/*     */   Set<Integer> getManageApplicantsDuties() {
/*  44 */     Set<Integer> duties = new HashSet();
/*  45 */     for (SGangDutyCfg dutyCfg : SGangDutyCfg.getAll().values()) {
/*  46 */       duties.add(Integer.valueOf(dutyCfg.id));
/*     */     }
/*  48 */     return duties;
/*     */   }
/*     */   
/*     */   Set<Integer> getNormalDuties() {
/*  52 */     Set<Integer> duties = new HashSet(SGangDutyCfg.getAll().keySet());
/*  53 */     duties.remove(Integer.valueOf(SGangConst.getInstance().XUETU_ID));
/*  54 */     return duties;
/*     */   }
/*     */   
/*     */ 
/*     */   int getNormalMemberCapacity(int xiangFangLevel)
/*     */   {
/*  60 */     SGangDutyCfg bangZhongCfg = SGangDutyCfg.get(SGangConst.getInstance().BANGZHONG_ID);
/*  61 */     SGangXiangFangCfg xiangFangCfg = SGangXiangFangCfg.get(xiangFangLevel);
/*  62 */     if (xiangFangCfg == null) {
/*  63 */       return 0;
/*     */     }
/*  65 */     return ((Integer)xiangFangCfg.dutyList.get(bangZhongCfg.dutyLevel - 1)).intValue();
/*     */   }
/*     */   
/*     */   int getXueTuCapacity(int xiangFangLevel)
/*     */   {
/*  70 */     SGangDutyCfg xueTuCfg = SGangDutyCfg.get(SGangConst.getInstance().XUETU_ID);
/*  71 */     SGangXiangFangCfg xiangFangCfg = SGangXiangFangCfg.get(xiangFangLevel);
/*  72 */     if (xiangFangCfg == null) {
/*  73 */       return 0;
/*     */     }
/*  75 */     return ((Integer)xiangFangCfg.dutyList.get(xueTuCfg.dutyLevel - 1)).intValue();
/*     */   }
/*     */   
/*     */   int getGangCapacity(int xiangFangLevel)
/*     */   {
/*  80 */     SGangDutyCfg bangZhongCfg = SGangDutyCfg.get(SGangConst.getInstance().BANGZHONG_ID);
/*  81 */     SGangDutyCfg xueTuCfg = SGangDutyCfg.get(SGangConst.getInstance().XUETU_ID);
/*     */     
/*  83 */     SGangXiangFangCfg xiangFangCfg = SGangXiangFangCfg.get(xiangFangLevel);
/*  84 */     if (xiangFangCfg == null) {
/*  85 */       return 0;
/*     */     }
/*  87 */     return ((Integer)xiangFangCfg.dutyList.get(bangZhongCfg.dutyLevel - 1)).intValue() + ((Integer)xiangFangCfg.dutyList.get(xueTuCfg.dutyLevel - 1)).intValue();
/*     */   }
/*     */   
/*     */   int getDutyCapacity(int xiangFangLevel, int duty)
/*     */   {
/*  92 */     SGangXiangFangCfg xiangFangCfg = SGangXiangFangCfg.get(xiangFangLevel);
/*  93 */     if (xiangFangCfg == null) {
/*  94 */       return 0;
/*     */     }
/*     */     
/*  97 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(duty);
/*  98 */     return ((Integer)xiangFangCfg.dutyList.get(dutyCfg.dutyLevel - 1)).intValue();
/*     */   }
/*     */   
/*     */   String getDutyName(int designDutyCfgId, int duty)
/*     */   {
/* 103 */     SGangDutyCfg dutyCfg = SGangDutyCfg.get(duty);
/* 104 */     if (dutyCfg == null) {
/* 105 */       return null;
/*     */     }
/* 107 */     return getDutyNameByDutyLevel(designDutyCfgId, dutyCfg.dutyLevel);
/*     */   }
/*     */   
/*     */   String getDutyNameByDutyLevel(int designDutyCfgId, int dutyLevel)
/*     */   {
/* 112 */     SDesignDutyNameCfg designDutyCfg = SDesignDutyNameCfg.get(designDutyCfgId);
/* 113 */     if (designDutyCfg == null) {
/* 114 */       return null;
/*     */     }
/* 116 */     return (String)designDutyCfg.dutyNameList.get(dutyLevel - 1);
/*     */   }
/*     */   
/*     */   int getGangPayment(int gangMoney)
/*     */   {
/* 121 */     int payment = 0;
/* 122 */     int lastCeil = 0;
/* 123 */     for (SGangPayCfg payCfg : SGangPayCfg.getAll().values()) {
/* 124 */       int rangeMoney = Math.min(gangMoney, payCfg.gangMoneyCeil) - lastCeil;
/* 125 */       payment = (int)(payment + payCfg.ratio / 10000.0F * rangeMoney);
/* 126 */       if (gangMoney <= payCfg.gangMoneyCeil) {
/*     */         break;
/*     */       }
/*     */     }
/* 130 */     return payment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getAddGangVitalityByActiveNumber(int activeNumber)
/*     */   {
/* 140 */     int addVitality = 0;
/* 141 */     for (SGangVitalityCfg vitalityCfg : SGangVitalityCfg.getAll().values()) {
/* 142 */       if (activeNumber >= vitalityCfg.activeMin) {
/* 143 */         addVitality = vitalityCfg.vitality;
/*     */       }
/*     */     }
/* 146 */     return addVitality;
/*     */   }
/*     */   
/*     */   TreeMap<Integer, Integer> getApplyOldOnlineWeightCfg()
/*     */   {
/* 151 */     TreeMap<Integer, Integer> online2Weight = new TreeMap();
/* 152 */     for (ApplyOldOnlineWeight w : SGangConst.getInstance().applyOldWeights) {
/* 153 */       online2Weight.put(Integer.valueOf(w.online), Integer.valueOf(w.weight));
/*     */     }
/* 155 */     return online2Weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getApplyOldGangIndex(int onlineCount)
/*     */   {
/* 165 */     int index = -1;
/* 166 */     for (ApplyOldOnlineWeight w : SGangConst.getInstance().applyOldWeights) {
/* 167 */       if (onlineCount > w.online) {
/* 168 */         index++;
/*     */       }
/*     */     }
/* 171 */     return index;
/*     */   }
/*     */   
/*     */   ArrayList<Integer> getApplyOldGangWeights()
/*     */   {
/* 176 */     ArrayList<Integer> weights = new ArrayList();
/* 177 */     for (ApplyOldOnlineWeight w : SGangConst.getInstance().applyOldWeights) {
/* 178 */       weights.add(Integer.valueOf(w.weight));
/*     */     }
/* 180 */     return weights;
/*     */   }
/*     */   
/*     */   boolean isGangTeamNameTooLong(String name) {
/* 184 */     return Math.ceil(CommonUtils.getUTF16Length(name) / 2.0D) > SGangTeamConst.getInstance().GangTeamNameLength;
/*     */   }
/*     */   
/*     */   boolean isGangTeamNameLegal(String name) {
/* 188 */     if ((name == null) || (name.isEmpty())) {
/* 189 */       return false;
/*     */     }
/* 191 */     if (name.matches("\\d+")) {
/* 192 */       return false;
/*     */     }
/* 194 */     if (!AvailableStringArgs.getInstance().isStringUsable(name)) {
/* 195 */       return false;
/*     */     }
/* 197 */     if (mzm.gsp.sensitive.main.SensitiveInterface.isNameSensitive(name)) {
/* 198 */       return false;
/*     */     }
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\GangConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */