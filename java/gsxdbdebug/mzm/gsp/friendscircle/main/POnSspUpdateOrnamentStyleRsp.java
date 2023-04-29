/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FriendsCircleOrnamentItem;
/*    */ import xbean.Role2FriendsCircleInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnSspUpdateOrnamentStyleRsp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int pendantItemCfgId;
/*    */   private final int rahmenItemCfgId;
/*    */   
/*    */   public POnSspUpdateOrnamentStyleRsp(long roleId, int pendantItemCfgId, int rahmenItemCfgId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.pendantItemCfgId = pendantItemCfgId;
/* 23 */     this.rahmenItemCfgId = rahmenItemCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     String userId = RoleInterface.getUserId(this.roleId);
/* 30 */     if (userId == null)
/*    */     {
/* 32 */       onSspUpdateOrnamentStyleRspFail(6);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     lock(Lockeys.get(User.getTable(), userId));
/* 37 */     Role2FriendsCircleInfo xRole2FriendsCircleInfo = FriendsCircleManager.getAndInitFriendsCircleInfo(this.roleId);
/*    */     
/* 39 */     int xPendantOrnamentItemCfgId = xRole2FriendsCircleInfo.getCurrent_pendant_ornament().getItem_cfg_id();
/* 40 */     int xRahmenOrnamentItemCfgId = xRole2FriendsCircleInfo.getCurrent_rahmen_ornament().getItem_cfg_id();
/*    */     
/* 42 */     if ((xPendantOrnamentItemCfgId == this.pendantItemCfgId) && (xRahmenOrnamentItemCfgId == this.rahmenItemCfgId))
/*    */     {
/* 44 */       xRole2FriendsCircleInfo.setUpdate_ornament_result(true);
/*    */     }
/*    */     else
/*    */     {
/* 48 */       xRole2FriendsCircleInfo.setUpdate_ornament_result(false);
/* 49 */       FriendsCircleManager.reportUpdateSpaceStyle(userId, this.roleId, xPendantOrnamentItemCfgId, xRahmenOrnamentItemCfgId);
/*    */     }
/*    */     
/* 52 */     StringBuilder sbLog = new StringBuilder();
/* 53 */     sbLog.append("[friendscircle]POnSspUpdateOrnamentStyleRsp.processImp@handle ssp update ornament style friends circle rsp success");
/* 54 */     sbLog.append("|role_id=").append(this.roleId);
/* 55 */     sbLog.append("|pendant_item_cfg_id=").append(this.pendantItemCfgId);
/* 56 */     sbLog.append("|rahmen_item_cfg_id=").append(this.rahmenItemCfgId);
/* 57 */     sbLog.append("|x_pendant_item_cfg_id=").append(xPendantOrnamentItemCfgId);
/* 58 */     sbLog.append("|x_rahmen_item_cfg_id=").append(xRahmenOrnamentItemCfgId);
/*    */     
/* 60 */     GameServer.logger().info(sbLog.toString());
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   private void onSspUpdateOrnamentStyleRspFail(int ret)
/*    */   {
/* 66 */     onSspUpdateOrnamentStyleRspFail(ret, null);
/*    */   }
/*    */   
/*    */   private void onSspUpdateOrnamentStyleRspFail(int ret, Map<String, Object> extraMap)
/*    */   {
/* 71 */     StringBuilder sbLog = new StringBuilder();
/* 72 */     sbLog.append("[friendscircle]POnSspUpdateOrnamentStyleRsp.processImp@handle ssp update ornament style friends circle rsp failed");
/* 73 */     sbLog.append("|ret=").append(ret);
/* 74 */     sbLog.append("|role_id=").append(this.roleId);
/* 75 */     sbLog.append("|pendant_item_cfg_id=").append(this.pendantItemCfgId);
/* 76 */     sbLog.append("|rahmen_item_cfg_id=").append(this.rahmenItemCfgId);
/*    */     
/* 78 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*    */     {
/* 80 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*    */       {
/* 82 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*    */       }
/*    */     }
/* 85 */     GameServer.logger().error(sbLog.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnSspUpdateOrnamentStyleRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */