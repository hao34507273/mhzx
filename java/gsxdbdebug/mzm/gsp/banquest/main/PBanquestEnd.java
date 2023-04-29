/*    */ package mzm.gsp.banquest.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.main.MarriageInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BanquestInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Role2banquestinfo;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBanquestEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long startTime;
/* 24 */   private Map<Long, String> roleidToUserid = new HashMap();
/* 25 */   private ArrayList<Long> lockRoleIds = new ArrayList();
/*    */   private long masterId;
/*    */   
/*    */   public PBanquestEnd(long roleId, long startTime)
/*    */   {
/* 30 */     this.roleId = roleId;
/* 31 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     String startTimeStr = BanquestManager.getFormatDate(this.startTime);
/* 38 */     GameServer.logger().info(String.format("[banquest]BanquestEnd.processImp@ banquest end!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), startTimeStr }));
/*    */     
/*    */ 
/*    */ 
/* 42 */     if (!initWhenBanquestEnd())
/*    */     {
/* 44 */       GameServer.logger().error(String.format("[banquest]BanquestEnd.processImp@ initWhenBanquestEnd failed!|roleId=%d|startTimeStr=%s", new Object[] { Long.valueOf(this.roleId), startTimeStr }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 49 */     BanquestManager.clearBanquest(this.masterId);
/*    */     
/*    */ 
/* 52 */     Lockeys.lock(User.getTable(), this.roleidToUserid.values());
/*    */     
/* 54 */     Lockeys.lock(Basic.getTable(), this.lockRoleIds);
/*    */     
/* 56 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(this.masterId));
/* 57 */     if (xBanquestInfo == null)
/*    */     {
/* 59 */       GameServer.logger().error(String.format("[banquest]BanquestEnd.processImp@ xBanquestInfom is null!|roleId=%d|masterId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId) }));
/*    */       
/*    */ 
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     BanquestManager.onBanquestEnd(xBanquestInfo, this.masterId, this.lockRoleIds);
/*    */     
/* 67 */     BanquestTlogManager.tlogBanquestEnd(this.masterId, xBanquestInfo.getHoldcount(), this.startTime);
/*    */     
/* 69 */     GameServer.logger().info(String.format("[banquest]BanquestEnd.processImp@ banquest end hand suc!|roleId=%d|startTImeStr=%s|masterId=%d", new Object[] { Long.valueOf(this.roleId), startTimeStr, Long.valueOf(this.masterId) }));
/*    */     
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private boolean initWhenBanquestEnd()
/*    */   {
/* 78 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId);
/* 79 */     if (marriedRoleId > 0L)
/*    */     {
/* 81 */       String marriedUserId = RoleInterface.getUserId(this.roleId);
/* 82 */       this.roleidToUserid.put(Long.valueOf(marriedRoleId), marriedUserId);
/* 83 */       this.lockRoleIds.add(Long.valueOf(marriedRoleId));
/*    */     }
/* 85 */     String userId = RoleInterface.getUserId(this.roleId);
/* 86 */     this.roleidToUserid.put(Long.valueOf(this.roleId), userId);
/* 87 */     this.lockRoleIds.add(Long.valueOf(this.roleId));
/*    */     
/*    */ 
/* 90 */     this.masterId = BanquestManager.getMasterId(this.roleId, marriedRoleId);
/* 91 */     if (this.masterId <= 0L)
/*    */     {
/* 93 */       GameServer.logger().error(String.format("[banquest]PCHoldBanquetReq.processImp@ get master err!|roleId=%d|marriedRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*    */       
/*    */ 
/* 96 */       return false;
/*    */     }
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PBanquestEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */