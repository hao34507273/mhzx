/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CrossServerFriendsCircleBlackRole;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ 
/*    */ public class POnCrossServerOperatorBlacklistRsp extends LogicProcedure
/*    */ {
/*    */   private final long activeRoleId;
/*    */   private final long beBlackedRoleId;
/*    */   private final int operatorType;
/*    */   private final int retcode;
/*    */   
/*    */   public POnCrossServerOperatorBlacklistRsp(long activeRoleId, long beBlackedRoleId, int operatorType, int retcode)
/*    */   {
/* 21 */     this.activeRoleId = activeRoleId;
/* 22 */     this.beBlackedRoleId = beBlackedRoleId;
/* 23 */     this.operatorType = operatorType;
/* 24 */     this.retcode = retcode;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     String userId = RoleInterface.getUserId(this.activeRoleId);
/* 31 */     if (userId == null)
/*    */     {
/* 33 */       onCrossServerOperatorBlacklistRspFail(-1);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.activeRoleId);
/* 38 */     Map<Long, CrossServerFriendsCircleBlackRole> xCrossServerFriendsCircleMap = xRole2FriendsCircleInfo.getCross_server_black_operator();
/* 39 */     CrossServerFriendsCircleBlackRole xCrossServerFriendsCircleBlackRole = (CrossServerFriendsCircleBlackRole)xCrossServerFriendsCircleMap.get(Long.valueOf(this.beBlackedRoleId));
/* 40 */     if (xCrossServerFriendsCircleBlackRole == null)
/*    */     {
/* 42 */       onCrossServerOperatorBlacklistRspFail(-2);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (this.retcode != 0)
/*    */     {
/* 48 */       onCrossServerOperatorBlacklistRspFail(-4);
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     if (xCrossServerFriendsCircleBlackRole.getOperator() != this.operatorType)
/*    */     {
/* 54 */       onCrossServerOperatorBlacklistRspFail(-3);
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     xCrossServerFriendsCircleMap.remove(Long.valueOf(this.beBlackedRoleId));
/*    */     
/* 60 */     StringBuilder sBuilder = new StringBuilder();
/* 61 */     sBuilder.append("[friendscircle]POnCrossServerOperatorBlacklistRsp.processImp@get rsp success");
/* 62 */     sBuilder.append("|active_role_id=").append(this.activeRoleId);
/* 63 */     sBuilder.append("|be_blacked_role_id=").append(this.beBlackedRoleId);
/* 64 */     sBuilder.append("|operator=").append(this.operatorType);
/*    */     
/* 66 */     GameServer.logger().info(sBuilder.toString());
/*    */     
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private void onCrossServerOperatorBlacklistRspFail(int ret)
/*    */   {
/* 73 */     onCrossServerOperatorBlacklistRspFail(ret, null);
/*    */   }
/*    */   
/*    */   private void onCrossServerOperatorBlacklistRspFail(int ret, Map<String, Object> extraMap)
/*    */   {
/* 78 */     StringBuilder sbLog = new StringBuilder();
/* 79 */     sbLog.append("[friendscircle]POnCrossServerOperatorBlacklistRsp.processImp@get rsp success");
/* 80 */     sbLog.append("|ret=").append(ret);
/* 81 */     sbLog.append("|active_role_id=").append(this.activeRoleId);
/* 82 */     sbLog.append("|be_blacked_role_id=").append(this.beBlackedRoleId);
/* 83 */     sbLog.append("|operator_type=").append(this.operatorType);
/* 84 */     sbLog.append("|ret_code=").append(this.retcode);
/*    */     
/* 86 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*    */     {
/* 88 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*    */       {
/* 90 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*    */       }
/*    */     }
/* 93 */     GameServer.logger().error(sbLog.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnCrossServerOperatorBlacklistRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */