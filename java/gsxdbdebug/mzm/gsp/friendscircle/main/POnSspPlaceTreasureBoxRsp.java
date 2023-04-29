/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FriendsCirclePlaceTreasureResult;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSspPlaceTreasureBoxRsp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long serialId;
/*    */   private final int placeTreasureCount;
/*    */   private final int retCode;
/*    */   
/*    */   public POnSspPlaceTreasureBoxRsp(long roleId, long serialId, int placeTreasureCount, int retCode)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.serialId = serialId;
/* 24 */     this.placeTreasureCount = placeTreasureCount;
/* 25 */     this.retCode = retCode;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     String userId = RoleInterface.getUserId(this.roleId);
/* 32 */     if (userId == null)
/*    */     {
/* 34 */       onSspPlaceTreasureBoxRspFail(6);
/* 35 */       return false;
/*    */     }
/* 37 */     lock(Lockeys.get(User.getTable(), userId));
/* 38 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 40 */     FriendsCirclePlaceTreasureResult xFriendsCirclePlaceTreasureResult = (FriendsCirclePlaceTreasureResult)xRole2FriendsCircleInfo.getPlace_treasure_result().get(Long.valueOf(this.serialId));
/*    */     
/* 42 */     if (xFriendsCirclePlaceTreasureResult == null)
/*    */     {
/* 44 */       onSspPlaceTreasureBoxRspFail(35);
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (xFriendsCirclePlaceTreasureResult.getPlace_treasure_count() != this.placeTreasureCount)
/*    */     {
/* 50 */       onSspPlaceTreasureBoxRspFail(36);
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     xRole2FriendsCircleInfo.getPlace_treasure_result().remove(Long.valueOf(this.serialId));
/*    */     
/* 56 */     if (xRole2FriendsCircleInfo.getPlace_treasure_result().isEmpty())
/*    */     {
/* 58 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(this.roleId, 2001);
/*    */     }
/*    */     
/* 61 */     StringBuilder sbLog = new StringBuilder();
/* 62 */     sbLog.append("[friendscircle]POnSspPlaceTreasureBoxRsp.processImp@handle ssp place treasure box rsp success");
/* 63 */     sbLog.append("|role_id=").append(this.roleId);
/* 64 */     sbLog.append("|serial_id=").append(this.serialId);
/* 65 */     sbLog.append("|place_treasure_count=").append(this.placeTreasureCount);
/* 66 */     sbLog.append("|ret_code=").append(this.retCode);
/*    */     
/* 68 */     GameServer.logger().info(sbLog.toString());
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   private void onSspPlaceTreasureBoxRspFail(int ret)
/*    */   {
/* 74 */     onSspPlaceTreasureBoxRspFail(ret, null);
/*    */   }
/*    */   
/*    */   private void onSspPlaceTreasureBoxRspFail(int ret, Map<String, Object> extraMap)
/*    */   {
/* 79 */     StringBuilder sbLog = new StringBuilder();
/* 80 */     sbLog.append("[friendscircle]POnSspPlaceTreasureBoxRsp.processImp@handle ssp place treasure box rsp failed");
/* 81 */     sbLog.append("|ret=").append(ret);
/* 82 */     sbLog.append("|role_id=").append(this.roleId);
/* 83 */     sbLog.append("|serial_id=").append(this.serialId);
/* 84 */     sbLog.append("|place_treasure_count=").append(this.placeTreasureCount);
/* 85 */     sbLog.append("|ret_code=").append(this.retCode);
/*    */     
/* 87 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*    */     {
/* 89 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*    */       {
/* 91 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*    */       }
/*    */     }
/* 94 */     GameServer.logger().error(sbLog.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSspPlaceTreasureBoxRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */