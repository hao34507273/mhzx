/*     */ package mzm.gsp.item.main.sift;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.confbean.SDrugInFightSiftConCfg;
/*     */ import mzm.gsp.item.confbean.SDrugOutFightSiftConCfg;
/*     */ import mzm.gsp.item.confbean.SEquipSiftConCfg;
/*     */ import mzm.gsp.item.confbean.SPetSkillBookSiftConCfg;
/*     */ import mzm.gsp.item.main.sift.condition.AbsSiftCondition;
/*     */ import mzm.gsp.item.main.sift.condition.DrugInFightFunCon;
/*     */ import mzm.gsp.item.main.sift.condition.DrugInFightProBetweenCon;
/*     */ import mzm.gsp.item.main.sift.condition.DrugOutFightProBetweenCon;
/*     */ import mzm.gsp.item.main.sift.condition.EquipColorSiftCon;
/*     */ import mzm.gsp.item.main.sift.condition.EquipGenderSiftCon;
/*     */ import mzm.gsp.item.main.sift.condition.EquipLevelBetweenCon;
/*     */ import mzm.gsp.item.main.sift.condition.EquipMenpaiSiftCondtion;
/*     */ import mzm.gsp.item.main.sift.condition.EquipWearPosSiftCon;
/*     */ import mzm.gsp.item.main.sift.condition.ItemProprietarySiftCon;
/*     */ import mzm.gsp.item.main.sift.condition.ItemTypeSiftCondtion;
/*     */ import mzm.gsp.item.main.sift.condition.PetSkilBokItemPhaseCond;
/*     */ import mzm.gsp.item.main.sift.condition.PetSkilBokSkillPhaseCond;
/*     */ import org.apache.log4j.Logger;
/*     */ import util.ClassHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SiftConditionFac
/*     */ {
/*     */   private static final String CONDITION_PACKAGE = "mzm.gsp.item.main.sift.condition";
/*  46 */   private static final Map<Integer, Constructor<? extends AbsSiftCondition>> conType2SiftConstructor = new HashMap();
/*     */   
/*  48 */   private static final Logger LOGGER = Logger.getLogger(SiftConditionFac.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void init()
/*     */     throws Exception
/*     */   {
/*  57 */     SiftItemArgs.init();
/*  58 */     Map<Integer, Class<? extends AbsSiftCondition>> conType2SiftConClassMap = new HashMap();
/*     */     
/*  60 */     registerSiftConditionClass(100, ItemTypeSiftCondtion.class, conType2SiftConClassMap);
/*  61 */     registerSiftConditionClass(101, ItemProprietarySiftCon.class, conType2SiftConClassMap);
/*     */     
/*  63 */     registerSiftConditionClass(204, EquipGenderSiftCon.class, conType2SiftConClassMap);
/*  64 */     registerSiftConditionClass(201, EquipLevelBetweenCon.class, conType2SiftConClassMap);
/*  65 */     registerSiftConditionClass(203, EquipMenpaiSiftCondtion.class, conType2SiftConClassMap);
/*  66 */     registerSiftConditionClass(202, EquipWearPosSiftCon.class, conType2SiftConClassMap);
/*  67 */     registerSiftConditionClass(205, EquipColorSiftCon.class, conType2SiftConClassMap);
/*     */     
/*  69 */     registerSiftConditionClass(301, DrugInFightProBetweenCon.class, conType2SiftConClassMap);
/*     */     
/*  71 */     registerSiftConditionClass(303, DrugInFightFunCon.class, conType2SiftConClassMap);
/*     */     
/*     */ 
/*  74 */     registerSiftConditionClass(401, DrugOutFightProBetweenCon.class, conType2SiftConClassMap);
/*     */     
/*     */ 
/*  77 */     registerSiftConditionClass(501, PetSkilBokItemPhaseCond.class, conType2SiftConClassMap);
/*  78 */     registerSiftConditionClass(502, PetSkilBokSkillPhaseCond.class, conType2SiftConClassMap);
/*     */     
/*  80 */     for (Map.Entry<Integer, Class<? extends AbsSiftCondition>> conditionEntry : conType2SiftConClassMap.entrySet()) {
/*  81 */       Constructor<? extends AbsSiftCondition> siftConstructor = ((Class)conditionEntry.getValue()).getDeclaredConstructor(new Class[] { List.class });
/*     */       
/*  83 */       siftConstructor.setAccessible(true);
/*  84 */       conType2SiftConstructor.put(conditionEntry.getKey(), siftConstructor);
/*     */     }
/*     */     try
/*     */     {
/*  88 */       List<Class<?>> allClasses = ClassHelper.getAllClass("mzm.gsp.item.main.sift.condition");
/*  89 */       for (Class<?> class1 : allClasses) {
/*  90 */         if ((AbsSiftCondition.class.isAssignableFrom(class1)) && (!class1.equals(AbsSiftCondition.class)) && 
/*  91 */           (!conType2SiftConClassMap.values().contains(class1))) {
/*  92 */           throw new RuntimeException("实现的筛选条件没有被注册!" + class1.getName());
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  97 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void registerSiftConditionClass(int conType, Class<? extends AbsSiftCondition> clss, Map<Integer, Class<? extends AbsSiftCondition>> conType2SiftConClassMap)
/*     */   {
/* 110 */     conType2SiftConClassMap.put(Integer.valueOf(conType), clss);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static AbsSiftCondition createSiftCondition(int conType, Object... params)
/*     */   {
/* 119 */     AbsSiftCondition siftCondition = null;
/*     */     try {
/* 121 */       List<Object> paramList = new ArrayList();
/* 122 */       for (int i = 0; i < params.length; i++) {
/* 123 */         paramList.add(params[i]);
/*     */       }
/* 125 */       siftCondition = (AbsSiftCondition)((Constructor)conType2SiftConstructor.get(Integer.valueOf(conType))).newInstance(new Object[] { paramList });
/*     */     } catch (Exception e) {
/* 127 */       LOGGER.error("创建条件对象出错:" + conType, e);
/*     */     }
/*     */     
/* 130 */     return siftCondition;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<AbsSiftCondition> createSiftCondition(Map<Integer, List<Object>> conType2ParamMap)
/*     */   {
/* 140 */     List<AbsSiftCondition> equipSiftConditions = new ArrayList();
/* 141 */     for (Map.Entry<Integer, List<Object>> entry : conType2ParamMap.entrySet()) {
/*     */       try
/*     */       {
/* 144 */         AbsSiftCondition siftCondition = (AbsSiftCondition)((Constructor)conType2SiftConstructor.get(entry.getKey())).newInstance(new Object[] { entry.getValue() });
/* 145 */         equipSiftConditions.add(siftCondition);
/*     */       } catch (Exception e) {
/* 147 */         LOGGER.error("创建条件对象错我:" + entry.getKey(), e);
/*     */       }
/*     */     }
/*     */     
/* 151 */     return equipSiftConditions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<AbsSiftCondition> createEquipSiftCondition(int siftCfgId)
/*     */   {
/* 159 */     SEquipSiftConCfg equipSiftConCfg = SEquipSiftConCfg.get(siftCfgId);
/* 160 */     if (equipSiftConCfg == null) {
/* 161 */       throw new RuntimeException("装备过滤条件表中不存在该条配置：" + siftCfgId);
/*     */     }
/* 163 */     List<AbsSiftCondition> equipSiftConditions = new ArrayList();
/* 164 */     AbsSiftCondition levelBetcon = createSiftCondition(201, new Object[] { Integer.valueOf(equipSiftConCfg.minUseLevel), Integer.valueOf(equipSiftConCfg.maxUseLevel) });
/* 165 */     equipSiftConditions.add(levelBetcon);
/* 166 */     if (equipSiftConCfg.menPai != 0) {
/* 167 */       AbsSiftCondition menPaiCon = createSiftCondition(203, new Object[] { Integer.valueOf(equipSiftConCfg.menPai) });
/* 168 */       equipSiftConditions.add(menPaiCon);
/*     */     }
/* 170 */     if (equipSiftConCfg.wearPos != 10000000) {
/* 171 */       AbsSiftCondition menPaiCon = createSiftCondition(202, new Object[] { Integer.valueOf(equipSiftConCfg.wearPos) });
/* 172 */       equipSiftConditions.add(menPaiCon);
/*     */     }
/*     */     
/* 175 */     if (equipSiftConCfg.sex != 0) {
/* 176 */       AbsSiftCondition menPaiCon = createSiftCondition(204, new Object[] { Integer.valueOf(equipSiftConCfg.sex) });
/* 177 */       equipSiftConditions.add(menPaiCon);
/*     */     }
/* 179 */     if (equipSiftConCfg.isProprietary != 0) {
/* 180 */       AbsSiftCondition menPaiCon = createSiftCondition(101, new Object[] { Boolean.valueOf(equipSiftConCfg.isProprietary == 1 ? 1 : false) });
/* 181 */       equipSiftConditions.add(menPaiCon);
/*     */     }
/*     */     
/* 184 */     if (equipSiftConCfg.color != 0) {
/* 185 */       AbsSiftCondition menPaiCon = createSiftCondition(205, new Object[] { Integer.valueOf(equipSiftConCfg.color) });
/* 186 */       equipSiftConditions.add(menPaiCon);
/*     */     }
/* 188 */     return equipSiftConditions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<AbsSiftCondition> createInFightDrugSiftCondition(int siftCfgId)
/*     */   {
/* 196 */     SDrugInFightSiftConCfg drugInFightSiftConCfg = SDrugInFightSiftConCfg.get(siftCfgId);
/* 197 */     if (drugInFightSiftConCfg == null) {
/* 198 */       throw new RuntimeException("战斗内过滤条件表中不存在该条配置：" + siftCfgId);
/*     */     }
/* 200 */     List<AbsSiftCondition> drugInFightSiftConditions = new ArrayList();
/* 201 */     AbsSiftCondition levelBetcon = createSiftCondition(301, new Object[] { Integer.valueOf(drugInFightSiftConCfg.minDrugPro), Integer.valueOf(drugInFightSiftConCfg.maxDrugPro) });
/* 202 */     drugInFightSiftConditions.add(levelBetcon);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 208 */     if (drugInFightSiftConCfg.fun != 0) {
/* 209 */       AbsSiftCondition funCondition = createSiftCondition(303, new Object[] { Integer.valueOf(drugInFightSiftConCfg.fun) });
/* 210 */       drugInFightSiftConditions.add(funCondition);
/*     */     }
/*     */     
/*     */ 
/* 214 */     if (drugInFightSiftConCfg.isProprietary != 0) {
/* 215 */       AbsSiftCondition menPaiCon = createSiftCondition(101, new Object[] { Boolean.valueOf(drugInFightSiftConCfg.isProprietary == 1 ? 1 : false) });
/* 216 */       drugInFightSiftConditions.add(menPaiCon);
/*     */     }
/*     */     
/* 219 */     return drugInFightSiftConditions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<AbsSiftCondition> createOutFightDrugSiftCondition(int siftCfgId)
/*     */   {
/* 228 */     SDrugOutFightSiftConCfg drugOutFightSiftConCfg = SDrugOutFightSiftConCfg.get(siftCfgId);
/* 229 */     if (drugOutFightSiftConCfg == null) {
/* 230 */       throw new RuntimeException("战斗外过滤条件表中不存在该条配置：" + siftCfgId);
/*     */     }
/* 232 */     List<AbsSiftCondition> drugOutFightSiftConditions = new ArrayList();
/* 233 */     AbsSiftCondition proBetcon = createSiftCondition(401, new Object[] { Integer.valueOf(drugOutFightSiftConCfg.minDrugPro), Integer.valueOf(drugOutFightSiftConCfg.maxDrugPro) });
/* 234 */     drugOutFightSiftConditions.add(proBetcon);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 243 */     if (drugOutFightSiftConCfg.isProprietary != 0) {
/* 244 */       AbsSiftCondition proprietaryCon = createSiftCondition(101, new Object[] { Boolean.valueOf(drugOutFightSiftConCfg.isProprietary == 1 ? 1 : false) });
/* 245 */       drugOutFightSiftConditions.add(proprietaryCon);
/*     */     }
/*     */     
/* 248 */     return drugOutFightSiftConditions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<AbsSiftCondition> createPetSkilBokSiftCondition(int siftCfgId)
/*     */   {
/* 256 */     SPetSkillBookSiftConCfg petSkillBookSiftConCfg = SPetSkillBookSiftConCfg.get(siftCfgId);
/* 257 */     if (petSkillBookSiftConCfg == null) {
/* 258 */       throw new RuntimeException("宠物技能书过滤条件表中不存在该条配置：" + siftCfgId);
/*     */     }
/* 260 */     List<AbsSiftCondition> petSkillConditions = new ArrayList();
/* 261 */     if (petSkillBookSiftConCfg.itemPhase != 0) {
/* 262 */       AbsSiftCondition itemPhaseCon = createSiftCondition(501, new Object[] { Integer.valueOf(petSkillBookSiftConCfg.itemPhase) });
/* 263 */       petSkillConditions.add(itemPhaseCon);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 268 */     if (petSkillBookSiftConCfg.skillPhase != 0) {
/* 269 */       AbsSiftCondition skillPhaseCon = createSiftCondition(502, new Object[] { Integer.valueOf(petSkillBookSiftConCfg.skillPhase) });
/* 270 */       petSkillConditions.add(skillPhaseCon);
/*     */     }
/*     */     
/*     */ 
/* 274 */     if (petSkillBookSiftConCfg.isProprietary != 0) {
/* 275 */       AbsSiftCondition proprietaryCon = createSiftCondition(101, new Object[] { Boolean.valueOf(petSkillBookSiftConCfg.isProprietary == 1 ? 1 : false) });
/* 276 */       petSkillConditions.add(proprietaryCon);
/*     */     }
/*     */     
/* 279 */     return petSkillConditions;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\SiftConditionFac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */