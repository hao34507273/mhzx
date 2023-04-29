/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.SelectionOrFinalDataBackReq;
/*     */ import hub.SelectionOrFinalDataBackRsp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.crossbattle.knockout.KnockOutEndContext;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class DTH_KnockOutDataBack
/*     */   extends DataTransferHandler<SelectionOrFinalDataBackReq, SelectionOrFinalDataBackRsp>
/*     */ {
/*     */   protected SelectionOrFinalDataBackReq makeReqDataBean()
/*     */   {
/*  31 */     return new SelectionOrFinalDataBackReq();
/*     */   }
/*     */   
/*     */ 
/*     */   protected SelectionOrFinalDataBackRsp makeRspDataBean()
/*     */   {
/*  37 */     return new SelectionOrFinalDataBackRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onDataTransferReq(DataTransferReq req, SelectionOrFinalDataBackReq reqData)
/*     */   {
/*  43 */     List<String> userIdList = new ArrayList();
/*  44 */     for (Octets userIdOctets : reqData.team_user_list)
/*     */     {
/*  46 */       userIdList.add(userIdOctets.getString("UTF-8"));
/*     */     }
/*     */     
/*  49 */     String ownCorpsName = reqData.own_corps_name.getString("UTF-8");
/*  50 */     String opponentCorpsName = reqData.opponent_corps_name.getString("UTF-8");
/*  51 */     KnockOutEndContext crossBattleEndContext = new KnockOutEndContext(reqData.fight_type, reqData.fight_stage, reqData.fight_index_id, reqData.win_or_lose, reqData.own_corps_id, ownCorpsName, reqData.opponent_corps_id, opponentCorpsName, reqData.team_role_list, userIdList, reqData.exchange_data_handler_info_map);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */     boolean ret = new PSelectionOrFinalDataBack(crossBattleEndContext).call();
/*  59 */     if (!ret)
/*     */     {
/*  61 */       StringBuilder sb = new StringBuilder();
/*  62 */       sb.append("[crossserver_knockout]DTH_KnockOutDataBack.onDataTransferReq@own server receive fight result,procedure wrong");
/*  63 */       sb.append(reqData);
/*     */       
/*  65 */       GameServer.logger().error(sb.toString());
/*     */     }
/*     */     
/*  68 */     DataTransferRsp rsp = new DataTransferRsp();
/*  69 */     rsp.direction = req.direction;
/*  70 */     rsp.xid = req.xid;
/*  71 */     rsp.src_id = req.dst_id;
/*  72 */     rsp.dst_id = req.src_id;
/*  73 */     rsp.data_type = req.data_type;
/*  74 */     rsp.retcode = 0;
/*     */     
/*  76 */     SelectionOrFinalDataBackRsp selectionOrFinalDataBackRsp = new SelectionOrFinalDataBackRsp();
/*  77 */     OctetsStream os = new OctetsStream();
/*  78 */     selectionOrFinalDataBackRsp.marshal(os);
/*  79 */     rsp.data = os;
/*  80 */     GHubHelper.sendDataTransferRsp(rsp);
/*     */     
/*  82 */     StringBuilder sb = new StringBuilder();
/*  83 */     sb.append("[crossserver_knockout]DTH_KnockOutDataBack.onDataTransferReq@own server receive fight result");
/*  84 */     sb.append(reqData);
/*     */     
/*  86 */     GameServer.logger().info(sb.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PSelectionOrFinalDataBack
/*     */     extends LogicProcedure
/*     */   {
/*     */     private KnockOutEndContext context;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     PSelectionOrFinalDataBack(KnockOutEndContext context)
/*     */     {
/* 104 */       this.context = context;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 110 */       lock(User.getTable(), this.context.allUserIdList);
/* 111 */       lock(Role2properties.getTable(), this.context.allRoleIdList);
/*     */       
/* 113 */       return CrossBattleKnockoutInterface.onSelectionOrFinalEnd(this.context);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalDataBackReq reqData, int code)
/*     */   {
/* 121 */     StringBuilder logBuilder = new StringBuilder();
/* 122 */     logBuilder.append("[crossserver_knockout]DTH_KnockOutDataBack.onDataTransferTimeout@time out now");
/* 123 */     logBuilder.append("|req_data=").append(reqData);
/* 124 */     logBuilder.append("|code=").append(code);
/*     */     
/* 126 */     GameServer.logger().info(logBuilder.toString());
/*     */     
/* 128 */     int index = 0;
/* 129 */     for (Iterator i$ = reqData.team_role_list.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 131 */       final String userId = ((Octets)reqData.team_user_list.get(index)).getString("UTF-8");
/* 132 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 138 */           lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 139 */           LoginManager.getInstance().onReturnOrigianServer(userId, roleId);
/* 140 */           return true;
/*     */         }
/*     */         
/* 143 */       }.call();
/* 144 */       index++;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalDataBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, SelectionOrFinalDataBackRsp rspData)
/*     */   {
/* 152 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 153 */     if (rsp.retcode != 0)
/*     */     {
/* 155 */       GameServer.logger().error(String.format("[crossserver_knockout]DTH_KnockOutDataBack.onDataTransferRsp@ret code is error|errorcode=%d|desc=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 161 */     int index = 0;
/* 162 */     for (Iterator i$ = reqData.team_role_list.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 164 */       final String userId = ((Octets)reqData.team_user_list.get(index)).getString("UTF-8");
/* 165 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/* 171 */           lock(User.getTable(), Arrays.asList(new String[] { userId }));
/* 172 */           LoginManager.getInstance().onReturnOrigianServer(userId, roleId);
/* 173 */           return true;
/*     */         }
/*     */         
/* 176 */       }.call();
/* 177 */       index++;
/*     */     }
/*     */     
/* 180 */     StringBuilder logBuilder = new StringBuilder();
/* 181 */     logBuilder.append("[crossserver_knockout]DTH_KnockOutDataBack.onDataTransferRsp@rsp success");
/* 182 */     logBuilder.append("|req_data=").append(reqData);
/*     */     
/* 184 */     GameServer.logger().info(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_KnockOutDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */