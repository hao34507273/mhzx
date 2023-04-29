/*     */ package mzm.gsp.crossfield.roam;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataTransferReq;
/*     */ import hub.ExchangeDataHandlerInfo;
/*     */ import hub.GHubHelper;
/*     */ import hub.SingleCrossFieldDataBackReq;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*     */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamedContext;
/*     */ import mzm.gsp.crossserver.main.SingleCrossFieldRoamedRoleInfo;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.singlebattle.event.LeaveSingleBattleArg;
/*     */ import mzm.gsp.singlebattle.event.LeaveSingleBattleProcedure;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleInterface.LeaveBattleReason;
/*     */ import mzm.gsp.singlebattle.main.SingleBattleResult;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnLeaveSingleBattle
/*     */   extends LeaveSingleBattleProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!(((LeaveSingleBattleArg)this.arg).get_context() instanceof SingleCrossFieldRoamedContext))
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     SingleCrossFieldRoamedContext context = (SingleCrossFieldRoamedContext)((LeaveSingleBattleArg)this.arg).get_context();
/*  39 */     final long roleid = ((LeaveSingleBattleArg)this.arg).getRoleId();
/*  40 */     final String userid = RoleInterface.getUserId(roleid);
/*     */     
/*  42 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  44 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*     */     
/*  46 */     DataTransferReq req = new DataTransferReq();
/*  47 */     req.direction = 0;
/*  48 */     req.data_type = 406;
/*  49 */     req.src_id = GameServerInfoManager.getZoneId();
/*  50 */     req.dst_id = GameServerInfoManager.getZoneidFromUserid(userid);
/*     */     
/*  52 */     SingleCrossFieldDataBackReq reqData = new SingleCrossFieldDataBackReq();
/*  53 */     reqData.userid.setString(userid, "UTF-8");
/*  54 */     reqData.roleid = roleid;
/*  55 */     reqData.season = context.getRoleInfo(roleid).getSeason();
/*  56 */     reqData.start_timestamp = context.getRoleInfo(roleid).getStartTimestamp();
/*  57 */     reqData.pvp_fight_times = ((LeaveSingleBattleArg)this.arg).getPvpFightCount();
/*  58 */     if (((LeaveSingleBattleArg)this.arg).getReason() == SingleBattleInterface.LeaveBattleReason.ACTIVE_LEAVE)
/*     */     {
/*  60 */       reqData.back_reason = 0;
/*  61 */       reqData.result = 1;
/*  62 */       reqData.change_point = 0;
/*  63 */       reqData.is_mvp = 0;
/*     */     }
/*     */     else
/*     */     {
/*  67 */       reqData.back_reason = 1;
/*  68 */       if (((LeaveSingleBattleArg)this.arg).getRes().getWinnerCampId() == 0)
/*     */       {
/*  70 */         reqData.result = 2;
/*     */       }
/*  72 */       else if (((LeaveSingleBattleArg)this.arg).getRes().getRoleCampId(roleid) == ((LeaveSingleBattleArg)this.arg).getRes().getWinnerCampId())
/*     */       {
/*  74 */         reqData.result = 0;
/*     */       }
/*     */       else
/*     */       {
/*  78 */         reqData.result = 1;
/*     */       }
/*  80 */       reqData.change_point = ((LeaveSingleBattleArg)this.arg).getRes().getRolePoint(roleid);
/*  81 */       reqData.is_mvp = ((byte)(((LeaveSingleBattleArg)this.arg).getRes().isMvp(roleid) ? 1 : 0));
/*     */     }
/*  83 */     ExchangeDataHandlerInfo handlerInfo = new ExchangeDataHandlerInfo();
/*  84 */     if (ReturnFromRoamServerHandlerManager.boxData(userid, roleid, handlerInfo))
/*     */     {
/*  86 */       reqData.exchange_data_handler_info.add(handlerInfo);
/*     */     }
/*  88 */     OctetsStream os = new OctetsStream();
/*  89 */     os.marshal(reqData);
/*  90 */     req.data.replace(os);
/*     */     
/*  92 */     if (!GHubHelper.sendDataTransferReq(req, true, 5))
/*     */     {
/*  94 */       new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  99 */           lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 100 */           LoginManager.getInstance().onReturnOrigianServer(userid, roleid);
/* 101 */           return true;
/*     */         }
/* 103 */       }.call();
/* 104 */       GameServer.logger().error(String.format("[crossfield]POnLeaveSingleBattle.processImp@send data back req error|req_data=%s", new Object[] { reqData.toString() }));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 110 */       GameServer.logger().info(String.format("[crossfield]POnLeaveSingleBattle.processImp@send data back req success|req_data=%s", new Object[] { reqData.toString() }));
/*     */     }
/*     */     
/*     */ 
/* 114 */     SingleCrossFieldRoamedContextManager.getInstance().removeKeys(Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/* 115 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\roam\POnLeaveSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */