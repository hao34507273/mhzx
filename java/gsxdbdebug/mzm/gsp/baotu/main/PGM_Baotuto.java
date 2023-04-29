/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2properties;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_Baotuto
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int count;
/*    */   
/*    */   public PGM_Baotuto(long roleid, int count)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.count = count;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     String userid = RoleInterface.getUserId(this.roleid);
/* 33 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 34 */     Lockeys.lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 35 */     ActivityInterface.setActivityDataForGM(userid, this.roleid, BaoTuActivityCfgConsts.getInstance().ACTIVITYID, this.count);
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\PGM_Baotuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */