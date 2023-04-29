/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.GenerateGoodsItem;
/*    */ import mzm.gsp.item.main.PUseFumoItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.skill.SSyncSkillCommonTip;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleSkillBags;
/*    */ import xtable.Role2skillbag;
/*    */ 
/*    */ public class PAutoEnchantReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int skillId;
/*    */   private int skillBagId;
/*    */   
/*    */   public PAutoEnchantReq(long roleId, int skillId, int skillBagId)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.skillId = skillId;
/* 27 */     this.skillBagId = skillBagId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!SkillManager.isSkillSwitchOpenForRole(this.roleId)) {
/* 34 */       return false;
/*    */     }
/* 36 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(this.roleId));
/* 37 */     Integer lv = (Integer)xRoleSkillBags.getMenpai().get(Integer.valueOf(this.skillBagId));
/* 38 */     if (lv == null) {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     EnchantSkill skill = SkillManager.getEnchantSkill(this.skillId, lv.intValue());
/* 43 */     if (skill == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     int needVigor = skill.getNeedVoigor(this.roleId);
/* 47 */     if (needVigor < 0) {
/* 48 */       return false;
/*    */     }
/* 50 */     if (!RoleInterface.cutVigor(this.roleId, needVigor, new TLogArg(LogReason.VIGOR_CUT__WUQIFUMO))) {
/* 51 */       SSyncSkillCommonTip sSyncSkillCommonTip = new SSyncSkillCommonTip();
/* 52 */       sSyncSkillCommonTip.res = 2;
/* 53 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSyncSkillCommonTip);
/* 54 */       return false;
/*    */     }
/* 56 */     List<OutFightEffect> effectList = skill.getEffectList(RoleInterface.getRoleOutFightObject(this.roleId));
/* 57 */     int itemId = -1;
/* 58 */     for (OutFightEffect effect : effectList) {
/* 59 */       if ((effect instanceof GenerateGoodsItem)) {
/* 60 */         itemId = ((GenerateGoodsItem)effect).getItemId();
/* 61 */         break;
/*    */       }
/*    */     }
/* 64 */     return new PUseFumoItem(this.roleId, Integer.valueOf(itemId)).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PAutoEnchantReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */