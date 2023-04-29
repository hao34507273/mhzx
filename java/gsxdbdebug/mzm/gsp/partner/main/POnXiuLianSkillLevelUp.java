/*    */ package mzm.gsp.partner.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillArg;
/*    */ import mzm.gsp.xiulian.event.XiuLianSkillLevelUpProcedure;
/*    */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnXiuLianSkillLevelUp
/*    */   extends XiuLianSkillLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     long roleId = ((XiuLianSkillArg)this.arg).roleId;
/*    */     
/* 24 */     if (((XiuLianSkillArg)this.arg).skillId == 0)
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     if ((XiuLianSkillInterface.getXiuLianSkillEffectTarget(((XiuLianSkillArg)this.arg).skillId) & 0x4) == 0)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(roleId)));
/*    */     
/* 36 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*    */     
/* 38 */     RolePartner rolePartner = PartnerManager.getRolePartner(((XiuLianSkillArg)this.arg).roleId, true);
/* 39 */     if (rolePartner.getPartnerBag() == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     if (!PartnerManager.checkAndSendNewSkill(roleId, rolePartner, false))
/*    */     {
/* 46 */       return false;
/*    */     }
/*    */     
/* 49 */     PartnerManager.syncPartnerProInfo(roleId, rolePartner, true);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\main\POnXiuLianSkillLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */