/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.homeland.SCreateHomelandRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2homeinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCreateHomelandReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int createType;
/*     */   
/*     */   public PCreateHomelandReq(long roleId, int createType)
/*     */   {
/*  29 */     this.roleId = roleId;
/*  30 */     this.createType = createType;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[home]PCreateHomelandReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       HomelandManager.logger.info(logStr);
/*  42 */       return false;
/*     */     }
/*  44 */     String userid = RoleInterface.getUserId(this.roleId);
/*  45 */     if (userid == null)
/*     */     {
/*  47 */       String logString = String.format("[home]PCreateHomelandReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  49 */       HomelandManager.logger.error(logString);
/*  50 */       return false;
/*     */     }
/*  52 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(SHomelandCfgConsts.getInstance().CREATE_HOMELAND_NPC, SHomelandCfgConsts.getInstance().CREATE_HOMELAND_NPC_SERVICE, this.roleId))
/*     */     {
/*     */ 
/*  55 */       String logString = String.format("[home]PCreateHomelandReq.processImp@role is not near create home npc roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  58 */       HomelandManager.logger.error(logString);
/*  59 */       return false;
/*     */     }
/*  61 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  66 */     if (!HomelandManager.isRoleLevelRight(roleLevel))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     long partenerRoleId = MarriageInterface.getMarriedRoleid(this.roleId);
/*     */     
/*  73 */     boolean isMarried = false;
/*  74 */     if (partenerRoleId == -1L)
/*     */     {
/*  76 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*  77 */       Lockeys.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  81 */       String partnerUserId = RoleInterface.getUserId(partenerRoleId);
/*  82 */       Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userid, partnerUserId }));
/*  83 */       Lockeys.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(partenerRoleId) }));
/*  84 */       isMarried = true;
/*     */     }
/*  86 */     long newPartenerRoleId = MarriageInterface.getMarriedRoleid(this.roleId);
/*     */     
/*  88 */     if (newPartenerRoleId != partenerRoleId)
/*     */     {
/*  90 */       String logString = String.format("[home]PCreateHomelandReq.processImp@partenerRoleId not same|roleId=%d|createType=%d|newPartenerRoleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.createType), Long.valueOf(newPartenerRoleId), Long.valueOf(partenerRoleId) });
/*     */       
/*     */ 
/*     */ 
/*  94 */       HomelandManager.logger.info(logString);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(SHomelandCfgConsts.getInstance().INIT_HOMELAND_LEVEL);
/*  99 */     if (sHomelandCfg == null)
/*     */     {
/* 101 */       String logString = String.format("[home]PCreateHomelandReq.processImp@SHomelandCfg is null|roleId=%d|createType=%d|newPartenerRoleId=%d|partenerRoleId=%d|homeLevel", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.createType), Long.valueOf(newPartenerRoleId), Long.valueOf(partenerRoleId), Integer.valueOf(SHomelandCfgConsts.getInstance().INIT_HOMELAND_LEVEL) });
/*     */       
/*     */ 
/*     */ 
/* 105 */       HomelandManager.logger.error(logString);
/*     */       
/* 107 */       return false;
/*     */     }
/* 109 */     TLogArg logArg = new TLogArg(LogReason.CREATE_HOME, this.createType);
/*     */     
/* 111 */     if (this.createType == 0)
/*     */     {
/*     */ 
/* 114 */       boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.CREATE_HOME, this.createType, sHomelandCfg.moneyType, sHomelandCfg.moneyNum, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_CREATE_HOME);
/*     */       
/*     */ 
/* 117 */       if (!ret)
/*     */       {
/* 119 */         String logString = String.format("[home]PCreateHomelandReq.processImp@create home cut monery error|roleId=%d|partnerRoleid=%d|createType=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partenerRoleId), Integer.valueOf(this.createType), Integer.valueOf(sHomelandCfg.moneyType), Integer.valueOf(sHomelandCfg.moneyNum) });
/*     */         
/*     */ 
/*     */ 
/* 123 */         HomelandManager.logger.info(logString);
/*     */         
/* 125 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 131 */       boolean ret = mzm.gsp.item.main.ItemInterface.removeItemById(this.roleId, sHomelandCfg.itemId, sHomelandCfg.itemNum, logArg);
/*     */       
/* 133 */       if (!ret)
/*     */       {
/* 135 */         String logString = String.format("[home]PCreateHomelandReq.processImp@remove item error|roleId=%d|partnerRoleid=%d|createType=%d|itemId=%d|itemNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partenerRoleId), Integer.valueOf(this.createType), Integer.valueOf(sHomelandCfg.itemId), Integer.valueOf(sHomelandCfg.itemNum) });
/*     */         
/*     */ 
/*     */ 
/* 139 */         HomelandManager.logger.error(logString);
/* 140 */         return false;
/*     */       }
/*     */     }
/* 143 */     if (isMarried)
/*     */     {
/* 145 */       HomeInfo xHomeInfoSelf = Role2homeinfo.get(Long.valueOf(this.roleId));
/* 146 */       HomeInfo xHomeInfoPartener = Role2homeinfo.get(Long.valueOf(partenerRoleId));
/* 147 */       if ((xHomeInfoSelf == null) && (xHomeInfoPartener == null))
/*     */       {
/* 149 */         xHomeInfoSelf = Pod.newHomeInfo();
/* 150 */         Role2homeinfo.insert(Long.valueOf(this.roleId), xHomeInfoSelf);
/* 151 */         return createHome(userid, roleLevel, sHomelandCfg, xHomeInfoSelf, true, partenerRoleId);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 156 */       String logString = String.format("[home]PCreateHomelandReq.processImp@already has home|roleId=%d|partenerRoleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partenerRoleId), Long.valueOf(partenerRoleId), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*     */ 
/* 160 */       HomelandManager.logger.error(logString);
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 168 */     HomeInfo xHomeInfo = Role2homeinfo.get(Long.valueOf(this.roleId));
/* 169 */     if (xHomeInfo == null)
/*     */     {
/* 171 */       xHomeInfo = Pod.newHomeInfo();
/* 172 */       Role2homeinfo.insert(Long.valueOf(this.roleId), xHomeInfo);
/* 173 */       return createHome(userid, roleLevel, sHomelandCfg, xHomeInfo, false, -1L);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 179 */     String logString = String.format("[home]PCreateHomelandReq.processImp@already has home|roleId=%d|partenerRoleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partenerRoleId), Integer.valueOf(this.createType) });
/*     */     
/*     */ 
/*     */ 
/* 183 */     HomelandManager.logger.error(logString);
/*     */     
/* 185 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean createHome(String userid, int roleLevel, SHomelandCfg sHomelandCfg, HomeInfo xHomeInfo, boolean isMarried, long partnerRoleId)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 197 */     if (xHomeInfo != null)
/*     */     {
/* 199 */       HomeOperate xMainHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/* 200 */       HomelandManager.initXHomeInfo(this.roleId, xHomeInfo, isMarried, xMainHomeOperate);
/* 201 */       String logString = String.format("[home]PCreateHomelandReq.createHome@create home success|roleId=%d|partenerRoleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.createType) });
/*     */       
/*     */ 
/*     */ 
/* 205 */       HomelandManager.logger.info(logString);
/*     */       
/* 207 */       SCreateHomelandRes res = new SCreateHomelandRes();
/*     */       
/* 209 */       res.homelevel = xHomeInfo.getHomelevel();
/* 210 */       OnlineManager.getInstance().send(this.roleId, res);
/*     */       
/* 212 */       synHomeInfoOnCreate(this.roleId, true, xHomeInfo, xMainHomeOperate);
/*     */       
/* 214 */       if (partnerRoleId != -1L)
/*     */       {
/* 216 */         HomeOperate xPartHomeOperate = HomelandManager.getXHomeOperate(partnerRoleId);
/* 217 */         synHomeInfoOnCreate(partnerRoleId, false, xHomeInfo, xPartHomeOperate);
/*     */       }
/*     */       
/* 220 */       HomelandRankManager.getInstance().rank(new RoleHomelandChart(this.roleId, HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */       
/* 222 */       tlogCreateHome(userid, roleLevel, xHomeInfo, sHomelandCfg, isMarried, partnerRoleId);
/* 223 */       HomelandManager.triggerCreateHomeEvent(this.roleId, partnerRoleId, xHomeInfo.getHomelevel());
/* 224 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 228 */     String logString = String.format("[home]PCreateHomelandReq.createHome@create home failed|roleId=%d|partenerRoleId=%d|createType=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.createType) });
/*     */     
/*     */ 
/*     */ 
/* 232 */     HomelandManager.logger.info(logString);
/*     */     
/* 234 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void synHomeInfoOnCreate(long roleId, boolean isOwner, HomeInfo xHomeInfo, HomeOperate xHomeOperate)
/*     */     throws UnsupportedEncodingException
/*     */   {
/* 242 */     if (isOwner)
/*     */     {
/* 244 */       xHomeOperate.setHomestate(2);
/*     */     }
/*     */     else
/*     */     {
/* 248 */       xHomeOperate.setHomestate(4);
/*     */     }
/*     */     
/* 251 */     HomelandManager.sendSSynHomelandRes(roleId, isOwner, xHomeInfo, xHomeOperate);
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogCreateHome(String userid, int roleLevel, HomeInfo xHomeInfo, SHomelandCfg sHomelandCfg, boolean isMain, long partnerRoleid)
/*     */   {
/* 257 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/*     */     
/* 259 */     int moneytype = 0;
/* 260 */     int moneynum = 0;
/* 261 */     int itemid = 0;
/* 262 */     int itemnum = 0;
/* 263 */     if (this.createType == 0)
/*     */     {
/* 265 */       moneytype = sHomelandCfg.moneyType;
/* 266 */       moneynum = sHomelandCfg.moneyNum;
/*     */     }
/*     */     else
/*     */     {
/* 270 */       itemid = sHomelandCfg.itemId;
/* 271 */       itemnum = sHomelandCfg.itemNum;
/*     */     }
/*     */     
/* 274 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(moneytype), Integer.valueOf(moneynum), Integer.valueOf(itemid), Integer.valueOf(itemnum), Integer.valueOf(isMain ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)) };
/*     */     
/*     */ 
/* 277 */     TLogManager.getInstance().addLog(userid, this.roleId, "Createhome", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PCreateHomelandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */