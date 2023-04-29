/*     */ package mzm.gsp.effect.main;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import mzm.gsp.effect.confbean.FighterEffectCfg;
/*     */ import mzm.gsp.effect.fighter.NoEffect;
/*     */ import mzm.gsp.effect.formula.fighter.EffectFormulaFactory;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FighterEffectConfigManager
/*     */ {
/*     */   private static FighterEffectConfigManager instance;
/*     */   
/*     */   static FighterEffectConfigManager getInstance()
/*     */   {
/*  29 */     if (instance == null) {
/*  30 */       instance = new FighterEffectConfigManager();
/*     */     }
/*  32 */     return instance;
/*     */   }
/*     */   
/*  35 */   private Map<Integer, Constructor<?>> effectid2Constructor = new ConcurrentHashMap();
/*     */   
/*     */   void init() {
/*  38 */     initFighterEffectConfig();
/*  39 */     EffectFormulaFactory.getInstance();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void initFighterEffectConfig()
/*     */   {
/*  46 */     for (Map.Entry<Integer, FighterEffectCfg> effectEntry : FighterEffectCfg.getAll().entrySet()) {
/*  47 */       Class<?> effectClass = null;
/*  48 */       String classname = ((FighterEffectCfg)effectEntry.getValue()).classname.trim();
/*  49 */       if ((classname == null) || (classname.equals("")) || (classname.equalsIgnoreCase("null"))) {
/*  50 */         throw new RuntimeException("配置错误，效果类名有问题, key: " + effectEntry.getKey());
/*     */       }
/*     */       try {
/*  53 */         String className = NoEffect.class.getPackage().getName() + "." + classname;
/*  54 */         effectClass = Class.forName(className);
/*     */         
/*     */ 
/*  57 */         allClazz = new LinkedList();
/*  58 */         Class<?> superClass = effectClass;
/*  59 */         while (superClass != null) {
/*  60 */           allClazz.add(superClass);
/*  61 */           superClass = superClass.getSuperclass();
/*  62 */           if (FighterEffect.class.equals(superClass)) {
/*     */             break;
/*     */           }
/*     */         }
/*     */         
/*  67 */         for (String fieldName : ((FighterEffectCfg)effectEntry.getValue()).parameters)
/*  68 */           if ((fieldName.length() > 0) && (!fieldName.equals("null")))
/*     */           {
/*     */ 
/*     */ 
/*  72 */             boolean isDefined = false;
/*  73 */             for (Class<?> clazz : allClazz) {
/*     */               try {
/*  75 */                 clazz.getDeclaredField(fieldName.trim());
/*     */               } catch (Exception e) {}
/*  77 */               continue;
/*     */               
/*  79 */               isDefined = true;
/*     */             }
/*     */             
/*  82 */             if (!isDefined) {
/*  83 */               StringBuilder sb = new StringBuilder();
/*  84 */               sb.append("Effect no field, id=").append(effectEntry.getKey()).append(",effectClass=").append(classname).append(",fieldName=").append(fieldName.trim());
/*     */               
/*  86 */               throw new RuntimeException(sb.toString());
/*     */             }
/*     */           }
/*     */       } catch (ClassNotFoundException e) {
/*     */         List<Class<?>> allClazz;
/*  91 */         StringBuilder sb = new StringBuilder();
/*  92 */         sb.append("Effect not found, id=").append(effectEntry.getKey()).append(",effectClass=").append(classname);
/*     */         
/*  94 */         throw new RuntimeException(sb.toString());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  99 */       if (effectClass != null) {
/* 100 */         Constructor<?>[] constructors = effectClass.getDeclaredConstructors();
/* 101 */         if (constructors.length != 1) {
/* 102 */           throw new RuntimeException("效果 " + classname + " 的构造函数不唯一，id=" + effectEntry.getKey());
/*     */         }
/*     */         
/* 105 */         Constructor<?> constructor = constructors[0];
/* 106 */         constructor.setAccessible(true);
/* 107 */         if (constructor.getParameterTypes().length != ((FighterEffectCfg)effectEntry.getValue()).parameters.size())
/*     */         {
/* 109 */           throw new RuntimeException("效果 " + classname + " 的参数数量不匹配，id=" + effectEntry.getKey());
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 114 */         this.effectid2Constructor.put(effectEntry.getKey(), constructors[0]);
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   FighterEffect getFighterEffectInstance(int id, List<Integer> params)
/*     */   {
/* 131 */     FighterEffectCfg effectCfg = FighterEffectCfg.get(id);
/* 132 */     if (effectCfg == null) {
/* 133 */       EffectManager.logger.error("Invalid effectid : " + id);
/* 134 */       return new NoEffect();
/*     */     }
/* 136 */     if ((params == null) || (params.size() != effectCfg.parameters.size())) {
/* 137 */       EffectManager.logger.error("Effect Parameters Size do not match. id=" + id + ",params=" + params);
/* 138 */       return new NoEffect();
/*     */     }
/*     */     
/* 141 */     Constructor<?> constructor = (Constructor)this.effectid2Constructor.get(Integer.valueOf(id));
/* 142 */     if (constructor == null) {
/* 143 */       EffectManager.logger.error("找不到效果" + id + "的构造函数！");
/* 144 */       return new NoEffect();
/*     */     }
/*     */     
/* 147 */     synchronized (constructor)
/*     */     {
/*     */       try {
/* 150 */         Object obj = constructor.newInstance(params.toArray());
/* 151 */         return (FighterEffect)obj;
/*     */       } catch (Exception e) {
/* 153 */         EffectManager.logger.error("Effect Instance Construct Error. id=" + id + ",param=" + params + "," + e.getMessage());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 158 */     return new NoEffect();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\FighterEffectConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */