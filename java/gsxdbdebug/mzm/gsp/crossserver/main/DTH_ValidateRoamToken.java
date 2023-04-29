/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.ValidateRoamTokenReq;
/*    */ import hub.ValidateRoamTokenRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.online.main.LoginManager.CheckCrossServer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ValidateRoamToken extends DataTransferHandler<ValidateRoamTokenReq, ValidateRoamTokenRsp>
/*    */ {
/*    */   protected ValidateRoamTokenReq makeReqDataBean()
/*    */   {
/* 22 */     return new ValidateRoamTokenReq();
/*    */   }
/*    */   
/*    */   protected ValidateRoamTokenRsp makeRspDataBean()
/*    */   {
/* 27 */     return new ValidateRoamTokenRsp();
/*    */   }
/*    */   
/*    */   protected void onDataTransferReq(DataTransferReq req, ValidateRoamTokenReq reqData)
/*    */   {
/* 32 */     DataTransferRsp rsp = new DataTransferRsp();
/* 33 */     rsp.direction = req.direction;
/* 34 */     rsp.xid = req.xid;
/* 35 */     rsp.src_id = req.dst_id;
/* 36 */     rsp.dst_id = req.src_id;
/* 37 */     rsp.data_type = req.data_type;
/*    */     
/* 39 */     ValidateRoamTokenRsp validateRoamTokenRsp = new ValidateRoamTokenRsp();
/* 40 */     String userid = reqData.userid.getString("UTF-8");
/* 41 */     boolean ret = new ValidateTokenPro(userid, reqData.token).call();
/* 42 */     if (ret) {
/* 43 */       validateRoamTokenRsp.ret = 0;
/*    */     } else {
/* 45 */       validateRoamTokenRsp.ret = 1;
/*    */     }
/* 47 */     rsp.retcode = 0;
/* 48 */     OctetsStream os = new OctetsStream();
/* 49 */     validateRoamTokenRsp.marshal(os);
/* 50 */     rsp.data = os;
/*    */     
/* 52 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   private static class ValidateTokenPro extends LogicProcedure
/*    */   {
/*    */     private final String userid;
/*    */     private final Octets token;
/*    */     
/*    */     ValidateTokenPro(String userid, Octets token) {
/* 61 */       this.userid = userid;
/* 62 */       this.token = token;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 67 */       return LoginManager.getInstance().validateRomoteServerToken(this.userid, this.token);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ValidateRoamTokenReq reqData, int code)
/*    */   {
/* 76 */     ValidateRoamTokenTransferReqXidWrapper validateRoamTokenTransferReqXidWrapper = (ValidateRoamTokenTransferReqXidWrapper)reqXidWrapper;
/* 77 */     validateRoamTokenTransferReqXidWrapper.getContext().addNormalRole(reqData.userid.getString("UTF-8"), reqData.roleid, validateRoamTokenTransferReqXidWrapper.getProtocol().dst_id, reqData.token);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ValidateRoamTokenReq reqData, DataTransferRspXidWrapper rspXidWrapper, ValidateRoamTokenRsp rspData)
/*    */   {
/* 84 */     ValidateRoamTokenTransferReqXidWrapper validateRoamTokenTransferReqXidWrapper = (ValidateRoamTokenTransferReqXidWrapper)reqXidWrapper;
/* 85 */     LoginManager.CheckCrossServer checkCrossServer = validateRoamTokenTransferReqXidWrapper.getContext();
/* 86 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 87 */     if (rsp.retcode != 0) {
/* 88 */       GameServer.logger().error(String.format("[DTH_ValidateRoamToken]DTH_ValidateRoamToken.onDataTransferRsp@ret errorcode|code=%d", new Object[] { Integer.valueOf(rsp.retcode) }));
/*    */       
/*    */ 
/*    */ 
/* 92 */       checkCrossServer.addNormalRole(reqData.userid.getString("UTF-8"), reqData.roleid, validateRoamTokenTransferReqXidWrapper.getProtocol().dst_id, reqData.token);
/*    */ 
/*    */     }
/* 95 */     else if (rspData.ret == 0) {
/* 96 */       checkCrossServer.addCrossRole();
/*    */     } else {
/* 98 */       checkCrossServer.addNormalRole(reqData.userid.getString("UTF-8"), reqData.roleid, validateRoamTokenTransferReqXidWrapper.getProtocol().dst_id, reqData.token);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ValidateRoamToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */