/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.event.JoinGangProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2worship;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnJoinGang
/*    */   extends JoinGangProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long factionId;
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     this.roleId = ((GangArg)this.arg).roleId;
/* 24 */     this.factionId = ((GangArg)this.arg).gangId;
/*    */     
/*    */ 
/* 27 */     String userid = RoleInterface.getUserId(this.roleId);
/* 28 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 30 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 31 */     RoleWorshipInfo xRoleWorshipInfo = Role2worship.get(Long.valueOf(this.roleId));
/* 32 */     if (xRoleWorshipInfo == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     punishSalary(xRoleWorshipInfo);
/*    */     
/* 39 */     xRoleWorshipInfo.setCurfactionid(this.factionId);
/*    */     
/* 41 */     WorshipManager.aSynRoleAllWorshipInfo(this.roleId);
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void punishSalary(RoleWorshipInfo xRoleWorshipInfo)
/*    */   {
/* 52 */     long xOldFactionId = xRoleWorshipInfo.getCurfactionid();
/* 53 */     if (xOldFactionId <= 0L)
/*    */     {
/* 55 */       return;
/*    */     }
/* 57 */     if (xOldFactionId == this.factionId)
/*    */     {
/* 59 */       return;
/*    */     }
/* 61 */     if (xRoleWorshipInfo.getWorshipid() <= 0)
/*    */     {
/* 63 */       Integer lastCircleNum = (Integer)xRoleWorshipInfo.getLastcycledata().get(Long.valueOf(xOldFactionId));
/* 64 */       if ((lastCircleNum != null) && (lastCircleNum.intValue() > 1))
/*    */       {
/* 66 */         int newLastNum = (int)Math.ceil(lastCircleNum.intValue() * 0.5D);
/* 67 */         xRoleWorshipInfo.getLastcycledata().put(Long.valueOf(xOldFactionId), Integer.valueOf(newLastNum));
/*    */       }
/*    */     }
/* 70 */     Integer thisCircleNum = (Integer)xRoleWorshipInfo.getThiscycledata().get(Long.valueOf(xOldFactionId));
/* 71 */     if ((thisCircleNum != null) && (thisCircleNum.intValue() > 1))
/*    */     {
/* 73 */       int newThisNum = (int)Math.ceil(thisCircleNum.intValue() * 0.5D);
/* 74 */       xRoleWorshipInfo.getThiscycledata().put(Long.valueOf(xOldFactionId), Integer.valueOf(newThisNum));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\POnJoinGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */