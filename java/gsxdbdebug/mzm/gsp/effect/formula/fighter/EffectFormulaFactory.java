/*     */ package mzm.gsp.effect.formula.fighter;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.confbean.SEffectFormula;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EffectFormulaFactory
/*     */ {
/*  16 */   private Map<String, Constructor<?>> formulaName2ConstructMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   private static EffectFormulaFactory instance;
/*     */   
/*     */ 
/*     */ 
/*     */   public static EffectFormulaFactory getInstance()
/*     */   {
/*  26 */     if (instance == null) {
/*  27 */       instance = new EffectFormulaFactory();
/*  28 */       instance.init();
/*     */     }
/*  30 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static EffectFormula getFormula(int formulaid)
/*     */   {
/*  41 */     SEffectFormula effectFormula = SEffectFormula.get(formulaid);
/*  42 */     if (effectFormula == null) {
/*  43 */       GameServer.logger().error("没有找到效果公式 formulaid=" + formulaid);
/*  44 */       return null;
/*     */     }
/*  46 */     Constructor<?> constructor = (Constructor)getInstance().formulaName2ConstructMap.get(effectFormula.className);
/*  47 */     if (constructor == null) {
/*  48 */       GameServer.logger().error("没有找到效果公式的构造函数" + formulaid);
/*  49 */       return null;
/*     */     }
/*     */     
/*  52 */     synchronized (constructor)
/*     */     {
/*     */       try {
/*  55 */         Object obj = constructor.newInstance(effectFormula.params.toArray());
/*  56 */         return (EffectFormula)obj;
/*     */       } catch (Exception e) {
/*  58 */         GameServer.logger().error("效果公式构造函数出错 formulaid:" + formulaid + " params:" + effectFormula.params.toArray(), e);
/*     */       }
/*     */     }
/*     */     
/*  62 */     return null;
/*     */   }
/*     */   
/*     */   private void init() {
/*  66 */     initEffectFormulaConfig();
/*     */   }
/*     */   
/*     */   private void initEffectFormulaConfig()
/*     */   {
/*  71 */     for (SEffectFormula effectFormula : SEffectFormula.getAll().values()) {
/*  72 */       Class<?> formulaClass = null;
/*  73 */       if ((effectFormula.className == null) || (effectFormula.className.trim().equals("")) || (effectFormula.className.trim().toUpperCase().equals("NULL")))
/*     */       {
/*  75 */         StringBuilder sb = new StringBuilder();
/*  76 */         sb.append("SkillFormula class name error: id=" + effectFormula.id);
/*  77 */         GameServer.logger().error(sb.toString());
/*     */         
/*  79 */         throw new RuntimeException(sb.toString());
/*     */       }
/*     */       try {
/*  82 */         String className = EffectFormula.class.getPackage().getName() + "." + effectFormula.className.trim();
/*     */         
/*  84 */         formulaClass = Class.forName(className);
/*     */       } catch (ClassNotFoundException e) {
/*  86 */         StringBuilder sb = new StringBuilder();
/*  87 */         sb.append("SkillFormula not found, id=").append(effectFormula.id).append(",formulaClass=").append(effectFormula.className.trim());
/*     */         
/*  89 */         GameServer.logger().error(sb.toString());
/*     */         
/*  91 */         throw new RuntimeException(sb.toString());
/*     */       }
/*     */       
/*     */ 
/*  95 */       if (formulaClass != null) {
/*  96 */         Constructor<?>[] constructors = formulaClass.getDeclaredConstructors();
/*  97 */         if (constructors.length != 1) {
/*  98 */           throw new RuntimeException("技能公式" + effectFormula.className.trim() + "的构造函数不唯一，id=" + effectFormula.id);
/*     */         }
/*     */         
/*     */ 
/* 102 */         Constructor<?> constructor = constructors[0];
/* 103 */         constructor.setAccessible(true);
/* 104 */         if (constructor.getParameterTypes().length != effectFormula.params.size()) {
/* 105 */           throw new RuntimeException("技能公式" + effectFormula.className.trim() + "的参数数量不匹配，id=" + effectFormula.id);
/*     */         }
/*     */         
/*     */ 
/* 109 */         this.formulaName2ConstructMap.put(effectFormula.className, constructors[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\formula\fighter\EffectFormulaFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */