/*     */ package mzm.gsp.children.childhood;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.children.SChooseInterestFailed;
/*     */ import mzm.gsp.children.SChooseInterestSuccess;
/*     */ import mzm.gsp.children.confbean.SChildHoodConst;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.children.main.ChildrenManager;
/*     */ import mzm.gsp.homeland.main.HomelandInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChildInfo;
/*     */ import xbean.ChildhoodInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Children;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCChooseInterest
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long childid;
/*     */   private final int clientDrawLotsCfgid;
/*     */   
/*     */   public PCChooseInterest(long roleid, long childid, int clientDrawLotsCfgid)
/*     */   {
/*  45 */     this.roleid = roleid;
/*  46 */     this.childid = childid;
/*  47 */     this.clientDrawLotsCfgid = clientDrawLotsCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (this.childid <= 0L)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!ChildrenManager.isFunOpen(this.roleid))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!ChildhoodManager.isFunOpen(this.roleid))
/*     */     {
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!ChildhoodManager.canDoAction(this.roleid, 601))
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     if (!HomelandInterface.hasHome(this.roleid))
/*     */     {
/*  76 */       onFailed(8);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     String userid = RoleInterface.getUserId(this.roleid);
/*  81 */     if (userid == null)
/*     */     {
/*  83 */       onFailed(12);
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     lock(Lockeys.get(User.getTable(), userid));
/*  89 */     if (!ChildhoodManager.checkHomeWorldid(this.roleid, true))
/*     */     {
/*  91 */       onFailed(9);
/*  92 */       return false;
/*     */     }
/*  94 */     long marriedRoleid = MarriageInterface.getMarriedRoleid(this.roleid, true);
/*  95 */     ChildInfo xChildInfo = Children.get(Long.valueOf(this.childid));
/*  96 */     if (xChildInfo == null)
/*     */     {
/*  98 */       onFailed(10);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     long ownerRoleid = xChildInfo.getOwn_role_id();
/* 103 */     if (!ChildhoodManager.checkChild(xChildInfo, this.roleid, marriedRoleid))
/*     */     {
/* 105 */       Map<String, Object> extras = new HashMap();
/* 106 */       extras.put("married_roleid", Long.valueOf(marriedRoleid));
/* 107 */       extras.put("owner_roleid", Long.valueOf(ownerRoleid));
/* 108 */       extras.put("another_parent_role_id", Long.valueOf(xChildInfo.getAnother_parent_role_id()));
/* 109 */       onFailed(11, extras);
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     if (xChildInfo.getChild_period() != 1)
/*     */     {
/* 115 */       Map<String, Object> extras = new HashMap();
/* 116 */       extras.put("status", Integer.valueOf(xChildInfo.getChild_period()));
/* 117 */       onFailed(2, extras);
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (xChildInfo.getHome_state() == 0)
/*     */     {
/* 123 */       GameServer.logger().error(String.format("[childhood]PCChooseInterest.processImp@child not in home|roleid=%d|childid=%d|userid=%s|home_state=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), userid, Integer.valueOf(xChildInfo.getHome_state()) }));
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     ChildhoodInfo xChildhoodInfo = xChildInfo.getChildhood_info();
/* 131 */     int oldInterestCfgid = xChildhoodInfo.getInterest();
/*     */     
/* 133 */     if (oldInterestCfgid != this.clientDrawLotsCfgid)
/*     */     {
/* 135 */       Map<String, Object> extras = new HashMap();
/* 136 */       extras.put("client_draw_lots_cfgid", Integer.valueOf(this.clientDrawLotsCfgid));
/* 137 */       extras.put("cur_interest_cfgid", Integer.valueOf(oldInterestCfgid));
/* 138 */       onFailed(2, extras);
/* 139 */       return false;
/*     */     }
/* 141 */     long cutGold = 0L;
/* 142 */     if (oldInterestCfgid != 0)
/*     */     {
/* 144 */       TLogArg tlogArg = new TLogArg(LogReason.CHILDHOOD_CHOOSE_INTEREST);
/* 145 */       cutGold = SChildHoodConst.getInstance().RESET_INTEREST_COST;
/* 146 */       if (!RoleInterface.cutGold(this.roleid, cutGold, tlogArg))
/*     */       {
/* 148 */         Map<String, Object> extras = new HashMap();
/* 149 */         extras.put("cur_gold", Long.valueOf(RoleInterface.getGold(this.roleid)));
/* 150 */         onFailed(-1, extras);
/* 151 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 155 */     int interestCfgid = ChildhoodManager.randomInterest(oldInterestCfgid);
/* 156 */     if (interestCfgid <= 0)
/*     */     {
/* 158 */       Map<String, Object> extras = new HashMap();
/* 159 */       extras.put("old_intereset_cfgid", Integer.valueOf(oldInterestCfgid));
/* 160 */       extras.put("intereset_cfgid", Integer.valueOf(interestCfgid));
/* 161 */       onFailed(1, extras);
/* 162 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 166 */     xChildhoodInfo.setInterest(interestCfgid);
/*     */     
/*     */ 
/* 169 */     Map<Integer, Integer> intParameters = new HashMap();
/* 170 */     intParameters.put(Integer.valueOf(0), Integer.valueOf(interestCfgid));
/* 171 */     ChildrenInterface.fillChildGrowthDiary(this.childid, intParameters, null, 2, DateTimeUtils.getCurrTimeInMillis());
/*     */     
/*     */ 
/*     */ 
/* 175 */     addTlog(userid, ownerRoleid, marriedRoleid, xChildInfo.getChild_period(), oldInterestCfgid, interestCfgid, cutGold);
/*     */     
/*     */ 
/* 178 */     SChooseInterestSuccess resp = new SChooseInterestSuccess();
/* 179 */     resp.childid = this.childid;
/* 180 */     resp.draw_lots_cfgid = interestCfgid;
/* 181 */     ChildhoodManager.sendProtocol(this.roleid, marriedRoleid, resp);
/*     */     
/* 183 */     GameServer.logger().info(String.format("[childhood]PCChooseInterest.processImp@choose interest success|roleid=%d|childid=%d|old_interest_cfgid=%d|interest_cfgid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.childid), Integer.valueOf(oldInterestCfgid), Integer.valueOf(interestCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 192 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 197 */     if (retcode < 0)
/*     */     {
/* 199 */       SChooseInterestFailed resp = new SChooseInterestFailed();
/* 200 */       resp.retcode = retcode;
/* 201 */       resp.childid = this.childid;
/* 202 */       OnlineManager.getInstance().sendAtOnce(this.roleid, resp);
/*     */     }
/*     */     
/* 205 */     StringBuffer logBuilder = new StringBuffer();
/* 206 */     logBuilder.append("[childhood]PCChooseInterest.onFailed@choose interest failed");
/* 207 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 208 */     logBuilder.append('|').append("childid=").append(this.childid);
/* 209 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 211 */     if (extraParams != null)
/*     */     {
/* 213 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 215 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 219 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTlog(String userid, long ownerRoleid, long marriedRoleid, int phase, int oldInterestCfgid, int newInterestCfgid, long gold)
/*     */   {
/* 225 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 226 */     int roleLevel = RoleInterface.getLevel(this.roleid);
/*     */     
/* 228 */     TLogManager.getInstance().addLog(userid, "ChildChooseInteresetForServer", new Object[] { vGameIp, userid, Long.valueOf(this.roleid), Integer.valueOf(roleLevel), Long.valueOf(this.childid), Long.valueOf(ownerRoleid), Long.valueOf(marriedRoleid), Integer.valueOf(phase), Integer.valueOf(oldInterestCfgid), Integer.valueOf(newInterestCfgid), Long.valueOf(gold) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\childhood\PCChooseInterest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */