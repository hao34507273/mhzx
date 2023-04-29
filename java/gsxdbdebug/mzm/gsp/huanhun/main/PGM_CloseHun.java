/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_CloseHun extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_CloseHun(long roleId)
/*    */   {
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     String userid = RoleInterface.getUserId(this.roleId);
/* 22 */     lock(xdb.Lockeys.get(User.getTable(), userid));
/* 23 */     HunTaskActivityInit hunTaskActivityInit = new HunTaskActivityInit();
/* 24 */     hunTaskActivityInit.initData(userid, this.roleId, 0, HuanHunMiShuConsts.getInstance().ACTIVITYID);
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PGM_CloseHun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */