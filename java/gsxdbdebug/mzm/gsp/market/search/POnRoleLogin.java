/*     */ package mzm.gsp.market.search;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.market.EquipConditions;
/*     */ import mzm.gsp.market.PetConditions;
/*     */ import mzm.gsp.market.PetEquipConditions;
/*     */ import mzm.gsp.market.SAllCustomizedConditionsRes;
/*     */ import xbean.CustommizedCons;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  20 */     CustommizedCons xCustommizedCons = xtable.Role2customized.get((Long)this.arg);
/*  21 */     SAllCustomizedConditionsRes res = new SAllCustomizedConditionsRes();
/*     */     
/*  23 */     if (xCustommizedCons == null)
/*     */     {
/*  25 */       mzm.gsp.online.main.OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/*  26 */       return true;
/*     */     }
/*  28 */     CustomizedConditionManager.getInstance().removeRoleTimeOutConditions(xCustommizedCons, now);
/*     */     
/*  30 */     for (Iterator i$ = xCustommizedCons.getSubid2equipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/*  32 */       xbean.MarketEquipConSet xMarketEquipConSet = (xbean.MarketEquipConSet)xCustommizedCons.getSubid2equipcons().get(Integer.valueOf(subid));
/*     */       
/*  34 */       for (int i = 0; i < xMarketEquipConSet.getEquipcons().size(); i++)
/*     */       {
/*  36 */         xbean.MarketEquipCon xMarketEquipCon = (xbean.MarketEquipCon)xMarketEquipConSet.getEquipcons().get(i);
/*     */         
/*  38 */         EquipCondition equipCondition = MarketSearcherManager.getEquipConditionFromXbean(xMarketEquipCon);
/*     */         
/*  40 */         CustomizedConditionManager.getInstance().addEquipConditionRoleId(subid, equipCondition, ((Long)this.arg).longValue());
/*     */         
/*  42 */         EquipConditions equipConditions = (EquipConditions)res.subid2equipcons.get(Integer.valueOf(subid));
/*  43 */         if (equipConditions == null)
/*     */         {
/*  45 */           equipConditions = new EquipConditions();
/*  46 */           res.subid2equipcons.put(Integer.valueOf(subid), equipConditions);
/*     */         }
/*     */         
/*  49 */         equipConditions.equipcons.add(MarketSearcherManager.getEquipConditionFromXbean(subid, xMarketEquipCon));
/*     */         
/*  51 */         if (!mzm.gsp.market.main.MarketInterface.isMarketCustomizedSwitchOpenForRole(((Long)this.arg).longValue()))
/*     */         {
/*  53 */           equipConditions.conditionstate.add(Integer.valueOf(2));
/*     */ 
/*     */ 
/*     */         }
/*  57 */         else if (!EquipConditionManager.getInstance().siftByCondition(subid, equipCondition, true).isEmpty())
/*     */         {
/*     */ 
/*  60 */           equipConditions.conditionstate.add(Integer.valueOf(0));
/*     */ 
/*     */         }
/*  63 */         else if (!EquipConditionManager.getInstance().siftByCondition(subid, equipCondition, false).isEmpty())
/*     */         {
/*  65 */           equipConditions.conditionstate.add(Integer.valueOf(1));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*  70 */           equipConditions.conditionstate.add(Integer.valueOf(2));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     for (Iterator i$ = xCustommizedCons.getSubid2petequipcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/*  80 */       xbean.MarketPetEquipConSet xMarketPetEquipConSet = (xbean.MarketPetEquipConSet)xCustommizedCons.getSubid2petequipcons().get(Integer.valueOf(subid));
/*     */       
/*  82 */       for (int i = 0; i < xMarketPetEquipConSet.getPetequipcons().size(); i++)
/*     */       {
/*     */ 
/*  85 */         xbean.MarketPetEquipCon xMarketPetEquipCon = (xbean.MarketPetEquipCon)xMarketPetEquipConSet.getPetequipcons().get(i);
/*  86 */         PetEquipCondition petEquipCondition = MarketSearcherManager.getPetEquipConditionFromXbean(xMarketPetEquipCon);
/*  87 */         CustomizedConditionManager.getInstance().addPetEquipConditionRoleId(subid, petEquipCondition, ((Long)this.arg).longValue());
/*     */         
/*  89 */         PetEquipConditions petEquipConditions = (PetEquipConditions)res.subid2petequipcons.get(Integer.valueOf(subid));
/*  90 */         if (petEquipConditions == null)
/*     */         {
/*  92 */           petEquipConditions = new PetEquipConditions();
/*  93 */           res.subid2petequipcons.put(Integer.valueOf(subid), petEquipConditions);
/*     */         }
/*  95 */         petEquipConditions.petequipcons.add(MarketSearcherManager.getPetEquipConditionFromXbean(subid, xMarketPetEquipCon));
/*     */         
/*  97 */         if (!mzm.gsp.market.main.MarketInterface.isMarketCustomizedSwitchOpenForRole(((Long)this.arg).longValue()))
/*     */         {
/*  99 */           petEquipConditions.conditionstate.add(Integer.valueOf(2));
/*     */ 
/*     */ 
/*     */         }
/* 103 */         else if (!PetEquipConditionManager.getInstance().siftByCondition(subid, petEquipCondition, true).isEmpty())
/*     */         {
/* 105 */           petEquipConditions.conditionstate.add(Integer.valueOf(0));
/*     */         }
/* 107 */         else if (!PetEquipConditionManager.getInstance().siftByCondition(subid, petEquipCondition, false).isEmpty())
/*     */         {
/* 109 */           petEquipConditions.conditionstate.add(Integer.valueOf(1));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 114 */           petEquipConditions.conditionstate.add(Integer.valueOf(2));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 121 */     for (Iterator i$ = xCustommizedCons.getSubid2petcons().keySet().iterator(); i$.hasNext();) { int subid = ((Integer)i$.next()).intValue();
/*     */       
/* 123 */       xbean.MarketPetConSet xMarketPetConSet = (xbean.MarketPetConSet)xCustommizedCons.getSubid2petcons().get(Integer.valueOf(subid));
/*     */       
/* 125 */       for (int i = 0; i < xMarketPetConSet.getPetcons().size(); i++)
/*     */       {
/* 127 */         xbean.MarketPetCon xMarketPetCon = (xbean.MarketPetCon)xMarketPetConSet.getPetcons().get(i);
/*     */         
/* 129 */         PetCondition petCondition = MarketSearcherManager.getPetConditionFromXbean(xMarketPetCon);
/*     */         
/* 131 */         CustomizedConditionManager.getInstance().addPetConditionRoleId(subid, petCondition, ((Long)this.arg).longValue());
/*     */         
/* 133 */         PetConditions petConditions = (PetConditions)res.subid2petcons.get(Integer.valueOf(subid));
/* 134 */         if (petConditions == null)
/*     */         {
/* 136 */           petConditions = new PetConditions();
/* 137 */           res.subid2petcons.put(Integer.valueOf(subid), petConditions);
/*     */         }
/* 139 */         petConditions.petcons.add(MarketSearcherManager.getPetConditionFromXbean(subid, xMarketPetCon));
/* 140 */         if (!mzm.gsp.market.main.MarketInterface.isMarketCustomizedSwitchOpenForRole(((Long)this.arg).longValue()))
/*     */         {
/* 142 */           petConditions.conditionstate.add(Integer.valueOf(2));
/*     */ 
/*     */ 
/*     */         }
/* 146 */         else if (!PetConditionManager.getInstance().siftByCondition(subid, petCondition, true).isEmpty())
/*     */         {
/* 148 */           petConditions.conditionstate.add(Integer.valueOf(0));
/*     */         }
/* 150 */         else if (!PetConditionManager.getInstance().siftByCondition(subid, petCondition, false).isEmpty())
/*     */         {
/* 152 */           petConditions.conditionstate.add(Integer.valueOf(1));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 157 */           petConditions.conditionstate.add(Integer.valueOf(2));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 163 */     mzm.gsp.online.main.OnlineManager.getInstance().send(((Long)this.arg).longValue(), res);
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */