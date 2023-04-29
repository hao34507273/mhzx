/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.LadderDataBackReq;
/*     */ import hub.LadderDataBackRsp;
/*     */ import hub.LadderUserDataBack;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.ladder.main.LadderInterface;
/*     */ import mzm.gsp.ladder.main.LadderMatchEndContext;
/*     */ import mzm.gsp.ladder.main.LadderMatchEndContext.LadderMatchEnd;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class DTH_LadderDataBack extends DataTransferHandler<LadderDataBackReq, LadderDataBackRsp>
/*     */ {
/*     */   protected LadderDataBackReq makeReqDataBean()
/*     */   {
/*  29 */     return new LadderDataBackReq();
/*     */   }
/*     */   
/*     */   protected LadderDataBackRsp makeRspDataBean()
/*     */   {
/*  34 */     return new LadderDataBackRsp();
/*     */   }
/*     */   
/*     */   protected void onDataTransferReq(DataTransferReq req, LadderDataBackReq reqData)
/*     */   {
/*  39 */     LadderMatchEndContext ladderMatchEndContext = new LadderMatchEndContext(reqData.winorlose, reqData.fightresult);
/*  40 */     for (LadderUserDataBack ladderUserDataBack : reqData.ladderuserbackdatas) {
/*  41 */       String userid = ladderUserDataBack.userid.getString("UTF-8");
/*  42 */       LadderMatchEndContext.LadderMatchEnd ladderMatchEnd = new LadderMatchEndContext.LadderMatchEnd(userid, ladderUserDataBack.roleid, ladderUserDataBack.changescore, ladderUserDataBack.ladderscore, (Octets)ladderUserDataBack.usertokenmap.get(userid), ladderUserDataBack.petids, ladderUserDataBack.childrenmap, ladderUserDataBack.exchange_data_handler_info.isEmpty() ? null : (hub.ExchangeDataHandlerInfo)ladderUserDataBack.exchange_data_handler_info.get(0));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  47 */       ladderMatchEndContext.matchEndList.add(ladderMatchEnd);
/*     */     }
/*  49 */     boolean ret = new LadderUserDataBackPro(ladderMatchEndContext).call();
/*  50 */     if (!ret)
/*     */     {
/*  52 */       GameServer.logger().error("[DTH_LadderDataBack]DTH_LadderDataBack.onDataTransferReq@procedure is wrong");
/*     */     }
/*  54 */     DataTransferRsp rsp = new DataTransferRsp();
/*  55 */     rsp.direction = req.direction;
/*  56 */     rsp.xid = req.xid;
/*  57 */     rsp.src_id = req.dst_id;
/*  58 */     rsp.dst_id = req.src_id;
/*  59 */     rsp.data_type = req.data_type;
/*  60 */     rsp.retcode = 0;
/*  61 */     LadderDataBackRsp ladderDataBackRsp = new LadderDataBackRsp();
/*  62 */     OctetsStream os = new OctetsStream();
/*  63 */     ladderDataBackRsp.marshal(os);
/*  64 */     rsp.data = os;
/*  65 */     hub.GHubHelper.sendDataTransferRsp(rsp);
/*     */   }
/*     */   
/*     */   private static class LadderUserDataBackPro extends LogicProcedure
/*     */   {
/*     */     private LadderMatchEndContext context;
/*     */     
/*     */     LadderUserDataBackPro(LadderMatchEndContext context) {
/*  73 */       this.context = context;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  78 */       List<String> allUsers = new ArrayList();
/*  79 */       List<Long> allRoles = new ArrayList();
/*  80 */       for (LadderMatchEndContext.LadderMatchEnd ladderMatchEnd : this.context.matchEndList) {
/*  81 */         allUsers.add(ladderMatchEnd.userid);
/*  82 */         allRoles.add(Long.valueOf(ladderMatchEnd.roleid));
/*     */       }
/*  84 */       lock(User.getTable(), allUsers);
/*  85 */       lock(xtable.Role2properties.getTable(), allRoles);
/*  86 */       return LadderInterface.onMatchFightEnd(this.context);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, LadderDataBackReq reqData, int code)
/*     */   {
/*  94 */     GameServer.logger().error(String.format("[Ladder]DTH_LadderDataBack.DTH_LadderDataBack@time out now|des=%s", new Object[] { reqData.toString() }));
/*     */     
/*  96 */     for (final LadderUserDataBack ladderUserDataBack : reqData.ladderuserbackdatas) {
/*  97 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 101 */           String userid = ladderUserDataBack.userid.getString("UTF-8");
/* 102 */           lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 103 */           LoginManager.getInstance().onReturnOrigianServer(userid, ladderUserDataBack.roleid);
/* 104 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, LadderDataBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, LadderDataBackRsp rspData)
/*     */   {
/* 113 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 114 */     if (rsp.retcode != 0) {
/* 115 */       GameServer.logger().error(String.format("[DTH_LadderDataBack]DTH_LadderDataBack.onDataTransferRsp@ret code is error|errorcode=%d|desc=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 121 */     for (final LadderUserDataBack ladderUserDataBack : reqData.ladderuserbackdatas) {
/* 122 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/* 126 */           String userid = ladderUserDataBack.userid.getString("UTF-8");
/* 127 */           lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 128 */           LoginManager.getInstance().onReturnOrigianServer(userid, ladderUserDataBack.roleid);
/* 129 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_LadderDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */