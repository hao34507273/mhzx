/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.friendscircle.SFriendsCircleNormalRes;
/*    */ import mzm.gsp.friendscircle.SGetFriendsCircleSignRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetFriendsCircleSign extends mzm.gsp.util.LogicProcedure
/*    */ {
/* 20 */   private static Set<String> signSourceSet = new TreeSet();
/*    */   private final long roleId;
/*    */   
/* 23 */   static { signSourceSet.add("gameId");
/* 24 */     signSourceSet.add("roleId");
/* 25 */     signSourceSet.add("timestamp");
/* 26 */     signSourceSet.add("userId");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public PCGetFriendsCircleSign(long roleId)
/*    */   {
/* 33 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 39 */     String userId = RoleInterface.getUserId(this.roleId);
/* 40 */     if (userId == null)
/*    */     {
/* 42 */       onGetFriendsCircleSignFail(6);
/* 43 */       return false;
/*    */     }
/* 45 */     long timestamp = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 47 */     Map<String, String> signSourceMap = new HashMap();
/* 48 */     signSourceMap.put("gameId", String.valueOf(GameServerInfoManager.getGameid()));
/* 49 */     signSourceMap.put("roleId", String.valueOf(this.roleId));
/* 50 */     signSourceMap.put("timestamp", String.valueOf(timestamp));
/* 51 */     signSourceMap.put("userId", userId);
/*    */     
/* 53 */     StringBuilder sBuilder = new StringBuilder();
/* 54 */     for (String key : signSourceSet)
/*    */     {
/* 56 */       String value = (String)signSourceMap.get(key);
/* 57 */       sBuilder.append(value);
/*    */     }
/* 59 */     sBuilder.append(FriendsCircleArgs.getInstance().privateKey);
/*    */     
/* 61 */     byte[] sign = CommonUtils.md5(sBuilder.toString(), "UTF-8");
/*    */     
/* 63 */     SGetFriendsCircleSignRes sGetFriendsCircleSignRes = new SGetFriendsCircleSignRes();
/* 64 */     sGetFriendsCircleSignRes.timestamp = timestamp;
/* 65 */     sGetFriendsCircleSignRes.sign.setString(CommonUtils.bytesToHexString(sign), "UTF-8");
/*    */     
/* 67 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sGetFriendsCircleSignRes);
/* 68 */     return true;
/*    */   }
/*    */   
/*    */   private void onGetFriendsCircleSignFail(int ret)
/*    */   {
/* 73 */     onGetFriendsCircleSignFail(ret, null);
/*    */   }
/*    */   
/*    */   private void onGetFriendsCircleSignFail(int ret, Map<String, Object> extraMap)
/*    */   {
/* 78 */     StringBuilder sbLog = new StringBuilder();
/* 79 */     sbLog.append("[friends_circle]PCGetFriendsCircleSign.processImp@get friends circle sign failed");
/* 80 */     sbLog.append("|ret=").append(ret);
/* 81 */     sbLog.append("|role_id=").append(this.roleId);
/*    */     
/* 83 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*    */     {
/* 85 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*    */       {
/* 87 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*    */       }
/*    */     }
/* 90 */     GameServer.logger().error(sbLog.toString());
/*    */     
/* 92 */     SFriendsCircleNormalRes sFriendsCircleNormalRes = new SFriendsCircleNormalRes();
/* 93 */     sFriendsCircleNormalRes.ret = ret;
/*    */     
/* 95 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFriendsCircleNormalRes);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\PCGetFriendsCircleSign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */