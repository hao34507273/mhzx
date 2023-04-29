/*     */ package mzm.gsp.skill.formula.fighter;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.skill.confbean.SSkillFormula;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkillFormulaFactory
/*     */ {
/*  19 */   private Map<String, Constructor<?>> formulaName2ConstructMap = new HashMap();
/*     */   
/*     */   private static SkillFormulaFactory instance;
/*     */   
/*  23 */   private static Map<Integer, List<String>> formulaTypeToNameListMap = new HashMap();
/*     */   
/*     */   static {
/*  26 */     formulaTypeToNameListMap.put(Integer.valueOf(4), new ArrayList());
/*  27 */     formulaTypeToNameListMap.put(Integer.valueOf(2), new ArrayList());
/*  28 */     formulaTypeToNameListMap.put(Integer.valueOf(1), new ArrayList());
/*  29 */     formulaTypeToNameListMap.put(Integer.valueOf(3), new ArrayList());
/*     */     
/*     */ 
/*  32 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(4))).add(CommonFighterLVFormula.class.getName());
/*  33 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(4))).add(CommonSKillLVFormula.class.getName());
/*  34 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(4))).add(RandomSKillLVFormula.class.getName());
/*  35 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(4))).add(RandomRangeSKillLVFormula.class.getName());
/*     */     
/*  37 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(2))).add(CommonFighterLVFormula.class.getName());
/*  38 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(2))).add(CommonSKillLVFormula.class.getName());
/*     */     
/*  40 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(1))).add(TargetNumFormula_SkillLV.class.getName());
/*  41 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(1))).add(TargetNumFormula_FighterLV.class.getName());
/*     */     
/*  43 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(3))).add(CommonFighterLVFormula.class.getName());
/*  44 */     ((List)formulaTypeToNameListMap.get(Integer.valueOf(3))).add(CommonSKillLVFormula.class.getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SkillFormulaFactory getInstance()
/*     */   {
/*  53 */     if (instance == null) {
/*  54 */       instance = new SkillFormulaFactory();
/*  55 */       instance.init();
/*     */     }
/*  57 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static SkillFormula getFormula(int formulaid)
/*     */   {
/*  68 */     SSkillFormula skillFormula = SSkillFormula.get(formulaid);
/*  69 */     if (skillFormula == null) {
/*  70 */       GameServer.logger().error("没有找到技能公式 formulaid=" + formulaid);
/*  71 */       return null;
/*     */     }
/*  73 */     Constructor<?> constructor = (Constructor)getInstance().formulaName2ConstructMap.get(skillFormula.className);
/*  74 */     if (constructor == null) {
/*  75 */       GameServer.logger().error("没有找到技能公式的构造函数" + formulaid);
/*  76 */       return null;
/*     */     }
/*     */     
/*  79 */     synchronized (constructor)
/*     */     {
/*     */       try {
/*  82 */         Object obj = constructor.newInstance(skillFormula.params.toArray());
/*  83 */         return (SkillFormula)obj;
/*     */       } catch (Exception e) {
/*  85 */         GameServer.logger().error("技能公式构造函数出错 formulaid:" + formulaid + " params:" + skillFormula.params.toArray(), e);
/*     */       }
/*     */     }
/*     */     
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   private void init() {
/*  93 */     initSkillFormulaConfig();
/*     */   }
/*     */   
/*     */   private void initSkillFormulaConfig()
/*     */   {
/*  98 */     for (SSkillFormula sSkillFormula : SSkillFormula.getAll().values()) {
/*  99 */       Class<?> formulaClass = null;
/* 100 */       if ((sSkillFormula.className == null) || (sSkillFormula.className.trim().equals("")) || (sSkillFormula.className.trim().toUpperCase().equals("NULL")))
/*     */       {
/* 102 */         StringBuilder sb = new StringBuilder();
/* 103 */         sb.append("SkillFormula class name error: id=" + sSkillFormula.id);
/* 104 */         GameServer.logger().error(sb.toString());
/*     */       } else {
/*     */         try {
/* 107 */           String classnameCfg = sSkillFormula.className.trim();
/* 108 */           List<String> classnames = (List)formulaTypeToNameListMap.get(Integer.valueOf(sSkillFormula.formulatype));
/* 109 */           String className = SkillFormula.class.getPackage().getName() + "." + classnameCfg;
/* 110 */           if ((classnames == null) || (!classnames.contains(className))) {
/* 111 */             StringBuilder sb = new StringBuilder();
/* 112 */             sb.append("公式范围对应的公式不正确,id:").append(sSkillFormula.id).append(",formulaClass:").append(classnameCfg);
/*     */             
/* 114 */             GameServer.logger().error(sb.toString());
/* 115 */             throw new RuntimeException(sb.toString());
/*     */           }
/* 117 */           formulaClass = Class.forName(className);
/*     */         } catch (ClassNotFoundException e) {
/* 119 */           StringBuilder sb = new StringBuilder();
/* 120 */           sb.append("SkillFormula not found, id=").append(sSkillFormula.id).append(",formulaClass=").append(sSkillFormula.className.trim());
/*     */           
/* 122 */           GameServer.logger().error(sb.toString());
/* 123 */           throw new RuntimeException(sb.toString());
/*     */         }
/*     */       }
/*     */       
/* 127 */       if (formulaClass != null) {
/* 128 */         Constructor<?>[] constructors = formulaClass.getDeclaredConstructors();
/* 129 */         if (constructors.length != 1) {
/* 130 */           throw new RuntimeException("技能公式" + sSkillFormula.className.trim() + "的构造函数不唯一，id=" + sSkillFormula.id);
/*     */         }
/*     */         
/*     */ 
/* 134 */         Constructor<?> constructor = constructors[0];
/* 135 */         constructor.setAccessible(true);
/* 136 */         if (constructor.getParameterTypes().length != sSkillFormula.params.size()) {
/* 137 */           throw new RuntimeException("技能公式" + sSkillFormula.className.trim() + "的参数数量不匹配，id=" + sSkillFormula.id);
/*     */         }
/*     */         
/*     */ 
/* 141 */         this.formulaName2ConstructMap.put(sSkillFormula.className, constructors[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\SkillFormulaFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */