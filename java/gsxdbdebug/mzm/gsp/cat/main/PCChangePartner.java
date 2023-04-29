/*     */ package mzm.gsp.cat.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.cat.SChangePartnerFailed;
/*     */ import mzm.gsp.cat.SChangePartnerSuccess;
/*     */ import mzm.gsp.cat.confbean.SCatCfgConsts;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CatInfo;
/*     */ 
/*     */ public class PCChangePartner extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private long catid;
/*     */   
/*     */   public PCChangePartner(long roleid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!CatManager.isFunOpen(this.roleid))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  40 */     if (!CatManager.checkRoleStatus(this.roleid))
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  48 */       onFailed(6);
/*  49 */       return false;
/*     */     }
/*  51 */     long worldid = HomelandInterface.getHomeWorldIdByRoleId(this.roleid, false);
/*  52 */     if (worldid < 0L)
/*     */     {
/*  54 */       onFailed(11);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     CatInfo xCatInfo = CatManager.getHomelandCat(this.roleid, true);
/*  60 */     if (xCatInfo == null)
/*     */     {
/*  62 */       onFailed(4);
/*  63 */       return false;
/*     */     }
/*  65 */     this.catid = xCatInfo.getId();
/*     */     
/*     */ 
/*  68 */     if (!CatManager.checkNpcService(this.roleid, xCatInfo))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (xCatInfo.getState() == 2)
/*     */     {
/*  76 */       Map<String, Object> extras = new HashMap();
/*  77 */       extras.put("current_state", Integer.valueOf(2));
/*  78 */       onFailed(5, extras);
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     int cost = SCatCfgConsts.getInstance().RESET_PARTNER_COST;
/*  84 */     if (cost <= 0)
/*     */     {
/*  86 */       Map<String, Object> extras = new HashMap();
/*  87 */       extras.put("cost", Integer.valueOf(cost));
/*  88 */       onFailed(13, extras);
/*  89 */       return false;
/*     */     }
/*  91 */     TLogArg logArg = new TLogArg(LogReason.CAT_CHANGE_PARTNER, 0);
/*  92 */     if (!RoleInterface.cutGold(this.roleid, cost, logArg))
/*     */     {
/*  94 */       Map<String, Object> extras = new HashMap();
/*  95 */       extras.put("cost", Integer.valueOf(cost));
/*  96 */       extras.put("current_gold", Long.valueOf(RoleInterface.getGold(this.roleid)));
/*  97 */       onFailed(-1, extras);
/*  98 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 102 */     int oldPartnerCfgid = xCatInfo.getPartner_cfgid();
/* 103 */     int partnerCfgid = CatManager.randomPartner();
/* 104 */     if (partnerCfgid < 0)
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     xCatInfo.setPartner_cfgid(partnerCfgid);
/*     */     
/*     */ 
/* 111 */     addTlog(this.roleid, this.catid, xCatInfo.getCat_level_cfgid(), xCatInfo.getItem_cfgid(), xCatInfo.getState(), oldPartnerCfgid, partnerCfgid, cost);
/*     */     
/*     */ 
/* 114 */     SChangePartnerSuccess resp = new SChangePartnerSuccess();
/* 115 */     resp.partner_cfgid = partnerCfgid;
/* 116 */     OnlineManager.getInstance().send(this.roleid, resp);
/*     */     
/* 118 */     GameServer.logger().info(String.format("[cat]PCChangePartner.processImp@change partner success|roleid=%d|catid=%d|cat_level_cfgid=%d|item_cfgid=%d|old_partner_cfgid=%d|new_partner_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.catid), Integer.valueOf(xCatInfo.getCat_level_cfgid()), Integer.valueOf(xCatInfo.getItem_cfgid()), Integer.valueOf(oldPartnerCfgid), Integer.valueOf(partnerCfgid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 123 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 128 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 133 */     if (retcode < 0)
/*     */     {
/* 135 */       SChangePartnerFailed resp = new SChangePartnerFailed();
/* 136 */       resp.retcode = retcode;
/* 137 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 140 */     StringBuffer logBuilder = new StringBuffer();
/* 141 */     logBuilder.append("[cat]PCChangePartner.onFailed@change partner failed");
/* 142 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 143 */     logBuilder.append('|').append("catid=").append(this.catid);
/* 144 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 146 */     if (extraParams != null)
/*     */     {
/* 148 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 150 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 154 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void addTlog(long roleid, long catid, int catLevelCfgid, int itemCfgid, int state, int oldPartnerCfgid, int newPartnerCfgid, int cost)
/*     */   {
/* 161 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 162 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 163 */     String userid = RoleInterface.getUserId(roleid);
/* 164 */     TLogManager.getInstance().addLog(userid, "CatChangePartnerForServer", new Object[] { vGameIp, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Long.valueOf(catid), Integer.valueOf(catLevelCfgid), Integer.valueOf(itemCfgid), Integer.valueOf(state), Integer.valueOf(oldPartnerCfgid), Integer.valueOf(newPartnerCfgid), Integer.valueOf(cost) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\main\PCChangePartner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */