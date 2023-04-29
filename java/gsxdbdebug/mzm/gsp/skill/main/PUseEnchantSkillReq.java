/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.GenerateGoodsItem;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.skill.SUseFuMoSkillRes;
/*    */ import mzm.gsp.skill.event.MakeFuMoFu;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleSkillBags;
/*    */ import xtable.Role2skillbag;
/*    */ 
/*    */ 
/*    */ public class PUseEnchantSkillReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int skillId;
/*    */   private int skillBagId;
/*    */   
/*    */   public PUseEnchantSkillReq(long roleId, int skillId, int skillBagId)
/*    */   {
/* 29 */     this.roleId = roleId;
/* 30 */     this.skillId = skillId;
/* 31 */     this.skillBagId = skillBagId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 38 */     if (!SkillManager.isSkillSwitchOpenForRole(this.roleId))
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     if (ItemInterface.isBagFull(this.roleId, 340600000, true))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     RoleSkillBags xRoleSkillBags = Role2skillbag.get(Long.valueOf(this.roleId));
/*    */     
/* 48 */     if (!xRoleSkillBags.getMenpai().containsKey(Integer.valueOf(this.skillBagId)))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     if (!MenPaiSkillBagManager.cheSkillBagHasSkill(this.skillBagId, this.skillId))
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     Integer lv = (Integer)xRoleSkillBags.getMenpai().get(Integer.valueOf(this.skillBagId));
/* 58 */     if (lv == null)
/*    */     {
/* 60 */       return false;
/*    */     }
/*    */     
/* 63 */     if (!SkillManager.isSkillInBag(this.skillBagId, this.skillId))
/*    */     {
/* 65 */       GameServer.logger().error(String.format("[skill]PUseEnchantSkillReq.processImp@skill not in bag|roleid=%d|skill_bagid=%d|skillid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.skillBagId), Integer.valueOf(this.skillId) }));
/*    */       
/*    */ 
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     EnchantSkill skill = SkillManager.getEnchantSkill(this.skillId, lv.intValue());
/* 72 */     if (skill == null)
/*    */     {
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     int res = skill.use(this.roleId);
/* 78 */     if (res != 0)
/*    */     {
/* 80 */       return false;
/*    */     }
/* 82 */     List<OutFightEffect> effectList = skill.getEffectList(RoleInterface.getRoleOutFightObject(this.roleId));
/* 83 */     int itemId = -1;
/* 84 */     for (OutFightEffect effect : effectList)
/*    */     {
/* 86 */       if ((effect instanceof GenerateGoodsItem))
/*    */       {
/* 88 */         itemId = ((GenerateGoodsItem)effect).getItemId();
/* 89 */         break;
/*    */       }
/*    */     }
/* 92 */     SUseFuMoSkillRes sUseFuMoSkillRes = new SUseFuMoSkillRes();
/* 93 */     sUseFuMoSkillRes.itemid = itemId;
/* 94 */     OnlineManager.getInstance().send(this.roleId, sUseFuMoSkillRes);
/* 95 */     TriggerEventsManger.getInstance().triggerEvent(new MakeFuMoFu(), Long.valueOf(this.roleId));
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\PUseEnchantSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */