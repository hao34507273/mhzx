/*    */ package mzm.gsp.xiulian.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.xiulian.SSetDefaultSKillRes;
/*    */ import xbean.RoleXiuLian;
/*    */ import xtable.Role2xiulianskill;
/*    */ 
/*    */ public class PSetDefaultSkillReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int skillid;
/*    */   
/*    */   public PSetDefaultSkillReq(long roleId, int skillid)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.skillid = skillid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     if (!XiuLianSkillManager.isXiuLianSwitchOpenForRole(this.roleId)) {
/* 24 */       return false;
/*    */     }
/* 26 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(this.roleId));
/* 27 */     if (xRoleXiuLian == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!xRoleXiuLian.getSkillmap().containsKey(Integer.valueOf(this.skillid))) {
/* 31 */       return false;
/*    */     }
/* 33 */     if (xRoleXiuLian.getDefaultskillid() == this.skillid) {
/* 34 */       return false;
/*    */     }
/* 36 */     xRoleXiuLian.setDefaultskillid(this.skillid);
/* 37 */     SSetDefaultSKillRes res = new SSetDefaultSKillRes();
/* 38 */     res.skillbagid = this.skillid;
/* 39 */     OnlineManager.getInstance().send(this.roleId, res);
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiulian\main\PSetDefaultSkillReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */