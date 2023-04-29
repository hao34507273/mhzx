/*    */ package mzm.gsp.shimen.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.shimen.confbean.ShimenActivityCfgConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_Shimento
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private long roleid;
/*    */   private int count;
/*    */   
/*    */   public PGM_Shimento(long gmRoleid, long roleid, int count)
/*    */   {
/* 26 */     this.gmRoleid = gmRoleid;
/* 27 */     this.roleid = roleid;
/* 28 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     String userid = RoleInterface.getUserId(this.roleid);
/* 35 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 36 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 38 */     if (!ActivityInterface.setActivityDataForGM(userid, this.roleid, ShimenActivityCfgConsts.getInstance().ACTIVITYID, this.count))
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d跳转到%d师门环失败", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.count) }));
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, String.format("%d跳转到%d师门环成功", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.count) }));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shimen\main\PGM_Shimento.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */