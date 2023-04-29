/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import gnet.link.Onlines;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.OnlineUserInfo;
/*    */ import xtable.Role2heartbeat;
/*    */ 
/*    */ public class HeartbeatLogObserver extends Observer
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   public HeartbeatLogObserver(long roleid)
/*    */   {
/* 26 */     super(LogManager.getInstance().getHeartbeatLogIntervalSeconds());
/* 27 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 32 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 36 */         if (OnlineManager.getInstance().getRoleById(HeartbeatLogObserver.this.roleid) == null) {
/* 37 */           HeartbeatLogObserver.this.stopTimer();
/* 38 */           Role2heartbeat.remove(Long.valueOf(HeartbeatLogObserver.this.roleid));
/* 39 */           return true;
/*    */         }
/* 41 */         String userId = RoleInterface.getUserId(HeartbeatLogObserver.this.roleid);
/*    */         
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 47 */         OnlineUserInfo userInfo = Onlines.getInstance().findUserInfo(userId);
/* 48 */         if (userInfo == null) {
/* 49 */           return false;
/*    */         }
/* 51 */         int platform = userInfo.getPlatid();
/* 52 */         String channel = userInfo.getChannel();
/* 53 */         long gangId = GangInterface.getGangId(HeartbeatLogObserver.this.roleid);
/* 54 */         int ip = userInfo.getPeer();
/* 55 */         StringBuilder stringBuilder = new StringBuilder();
/* 56 */         stringBuilder.append(ip & 0xFF).append(".");
/* 57 */         stringBuilder.append(ip >> 8 & 0xFF).append(".");
/* 58 */         stringBuilder.append(ip >> 16 & 0xFF).append(".");
/* 59 */         stringBuilder.append(ip >> 24 & 0xFF);
/* 60 */         String loginIp = stringBuilder.toString();
/* 61 */         String mac = Onlines.getInstance().findEnumFromLoginArg(11, userInfo);
/*    */         
/*    */ 
/* 64 */         if ((ip == 0) || (platform < 0)) {
/* 65 */           return false;
/*    */         }
/*    */         
/* 68 */         int level = RoleInterface.getLevel(HeartbeatLogObserver.this.roleid);
/* 69 */         int fightValue = RoleInterface.getFightValue(HeartbeatLogObserver.this.roleid);
/* 70 */         int roleMfv = RoleInterface.getRoleMFValue(HeartbeatLogObserver.this.roleid);
/* 71 */         int occupation = RoleInterface.getOccupationId(HeartbeatLogObserver.this.roleid);
/* 72 */         int iZoneAreaID = GameServerInfoManager.getZoneidFromUserid(userId);
/*    */         
/* 74 */         String logStr = String.format("%d|%s|%s|%s|%s|%d|%d|%s|%d|%d|%s|%d", new Object[] { Integer.valueOf(platform), channel, "0", mac, userId, Long.valueOf(HeartbeatLogObserver.this.roleid), Long.valueOf(gangId), loginIp, Integer.valueOf(fightValue), Integer.valueOf(level), "0", Integer.valueOf(iZoneAreaID) });
/*    */         
/* 76 */         LogManager.getInstance().addLog("userheartbeat", logStr);
/*    */         
/* 78 */         int friendSize = FriendInterface.getFriendNum(HeartbeatLogObserver.this.roleid);
/*    */         
/* 80 */         String tlogStr = String.format("%s|%d|%d|%s|%d|%d|%s|%d|%d|%d", new Object[] { userId, Long.valueOf(HeartbeatLogObserver.this.roleid), Long.valueOf(gangId), loginIp, Integer.valueOf(fightValue), Integer.valueOf(level), channel, Integer.valueOf(friendSize), Integer.valueOf(roleMfv), Integer.valueOf(occupation) });
/*    */         
/* 82 */         TLogManager.getInstance().addLog(userId, "userheartbeat", tlogStr);
/* 83 */         Set<Integer> statuses = RoleStatusInterface.selectStatusSet(HeartbeatLogObserver.this.roleid);
/* 84 */         GameServer.logger().info(String.format("[Log]HeartbeatLogObserver.processImp@role statuses|roleid=%d|statuses=%s", new Object[] { Long.valueOf(HeartbeatLogObserver.this.roleid), statuses }));
/*    */         
/*    */ 
/* 87 */         return true;
/*    */       }
/*    */       
/*    */ 
/* 91 */     });
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\HeartbeatLogObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */