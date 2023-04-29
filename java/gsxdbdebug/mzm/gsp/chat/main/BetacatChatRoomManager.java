/*     */ package mzm.gsp.chat.main;
/*     */ 
/*     */ import betacat.DataBetweenBetacatAndGameServerReq;
/*     */ import betacat.DataBetweenBetacatAndGameServerRsp;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.GDeliveryManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.chat.ChatContent;
/*     */ import mzm.gsp.chat.SChatInRoom;
/*     */ import mzm.gsp.chat.SExitChatRoomRsp;
/*     */ import mzm.gsp.chat.SJoinChatRoomRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.personal.main.PersonalInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleChatInfo;
/*     */ import xtable.Role2chat;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BetacatChatRoomManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static final boolean sendJoinRoomReq(long roleid)
/*     */   {
/*  33 */     int province = PersonalInterface.getProvince(roleid, false);
/*  34 */     if (province < 0)
/*     */     {
/*  36 */       onJoinRoomFailed(roleid, -1);
/*  37 */       return false;
/*     */     }
/*     */     
/*  40 */     String userid = RoleInterface.getUserId(roleid);
/*  41 */     if (userid == null)
/*     */     {
/*  43 */       onJoinRoomFailed(roleid, -3);
/*  44 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  49 */       DataBetweenBetacatAndGameServerReq req = new DataBetweenBetacatAndGameServerReq();
/*  50 */       req.direction = 2;
/*  51 */       req.account.setString(userid, "UTF-8");
/*  52 */       req.zoneid = CommonUtils.getZoneId(userid);
/*  53 */       req.roleid = roleid;
/*  54 */       req.data_type = 1;
/*  55 */       OctetsStream os = new OctetsStream();
/*  56 */       os.marshal(province);
/*  57 */       req.data.replace(os);
/*  58 */       if (!GDeliveryManager.getInstance().send(req))
/*     */       {
/*  60 */         onJoinRoomFailed(roleid, -2);
/*  61 */         return false;
/*     */       }
/*     */       
/*  64 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  68 */       onJoinRoomFailed(roleid, -3);
/*     */     }
/*  70 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void onJoinRoomFailed(long roleid, int retcode)
/*     */   {
/*  76 */     SJoinChatRoomRsp rsp = new SJoinChatRoomRsp();
/*  77 */     rsp.retcode = retcode;
/*  78 */     OnlineManager.getInstance().sendAtOnce(roleid, rsp);
/*     */   }
/*     */   
/*     */   static final void onJoinRoomRsp(long roleid, boolean isOK, int province, int roomid)
/*     */   {
/*  83 */     if (isOK)
/*     */     {
/*  85 */       RoleChatInfo xRoleChatInfo = Role2chat.get(Long.valueOf(roleid));
/*  86 */       if (xRoleChatInfo == null)
/*     */       {
/*  88 */         xRoleChatInfo = Pod.newRoleChatInfo();
/*  89 */         Role2chat.insert(Long.valueOf(roleid), xRoleChatInfo);
/*     */       }
/*     */       
/*  92 */       xRoleChatInfo.setChat_room_type(province);
/*  93 */       xRoleChatInfo.setChat_roomid(roomid);
/*     */     }
/*     */     
/*  96 */     if (OnlineManager.getInstance().isOnline(roleid))
/*     */     {
/*  98 */       SJoinChatRoomRsp joinChatRoomRsp = new SJoinChatRoomRsp();
/*  99 */       joinChatRoomRsp.retcode = (isOK ? 0 : -3);
/* 100 */       joinChatRoomRsp.province = province;
/* 101 */       OnlineManager.getInstance().send(roleid, joinChatRoomRsp);
/*     */     }
/*     */   }
/*     */   
/*     */   static final boolean sendExitRoomReq(long roleid)
/*     */   {
/* 107 */     String userid = RoleInterface.getUserId(roleid);
/* 108 */     if (userid == null)
/*     */     {
/* 110 */       onExitRoomFailed(roleid, -3);
/* 111 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 116 */       DataBetweenBetacatAndGameServerReq req = new DataBetweenBetacatAndGameServerReq();
/* 117 */       req.direction = 2;
/* 118 */       req.account.setString(userid, "UTF-8");
/* 119 */       req.zoneid = CommonUtils.getZoneId(userid);
/* 120 */       req.roleid = roleid;
/* 121 */       req.data_type = 2;
/* 122 */       if (!GDeliveryManager.getInstance().send(req))
/*     */       {
/* 124 */         onExitRoomFailed(roleid, -2);
/* 125 */         return false;
/*     */       }
/*     */       
/* 128 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 132 */       onExitRoomFailed(roleid, -3); }
/* 133 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static final void onExitRoomFailed(long roleid, int retcode)
/*     */   {
/* 139 */     SExitChatRoomRsp rsp = new SExitChatRoomRsp();
/* 140 */     rsp.retcode = retcode;
/* 141 */     OnlineManager.getInstance().sendAtOnce(roleid, rsp);
/*     */   }
/*     */   
/*     */   static final boolean sendChatInRoomReq(String userid, long roleid, ChatContent chatContent)
/*     */   {
/*     */     try
/*     */     {
/* 148 */       DataBetweenBetacatAndGameServerReq req = new DataBetweenBetacatAndGameServerReq();
/* 149 */       req.direction = 2;
/* 150 */       req.account.setString(userid, "UTF-8");
/* 151 */       req.zoneid = CommonUtils.getZoneId(userid);
/* 152 */       req.roleid = roleid;
/* 153 */       req.data_type = 3;
/* 154 */       OctetsStream os = new OctetsStream();
/* 155 */       chatContent.marshal(os);
/* 156 */       req.data.replace(os);
/* 157 */       return GDeliveryManager.getInstance().send(req);
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   static final void onDataBetweenBetacatAndGameServerReq(DataBetweenBetacatAndGameServerReq req)
/*     */   {
/*     */     try
/*     */     {
/* 171 */       if (req.data_type == 3)
/*     */       {
/* 173 */         SChatInRoom chatInRoom = new SChatInRoom();
/* 174 */         OctetsStream os = new OctetsStream(req.data);
/* 175 */         chatInRoom.sender_zoneid = os.unmarshal_int();
/* 176 */         chatInRoom.content.unmarshal(new OctetsStream(os.unmarshal_Octets()));
/* 177 */         List<Long> roleids = new ArrayList();
/* 178 */         for (int size = os.uncompact_uint32(); size > 0; size--)
/*     */         {
/* 180 */           long roleid = os.unmarshal_long();
/*     */           
/* 182 */           String userid = os.unmarshal_String();
/* 183 */           roleids.add(Long.valueOf(roleid));
/*     */         }
/* 185 */         OnlineManager.getInstance().sendMulti(chatInRoom, roleids);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final void onDataBetweenBetacatAndGameServerRsp(DataBetweenBetacatAndGameServerRsp rsp)
/*     */   {
/*     */     try
/*     */     {
/* 198 */       long roleid = rsp.roleid;
/* 199 */       if (rsp.data_type == 1)
/*     */       {
/* 201 */         int province = 0;
/* 202 */         int roomid = 0;
/* 203 */         int retcode = rsp.retcode;
/* 204 */         boolean isOk = (retcode == 14) || (retcode == 0);
/* 205 */         if (isOk)
/*     */         {
/* 207 */           OctetsStream os = new OctetsStream(rsp.data);
/* 208 */           province = os.unmarshal_int();
/* 209 */           roomid = os.unmarshal_int();
/*     */         }
/* 211 */         onJoinRoomRsp(roleid, isOk, province, roomid);
/*     */       }
/* 213 */       else if (rsp.data_type == 2)
/*     */       {
/* 215 */         if (OnlineManager.getInstance().isOnline(roleid))
/*     */         {
/* 217 */           SExitChatRoomRsp exitChatRoomRsp = new SExitChatRoomRsp();
/* 218 */           exitChatRoomRsp.retcode = rsp.retcode;
/* 219 */           OnlineManager.getInstance().send(roleid, exitChatRoomRsp);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final boolean onRoleRealOffline(long roleid)
/*     */   {
/* 231 */     RoleChatInfo xRoleChatInfo = Role2chat.get(Long.valueOf(roleid));
/* 232 */     if (xRoleChatInfo == null)
/*     */     {
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     if ((xRoleChatInfo.getChat_room_type() > 0) || (xRoleChatInfo.getChat_roomid() > 0))
/*     */     {
/* 239 */       xRoleChatInfo.setChat_room_type(-1);
/* 240 */       xRoleChatInfo.setChat_roomid(-1);
/*     */       
/* 242 */       sendExitRoomReq(roleid);
/*     */     }
/*     */     
/* 245 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean onRoleLogin(long roleid)
/*     */   {
/* 250 */     RoleChatInfo xRoleChatInfo = Role2chat.get(Long.valueOf(roleid));
/* 251 */     if (xRoleChatInfo == null)
/*     */     {
/* 253 */       xRoleChatInfo = Pod.newRoleChatInfo();
/* 254 */       Role2chat.insert(Long.valueOf(roleid), xRoleChatInfo);
/*     */       
/* 256 */       sendExitRoomReq(roleid);
/*     */       
/* 258 */       return true;
/*     */     }
/*     */     
/* 261 */     if ((xRoleChatInfo.getChat_room_type() > 0) || (xRoleChatInfo.getChat_roomid() > 0))
/*     */     {
/* 263 */       xRoleChatInfo.setChat_room_type(-1);
/* 264 */       xRoleChatInfo.setChat_roomid(-1);
/*     */       
/* 266 */       sendExitRoomReq(roleid);
/*     */     }
/*     */     
/* 269 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   static final boolean isOpen(long roleid, String logPrgDesc)
/*     */   {
/* 275 */     if (!OpenInterface.getOpenStatus(135))
/*     */     {
/* 277 */       GameServer.logger().info(String.format("[chat]%s@chat room system switch closed|role_id=%d", new Object[] { logPrgDesc, Long.valueOf(roleid) }));
/*     */       
/* 279 */       OpenInterface.sendCloseProtocol(roleid, 135, null);
/*     */       
/* 281 */       return false;
/*     */     }
/*     */     
/* 284 */     if (OpenInterface.isBanPlay(roleid, 135))
/*     */     {
/* 286 */       GameServer.logger().info(String.format("[chat]%s@chat room is ban play|role_id=%d", new Object[] { logPrgDesc, Long.valueOf(roleid) }));
/*     */       
/* 288 */       OpenInterface.sendBanPlayMsg(roleid, 135);
/*     */       
/* 290 */       return false;
/*     */     }
/*     */     
/* 293 */     return true;
/*     */   }
/*     */   
/*     */   static final boolean isJoinRoom(long roleid)
/*     */   {
/* 298 */     Integer roomType = Role2chat.selectChat_room_type(Long.valueOf(roleid));
/* 299 */     Integer roomid = Role2chat.selectChat_roomid(Long.valueOf(roleid));
/* 300 */     return (roomType != null) && (roomType.intValue() > -1) && (roomid != null) && (roomid.intValue() > -1);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\BetacatChatRoomManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */