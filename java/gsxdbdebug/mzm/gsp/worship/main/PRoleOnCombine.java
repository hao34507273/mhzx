/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2worship;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleOnCombine
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PRoleOnCombine(long roleId)
/*    */   {
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     String userid = RoleInterface.getUserId(this.roleId);
/* 30 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 32 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 33 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(this.roleId));
/* 34 */     if (xRoleWorshipInfo == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     long factionId = GangInterface.getGangId(this.roleId);
/*    */     
/* 41 */     WorshipManager.convertFactionData(xRoleWorshipInfo, factionId);
/*    */     
/* 43 */     WorshipManager.aSynRoleAllWorshipInfo(this.roleId);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\PRoleOnCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */