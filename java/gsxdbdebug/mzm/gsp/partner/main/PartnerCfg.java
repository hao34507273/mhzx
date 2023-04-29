/*     */ package mzm.gsp.partner.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.partner.confbean.SPartnerCfg;
/*     */ import mzm.gsp.partner.confbean.SPartnerYuanShenCfg;
/*     */ import mzm.gsp.partner.confbean.SRankInfo;
/*     */ import mzm.gsp.partner.confbean.STPartner2Prop;
/*     */ import mzm.gsp.partner.confbean.STPartnerRankCfg;
/*     */ import mzm.gsp.partner.confbean.STPropPerLevel;
/*     */ import mzm.gsp.partner.confbean.STTransformProp;
/*     */ import mzm.gsp.partner.confbean.STYuanCostCfg;
/*     */ import mzm.gsp.role.main.OccupationManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PartnerCfg
/*     */ {
/*     */   private int sPartnerCfgId;
/*     */   
/*     */   public PartnerCfg(int sPartnerCfgId)
/*     */   {
/*  27 */     this.sPartnerCfgId = sPartnerCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPartnerCfg getsPartnerCfg()
/*     */   {
/*  37 */     return SPartnerCfg.get(this.sPartnerCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STPartner2Prop getPropCfg()
/*     */   {
/*  47 */     return STPartner2Prop.get(this.sPartnerCfgId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Map<Integer, STPropPerLevel> getLevel2value()
/*     */   {
/*  57 */     return getPropCfg().level2value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getId()
/*     */   {
/*  67 */     return this.sPartnerCfgId;
/*     */   }
/*     */   
/*     */   boolean isOccReadyForActive()
/*     */   {
/*  72 */     return mzm.gsp.role.main.RoleInterface.isOccupationOpen(getsPartnerCfg().faction);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   float getProperty(int type, int level)
/*     */   {
/*  84 */     STPropPerLevel stPropPerLevel = (STPropPerLevel)getLevel2value().get(Integer.valueOf(level));
/*  85 */     if (stPropPerLevel == null)
/*     */     {
/*  87 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getProperty@ no this level data!|level=%d", new Object[] { Integer.valueOf(level) }));
/*  88 */       return 0.0F;
/*     */     }
/*  90 */     Map<Integer, Double> propMap = stPropPerLevel.pro2value;
/*  91 */     if (propMap == null)
/*     */     {
/*  93 */       return 0.0F;
/*     */     }
/*  95 */     Double propValue = (Double)propMap.get(Integer.valueOf(type));
/*  96 */     if (propValue == null)
/*     */     {
/*  98 */       return 0.0F;
/*     */     }
/* 100 */     return propValue.floatValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int calculateType(int level, int propertyType)
/*     */   {
/* 111 */     float propValue = 0.0F;
/* 112 */     propValue += getProperty(propertyType, level);
/* 113 */     STTransformProp stTransformProp = STTransformProp.get(propertyType);
/* 114 */     if (stTransformProp != null)
/*     */     {
/* 116 */       Map<Integer, Double> baseTransform = stTransformProp.basePro2value;
/* 117 */       Iterator<Map.Entry<Integer, Double>> it = baseTransform.entrySet().iterator();
/* 118 */       while (it.hasNext())
/*     */       {
/* 120 */         Map.Entry<Integer, Double> entry = (Map.Entry)it.next();
/* 121 */         propValue += getProperty(((Integer)entry.getKey()).intValue(), level) * ((Double)entry.getValue()).floatValue();
/*     */       }
/*     */     }
/* 124 */     return Math.round(propValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getLoveId()
/*     */   {
/* 134 */     return getsPartnerCfg().LoveId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getModelId()
/*     */   {
/* 144 */     return getsPartnerCfg().modelId;
/*     */   }
/*     */   
/*     */   String getName()
/*     */   {
/* 149 */     return getsPartnerCfg().name;
/*     */   }
/*     */   
/*     */   int getFaction()
/*     */   {
/* 154 */     return getsPartnerCfg().faction;
/*     */   }
/*     */   
/*     */   int getSex()
/*     */   {
/* 159 */     return getsPartnerCfg().sex;
/*     */   }
/*     */   
/*     */   int getClassType()
/*     */   {
/* 164 */     return getsPartnerCfg().classType;
/*     */   }
/*     */   
/*     */   int getClassLevel()
/*     */   {
/* 169 */     return getsPartnerCfg().classLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isAssistPartner()
/*     */   {
/* 179 */     return OccupationManager.getInstance().isAssistOccupation(getFaction(), getSex());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getYuanCfgId()
/*     */   {
/* 189 */     return getsPartnerCfg().yuanCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SPartnerYuanShenCfg getSYuanCfg()
/*     */   {
/* 199 */     return SPartnerYuanShenCfg.get(getYuanCfgId());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   YuanCostInfo getCostInfo(int toLevel)
/*     */   {
/* 211 */     SPartnerYuanShenCfg cfg = getSYuanCfg();
/* 212 */     if (cfg == null)
/*     */     {
/* 214 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getCostInfo@ SPartnerYuanShenCfg is null!|yuanCfgId=%d|toLevel=%d", new Object[] { Integer.valueOf(getYuanCfgId()), Integer.valueOf(toLevel) }));
/*     */       
/*     */ 
/* 217 */       return null;
/*     */     }
/* 219 */     int costId = cfg.costId;
/* 220 */     STYuanCostCfg costCfg = STYuanCostCfg.get(costId);
/* 221 */     if (costCfg == null)
/*     */     {
/* 223 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getCostInfo@ STYuanCostCfg is null!|toLevel=%d|costId=%d", new Object[] { Integer.valueOf(toLevel), Integer.valueOf(costId) }));
/*     */       
/*     */ 
/* 226 */       return null;
/*     */     }
/* 228 */     Integer num = (Integer)costCfg.yuanLv2needNum.get(Integer.valueOf(toLevel));
/* 229 */     if (num == null)
/*     */     {
/* 231 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getCostInfo@ no level data!|toLevel=%d|costId=%d", new Object[] { Integer.valueOf(toLevel), Integer.valueOf(costId) }));
/*     */       
/* 233 */       return null;
/*     */     }
/* 235 */     return new YuanCostInfo(cfg.costItemId, num.intValue());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getYuanPasSkills()
/*     */   {
/* 245 */     SPartnerYuanShenCfg cfg = getSYuanCfg();
/* 246 */     if (cfg == null)
/*     */     {
/* 248 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getCostInfo@ SPartnerYuanShenCfg is null!|yuanCfgId=%d", new Object[] { Integer.valueOf(getYuanCfgId()) }));
/*     */       
/* 250 */       return new ArrayList();
/*     */     }
/* 252 */     return cfg.pasSkillIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getSubYuanSize()
/*     */   {
/* 262 */     return 6;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getCfgSkills()
/*     */   {
/* 272 */     List<Integer> skills = new ArrayList();
/* 273 */     for (Iterator i$ = getsPartnerCfg().skills.iterator(); i$.hasNext();) { int skillId = ((Integer)i$.next()).intValue();
/*     */       
/* 275 */       if (skillId > 0)
/*     */       {
/* 277 */         skills.add(Integer.valueOf(skillId));
/*     */       }
/*     */     }
/* 280 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getCostId()
/*     */   {
/* 290 */     return getSYuanCfg().costId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getCostItemId()
/*     */   {
/* 300 */     return getSYuanCfg().costItemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRankId()
/*     */   {
/* 310 */     return getsPartnerCfg().rankId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getRankInfoId(int yuanLv)
/*     */   {
/* 321 */     STPartnerRankCfg cfg = STPartnerRankCfg.get(getRankId());
/* 322 */     if (cfg == null)
/*     */     {
/*     */ 
/* 325 */       return -1;
/*     */     }
/*     */     
/* 328 */     Integer rankCfgId = (Integer)cfg.yuanLv2rankCfgId.get(Integer.valueOf(yuanLv));
/* 329 */     if (rankCfgId == null)
/*     */     {
/* 331 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getRankInfoId@ no data to yuanLv!|yuanLv=%d", new Object[] { Integer.valueOf(yuanLv) }));
/* 332 */       return -1;
/*     */     }
/*     */     
/* 335 */     return rankCfgId.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   double getRankValue(int yuanLv)
/*     */   {
/* 346 */     int rankCfgId = getRankInfoId(yuanLv);
/* 347 */     if (rankCfgId <= 0)
/*     */     {
/* 349 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getRankValue@ no data to yuanLv!|yuanLv=%d", new Object[] { Integer.valueOf(yuanLv) }));
/* 350 */       return 0.0D;
/*     */     }
/* 352 */     SRankInfo cfg = SRankInfo.get(rankCfgId);
/* 353 */     if (cfg == null)
/*     */     {
/* 355 */       GameServer.logger().error(String.format("[partner]PartnerCfg.getRankValue@ no SRankInfo!|yuanLv=%d|cfgId=%d", new Object[] { Integer.valueOf(yuanLv), Integer.valueOf(rankCfgId) }));
/*     */       
/* 357 */       return 0.0D;
/*     */     }
/* 359 */     return cfg.rankValue;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\PartnerCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */