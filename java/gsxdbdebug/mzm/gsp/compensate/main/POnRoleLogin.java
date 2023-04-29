/*    */ package mzm.gsp.compensate.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     long roleid = ((Long)this.arg).longValue();
/* 17 */     String userid = RoleInterface.getUserId(roleid);
/* 18 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 20 */     Set<Long> remainUserCompensateIds = new HashSet();
/* 21 */     Set<Long> remainRoleCompensateIds = new HashSet();
/* 22 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 23 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 24 */     List<CompensateInfo> compensateInfos = CompensateManager.getCompensates();
/* 25 */     long createRoleTime = RoleInterface.getRoleCreateTime(roleid);
/* 26 */     for (CompensateInfo compensateInfo : compensateInfos)
/*    */     {
/* 28 */       if (currTime - compensateInfo.endTime <= 86400000L)
/*    */       {
/* 30 */         if (compensateInfo.mode == 1)
/*    */         {
/* 32 */           remainUserCompensateIds.add(Long.valueOf(compensateInfo.id));
/*    */         }
/*    */         else
/*    */         {
/* 36 */           remainRoleCompensateIds.add(Long.valueOf(compensateInfo.id));
/*    */         }
/*    */       }
/*    */       
/* 40 */       if ((compensateInfo.startTime <= currTime) && 
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 45 */         (compensateInfo.endTime >= currTime) && 
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 50 */         (roleLevel >= compensateInfo.minLevel) && (roleLevel <= compensateInfo.maxLevel) && 
/*    */         
/*    */ 
/*    */ 
/*    */ 
/* 55 */         ((compensateInfo.minCreateRoleTime <= 0L) || 
/*    */         
/* 57 */         (createRoleTime >= compensateInfo.minCreateRoleTime)) && (
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 63 */         (compensateInfo.maxCreateRoleTime <= 0L) || 
/*    */         
/* 65 */         (createRoleTime <= compensateInfo.maxCreateRoleTime)))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 71 */         CompensateManager.trySendCompensateMail(userid, roleid, compensateInfo);
/*    */       }
/*    */     }
/* 74 */     CompensateManager.cleanCompensateIds(userid, roleid, remainUserCompensateIds, remainRoleCompensateIds);
/*    */     
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\compensate\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */