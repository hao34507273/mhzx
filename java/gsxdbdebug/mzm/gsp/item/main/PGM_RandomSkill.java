/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.item.confbean.EquipSkillWeight;
/*     */ import mzm.gsp.item.confbean.SEquipSkillCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PGM_RandomSkill
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long gmRoleId;
/*     */   private final int itemid;
/*     */   private final int num;
/*     */   private final int skillid1;
/*     */   private final int skillid2;
/*     */   
/*     */   public PGM_RandomSkill(long gmRoleId, int itemid, int num, int skillid1, int skillid2)
/*     */   {
/*  31 */     this.gmRoleId = gmRoleId;
/*  32 */     this.itemid = itemid;
/*  33 */     this.num = num;
/*  34 */     this.skillid1 = skillid1;
/*  35 */     this.skillid2 = skillid2;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     Map<Integer, Integer> conf_skillid2rateMap = new HashMap();
/*  43 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(this.itemid);
/*     */     
/*  45 */     if (sItemEquipCfg == null)
/*     */     {
/*  47 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d不是装备，随机测试失败", new Object[] { Integer.valueOf(this.itemid) }));
/*  48 */       return false;
/*     */     }
/*  50 */     SEquipSkillCfg cfg = SEquipSkillCfg.get(sItemEquipCfg.skillid);
/*  51 */     if ((cfg == null) || (cfg.skills.isEmpty()))
/*     */     {
/*  53 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("物品%d没有可以随机的技能，随机测试失败", new Object[] { Integer.valueOf(this.itemid) }));
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     for (int i = 0; i < cfg.skills.size(); i++)
/*     */     {
/*  59 */       if (i == 0)
/*     */       {
/*  61 */         conf_skillid2rateMap.put(Integer.valueOf(((EquipSkillWeight)cfg.skills.get(i)).skillid), Integer.valueOf(((EquipSkillWeight)cfg.skills.get(i)).weight));
/*     */       }
/*     */       else
/*     */       {
/*  65 */         conf_skillid2rateMap.put(Integer.valueOf(((EquipSkillWeight)cfg.skills.get(i)).skillid), Integer.valueOf(((EquipSkillWeight)cfg.skills.get(i)).weight - ((EquipSkillWeight)cfg.skills.get(i - 1)).weight));
/*     */       }
/*     */     }
/*     */     
/*  69 */     Set<Integer> toRemoveSkillIntegers = new HashSet();
/*  70 */     if (this.skillid1 != -1)
/*     */     {
/*  72 */       boolean ret = isSkillRight(cfg, this.skillid1);
/*  73 */       if (!ret)
/*     */       {
/*  75 */         return false;
/*     */       }
/*  77 */       toRemoveSkillIntegers.add(Integer.valueOf(this.skillid1));
/*  78 */       conf_skillid2rateMap.remove(Integer.valueOf(this.skillid1));
/*     */     }
/*  80 */     if (this.skillid2 != -1)
/*     */     {
/*  82 */       boolean ret = isSkillRight(cfg, this.skillid2);
/*  83 */       if (!ret)
/*     */       {
/*  85 */         return false;
/*     */       }
/*  87 */       toRemoveSkillIntegers.add(Integer.valueOf(this.skillid2));
/*  88 */       conf_skillid2rateMap.remove(Integer.valueOf(this.skillid2));
/*     */     }
/*  90 */     int totalWeight = 0;
/*  91 */     for (Iterator i$ = conf_skillid2rateMap.values().iterator(); i$.hasNext();) { int w = ((Integer)i$.next()).intValue();
/*     */       
/*  93 */       totalWeight += w;
/*     */     }
/*  95 */     Map<Integer, Integer> skillid2num = new HashMap();
/*  96 */     for (int i = 0; i < this.num; i++)
/*     */     {
/*  98 */       int skillid = ItemConfigManager.randomEquipSkill(sItemEquipCfg.skillid, toRemoveSkillIntegers);
/*  99 */       Integer n = (Integer)skillid2num.get(Integer.valueOf(skillid));
/* 100 */       if (n == null)
/*     */       {
/* 102 */         n = Integer.valueOf(0);
/*     */       }
/* 104 */       skillid2num.put(Integer.valueOf(skillid), Integer.valueOf(n.intValue() + 1));
/*     */     }
/* 106 */     int total = 0;
/* 107 */     for (Iterator i$ = skillid2num.keySet().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*     */       
/* 109 */       int rankNum = ((Integer)skillid2num.get(Integer.valueOf(skillid))).intValue();
/* 110 */       total += rankNum;
/* 111 */       float rate = rankNum / this.num;
/* 112 */       float confRate = ((Integer)conf_skillid2rateMap.get(Integer.valueOf(skillid))).intValue() / totalWeight;
/* 113 */       String log = String.format("[skillrandom]PGM_RandomSkill.processImp@n=%d|skillid=%d|num=%d|rate=%f|conf_rate=%f", new Object[] { Integer.valueOf(this.num), Integer.valueOf(skillid), Integer.valueOf(rankNum), Float.valueOf(rate), Float.valueOf(confRate) });
/*     */       
/* 115 */       ItemManager.logger.info(log);
/* 116 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("随机[%d]次结果：%d=%d 实际随机结果比率：%f,配置数据比率%f", new Object[] { Integer.valueOf(this.num), Integer.valueOf(skillid), Integer.valueOf(rankNum), Float.valueOf(rate), Float.valueOf(confRate) }));
/*     */     }
/*     */     
/* 119 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("总共随机次数%d", new Object[] { Integer.valueOf(total) }));
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   boolean isSkillRight(SEquipSkillCfg cfg, int targetSkillid)
/*     */   {
/* 125 */     boolean isSkillAvailable = false;
/*     */     
/* 127 */     for (EquipSkillWeight weight : cfg.skills)
/*     */     {
/* 129 */       if (weight.skillid == targetSkillid)
/*     */       {
/* 131 */         isSkillAvailable = true;
/* 132 */         break;
/*     */       }
/*     */     }
/* 135 */     if (!isSkillAvailable)
/*     */     {
/* 137 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("技能id[%d]不是该装备合法的技能id，增加失败", new Object[] { Integer.valueOf(targetSkillid) }));
/* 138 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PGM_RandomSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */