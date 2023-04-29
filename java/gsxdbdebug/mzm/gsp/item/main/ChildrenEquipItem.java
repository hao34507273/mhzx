/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.children.confbean.ChildrenEquipLevelBean;
/*     */ import mzm.gsp.children.confbean.ChildrenEquipStageBean;
/*     */ import mzm.gsp.children.confbean.SChildrenEquipLevelCfg;
/*     */ import mzm.gsp.children.confbean.SChildrenEquipStageCfg;
/*     */ import mzm.gsp.item.confbean.SChildrenEquipItemCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ 
/*     */ public class ChildrenEquipItem extends BasicItem
/*     */ {
/*     */   public ChildrenEquipItem(Item item)
/*     */   {
/*  21 */     super(item);
/*     */   }
/*     */   
/*     */   public int getExp() {
/*  25 */     Integer curExp = getExtra(ItemStoreEnum.CHILDREN_EQUIP_EXP);
/*  26 */     return curExp == null ? 0 : curExp.intValue();
/*     */   }
/*     */   
/*     */   public void setExp(int exp) {
/*  30 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_EXP, exp);
/*     */   }
/*     */   
/*     */   public int getLevel() {
/*  34 */     Integer level = getExtra(ItemStoreEnum.CHILDREN_EQUIP_LEVEL);
/*  35 */     return level == null ? 1 : level.intValue();
/*     */   }
/*     */   
/*     */   public void setLevel(int lv) {
/*  39 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_LEVEL, lv);
/*     */   }
/*     */   
/*     */   public int getStage() {
/*  43 */     Integer stage = getExtra(ItemStoreEnum.CHILDREN_EQUIP_STAGE);
/*  44 */     return stage == null ? 0 : stage.intValue();
/*     */   }
/*     */   
/*     */   public void setStage(int stage) {
/*  48 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_STAGE, stage);
/*     */   }
/*     */   
/*     */   public int getPropA() {
/*  52 */     Integer propA = getExtra(ItemStoreEnum.CHILDREN_EQUIP_PROP_A);
/*  53 */     return propA == null ? 0 : propA.intValue();
/*     */   }
/*     */   
/*     */   public void setPropA(int propA) {
/*  57 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_PROP_A, propA);
/*     */   }
/*     */   
/*     */   protected boolean onCreateItem()
/*     */   {
/*  62 */     initChildrenEquip();
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   void initChildrenEquip() {
/*  67 */     int childrenEquipCfgid = getCfgId();
/*  68 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(childrenEquipCfgid);
/*  69 */     if (childrenEquipItemCfg == null) {
/*  70 */       throw new RuntimeException(String.format("[item]ChildrenEquipItem.initChildrenEquip@ChildrenEquipItem config is null|id=%d", new Object[] { Integer.valueOf(childrenEquipCfgid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  75 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_LEVEL, 1);
/*  76 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_EXP, 0);
/*  77 */     setExtra(ItemStoreEnum.CHILDREN_EQUIP_STAGE, 0);
/*  78 */     int propA = randomPropA();
/*  79 */     if (propA != 0) {
/*  80 */       setExtra(ItemStoreEnum.CHILDREN_EQUIP_PROP_A, propA);
/*     */     }
/*     */   }
/*     */   
/*     */   private int randomPropA()
/*     */   {
/*  86 */     return randomPropA(0);
/*     */   }
/*     */   
/*     */   public boolean isToMaxLevel() {
/*  90 */     ChildrenEquipLevelBean childrenEquipLevelBean = getChildrenEquipLevelBean(getLevel() + 1);
/*  91 */     if (childrenEquipLevelBean == null) {
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   private ChildrenEquipLevelBean getChildrenEquipLevelBean(int level)
/*     */   {
/*  99 */     SChildrenEquipLevelCfg childrenEquipLevelCfg = getChildrenEquipLevelCfg();
/* 100 */     if (childrenEquipLevelCfg == null) {
/* 101 */       return null;
/*     */     }
/* 103 */     return (ChildrenEquipLevelBean)childrenEquipLevelCfg.level2EquipLevelBean.get(Integer.valueOf(level));
/*     */   }
/*     */   
/*     */   public SChildrenEquipLevelCfg getChildrenEquipLevelCfg()
/*     */   {
/* 108 */     int childrenEquipCfgid = getCfgId();
/* 109 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(childrenEquipCfgid);
/* 110 */     if (childrenEquipItemCfg == null) {
/* 111 */       GameServer.logger().error(String.format("[item]ChildrenEquipItem.getChildrenEquipLevelCfg@ChildrenEquipItem config is null|id=%d", new Object[] { Integer.valueOf(childrenEquipCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 115 */       return null;
/*     */     }
/* 117 */     SChildrenEquipLevelCfg childrenEquipLevelCfg = SChildrenEquipLevelCfg.get(childrenEquipItemCfg.levelTypeid);
/* 118 */     if (childrenEquipLevelCfg == null) {
/* 119 */       GameServer.logger().error(String.format("[item]ChildrenEquipItem.getChildrenEquipLevelCfg@SChildrenEquipLevelCfg config is null|levelTypeid=%d", new Object[] { Integer.valueOf(childrenEquipItemCfg.levelTypeid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 124 */       return null;
/*     */     }
/* 126 */     return childrenEquipLevelCfg;
/*     */   }
/*     */   
/*     */   public boolean isToMaxStage() {
/* 130 */     ChildrenEquipStageBean childrenEquipStageBean = getChildrenEquipStageBean(getStage() + 1);
/* 131 */     if (childrenEquipStageBean == null) {
/* 132 */       return true;
/*     */     }
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   public ChildrenEquipStageBean getChildrenEquipStageBean(int stage)
/*     */   {
/* 139 */     SChildrenEquipStageCfg childrenEquipStageCfg = getChildrenEquipStageCfg();
/* 140 */     if (childrenEquipStageCfg == null) {
/* 141 */       return null;
/*     */     }
/* 143 */     return (ChildrenEquipStageBean)childrenEquipStageCfg.stage2EquipStageBean.get(Integer.valueOf(stage));
/*     */   }
/*     */   
/*     */   public SChildrenEquipStageCfg getChildrenEquipStageCfg() {
/* 147 */     int childrenEquipCfgid = getCfgId();
/* 148 */     SChildrenEquipItemCfg childrenEquipItemCfg = SChildrenEquipItemCfg.get(childrenEquipCfgid);
/* 149 */     if (childrenEquipItemCfg == null) {
/* 150 */       GameServer.logger().error(String.format("[item]ChildrenEquipItem.getChildrenEquipStageCfg@ChildrenEquipItem config is null|id=%d", new Object[] { Integer.valueOf(childrenEquipCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 154 */       return null;
/*     */     }
/* 156 */     SChildrenEquipStageCfg childrenEquipStageCfg = SChildrenEquipStageCfg.get(childrenEquipItemCfg.stageTypeid);
/* 157 */     if (childrenEquipStageCfg == null) {
/* 158 */       GameServer.logger().error(String.format("[item]ChildrenEquipItem.getChildrenEquipStageCfg@SChildrenEquipStageCfg config is null|stageTypeid=%d", new Object[] { Integer.valueOf(childrenEquipItemCfg.stageTypeid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 163 */       return null;
/*     */     }
/* 165 */     return childrenEquipStageCfg;
/*     */   }
/*     */   
/*     */   public int randomPropA(int exceptProp) {
/* 169 */     ChildrenEquipLevelBean childrenEquipLevelBean = getChildrenEquipLevelBean(getLevel());
/* 170 */     if (childrenEquipLevelBean == null) {
/* 171 */       GameServer.logger().error(String.format("[item]ChildrenEquipItem.randomPropA@ChildrenEquipLevelBean config is null|itemUuid=%d", new Object[] { getFirstUuid() }));
/*     */       
/*     */ 
/*     */ 
/* 175 */       return 0;
/*     */     }
/* 177 */     List<Integer> randomPropList = new java.util.ArrayList();
/* 178 */     for (Iterator i$ = childrenEquipLevelBean.proMap.keySet().iterator(); i$.hasNext();) { int propType = ((Integer)i$.next()).intValue();
/* 179 */       if ((propType != exceptProp) && (propType != 0))
/*     */       {
/*     */ 
/* 182 */         randomPropList.add(Integer.valueOf(propType)); }
/*     */     }
/* 184 */     int randomSize = randomPropList.size();
/* 185 */     if (randomSize <= 0) {
/* 186 */       return 0;
/*     */     }
/* 188 */     int index = xdb.Xdb.random().nextInt(randomSize);
/* 189 */     return ((Integer)randomPropList.get(index)).intValue();
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getProMap()
/*     */   {
/* 194 */     ChildrenEquipLevelBean childrenEquipLevelBean = getChildrenEquipLevelBean(getLevel());
/* 195 */     if (childrenEquipLevelBean == null) {
/* 196 */       return Collections.EMPTY_MAP;
/*     */     }
/* 198 */     int propA = getPropA();
/* 199 */     Integer propAValue = (Integer)childrenEquipLevelBean.proMap.get(Integer.valueOf(propA));
/* 200 */     if (propAValue == null) {
/* 201 */       return Collections.EMPTY_MAP;
/*     */     }
/* 203 */     Map<Integer, Integer> propMap = new HashMap();
/* 204 */     propMap.put(Integer.valueOf(propA), propAValue);
/* 205 */     return propMap;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ChildrenEquipItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */