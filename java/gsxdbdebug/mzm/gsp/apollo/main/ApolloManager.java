/*     */ package mzm.gsp.apollo.main;
/*     */ 
/*     */ import apollo.ApolloCreateLargeRoomReq;
/*     */ import apollo.ApolloCreateLargeRoomRsp;
/*     */ import apollo.ApolloEnterLargeRoomReq;
/*     */ import apollo.ApolloEnterLargeRoomRsp;
/*     */ import apollo.ApolloExitVoipRoomReq;
/*     */ import apollo.ApolloGetAuthKeyReq;
/*     */ import apollo.ApolloGetAuthKeyRsp;
/*     */ import apollo.ApolloJoinVoipRoomReq;
/*     */ import apollo.ApolloSTTReq;
/*     */ import apollo.ApolloSTTRsp;
/*     */ import apollo.CollectGameServerApolloInfoArg;
/*     */ import apollo.CollectGameServerApolloInfoRes;
/*     */ import apollo.GetApolloInfoRes;
/*     */ import apollo.GlobalSpeakerInfoList;
/*     */ import apollo.LargeEnterReqInfo;
/*     */ import apollo.LargeEnterRspInfo;
/*     */ import apollo.ReportSpeakerOnlineInfo;
/*     */ import apollo.ReportSpeakerOnlineInfoArg;
/*     */ import apollo.SSyncGlobalRoomInfo;
/*     */ import apollo.SyncApolloChatInfo;
/*     */ import apollo.SyncReportSpeakerMicStatus;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.GDeliveryManager;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.apollo.GlobalRoomSpeakerInfoList;
/*     */ import mzm.gsp.apollo.SApolloEnterGlobalLargeRoomRsp;
/*     */ import mzm.gsp.apollo.SApolloEnterLargeRoomRsp;
/*     */ import mzm.gsp.apollo.SGetAuthKeyRsp;
/*     */ import mzm.gsp.apollo.SNotifyReportSpeakerMicStatus;
/*     */ import mzm.gsp.apollo.SSTTRsp;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ 
/*     */ public class ApolloManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*  53 */   private static final ReadWriteLock readWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*  54 */   private static boolean inited = false;
/*  55 */   private static int businessid = 0;
/*  56 */   private static Map<Integer, GlobalRoomInfo> globalRoomInfos = new HashMap();
/*     */   
/*     */   static void onRoleLogin(long roleid, String userid, mzm.gsp.apollo.SSyncApolloInfo info)
/*     */   {
/*  60 */     String openid = CommonUtils.getOpenId(userid);
/*  61 */     int zoneid = CommonUtils.getZoneId(userid);
/*     */     
/*  63 */     List<Integer> roomTypes = new ArrayList();
/*     */     
/*  65 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/*  68 */       info.business_id = businessid;
/*     */       
/*  70 */       for (GlobalRoomInfo globalRoomInfo : globalRoomInfos.values())
/*     */       {
/*  72 */         GlobalRoomSpeakerInfoList globalRoomSpeakerInfoList = new GlobalRoomSpeakerInfoList();
/*  73 */         globalRoomSpeakerInfoList.room_type = globalRoomInfo.roomType;
/*     */         
/*  75 */         for (SpeakerInfo speakerInfo : globalRoomInfo.speakers.values())
/*     */         {
/*  77 */           if (openid.equals(speakerInfo.openid))
/*     */           {
/*  79 */             roomTypes.add(Integer.valueOf(globalRoomInfo.roomType));
/*     */           }
/*     */           
/*  82 */           mzm.gsp.apollo.GlobalSpeakerInfo globalSpeakerInfo = new mzm.gsp.apollo.GlobalSpeakerInfo();
/*  83 */           globalSpeakerInfo.openid.setString(speakerInfo.openid, "UTF-8");
/*  84 */           globalSpeakerInfo.nickname.setString(speakerInfo.nickname, "UTF-8");
/*  85 */           globalSpeakerInfo.is_open_mic = ((byte)(speakerInfo.openMicZoneids.isEmpty() ? 0 : 1));
/*  86 */           globalRoomSpeakerInfoList.speaker_infos.add(globalSpeakerInfo);
/*     */         }
/*  88 */         info.global_room_speaker_info_lists.add(globalRoomSpeakerInfoList);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}finally
/*     */     {
/*     */ 
/*  97 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/* 100 */     if (roomTypes.isEmpty())
/*     */     {
/* 102 */       return;
/*     */     }
/*     */     
/* 105 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 108 */       for (Integer roomType : roomTypes)
/*     */       {
/* 110 */         GlobalRoomInfo globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(roomType);
/* 111 */         if (globalRoomInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 116 */           SpeakerInfo globalSpeakerInfo = (SpeakerInfo)globalRoomInfo.speakers.get(openid);
/* 117 */           if (globalSpeakerInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 122 */             globalSpeakerInfo.onlineZoneids.add(Integer.valueOf(zoneid));
/*     */           }
/*     */         }
/*     */       }
/*     */     } finally {
/* 127 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 132 */       ReportSpeakerOnlineInfoArg arg = new ReportSpeakerOnlineInfoArg();
/* 133 */       arg.account.setString(userid, "UTF-8");
/* 134 */       arg.online_status = 3;
/* 135 */       ReportSpeakerOnlineInfo reportSpeakerOnlineInfo = new ReportSpeakerOnlineInfo(arg);
/* 136 */       if (!GDeliveryManager.getInstance().send(reportSpeakerOnlineInfo))
/*     */       {
/* 138 */         ApolloInterface.onReportSpeakerOnlineInfoTimeout(reportSpeakerOnlineInfo);
/*     */       }
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onRoleLogoff(long roleid, String userid, boolean isEnterProtect)
/*     */   {
/* 149 */     String openid = CommonUtils.getOpenId(userid);
/* 150 */     int zoneid = CommonUtils.getZoneId(userid);
/*     */     
/* 152 */     List<Integer> roomTypes = new ArrayList();
/*     */     
/* 154 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 157 */       for (i$ = globalRoomInfos.values().iterator(); i$.hasNext();) { globalRoomInfo = (GlobalRoomInfo)i$.next();
/*     */         
/* 159 */         for (SpeakerInfo speakerInfo : globalRoomInfo.speakers.values())
/*     */         {
/* 161 */           if ((openid.equals(speakerInfo.openid)) && (speakerInfo.onlineZoneids.contains(Integer.valueOf(zoneid))))
/*     */           {
/* 163 */             roomTypes.add(Integer.valueOf(globalRoomInfo.roomType));
/*     */           }
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       Iterator i$;
/*     */       GlobalRoomInfo globalRoomInfo;
/* 170 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/* 173 */     if (!roomTypes.isEmpty())
/*     */     {
/* 175 */       return;
/*     */     }
/*     */     
/* 178 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 181 */       for (Integer roomType : roomTypes)
/*     */       {
/* 183 */         GlobalRoomInfo globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(roomType);
/* 184 */         if (globalRoomInfo != null)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 189 */           SpeakerInfo globalSpeakerInfo = (SpeakerInfo)globalRoomInfo.speakers.get(openid);
/* 190 */           if (globalSpeakerInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 195 */             globalSpeakerInfo.onlineZoneids.remove(Integer.valueOf(zoneid));
/*     */           }
/*     */         }
/*     */       }
/*     */     } finally {
/* 200 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 205 */       ReportSpeakerOnlineInfoArg arg = new ReportSpeakerOnlineInfoArg();
/* 206 */       arg.account.setString(userid, "UTF-8");
/* 207 */       arg.online_status = ((byte)(isEnterProtect ? 2 : 1));
/*     */       
/* 209 */       ReportSpeakerOnlineInfo reportSpeakerOnlineInfo = new ReportSpeakerOnlineInfo(arg);
/* 210 */       if (!GDeliveryManager.getInstance().send(reportSpeakerOnlineInfo))
/*     */       {
/* 212 */         ApolloInterface.onReportSpeakerOnlineInfoTimeout(reportSpeakerOnlineInfo);
/*     */       }
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean createGlobalLargeRoom()
/*     */   {
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   static boolean createLargeRoom(String userid, long roleid, long roomid, long contextid, boolean isGlobal)
/*     */     throws Exception
/*     */   {
/* 229 */     ApolloCreateLargeRoomReq req = new ApolloCreateLargeRoomReq();
/* 230 */     req.account.setString(userid, "UTF-8");
/* 231 */     req.roleid = roleid;
/* 232 */     req.roomid = roomid;
/* 233 */     req.roomkey = 0L;
/* 234 */     req.user_openid = 0;
/* 235 */     req.cycle_report_switch = 0;
/* 236 */     req.encrypt_size = 0;
/* 237 */     req.uuid.setString(CommonUtils.getOpenId(userid), "UTF-8");
/* 238 */     OctetsStream os = new OctetsStream();
/* 239 */     os.marshal(isGlobal);
/* 240 */     os.marshal(contextid);
/* 241 */     req.async_data.replace(os);
/*     */     
/* 243 */     return GDeliveryManager.getInstance().send(req);
/*     */   }
/*     */   
/*     */   static boolean onApolloCreateLargeRoomRsp(ApolloCreateLargeRoomRsp rsp)
/*     */   {
/* 248 */     if (rsp.retcode != 0)
/*     */     {
/*     */ 
/* 251 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 256 */       OctetsStream os = new OctetsStream(rsp.async_data);
/* 257 */       boolean isGlobalLargeRoom = os.unmarshal_boolean();
/* 258 */       if (isGlobalLargeRoom)
/*     */       {
/* 260 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 265 */       return true;
/*     */     }
/*     */     catch (Exception ex) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */     return false;
/*     */   }
/*     */   
/*     */   static boolean enterApolloGlobalRoom(long roleid, int roomType) throws Exception
/*     */   {
/* 278 */     String userid = RoleInterface.getUserId(roleid);
/* 279 */     String openid = CommonUtils.getOpenId(userid);
/*     */     
/* 281 */     long roomid = 0L;
/* 282 */     int memberType = 0;
/*     */     
/* 284 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 287 */       GlobalRoomInfo globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(Integer.valueOf(roomType));
/* 288 */       if (globalRoomInfo == null)
/*     */       {
/* 290 */         return false;
/*     */       }
/*     */       
/* 293 */       roomid = globalRoomInfo.roomid;
/* 294 */       if (globalRoomInfo.speakers.containsKey(openid))
/*     */       {
/* 296 */         memberType = 1;
/*     */       }
/*     */       else
/*     */       {
/* 300 */         memberType = 2;
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 305 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/* 308 */     return enterApolloLargeRoom(userid, roleid, openid, memberType, 0L, roomid, true);
/*     */   }
/*     */   
/*     */   static boolean enterApolloLargeRoom(long roleid, int roomType, long contextid) throws Exception
/*     */   {
/* 313 */     return false;
/*     */   }
/*     */   
/*     */   static boolean enterApolloLargeRoom(String userid, long roleid, String openid, int memberType, long gid, long roomid, boolean isGlobalLargeRoom)
/*     */     throws Exception
/*     */   {
/* 319 */     ApolloEnterLargeRoomReq req = new ApolloEnterLargeRoomReq();
/* 320 */     req.account.setString(userid, "UTF-8");
/* 321 */     req.roleid = roleid;
/* 322 */     LargeEnterReqInfo enterReqInfo = new LargeEnterReqInfo();
/* 323 */     enterReqInfo.gid = gid;
/* 324 */     enterReqInfo.roomid = roomid;
/* 325 */     enterReqInfo.user_openid = ((int)(roleid >>> 32 ^ roleid & 0xFFFFFFFFFFFFFFFF));
/* 326 */     enterReqInfo.user_ip.setString(RoleInterface.getIpStr(roleid), "UTF-8");
/* 327 */     enterReqInfo.member_type = memberType;
/* 328 */     enterReqInfo.uuid.setString(openid, "UTF-8");
/* 329 */     req.req_infos.add(enterReqInfo);
/* 330 */     OctetsStream os = new OctetsStream();
/* 331 */     os.marshal(isGlobalLargeRoom);
/* 332 */     req.async_data.replace(os);
/* 333 */     return GDeliveryManager.getInstance().send(req);
/*     */   }
/*     */   
/*     */   static boolean onApolloEnterLargeRoomRsp(ApolloEnterLargeRoomRsp rsp)
/*     */   {
/* 338 */     boolean isGlobalLargeRoom = false;
/*     */     try
/*     */     {
/* 341 */       OctetsStream os = new OctetsStream(rsp.async_data);
/* 342 */       isGlobalLargeRoom = os.unmarshal_boolean();
/*     */     }
/*     */     catch (com.goldhuman.Common.Marshal.MarshalException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 349 */     if (rsp.retcode != 0)
/*     */     {
/* 351 */       if (isGlobalLargeRoom)
/*     */       {
/* 353 */         SApolloEnterGlobalLargeRoomRsp globalLargeRoomResponse = new SApolloEnterGlobalLargeRoomRsp();
/* 354 */         globalLargeRoomResponse.retcode = rsp.retcode;
/* 355 */         OnlineManager.getInstance().send(rsp.roleid, globalLargeRoomResponse);
/*     */       }
/*     */       else
/*     */       {
/* 359 */         SApolloEnterLargeRoomRsp largeRoomResponse = new SApolloEnterLargeRoomRsp();
/* 360 */         largeRoomResponse.retcode = rsp.retcode;
/* 361 */         OnlineManager.getInstance().send(rsp.roleid, largeRoomResponse);
/*     */       }
/*     */       
/* 364 */       return true;
/*     */     }
/*     */     
/* 367 */     xio.Protocol response = null;
/* 368 */     List<mzm.gsp.apollo.LargeRoomEnterRspInfo> enterMemberRspInfos = null;
/* 369 */     if (isGlobalLargeRoom)
/*     */     {
/* 371 */       SApolloEnterGlobalLargeRoomRsp globalLargeRoomResponse = new SApolloEnterGlobalLargeRoomRsp();
/* 372 */       globalLargeRoomResponse.retcode = rsp.retcode;
/* 373 */       enterMemberRspInfos = globalLargeRoomResponse.rsp_infos;
/* 374 */       response = globalLargeRoomResponse;
/*     */     }
/*     */     else
/*     */     {
/* 378 */       SApolloEnterLargeRoomRsp largeRoomResponse = new SApolloEnterLargeRoomRsp();
/* 379 */       largeRoomResponse.retcode = rsp.retcode;
/* 380 */       enterMemberRspInfos = largeRoomResponse.rsp_infos;
/* 381 */       response = largeRoomResponse;
/*     */     }
/*     */     
/* 384 */     for (LargeEnterRspInfo apolloLargeEnterRspInfo : rsp.rsp_infos)
/*     */     {
/* 386 */       mzm.gsp.apollo.LargeRoomEnterRspInfo largeEnterRspInfo = new mzm.gsp.apollo.LargeRoomEnterRspInfo();
/* 387 */       largeEnterRspInfo.gid = apolloLargeEnterRspInfo.gid;
/* 388 */       largeEnterRspInfo.roomid = apolloLargeEnterRspInfo.roomid;
/* 389 */       largeEnterRspInfo.roomkey = apolloLargeEnterRspInfo.roomkey;
/* 390 */       largeEnterRspInfo.memberid = apolloLargeEnterRspInfo.memberid;
/* 391 */       largeEnterRspInfo.user_openid = apolloLargeEnterRspInfo.user_openid;
/* 392 */       largeEnterRspInfo.user_access = apolloLargeEnterRspInfo.user_access;
/* 393 */       largeEnterRspInfo.entrypt_switch = apolloLargeEnterRspInfo.entrypt_switch;
/* 394 */       largeEnterRspInfo.mix_voice_ability = apolloLargeEnterRspInfo.mix_voice_ability;
/* 395 */       largeEnterRspInfo.uuid = apolloLargeEnterRspInfo.uuid;
/* 396 */       enterMemberRspInfos.add(largeEnterRspInfo);
/*     */     }
/*     */     
/* 399 */     OnlineManager.getInstance().send(rsp.roleid, response);
/*     */     
/* 401 */     return true;
/*     */   }
/*     */   
/*     */   static void onGetApolloInfoRsp(apollo.GetApolloInfoArg arg, GetApolloInfoRes res)
/*     */   {
/* 406 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 409 */       inited = true;
/*     */       
/* 411 */       businessid = res.businessid;
/* 412 */       globalRoomInfos.clear();
/* 413 */       zoneids = mzm.gsp.GameServerInfoManager.getZoneIds();
/* 414 */       for (Map.Entry<Integer, GlobalSpeakerInfoList> entry : res.global_room_to_speaker_info_list.entrySet())
/*     */       {
/* 416 */         GlobalRoomInfo globalRoomInfo = new GlobalRoomInfo();
/*     */         
/* 418 */         int roomType = ((Integer)entry.getKey()).intValue();
/* 419 */         globalRoomInfo.roomType = roomType;
/* 420 */         apollo.GlobalRoomInfo apolloGlobalRoomInfo = (apollo.GlobalRoomInfo)res.global_room_infos.get(Integer.valueOf(roomType));
/* 421 */         if (apolloGlobalRoomInfo != null)
/*     */         {
/* 423 */           globalRoomInfo.roomid = apolloGlobalRoomInfo.room_id;
/* 424 */           globalRoomInfo.roomGid = apolloGlobalRoomInfo.room_gid;
/* 425 */           globalRoomInfo.roomKey = apolloGlobalRoomInfo.room_key;
/*     */         }
/*     */         
/* 428 */         GlobalSpeakerInfoList apolloGlobalSpeakerInfoList = (GlobalSpeakerInfoList)entry.getValue();
/* 429 */         for (apollo.GlobalSpeakerInfo apolloGlobalSpeakerInfo : apolloGlobalSpeakerInfoList.speaker_info_list)
/*     */         {
/* 431 */           String openid = apolloGlobalSpeakerInfo.openid.getString("UTF-8");
/*     */           
/* 433 */           SpeakerInfo speakerInfo = new SpeakerInfo();
/* 434 */           speakerInfo.openid = openid;
/* 435 */           speakerInfo.channel = apolloGlobalSpeakerInfo.channel.getString("UTF-8");
/* 436 */           speakerInfo.nickname = apolloGlobalSpeakerInfo.nickname.getString("UTF-8");
/* 437 */           speakerInfo.openMicZoneids.addAll(apolloGlobalSpeakerInfo.open_mic_zoneids);
/* 438 */           for (Iterator i$ = zoneids.iterator(); i$.hasNext();) { int zoneid = ((Integer)i$.next()).intValue();
/*     */             
/* 440 */             String userid = CommonUtils.getUserId(openid, speakerInfo.channel, zoneid);
/* 441 */             if (OnlineManager.getInstance().isOnline(userid))
/*     */             {
/* 443 */               speakerInfo.onlineZoneids.add(Integer.valueOf(zoneid));
/*     */             }
/*     */           }
/* 446 */           globalRoomInfo.speakers.put(openid, speakerInfo);
/*     */         }
/* 448 */         globalRoomInfos.put(Integer.valueOf(roomType), globalRoomInfo);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally
/*     */     {
/*     */       List<Integer> zoneids;
/*     */       
/*     */ 
/*     */ 
/* 457 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static void onSSyncGlobalRoomInfo(SSyncGlobalRoomInfo info)
/*     */   {
/* 463 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 466 */       int roomType = info.room_type;
/* 467 */       GlobalRoomInfo globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(Integer.valueOf(roomType));
/* 468 */       if (globalRoomInfo == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 473 */       globalRoomInfo.roomid = info.room_info.room_id;
/* 474 */       globalRoomInfo.roomGid = info.room_info.room_gid;
/* 475 */       globalRoomInfo.roomKey = info.room_info.room_key;
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (Exception e) {}finally
/*     */     {
/*     */ 
/*     */ 
/* 483 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendReportSpeakerMicStatus(String userid, int roomType, byte status)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 490 */     apollo.ReportSpeakerMicStatusArg arg = new apollo.ReportSpeakerMicStatusArg();
/* 491 */     arg.account.setString(userid, "UTF-8");
/* 492 */     arg.room_type = roomType;
/* 493 */     arg.is_open_mic = status;
/* 494 */     apollo.ReportSpeakerMicStatus reportSpeakerMicStatus = new apollo.ReportSpeakerMicStatus(arg);
/* 495 */     if (!GDeliveryManager.getInstance().send(reportSpeakerMicStatus))
/*     */     {
/* 497 */       ApolloInterface.onReportSpeakerMicStatusTimeout(reportSpeakerMicStatus);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean updateSpeakerMicStatus(GlobalRoomInfo globalRoomInfo, String openid, int zoneid, byte isOpenMic)
/*     */   {
/* 504 */     SpeakerInfo speakerInfo = (SpeakerInfo)globalRoomInfo.speakers.get(openid);
/* 505 */     if (speakerInfo == null)
/*     */     {
/* 507 */       return false;
/*     */     }
/*     */     
/* 510 */     boolean needNotify = false;
/* 511 */     if (isOpenMic == 1)
/*     */     {
/* 513 */       needNotify = speakerInfo.openMicZoneids.isEmpty();
/* 514 */       speakerInfo.openMicZoneids.add(Integer.valueOf(zoneid));
/*     */     }
/*     */     else
/*     */     {
/* 518 */       needNotify = (speakerInfo.openMicZoneids.size() == 1) && (speakerInfo.openMicZoneids.remove(Integer.valueOf(zoneid)));
/*     */     }
/*     */     
/* 521 */     return needNotify;
/*     */   }
/*     */   
/*     */   static void onSyncReportSpeakerMicStatus(SyncReportSpeakerMicStatus info)
/*     */   {
/* 526 */     List<Integer> needNotifyRoomTypes = null;
/*     */     
/* 528 */     int roomType = info.room_type;
/* 529 */     int zoneid = info.zoneid;
/* 530 */     byte isOpenMic = info.is_open_mic;
/*     */     
/* 532 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 535 */       String openid = info.openid.getString("UTF-8");
/* 536 */       if (roomType > 0)
/*     */       {
/* 538 */         GlobalRoomInfo globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(Integer.valueOf(roomType));
/* 539 */         if (globalRoomInfo == null) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/* 544 */         if (!updateSpeakerMicStatus(globalRoomInfo, openid, zoneid, isOpenMic)) {
/*     */           return;
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 551 */         needNotifyRoomTypes = new ArrayList(globalRoomInfos.size());
/* 552 */         for (GlobalRoomInfo globalRoomInfo : globalRoomInfos.values())
/*     */         {
/* 554 */           if (updateSpeakerMicStatus(globalRoomInfo, openid, zoneid, isOpenMic))
/*     */           {
/* 556 */             needNotifyRoomTypes.add(Integer.valueOf(globalRoomInfo.roomType));
/*     */           }
/*     */         }
/*     */         
/* 560 */         if (needNotifyRoomTypes.isEmpty()) {
/*     */           return;
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       return;
/*     */     }
/*     */     finally
/*     */     {
/* 573 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */     Iterator i$;
/* 576 */     if (roomType > 0)
/*     */     {
/* 578 */       SNotifyReportSpeakerMicStatus notifyReportSpeakerMicStatus = new SNotifyReportSpeakerMicStatus();
/* 579 */       notifyReportSpeakerMicStatus.room_type = roomType;
/* 580 */       notifyReportSpeakerMicStatus.openid = info.openid;
/* 581 */       notifyReportSpeakerMicStatus.status = isOpenMic;
/* 582 */       OnlineManager.getInstance().sendAll(notifyReportSpeakerMicStatus);
/*     */     }
/*     */     else
/*     */     {
/* 586 */       for (i$ = needNotifyRoomTypes.iterator(); i$.hasNext();) { int notifyRoomType = ((Integer)i$.next()).intValue();
/*     */         
/* 588 */         SNotifyReportSpeakerMicStatus notifyReportSpeakerMicStatus = new SNotifyReportSpeakerMicStatus();
/* 589 */         notifyReportSpeakerMicStatus.room_type = notifyRoomType;
/* 590 */         notifyReportSpeakerMicStatus.openid = info.openid;
/* 591 */         notifyReportSpeakerMicStatus.status = isOpenMic;
/* 592 */         OnlineManager.getInstance().sendAll(notifyReportSpeakerMicStatus);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void sendSyncApolloChatInfo(String userid, int roomType, Octets content)
/*     */   {
/* 599 */     SyncApolloChatInfo info = new SyncApolloChatInfo();
/* 600 */     info.room_type = roomType;
/* 601 */     info.from_zone_id = CommonUtils.getZoneId(userid);
/* 602 */     info.content = content;
/* 603 */     GDeliveryManager.getInstance().send(info);
/*     */   }
/*     */   
/*     */   static void onSyncApolloChatInfo(SyncApolloChatInfo info)
/*     */   {
/* 608 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 611 */       globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(Integer.valueOf(info.room_type));
/* 612 */       if (globalRoomInfo == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 617 */       for (i$ = globalRoomInfo.speakers.values().iterator(); i$.hasNext();) { speakerInfo = (SpeakerInfo)i$.next();
/*     */         
/* 619 */         for (i$ = speakerInfo.onlineZoneids.iterator(); i$.hasNext();) { int zoneid = ((Integer)i$.next()).intValue();
/*     */           
/* 621 */           String userid = CommonUtils.getUserId(speakerInfo.openid, speakerInfo.channel, zoneid);
/* 622 */           mzm.gsp.chat.main.ChatInterface.send2AnchorClient(userid, info.from_zone_id, globalRoomInfo.roomType, info.content);
/*     */         }
/*     */       } } finally { GlobalRoomInfo globalRoomInfo;
/*     */       Iterator i$;
/*     */       SpeakerInfo speakerInfo;
/*     */       Iterator i$;
/* 628 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static void onCollectGameServerApolloInfoReq(CollectGameServerApolloInfoArg arg, CollectGameServerApolloInfoRes res)
/*     */   {
/* 635 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/* 638 */       List<Integer> zoneids = mzm.gsp.GameServerInfoManager.getZoneIds();
/* 639 */       for (Iterator i$ = globalRoomInfos.values().iterator(); i$.hasNext();) { globalRoomInfo = (GlobalRoomInfo)i$.next();
/*     */         
/* 641 */         for (i$ = globalRoomInfo.speakers.values().iterator(); i$.hasNext();) { speakerInfo = (SpeakerInfo)i$.next();
/*     */           
/* 643 */           for (Integer zoneid : zoneids)
/*     */           {
/* 645 */             String userid = CommonUtils.getUserId(speakerInfo.openid, speakerInfo.channel, zoneid.intValue());
/* 646 */             boolean isOnline = OnlineManager.getInstance().isOnline(userid);
/* 647 */             boolean isOpenMic = speakerInfo.openMicZoneids.contains(zoneid);
/* 648 */             if ((isOnline) || (isOpenMic))
/*     */             {
/* 650 */               apollo.SpeakerStatusInfo speakerStatusInfo = new apollo.SpeakerStatusInfo();
/* 651 */               speakerStatusInfo.account.setString(userid, "UTF-8");
/* 652 */               speakerStatusInfo.room_type = globalRoomInfo.roomType;
/* 653 */               speakerStatusInfo.is_open_mic = ((byte)(isOpenMic ? 1 : 0));
/* 654 */               speakerStatusInfo.online_status = ((byte)(isOnline ? 3 : 1));
/*     */               
/* 656 */               res.speaker_status_infos.add(speakerStatusInfo);
/*     */             }
/*     */           } } }
/*     */       GlobalRoomInfo globalRoomInfo;
/*     */       Iterator i$;
/*     */       SpeakerInfo speakerInfo;
/* 662 */       res.retcode = 0;
/*     */       
/* 664 */       if (!inited)
/*     */       {
/*     */         return;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}finally
/*     */     {
/*     */ 
/* 675 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/* 678 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 681 */       List<Integer> zoneids = mzm.gsp.GameServerInfoManager.getZoneIds();
/* 682 */       Set<Integer> invalidRoomTypes = new java.util.HashSet(globalRoomInfos.keySet());
/* 683 */       for (Map.Entry<Integer, apollo.GlobalRoomInfo> entry : arg.global_room_infos.entrySet())
/*     */       {
/* 685 */         int roomType = ((Integer)entry.getKey()).intValue();
/* 686 */         invalidRoomTypes.remove(Integer.valueOf(roomType));
/*     */         
/* 688 */         apollo.GlobalRoomInfo apolloGlobalRoomInfo = (apollo.GlobalRoomInfo)entry.getValue();
/* 689 */         globalRoomInfo = (GlobalRoomInfo)globalRoomInfos.get(Integer.valueOf(roomType));
/* 690 */         if (globalRoomInfo == null)
/*     */         {
/* 692 */           globalRoomInfo = new GlobalRoomInfo();
/* 693 */           globalRoomInfo.roomType = roomType;
/* 694 */           globalRoomInfos.put(Integer.valueOf(roomType), globalRoomInfo);
/*     */         }
/* 696 */         if ((globalRoomInfo.roomid == 0L) || (apolloGlobalRoomInfo.room_id > 0L))
/*     */         {
/* 698 */           globalRoomInfo.roomid = apolloGlobalRoomInfo.room_id;
/* 699 */           globalRoomInfo.roomGid = apolloGlobalRoomInfo.room_gid;
/* 700 */           globalRoomInfo.roomKey = apolloGlobalRoomInfo.room_key;
/*     */         }
/*     */         
/* 703 */         GlobalSpeakerInfoList apolloGlobalSpeakerInfoList = (GlobalSpeakerInfoList)arg.global_room_to_speaker_info_list.get(Integer.valueOf(roomType));
/* 704 */         if (apolloGlobalSpeakerInfoList == null)
/*     */         {
/* 706 */           globalRoomInfo.speakers.clear();
/*     */         }
/*     */         else
/*     */         {
/* 710 */           Set<String> invalidSpeakers = new java.util.HashSet(globalRoomInfo.speakers.keySet());
/* 711 */           for (apollo.GlobalSpeakerInfo apolloGlobalSpeakerInfo : apolloGlobalSpeakerInfoList.speaker_info_list)
/*     */           {
/* 713 */             openid = apolloGlobalSpeakerInfo.openid.getString("UTF-8");
/* 714 */             invalidSpeakers.remove(openid);
/*     */             
/* 716 */             speakerInfo = (SpeakerInfo)globalRoomInfo.speakers.get(openid);
/* 717 */             if (speakerInfo == null)
/*     */             {
/* 719 */               speakerInfo = new SpeakerInfo();
/* 720 */               speakerInfo.openid = openid;
/* 721 */               speakerInfo.channel = apolloGlobalSpeakerInfo.channel.getString("UTF-8");
/* 722 */               speakerInfo.nickname = apolloGlobalSpeakerInfo.nickname.getString("UTF-8");
/* 723 */               speakerInfo.openMicZoneids.addAll(apolloGlobalSpeakerInfo.open_mic_zoneids);
/* 724 */               globalRoomInfo.speakers.put(openid, speakerInfo);
/*     */             }
/* 726 */             for (i$ = zoneids.iterator(); i$.hasNext();) { int zoneid = ((Integer)i$.next()).intValue();
/*     */               
/* 728 */               String userid = CommonUtils.getUserId(openid, speakerInfo.channel, zoneid);
/* 729 */               if (OnlineManager.getInstance().isOnline(userid))
/*     */               {
/* 731 */                 speakerInfo.onlineZoneids.add(Integer.valueOf(zoneid)); } } }
/*     */           String openid;
/*     */           SpeakerInfo speakerInfo;
/*     */           Iterator i$;
/* 735 */           for (String invalidSpeaker : invalidSpeakers)
/*     */           {
/* 737 */             globalRoomInfo.speakers.remove(invalidSpeaker); }
/*     */         } }
/*     */       GlobalRoomInfo globalRoomInfo;
/* 740 */       for (Integer invalidRoomType : invalidRoomTypes)
/*     */       {
/* 742 */         globalRoomInfos.remove(invalidRoomType);
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (Exception e) {}finally
/*     */     {
/*     */ 
/* 751 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean sendGetAuthKeyReq(long roleid)
/*     */   {
/* 757 */     String userid = RoleInterface.getUserId(roleid);
/* 758 */     if (userid == null)
/*     */     {
/* 760 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 765 */       ApolloGetAuthKeyReq req = new ApolloGetAuthKeyReq();
/* 766 */       req.account.setString(userid, "UTF-8");
/* 767 */       req.roleid = roleid;
/* 768 */       req.client_ip.setString(RoleInterface.getIpStr(roleid), "UTF-8");
/* 769 */       if (!GDeliveryManager.getInstance().send(req))
/*     */       {
/* 771 */         onApolloGetAuthKeyError(roleid, 8);
/* 772 */         return false;
/*     */       }
/*     */       
/* 775 */       return true;
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 781 */     return false;
/*     */   }
/*     */   
/*     */   static void onApolloGetAuthKeyRsp(ApolloGetAuthKeyRsp core)
/*     */   {
/* 786 */     if (core.retcode != 0)
/*     */     {
/* 788 */       onApolloGetAuthKeyError(core.roleid, core.retcode);
/*     */       
/* 790 */       return;
/*     */     }
/*     */     
/* 793 */     SGetAuthKeyRsp rsp = new SGetAuthKeyRsp();
/* 794 */     rsp.retcode = 0;
/* 795 */     rsp.main_svr_id = core.main_svr_id;
/* 796 */     for (apollo.ServerUrlInfo svrUrlInfo : core.main_svr_urls)
/*     */     {
/* 798 */       rsp.main_svr_urls.add(new mzm.gsp.apollo.ServerUrlInfo(svrUrlInfo.url));
/*     */     }
/* 800 */     rsp.slave_svr_id = core.slave_svr_id;
/* 801 */     for (apollo.ServerUrlInfo svrUrlInfo : core.slave_svr_urls)
/*     */     {
/* 803 */       rsp.slave_svr_urls.add(new mzm.gsp.apollo.ServerUrlInfo(svrUrlInfo.url));
/*     */     }
/* 805 */     rsp.auth_key = core.auth_key;
/* 806 */     rsp.expire_in = core.expire_in;
/* 807 */     OnlineManager.getInstance().send(core.roleid, rsp);
/*     */   }
/*     */   
/*     */   static void onApolloGetAuthKeyError(long roleid, int errorCode)
/*     */   {
/* 812 */     SGetAuthKeyRsp rsp = new SGetAuthKeyRsp();
/* 813 */     rsp.retcode = errorCode;
/* 814 */     OnlineManager.getInstance().sendAtOnce(roleid, rsp);
/*     */   }
/*     */   
/*     */   static boolean sendApolloSTTReq(long roleid, Octets fileid)
/*     */   {
/* 819 */     String userid = RoleInterface.getUserId(roleid);
/* 820 */     if (userid == null)
/*     */     {
/* 822 */       return false;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 827 */       ApolloSTTReq req = new ApolloSTTReq();
/* 828 */       req.account.setString(userid, "UTF-8");
/* 829 */       req.roleid = roleid;
/* 830 */       req.file_id = fileid;
/* 831 */       if (!GDeliveryManager.getInstance().send(req))
/*     */       {
/* 833 */         onApolloSTTError(roleid, fileid, 8);
/* 834 */         return false;
/*     */       }
/*     */       
/* 837 */       return true;
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 844 */     return false;
/*     */   }
/*     */   
/*     */   static void onApolloSTTRsp(ApolloSTTRsp core)
/*     */   {
/* 849 */     if (core.retcode != 0)
/*     */     {
/* 851 */       onApolloSTTError(core.roleid, core.file_id, core.retcode);
/*     */       
/* 853 */       return;
/*     */     }
/*     */     
/* 856 */     SSTTRsp rsp = new SSTTRsp();
/* 857 */     rsp.retcode = 0;
/* 858 */     rsp.file_id = core.file_id;
/* 859 */     rsp.file_text = core.file_text;
/* 860 */     OnlineManager.getInstance().send(core.roleid, rsp);
/*     */   }
/*     */   
/*     */   static void onApolloSTTError(long roleid, Octets fileid, int errorCode)
/*     */   {
/* 865 */     SSTTRsp rsp = new SSTTRsp();
/* 866 */     rsp.retcode = errorCode;
/* 867 */     rsp.file_id = fileid;
/* 868 */     OnlineManager.getInstance().sendAtOnce(roleid, rsp);
/*     */   }
/*     */   
/*     */   static boolean createVoipRoom(String userid, long roleid, Octets context)
/*     */   {
/*     */     try
/*     */     {
/* 875 */       apollo.ApolloCreateVoipRoomReq req = new apollo.ApolloCreateVoipRoomReq();
/* 876 */       req.account.setString(userid, "UTF-8");
/* 877 */       req.roleid = roleid;
/* 878 */       req.async_data = context;
/*     */       
/* 880 */       return GDeliveryManager.getInstance().send(req);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 885 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onApolloCreateVoipRoomRsp(apollo.ApolloCreateVoipRoomRsp rsp)
/*     */   {
/* 891 */     mzm.gsp.apollo.event.CreateVoipRoomResponse event = new mzm.gsp.apollo.event.CreateVoipRoomResponse();
/* 892 */     mzm.gsp.apollo.event.CreateVoipRoomResponseArg arg = new mzm.gsp.apollo.event.CreateVoipRoomResponseArg(rsp);
/* 893 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */   
/*     */   static boolean closeVoipRoom(String userid, long roleid, long roomid, Octets context)
/*     */   {
/*     */     try
/*     */     {
/* 900 */       apollo.ApolloCloseVoipRoomReq req = new apollo.ApolloCloseVoipRoomReq();
/* 901 */       req.account.setString(userid, "UTF-8");
/* 902 */       req.roleid = roleid;
/* 903 */       req.room_id = roomid;
/* 904 */       req.async_data = context;
/*     */       
/* 906 */       return GDeliveryManager.getInstance().send(req);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 911 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onApolloCloseVoipRoomRsp(apollo.ApolloCloseVoipRoomRsp rsp)
/*     */   {
/* 917 */     mzm.gsp.apollo.event.CloseVoipRoomResponse event = new mzm.gsp.apollo.event.CloseVoipRoomResponse();
/* 918 */     mzm.gsp.apollo.event.CloseVoipRoomResponseArg arg = new mzm.gsp.apollo.event.CloseVoipRoomResponseArg(rsp);
/* 919 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */   
/*     */   static boolean joinVoipRoom(String userid, long roleid, long roomid, Octets context)
/*     */   {
/*     */     try
/*     */     {
/* 926 */       ApolloJoinVoipRoomReq req = new ApolloJoinVoipRoomReq();
/* 927 */       req.account.setString(userid, "UTF-8");
/* 928 */       req.roleid = roleid;
/* 929 */       req.room_id = roomid;
/* 930 */       req.user.open_id.setString(CommonUtils.getOpenId(userid), "UTF-8");
/* 931 */       req.user.client_ip.setString(CommonUtils.convertIpBigEndianIntToStr(OnlineManager.getInstance().getIp(userid)), "UTF-8");
/*     */       
/* 933 */       req.async_data = context;
/*     */       
/* 935 */       return GDeliveryManager.getInstance().send(req);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 940 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onApolloJoinVoipRoomRsp(apollo.ApolloJoinVoipRoomRsp rsp)
/*     */   {
/* 946 */     mzm.gsp.apollo.event.JoinVoipRoomResponse event = new mzm.gsp.apollo.event.JoinVoipRoomResponse();
/* 947 */     mzm.gsp.apollo.event.JoinVoipRoomResponseArg arg = new mzm.gsp.apollo.event.JoinVoipRoomResponseArg(rsp);
/* 948 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean exitVoipRoom(String userid, long roleid, long roomid, int memberid, Octets context)
/*     */   {
/*     */     try
/*     */     {
/* 956 */       ApolloExitVoipRoomReq req = new ApolloExitVoipRoomReq();
/* 957 */       req.account.setString(userid, "UTF-8");
/* 958 */       req.roleid = roleid;
/* 959 */       req.room_id = roomid;
/* 960 */       req.member_id = memberid;
/* 961 */       req.user_open_id.setString(CommonUtils.getOpenId(userid), "UTF-8");
/* 962 */       req.async_data = context;
/*     */       
/* 964 */       return GDeliveryManager.getInstance().send(req);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/* 969 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   static void onApolloExitVoipRoomRsp(apollo.ApolloExitVoipRoomRsp rsp)
/*     */   {
/* 975 */     mzm.gsp.apollo.event.ExitVoipRoomResponse event = new mzm.gsp.apollo.event.ExitVoipRoomResponse();
/* 976 */     mzm.gsp.apollo.event.ExitVoipRoomResponseArg arg = new mzm.gsp.apollo.event.ExitVoipRoomResponseArg(rsp);
/* 977 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\main\ApolloManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */