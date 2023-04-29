/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.BanquestInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2banquestinfo;
/*    */ 
/*    */ public class PSynBanquestInfo extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSynBanquestInfo(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long worldId = MapInterface.getRoleWorldInstanceId(this.roleId);
/* 25 */     long masterId = BanquestManager.getMasterIdBy(worldId);
/* 26 */     if (masterId <= 0L)
/*    */     {
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     Set<Long> lockRoleIds = new java.util.HashSet();
/* 32 */     lockRoleIds.add(Long.valueOf(this.roleId));
/* 33 */     lockRoleIds.add(Long.valueOf(masterId));
/*    */     
/* 35 */     lock(Basic.getTable(), lockRoleIds);
/* 36 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/* 37 */     if (!BanquestManager.isInBanquestTime(xBanquestInfo, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     long startTime = xBanquestInfo.getLastbanqueststarttime();
/* 42 */     Collection<Long> guestIds = BanquestManager.getBanquestGuyIds(masterId);
/* 43 */     BanquestManager.synBanquestGuyNum(masterId, guestIds);
/* 44 */     BanquestManager.synBanquestInfo(masterId, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), guestIds.size(), startTime);
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PSynBanquestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */