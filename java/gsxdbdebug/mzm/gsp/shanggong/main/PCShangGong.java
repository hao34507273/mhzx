/*     */ package mzm.gsp.shanggong.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.shanggong.SShangGongFail;
/*     */ import mzm.gsp.shanggong.SShangGongSuccess;
/*     */ import mzm.gsp.shanggong.confbean.SGongPinInfo;
/*     */ import mzm.gsp.shanggong.confbean.SShangGongCfg;
/*     */ import mzm.gsp.shanggong.event.ShangGongSuccess;
/*     */ import mzm.gsp.shanggong.event.ShangGongSuccessArg;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCShangGong
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int shanggongid;
/*     */   private final long sessionid;
/*     */   private final int sortid;
/*     */   private final int moneyType;
/*     */   private final int roleMoneyNum;
/*     */   
/*     */   public PCShangGong(long roleid, int shanggongid, long sessionid, int sortid, int moneyType, int roleMoneyNum)
/*     */   {
/*  41 */     this.roleid = roleid;
/*  42 */     this.shanggongid = shanggongid;
/*  43 */     this.sessionid = sessionid;
/*  44 */     this.sortid = sortid;
/*  45 */     this.moneyType = moneyType;
/*  46 */     this.roleMoneyNum = roleMoneyNum;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     SShangGongCfg cfg = SShangGongCfg.get(this.shanggongid);
/*  53 */     if (cfg == null)
/*     */     {
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*  58 */     if ((cfg.gongpin_infos.get(Integer.valueOf(this.sortid)) == null) || (((SGongPinInfo)cfg.gongpin_infos.get(Integer.valueOf(this.sortid))).money_type != this.moneyType))
/*     */     {
/*  60 */       onFail(-3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     if (this.roleMoneyNum < 0)
/*     */     {
/*  65 */       onFail(-3, null);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!ShangGongManager.isShangGongSwitchOpenForRole(this.roleid, this.shanggongid))
/*     */     {
/*     */ 
/*  72 */       onFail(-1, null);
/*  73 */       return false;
/*     */     }
/*  75 */     if (!ShangGongManager.checkRoleStatus(this.roleid, 721))
/*     */     {
/*     */ 
/*  78 */       onFail(-2, null);
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     Session session = Session.getSession(this.sessionid);
/*  83 */     if (session == null)
/*     */     {
/*     */ 
/*  86 */       onFail(1, null);
/*  87 */       return false;
/*     */     }
/*  89 */     ShangGongVaildSession shangGongVaildSession = null;
/*  90 */     if ((session instanceof ShangGongVaildSession))
/*     */     {
/*  92 */       shangGongVaildSession = (ShangGongVaildSession)session;
/*     */     }
/*  94 */     if ((shangGongVaildSession == null) || (shangGongVaildSession.getOwerId() != this.roleid) || (shangGongVaildSession.getShangGongid() != this.shanggongid))
/*     */     {
/*     */ 
/*     */ 
/*  98 */       onFail(2, null);
/*  99 */       return false;
/*     */     }
/* 101 */     Session.removeSession(this.sessionid, this.roleid);
/*     */     
/* 103 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/* 105 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/* 107 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 108 */     int needMoneyNum = ((SGongPinInfo)cfg.gongpin_infos.get(Integer.valueOf(this.sortid))).money_num;
/* 109 */     switch (((SGongPinInfo)cfg.gongpin_infos.get(Integer.valueOf(this.sortid))).money_type)
/*     */     {
/*     */     case 1: 
/* 112 */       long yuanbao = QingfuInterface.getYuanbao(userid, true) + QingfuInterface.getBindYuanbao(userid, true);
/* 113 */       if (yuanbao != this.roleMoneyNum)
/*     */       {
/*     */ 
/* 116 */         onFail(3, null);
/* 117 */         return false;
/*     */       }
/* 119 */       if (yuanbao < needMoneyNum)
/*     */       {
/*     */ 
/* 122 */         onFail(4, null);
/* 123 */         return false;
/*     */       }
/* 125 */       if (QingfuInterface.costYuanbao(userid, this.roleid, needMoneyNum, CostType.COST_BIND_FIRST_SHANG_GONG, new TLogArg(LogReason.SHANG_GONG_COST, this.shanggongid)) != CostResult.Success)
/*     */       {
/*     */ 
/*     */ 
/* 129 */         onFail(5, null);
/* 130 */         return false;
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 134 */       long gold = RoleInterface.getGold(this.roleid);
/* 135 */       if (gold < needMoneyNum)
/*     */       {
/*     */ 
/* 138 */         onFail(4, null);
/* 139 */         return false;
/*     */       }
/* 141 */       if (!RoleInterface.cutGold(this.roleid, needMoneyNum, new TLogArg(LogReason.SHANG_GONG_COST, this.shanggongid)))
/*     */       {
/*     */ 
/* 144 */         onFail(5, null);
/* 145 */         return false;
/*     */       }
/*     */       break;
/*     */     case 3: 
/* 149 */       long silver = RoleInterface.getSilver(this.roleid);
/* 150 */       if (silver < needMoneyNum)
/*     */       {
/*     */ 
/* 153 */         onFail(4, null);
/* 154 */         return false;
/*     */       }
/* 156 */       if (!RoleInterface.cutSilver(this.roleid, needMoneyNum, new TLogArg(LogReason.SHANG_GONG_COST, this.shanggongid)))
/*     */       {
/*     */ 
/*     */ 
/* 160 */         onFail(5, null);
/* 161 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 166 */       onFail(-3, null);
/* 167 */       return false;
/*     */     }
/* 169 */     TriggerEventsManger.getInstance().triggerEvent(new ShangGongSuccess(), new ShangGongSuccessArg(this.roleid, this.shanggongid, ((SGongPinInfo)cfg.gongpin_infos.get(Integer.valueOf(this.sortid))).point), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleid)));
/*     */     
/*     */ 
/*     */ 
/* 173 */     SShangGongSuccess protocol = new SShangGongSuccess();
/* 174 */     protocol.shanggong_id = this.shanggongid;
/* 175 */     protocol.sort_id = this.sortid;
/* 176 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 178 */     StringBuilder sb = new StringBuilder();
/* 179 */     sb.append(String.format("[shanggong]PCShangGong.processImp@shang gong success|roleid=%d|shanggongid=%d|sessionid=%d|sortid=%d|money_type=%d|role_money_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shanggongid), Long.valueOf(this.sessionid), Integer.valueOf(this.sortid), Integer.valueOf(this.moneyType), Integer.valueOf(this.roleMoneyNum) }));
/*     */     
/*     */ 
/* 182 */     ShangGongManager.logger.info(sb.toString());
/* 183 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 188 */     StringBuilder sb = new StringBuilder();
/* 189 */     sb.append(String.format("[shanggong]PCShangGong.processImp@shang gong fail|roleid=%d|shanggongid=%d|sessionid=%d|sortid=%d|money_type=%d|role_money_num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.shanggongid), Long.valueOf(this.sessionid), Integer.valueOf(this.sortid), Integer.valueOf(this.moneyType), Integer.valueOf(this.roleMoneyNum), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 192 */     if (extraInfo != null)
/*     */     {
/* 194 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 196 */         sb.append("|").append((String)entry.getKey());
/* 197 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 200 */     ShangGongManager.logger.info(sb.toString());
/* 201 */     if (res > 0)
/*     */     {
/* 203 */       SShangGongFail protocol = new SShangGongFail();
/* 204 */       protocol.res = res;
/* 205 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanggong\main\PCShangGong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */