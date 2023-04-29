/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.FriendsCircleGiveGiftReq;
/*     */ import hub.FriendsCircleGiveGiftRsp;
/*     */ import hub.GHubHelper;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friendscircle.main.FriendsCircleInterface;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerGiveFriendsCircleGift;
/*     */ import mzm.gsp.friendscircle.main.POnCrossServerGiveFriendsCircleGiftRsp;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_FriendsCircleGiveGift
/*     */   extends DataTransferHandler<FriendsCircleGiveGiftReq, FriendsCircleGiveGiftRsp>
/*     */ {
/*     */   protected FriendsCircleGiveGiftReq makeReqDataBean()
/*     */   {
/*  28 */     return new FriendsCircleGiveGiftReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected FriendsCircleGiveGiftRsp makeRspDataBean()
/*     */   {
/*  34 */     return new FriendsCircleGiveGiftRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, FriendsCircleGiveGiftReq reqData)
/*     */   {
/*  40 */     String activeRoleName = reqData.active_give_role_name.getString("UTF-8");
/*  41 */     String giftMessage = reqData.give_gift_message.getString("UTF-8");
/*     */     
/*  43 */     StringBuilder sBuilder = new StringBuilder();
/*  44 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.onDataTransferReq@get friends circle give gift req");
/*  45 */     sBuilder.append("|req=").append(req);
/*  46 */     sBuilder.append("|req_data=").append(reqData);
/*  47 */     sBuilder.append("|active_role_name=").append(activeRoleName);
/*     */     
/*  49 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/*  51 */     POnCrossServerGiveFriendsCircleGift procedure = new POnCrossServerGiveFriendsCircleGift(reqData.active_give_role_id, activeRoleName, req.src_id, reqData.receive_role_id, reqData.gift_item_cfg_id, reqData.gift_item_num, reqData.gift_grade, reqData.add_popularity_value, giftMessage, reqData.give_gift_serial_id);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */     procedure.call();
/*     */     
/*  64 */     DataTransferRsp rsp = new DataTransferRsp();
/*  65 */     rsp.direction = req.direction;
/*  66 */     rsp.xid = req.xid;
/*  67 */     rsp.src_id = req.dst_id;
/*  68 */     rsp.dst_id = req.src_id;
/*  69 */     rsp.data_type = req.data_type;
/*  70 */     rsp.retcode = 0;
/*     */     
/*  72 */     FriendsCircleGiveGiftRsp rspData = new FriendsCircleGiveGiftRsp();
/*  73 */     String receiveRoleName = procedure.getReceiveRoleName();
/*  74 */     if (receiveRoleName != null)
/*     */     {
/*     */       try
/*     */       {
/*  78 */         rspData.receive_role_name.setString(receiveRoleName, "UTF-8");
/*     */       }
/*     */       catch (UnsupportedEncodingException e)
/*     */       {
/*  82 */         e.printStackTrace();
/*     */       }
/*     */     }
/*  85 */     rspData.receive_role_total_popularity = procedure.getReceiveRoleTotalPopularity();
/*  86 */     rspData.receive_role_week_popularity = procedure.getReceiveRoleWeekPopularity();
/*  87 */     rspData.receive_role_gift_num = procedure.getReceiveRoleGiftNum();
/*     */     
/*  89 */     rspData.result = ((byte)procedure.getResult());
/*     */     
/*  91 */     rsp.data = new OctetsStream().marshal(rspData);
/*     */     
/*  93 */     StringBuilder rspSbLog = new StringBuilder();
/*  94 */     rspSbLog.append("|req=").append(req);
/*  95 */     rspSbLog.append("|req_data=").append(reqData);
/*  96 */     rspSbLog.append("|rsp_result=").append(rspData.result);
/*  97 */     rspSbLog.append("|receive_role_name=").append(rspData);
/*     */     
/*  99 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*     */     {
/* 101 */       GameServer.logger().error(String.format("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.onDataTransferReq@send friends circle gift rsp failed|context=%s", new Object[] { rspSbLog }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 107 */     GameServer.logger().info(String.format("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.onDataTransferReq@send friends circle gift rsp success|context=%s", new Object[] { rspSbLog }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleGiveGiftReq reqData, int code)
/*     */   {
/* 116 */     String activeRoleName = reqData.active_give_role_name.getString("UTF-8");
/*     */     
/* 118 */     StringBuilder sBuilder = new StringBuilder();
/* 119 */     sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.onDataTransferTimeout@send friends circle gift rsp time out");
/* 120 */     sBuilder.append("|req=").append(reqXidWrapper.getProtocol());
/* 121 */     sBuilder.append("|req_data=").append(reqData);
/* 122 */     sBuilder.append("|active_role_name=").append(activeRoleName);
/* 123 */     sBuilder.append("|code=").append(code);
/*     */     
/* 125 */     GameServer.logger().info(sBuilder.toString());
/*     */     
/* 127 */     new PRepeatFriendsCircleGiveGift(reqXidWrapper, reqData).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleGiveGiftReq reqData, DataTransferRspXidWrapper rspXidWrapper, FriendsCircleGiveGiftRsp rspData)
/*     */   {
/* 134 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 135 */     if (rsp.retcode != 0)
/*     */     {
/* 137 */       StringBuilder sBuilder = new StringBuilder();
/* 138 */       sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.onDataTransferRsp@friends circle gift rsp fail");
/* 139 */       sBuilder.append("|rsp_retcode=").append(rsp.retcode);
/* 140 */       sBuilder.append("|req_data=").append(reqData);
/*     */       
/* 142 */       GameServer.logger().error(sBuilder.toString());
/* 143 */       return;
/*     */     }
/*     */     
/* 146 */     new POnCrossServerGiveFriendsCircleGiftRsp(reqData.active_give_role_id, rspData.receive_role_name.getString("UTF-8"), rsp.src_id, reqData.receive_role_id, reqData.gift_item_cfg_id, reqData.gift_item_num, reqData.gift_grade, reqData.add_popularity_value, reqData.give_gift_message.getString("UTF-8"), rspData.receive_role_total_popularity, rspData.receive_role_week_popularity, rspData.receive_role_gift_num, reqData.give_gift_serial_id, rspData.result).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PRepeatFriendsCircleGiveGift
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final DataTransferReqXidWrapper reqXidWrapper;
/*     */     
/*     */ 
/*     */     private final FriendsCircleGiveGiftReq reqData;
/*     */     
/*     */ 
/*     */     public PRepeatFriendsCircleGiveGift(DataTransferReqXidWrapper reqXidWrapper, FriendsCircleGiveGiftReq reqData)
/*     */     {
/* 162 */       this.reqXidWrapper = reqXidWrapper;
/* 163 */       this.reqData = reqData;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 169 */       long activeGiveGiftRoleId = this.reqData.active_give_role_id;
/* 170 */       long serialId = this.reqData.give_gift_serial_id;
/*     */       
/* 172 */       if (FriendsCircleInterface.isGiveGiftNotServerReplied(activeGiveGiftRoleId, serialId))
/*     */       {
/*     */ 
/* 175 */         StringBuilder sBuilder = new StringBuilder();
/* 176 */         sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.PRepeatFriendsCircleGiveGift.processImp@aleardy deal");
/* 177 */         sBuilder.append("|req_data=").append(this.reqData);
/*     */         
/* 179 */         GameServer.logger().info(sBuilder.toString());
/* 180 */         return false;
/*     */       }
/*     */       
/* 183 */       FriendsCircleGiveGiftTransferReqXidWrapper xidWrapper = (FriendsCircleGiveGiftTransferReqXidWrapper)this.reqXidWrapper;
/*     */       
/* 185 */       if (xidWrapper.repeatTimes++ > 2)
/*     */       {
/* 187 */         return false;
/*     */       }
/*     */       
/* 190 */       if (!GHubHelper.sendDataTransferReq(this.reqXidWrapper, false))
/*     */       {
/* 192 */         StringBuilder sBuilder = new StringBuilder();
/* 193 */         sBuilder.append("[crossserver_friendscircle]DTH_FriendsCircleGiveGift.PRepeatFriendsCircleGiveGift.processImp@send fail");
/* 194 */         sBuilder.append("|req_data=").append(this.reqData);
/* 195 */         sBuilder.append("|repeat_times=").append(xidWrapper.repeatTimes);
/*     */         
/* 197 */         GameServer.logger().info(sBuilder.toString());
/*     */         
/* 199 */         return false;
/*     */       }
/* 201 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_FriendsCircleGiveGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */