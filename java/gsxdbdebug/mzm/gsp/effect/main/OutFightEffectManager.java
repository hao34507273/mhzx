/*    */ package mzm.gsp.effect.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.effect.confbean.RoleEffectCfg;
/*    */ import mzm.gsp.effect.outfight.NoEffect;
/*    */ import mzm.gsp.effect.outfight.factory.AbstractEffectFactory;
/*    */ import mzm.gsp.effect.outfight.factory.PropertyEffectFactory;
/*    */ import mzm.gsp.effect.outfight.factory.SpecialEffectFactory;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OutFightEffectManager
/*    */ {
/* 18 */   private static final Logger logger = Logger.getLogger(OutFightEffectManager.class);
/*    */   
/* 20 */   private static OutFightEffectManager instance = new OutFightEffectManager();
/*    */   
/*    */   private static final String roleEffectPackage = "mzm.gsp.effect.outfight";
/*    */   
/* 24 */   private Map<Integer, AbstractEffectFactory> effectFactoryMap = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static OutFightEffectManager getInstance()
/*    */   {
/* 30 */     return instance;
/*    */   }
/*    */   
/*    */   public void initialize() {
/* 34 */     Map<Integer, RoleEffectCfg> effectCfgMap = RoleEffectCfg.getAll();
/* 35 */     for (RoleEffectCfg cfg : effectCfgMap.values()) {
/* 36 */       if ((cfg.classname == null) || (cfg.classname.trim().equals(""))) {
/* 37 */         throw new RuntimeException("战斗外效果配置数据class为空");
/*    */       }
/* 39 */       String fullPathClass = "mzm.gsp.effect.outfight." + cfg.classname.trim();
/* 40 */       AbstractEffectFactory factory = null;
/*    */       try
/*    */       {
/* 43 */         Class<OutFightEffect> cls = Class.forName(fullPathClass);
/* 44 */         if (cfg.baseProp != 0) {
/* 45 */           factory = new PropertyEffectFactory(cfg.baseProp, cls);
/* 46 */         } else if (cfg.fightProp != 0) {
/* 47 */           factory = new PropertyEffectFactory(cfg.fightProp, cls);
/*    */         } else {
/* 49 */           factory = new SpecialEffectFactory(cls);
/*    */         }
/*    */       } catch (Exception e) {
/* 52 */         throw new RuntimeException("战斗外效果名称配置错误 classname = " + cfg.classname + " 效果不存在");
/*    */       }
/* 54 */       if (!factory.checkParam(cfg.parameters)) {
/* 55 */         throw new RuntimeException("效果参数格数不匹配! classname = " + cfg.classname);
/*    */       }
/* 57 */       this.effectFactoryMap.put(Integer.valueOf(cfg.id), factory);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isOutFightEffect(int id)
/*    */   {
/* 63 */     return this.effectFactoryMap.containsKey(Integer.valueOf(id));
/*    */   }
/*    */   
/*    */   public OutFightEffect getEffect(int id, List<Integer> params) {
/* 67 */     AbstractEffectFactory factory = (AbstractEffectFactory)this.effectFactoryMap.get(Integer.valueOf(id));
/* 68 */     if (factory == null) {
/* 69 */       logger.warn("效果列表中不存在提供的ID" + id);
/* 70 */       return new NoEffect();
/*    */     }
/*    */     try {
/* 73 */       return factory.createEffect(params);
/*    */     } catch (Exception e) {
/* 75 */       logger.error("获取效果出错ID" + id, e);
/*    */     }
/* 77 */     return new NoEffect();
/*    */   }
/*    */   
/*    */   static void init() {
/* 81 */     instance.initialize();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\OutFightEffectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */