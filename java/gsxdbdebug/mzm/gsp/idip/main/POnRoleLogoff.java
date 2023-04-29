/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.IdipNTimesAwardInfo;
/*    */ import xbean.Role2NTimesAwardInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2ntimesaward;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/* 28 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(roleId);
/* 29 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 31 */     Role2NTimesAwardInfo xRole2NTimesAwardInfo = Role2ntimesaward.get(Long.valueOf(roleId));
/*    */     
/* 33 */     IdipManager.checkZeroProfitLogoff(((Long)this.arg).longValue());
/*    */     
/* 35 */     if (xRole2NTimesAwardInfo != null)
/*    */     {
/*    */ 
/* 38 */       Map<Integer, IdipNTimesAwardInfo> xIdipNTimesAwardMapInfo = xRole2NTimesAwardInfo.getN_times_award_role_map();
/* 39 */       for (Map.Entry<Integer, IdipNTimesAwardInfo> entry : xIdipNTimesAwardMapInfo.entrySet())
/*    */       {
/* 41 */         int buffId = ((Integer)entry.getKey()).intValue();
/* 42 */         IdipNTimesAwardInfo xIdipNTimesAwardInfo = (IdipNTimesAwardInfo)entry.getValue();
/* 43 */         BuffInterface.uninstallBuf(roleId, buffId);
/*    */         
/* 45 */         GameServer.logger().info(String.format("[ntimesaward]POnRoleLogoff.processImp@logoff role unistall n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(buffId), Integer.valueOf(xIdipNTimesAwardInfo.getN_times()), Long.valueOf(xIdipNTimesAwardInfo.getStart_time()), Long.valueOf(xIdipNTimesAwardInfo.getExpire_time()) }));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 54 */     NTimesAwardManager.globalNTimesAwardUnInstallLogoff(roleId);
/*    */     
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */