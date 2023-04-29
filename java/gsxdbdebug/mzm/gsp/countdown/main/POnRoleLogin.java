/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.countdown.SSynCountDownInfo;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleOneByOneManager;
/*    */ import xbean.CountDownInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.RoleCountDownInfo;
/*    */ import xtable.Role2countdowninfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long roleid = ((Long)this.arg).longValue();
/* 21 */     if (!CountDownManager.isCountDownSwitchOpenForRole(roleid, false))
/*    */     {
/*    */ 
/* 24 */       return false;
/*    */     }
/* 26 */     if (!CountDownManager.checkRoleStatus(roleid))
/*    */     {
/*    */ 
/* 29 */       return false;
/*    */     }
/* 31 */     SSynCountDownInfo protocol = new SSynCountDownInfo();
/* 32 */     long nowInSecond = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 33 */     for (Iterator i$ = SCountDownCfg.getAll().keySet().iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 35 */       SCountDownCfg cfg = SCountDownCfg.get(cfgid);
/*    */       
/* 37 */       Set<Integer> canReceiveRemindMailIndices = CountDownCfgManager.getCanReceiveRemindMailIndices(cfgid, nowInSecond);
/*    */       
/* 39 */       if (!canReceiveRemindMailIndices.isEmpty())
/*    */       {
/* 41 */         RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(roleid));
/* 42 */         if (xRoleCountDownInfo != null)
/*    */         {
/* 44 */           CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(cfgid));
/* 45 */           if (xCountDownInfo != null)
/* 46 */             canReceiveRemindMailIndices.removeAll(xCountDownInfo.getRemind_mails());
/*    */         }
/*    */       }
/* 49 */       for (Iterator i$ = canReceiveRemindMailIndices.iterator(); i$.hasNext();) { int index = ((Integer)i$.next()).intValue();
/*    */         
/* 51 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PSendRemindMail(roleid, cfgid, index));
/*    */       }
/*    */       
/* 54 */       Set<Integer> canReceiveThankMailIndices = CountDownCfgManager.getCanReceiveThankMailIndices(cfgid, nowInSecond);
/*    */       
/* 56 */       if (!canReceiveThankMailIndices.isEmpty())
/*    */       {
/* 58 */         RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(roleid));
/* 59 */         if (xRoleCountDownInfo != null)
/*    */         {
/* 61 */           CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(cfgid));
/* 62 */           if (xCountDownInfo != null)
/* 63 */             canReceiveThankMailIndices.removeAll(xCountDownInfo.getThank_mails());
/*    */         }
/*    */       }
/* 66 */       for (Iterator i$ = canReceiveThankMailIndices.iterator(); i$.hasNext();) { int index = ((Integer)i$.next()).intValue();
/*    */         
/* 68 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(roleid), new PSendThankMail(roleid, cfgid, index));
/*    */       }
/*    */       
/* 71 */       if ((nowInSecond >= cfg.festival_timestamp + cfg.festival_effect_play_time) && (nowInSecond <= cfg.festival_timestamp + cfg.red_packet_valid_time))
/*    */       {
/*    */ 
/*    */ 
/* 75 */         RoleCountDownInfo xRoleCountDownInfo = Role2countdowninfo.get(Long.valueOf(roleid));
/* 76 */         if (xRoleCountDownInfo == null)
/*    */         {
/* 78 */           xRoleCountDownInfo = Pod.newRoleCountDownInfo();
/* 79 */           Role2countdowninfo.insert(Long.valueOf(roleid), xRoleCountDownInfo);
/*    */         }
/* 81 */         CountDownInfo xCountDownInfo = (CountDownInfo)xRoleCountDownInfo.getCount_down_infos().get(Integer.valueOf(cfgid));
/* 82 */         if (xCountDownInfo == null)
/*    */         {
/* 84 */           xCountDownInfo = Pod.newCountDownInfo();
/* 85 */           xRoleCountDownInfo.getCount_down_infos().put(Integer.valueOf(cfgid), xCountDownInfo);
/*    */         }
/* 87 */         if (!xCountDownInfo.getGet_red_packet())
/*    */         {
/* 89 */           xCountDownInfo.setCan_get_red_packet(true);
/* 90 */           protocol.not_get_red_packet_cfg_ids.add(Integer.valueOf(cfgid));
/*    */         }
/*    */       }
/*    */     }
/* 94 */     OnlineManager.getInstance().send(roleid, protocol);
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */