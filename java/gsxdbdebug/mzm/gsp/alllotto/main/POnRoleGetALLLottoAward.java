/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoTurnInfo;
/*    */ import mzm.gsp.alllotto.event.RoleGetALLLottoAwardArg;
/*    */ import mzm.gsp.alllotto.event.RoleGetALLLottoAwardProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleAllLottoActivityInfo;
/*    */ import xbean.RoleAllLottoInfo;
/*    */ import xbean.RoleAllLottoTurnInfo;
/*    */ import xtable.Role_all_lotto_infos;
/*    */ 
/*    */ public class POnRoleGetALLLottoAward extends RoleGetALLLottoAwardProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     SAllLottoCfg cfg = SAllLottoCfg.get(((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid());
/* 23 */     if (cfg == null)
/*    */     {
/*    */ 
/* 26 */       onFail(-3, null);
/* 27 */       return false;
/*    */     }
/* 29 */     SAllLottoTurnInfo turnInfo = (SAllLottoTurnInfo)cfg.turn_infos.get(Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getTurn()));
/* 30 */     if (turnInfo == null)
/*    */     {
/*    */ 
/* 33 */       onFail(-3, null);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     RoleAllLottoInfo xRoleAllLottoInfo = Role_all_lotto_infos.get(Long.valueOf(((RoleGetALLLottoAwardArg)this.arg).getRoleid()));
/* 38 */     if (xRoleAllLottoInfo == null)
/*    */     {
/* 40 */       xRoleAllLottoInfo = Pod.newRoleAllLottoInfo();
/* 41 */       Role_all_lotto_infos.insert(Long.valueOf(((RoleGetALLLottoAwardArg)this.arg).getRoleid()), xRoleAllLottoInfo);
/*    */     }
/* 43 */     RoleAllLottoActivityInfo xRoleAllLottoActivityInfo = (RoleAllLottoActivityInfo)xRoleAllLottoInfo.getActivity_infos().get(Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid()));
/*    */     
/* 45 */     if (xRoleAllLottoActivityInfo == null)
/*    */     {
/* 47 */       xRoleAllLottoActivityInfo = Pod.newRoleAllLottoActivityInfo();
/* 48 */       xRoleAllLottoInfo.getActivity_infos().put(Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid()), xRoleAllLottoActivityInfo);
/*    */     }
/* 50 */     RoleAllLottoTurnInfo xRoleAllLottoTurnInfo = (RoleAllLottoTurnInfo)xRoleAllLottoActivityInfo.getTurn_infos().get(Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getTurn()));
/* 51 */     if (xRoleAllLottoTurnInfo == null)
/*    */     {
/* 53 */       xRoleAllLottoTurnInfo = Pod.newRoleAllLottoTurnInfo();
/* 54 */       xRoleAllLottoActivityInfo.getTurn_infos().put(Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getTurn()), xRoleAllLottoTurnInfo);
/* 55 */       xRoleAllLottoTurnInfo.setAward_state(0);
/*    */     }
/* 57 */     if (xRoleAllLottoTurnInfo.getAward_state() != 0)
/*    */     {
/*    */ 
/* 60 */       Map<String, Object> extraInfo = new HashMap();
/* 61 */       extraInfo.put("award_state", Integer.valueOf(xRoleAllLottoTurnInfo.getAward_state()));
/* 62 */       onFail(-10, extraInfo);
/* 63 */       return false;
/*    */     }
/* 65 */     xRoleAllLottoTurnInfo.setAward_state(1);
/* 66 */     new SendAwardSession(AllLottoManager.SEND_AWARD_DELAY_IN_SECOND, ((RoleGetALLLottoAwardArg)this.arg).getRoleid(), ((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid(), ((RoleGetALLLottoAwardArg)this.arg).getTurn());
/*    */     
/* 68 */     GameServer.logger().info(String.format("[alllotto]POnRoleGetALLLottoAward.processImp@role get all lotto award process success|roleid=%d|activity_cfg_id=%d|turn=%d", new Object[] { Long.valueOf(((RoleGetALLLottoAwardArg)this.arg).getRoleid()), Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid()), Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getTurn()) }));
/*    */     
/*    */ 
/*    */ 
/* 72 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 77 */     StringBuilder sb = new StringBuilder();
/* 78 */     sb.append(String.format("[alllotto]POnRoleGetALLLottoAward.processImp@role get all lotto award process fail|roleid=%d|activity_cfg_id=%d|turn=%d|res=%d", new Object[] { Long.valueOf(((RoleGetALLLottoAwardArg)this.arg).getRoleid()), Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getActivityCfgid()), Integer.valueOf(((RoleGetALLLottoAwardArg)this.arg).getTurn()), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 81 */     if (extraInfo != null)
/*    */     {
/* 83 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 85 */         sb.append("|").append((String)entry.getKey());
/* 86 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 89 */     GameServer.logger().info(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\POnRoleGetALLLottoAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */