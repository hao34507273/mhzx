/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.mall.main.JifenOperateResult;
/*    */ import mzm.gsp.mall.main.MallInterface;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_ModMoralValue
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final long modNum;
/*    */   
/*    */   public PGM_ModMoralValue(long gmRoleId, long roleId, long modNum)
/*    */   {
/* 24 */     this.gmRoleId = gmRoleId;
/* 25 */     this.roleId = roleId;
/* 26 */     this.modNum = modNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 31 */     Role role = RoleInterface.getRole(this.roleId, true);
/* 32 */     if (role == null)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("角色不存在 (roleId=%d)", new Object[] { Long.valueOf(this.roleId) }));
/*    */     }
/* 36 */     if (this.modNum == 0L)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改量为0");
/*    */     }
/*    */     
/* 41 */     if (this.modNum > 0L)
/*    */     {
/* 43 */       return addMoralValue();
/*    */     }
/*    */     
/*    */ 
/* 47 */     return subtractMoralValue();
/*    */   }
/*    */   
/*    */ 
/*    */   private boolean addMoralValue()
/*    */   {
/* 53 */     JifenOperateResult result = MallInterface.addJifen(this.roleId, this.modNum, 7, true, new TLogArg(LogReason.GM_ADD));
/*    */     
/* 55 */     if (result.isSuccess())
/*    */     {
/* 57 */       int moralValue = (int)MallInterface.getJifen(this.roleId, 7);
/* 58 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("修改成功, 功德值为%d", new Object[] { Integer.valueOf(moralValue) }));
/* 59 */       PKManager.triggerMoralValueChangeEvent(this.roleId, (int)(moralValue - this.modNum), moralValue);
/* 60 */       PKLogManager.info(String.format("PGM_ModMoralValue.addMoralValue()@done|roleid=%d|moral_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(moralValue) }));
/*    */       
/* 62 */       return true;
/*    */     }
/*    */     
/* 65 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改失败");
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   private boolean subtractMoralValue()
/*    */   {
/* 71 */     JifenOperateResult result = MallInterface.cutJifen(this.roleId, -this.modNum, 7, new TLogArg(LogReason.GM_REM));
/*    */     
/* 73 */     if (result.isSuccess())
/*    */     {
/* 75 */       int moralValue = (int)MallInterface.getJifen(this.roleId, 7);
/* 76 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("修改成功, 功德值为%d", new Object[] { Integer.valueOf(moralValue) }));
/* 77 */       PKManager.triggerMoralValueChangeEvent(this.roleId, (int)(moralValue - this.modNum), moralValue);
/* 78 */       PKLogManager.info(String.format("PGM_ModMoralValue.subtractMoralValue()@done|roleid=%d|moral_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(moralValue) }));
/*    */       
/* 80 */       return true;
/*    */     }
/*    */     
/* 83 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "修改失败");
/* 84 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PGM_ModMoralValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */