/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.GenerateGoodsItem;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.skill.SFuMoSkillPreviewRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleSkillBags;
/*    */ import xtable.Role2skillbag;
/*    */ 
/*    */ public class PFuMoSkillPreviewReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int skillId;
/*    */   private int skillBagId;
/*    */   
/*    */   public PFuMoSkillPreviewReq(long roleId, int skillId, int skillBagId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.skillId = skillId;
/* 24 */     this.skillBagId = skillBagId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!SkillManager.isSkillSwitchOpenForRole(this.roleId)) {
/* 31 */       return false;
/*    */     }
/* 33 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(this.roleId));
/* 34 */     Integer lv = (Integer)xRoleSkillBags.getMenpai().get(Integer.valueOf(this.skillBagId));
/* 35 */     if (lv == null) {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     EnchantSkill skill = SkillManager.getEnchantSkill(this.skillId, lv.intValue());
/* 40 */     if (skill == null) {
/* 41 */       return false;
/*    */     }
/* 43 */     List<OutFightEffect> effectList = skill.getEffectList(RoleInterface.getRoleOutFightObject(this.roleId));
/* 44 */     int itemId = -1;
/* 45 */     for (OutFightEffect effect : effectList) {
/* 46 */       if ((effect instanceof GenerateGoodsItem)) {
/* 47 */         itemId = ((GenerateGoodsItem)effect).getItemId();
/* 48 */         break;
/*    */       }
/*    */     }
/* 51 */     if (itemId == -1) {
/* 52 */       return false;
/*    */     }
/* 54 */     SFuMoSkillPreviewRes res = new SFuMoSkillPreviewRes();
/* 55 */     res.itemid = itemId;
/* 56 */     res.needvigor = skill.getNeedVoigor(this.roleId);
/* 57 */     res.skillid = this.skillId;
/* 58 */     OnlineManager.getInstance().send(this.roleId, res);
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PFuMoSkillPreviewReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */