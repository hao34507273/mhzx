/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.ActionEffect;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.role.main.RoleOutFightObj;
/*    */ import mzm.gsp.skill.confbean.SEnchantSkill;
/*    */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*    */ import mzm.gsp.skill.formula.outfight.FormulaFunction;
/*    */ import mzm.gsp.skill.formula.outfight.FormulaFunctionFactory;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnchantSkill
/*    */   extends OutFightSkill
/*    */ {
/*    */   public static final int RES_SUCCESS = 0;
/*    */   public static final int RES_COST_FAIL = -1;
/*    */   public static final int RES_BAG_FULL = -2;
/*    */   private SEnchantSkill enchantSkillCfg;
/*    */   
/*    */   public EnchantSkill(SEnchantSkill enchantSkillCfg, int level)
/*    */   {
/* 29 */     super(level);
/* 30 */     this.enchantSkillCfg = enchantSkillCfg;
/*    */   }
/*    */   
/*    */   public List<SOutFightEffectGroup> getEffectGroup()
/*    */   {
/* 35 */     List<SOutFightEffectGroup> effectGroups = new ArrayList();
/* 36 */     SOutFightEffectGroup group = new SOutFightEffectGroup();
/* 37 */     group.effectId = this.enchantSkillCfg.effectId;
/* 38 */     group.formulaList.addAll(this.enchantSkillCfg.paramFormulaIdList);
/* 39 */     effectGroups.add(group);
/* 40 */     return effectGroups;
/*    */   }
/*    */   
/*    */   public int use(long roleId) {
/* 44 */     RoleOutFightObj outFightObj = RoleInterface.getRoleOutFightObject(roleId);
/* 45 */     FormulaFunction function = FormulaFunctionFactory.getFormula(this.enchantSkillCfg.costFormulaId);
/* 46 */     int costVigor = function.calc(outFightObj, this);
/* 47 */     if (!RoleInterface.cutVigor(roleId, costVigor, new TLogArg(LogReason.VIGOR_CUT__WUQIFUMO))) {
/* 48 */       return -1;
/*    */     }
/* 50 */     List<OutFightEffect> effectList = getEffectList(outFightObj);
/* 51 */     for (OutFightEffect effect : effectList) {
/* 52 */       if ((effect instanceof ActionEffect)) {
/* 53 */         ActionEffect actionEffect = (ActionEffect)effect;
/* 54 */         if (!actionEffect.cast(outFightObj)) {
/* 55 */           return -2;
/*    */         }
/*    */       }
/*    */     }
/* 59 */     return 0;
/*    */   }
/*    */   
/*    */   public int getNeedVoigor(long roleId) {
/* 63 */     RoleOutFightObj outFightObj = RoleInterface.getRoleOutFightObject(roleId);
/* 64 */     FormulaFunction function = FormulaFunctionFactory.getFormula(this.enchantSkillCfg.costFormulaId);
/* 65 */     return function.calc(outFightObj, this);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\EnchantSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */