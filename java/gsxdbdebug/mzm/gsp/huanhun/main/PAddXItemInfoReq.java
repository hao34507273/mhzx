/*     */ package mzm.gsp.huanhun.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.huanhun.GiveoutItemBean;
/*     */ import mzm.gsp.huanhun.RoleBaseInfo;
/*     */ import mzm.gsp.huanhun.SAddXItemInfoRep;
/*     */ import mzm.gsp.huanhun.event.FinishHuanHun;
/*     */ import mzm.gsp.huanhun.event.FinishHuanHunArg;
/*     */ import mzm.gsp.huanhun.event.HelpAddHuanHunItem;
/*     */ import mzm.gsp.huanhun.event.HelpAddHuanHunItemArg;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ItemResultEnum;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HanhunInfo;
/*     */ import xbean.ItemInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2huanhun;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PAddXItemInfoReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long roleidseekhelp;
/*     */   private final int itemindex;
/*     */   private final List<GiveoutItemBean> items;
/*     */   private String userid;
/*     */   
/*     */   public PAddXItemInfoReq(long roleId, long roleidseekhelp, int itemindex, List<GiveoutItemBean> items)
/*     */   {
/*  55 */     this.roleId = roleId;
/*  56 */     this.roleidseekhelp = roleidseekhelp;
/*  57 */     this.itemindex = itemindex;
/*  58 */     this.items = items;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  64 */     if (!HuanhunManager.isHunOpen(this.roleId))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 214, true))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (!TaskInterface.isHaveGraphId(this.roleidseekhelp, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID))
/*     */     {
/*  76 */       GameServer.logger().info(String.format("[hun]PAddXItemInfoReq.processImp@guy who seeks help not has hun task！|roleidseekhelp=%d|roleId=%d", new Object[] { Long.valueOf(this.roleidseekhelp), Long.valueOf(this.roleId) }));
/*     */       
/*     */ 
/*     */ 
/*  80 */       HuanhunManager.sendNormalResult(22, this.roleId, new String[0]);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     boolean sameGuy = false;
/*  85 */     if (this.roleId == this.roleidseekhelp)
/*     */     {
/*  87 */       sameGuy = true;
/*     */     }
/*     */     
/*  90 */     this.userid = RoleInterface.getUserId(this.roleId);
/*  91 */     String roleSeekHelpUserid = RoleInterface.getUserId(this.roleidseekhelp);
/*  92 */     if (!sameGuy)
/*     */     {
/*  94 */       if (!HuanhunManager.isRoleCallFactionHelp(this.roleidseekhelp, this.itemindex))
/*     */       {
/*  96 */         GameServer.logger().error(String.format("[hun]PAddXItemInfoReq.processImp@ role do not called help!|roleId_0=%d|roleId_1=%d|boxIndex=%d", new Object[] { Long.valueOf(this.roleidseekhelp), Long.valueOf(this.roleId), Integer.valueOf(this.itemindex) }));
/*     */         
/*     */ 
/*     */ 
/* 100 */         return false;
/*     */       }
/* 102 */       if (!GangInterface.isInOneGang(Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp) })))
/*     */       {
/* 104 */         GameServer.logger().error(String.format("[hun]PAddXItemInfoReq.processImp@ not in same faction!|roleId_0=%d|roleId_1=%d|boxIndex=%d", new Object[] { Long.valueOf(this.roleidseekhelp), Long.valueOf(this.roleId), Integer.valueOf(this.itemindex) }));
/*     */         
/*     */ 
/*     */ 
/* 108 */         return false;
/*     */       }
/* 110 */       lock(User.getTable(), Arrays.asList(new String[] { this.userid, roleSeekHelpUserid }));
/* 111 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp) }));
/*     */       
/* 113 */       HanhunInfo xHelpHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 114 */       if (xHelpHunInfo == null)
/*     */       {
/* 116 */         return false;
/*     */       }
/* 118 */       int count = xHelpHunInfo.getHelpotherleftcount();
/* 119 */       if (count <= 0)
/*     */       {
/*     */ 
/* 122 */         HuanhunManager.sendNormalResult(20, this.roleId, new String[0]);
/* 123 */         return false;
/*     */       }
/* 125 */       xHelpHunInfo.setHelpotherleftcount(--count);
/*     */     }
/*     */     else
/*     */     {
/* 129 */       lock(User.getTable(), Arrays.asList(new String[] { this.userid }));
/* 130 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     }
/* 132 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleidseekhelp));
/* 133 */     if (xHunInfo == null)
/*     */     {
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     ItemInfo xInfo = (ItemInfo)xHunInfo.getIteminfos().get(Integer.valueOf(this.itemindex));
/* 139 */     if (xInfo == null)
/*     */     {
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     if (xInfo.getTaskstate())
/*     */     {
/*     */ 
/* 147 */       HuanhunManager.sendNormalResult(5, this.roleId, new String[0]);
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     Map<Long, Integer> itemMap = new HashMap();
/* 152 */     int allCount = 0;
/* 153 */     for (GiveoutItemBean item : this.items)
/*     */     {
/* 155 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, item.uuid);
/* 156 */       if (basicItem == null)
/*     */       {
/* 158 */         return false;
/*     */       }
/* 160 */       int cfgId = basicItem.getCfgId();
/* 161 */       if ((cfgId != xInfo.getItemcfgid()) && (!HuanhunInitManager.isWantItem(Integer.valueOf(cfgId), xInfo.getItemcfgid())))
/*     */       {
/*     */ 
/* 164 */         HuanhunManager.sendNormalResult(7, this.roleId, new String[0]);
/* 165 */         return false;
/*     */       }
/* 167 */       Integer qilingLv = basicItem.getExtra(ItemStoreEnum.STRENGTH_LEVEL);
/* 168 */       if ((qilingLv != null) && (qilingLv.intValue() > 0))
/*     */       {
/* 170 */         GameServer.logger().error(String.format("[hun]PAddXItemInfoReq.processImp@ item has qilinLv!|roleId=%d|roleidseekhelp=%d|cfgId=%d|qilinLv=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp), Integer.valueOf(cfgId), Integer.valueOf(qilingLv.intValue()) }));
/*     */         
/*     */ 
/*     */ 
/* 174 */         return false;
/*     */       }
/* 176 */       itemMap.put(Long.valueOf(item.uuid), Integer.valueOf(item.num));
/* 177 */       allCount += item.num;
/*     */     }
/*     */     
/* 180 */     if (allCount != xInfo.getItemnum())
/*     */     {
/*     */ 
/* 183 */       HuanhunManager.sendNormalResult(6, this.roleId, new String[0]);
/* 184 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 188 */     ItemOperateResult res = ItemInterface.removeItemByUuid(this.roleId, itemMap, new TLogArg(LogReason.HUN_HANDUP_REM));
/* 189 */     if (!res.success())
/*     */     {
/* 191 */       GameServer.logger().error(String.format("[hun]PAddXItemInfoReq.processImp@ removeItemByUuid error!|roleId=%d|roleidseekhelp=%d|itemMap=%s|res=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp), itemMap.toString(), res.getResultEnum().toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */     xInfo.setTaskstate(true);
/*     */     
/* 200 */     boolean isZero = IdipManager.isZeroProfit(this.roleId);
/*     */     
/*     */ 
/* 203 */     awardXiuLian(xInfo, isZero);
/*     */     
/* 205 */     SAddXItemInfoRep sAddXItemInfoRep = fillAddHunItemInfo(xInfo);
/*     */     
/* 207 */     if (!checkHelper(sameGuy, xHunInfo, xInfo, sAddXItemInfoRep, isZero))
/*     */     {
/* 209 */       GameServer.logger().error(String.format("[hun]PAddXItemInfoReq.processImp@ checkHelper error!|roleId=%d|roleidseekhelp=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp) }));
/*     */       
/*     */ 
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     rmGangHelp(sAddXItemInfoRep);
/*     */     
/* 217 */     afterAddHunItem(xHunInfo);
/*     */     
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void awardXiuLian(ItemInfo xInfo, boolean isZero)
/*     */   {
/* 230 */     if (isZero)
/*     */     {
/*     */ 
/* 233 */       GameServer.logger().info(String.format("[hun]PGetHuanhunAwardReq.processImp@ role is in zero state!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 235 */       IdipManager.zeroProfitMsg(this.roleId);
/* 236 */       return;
/*     */     }
/* 238 */     int xExp = xInfo.getXiulianexp();
/* 239 */     TLogArg logArg = new TLogArg(LogReason.HUN_HANDUP_REM);
/* 240 */     XiuLianSkillInterface.addXiuLianExp(this.roleId, xExp, logArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean checkHelper(boolean sameGuy, HanhunInfo xHunInfo, ItemInfo xInfo, SAddXItemInfoRep sAddXItemInfoRep, boolean isZero)
/*     */   {
/* 255 */     if (!sameGuy)
/*     */     {
/*     */ 
/* 258 */       OnlineManager.getInstance().sendMulti(sAddXItemInfoRep, Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.roleidseekhelp) }));
/*     */       
/* 260 */       xInfo.setRoleid(this.roleId);
/* 261 */       xHunInfo.getGuyshelpyou().add(Long.valueOf(this.roleId));
/*     */       
/*     */ 
/* 264 */       HunLogManager.addHunHelpLog(this.roleidseekhelp, this.roleId, 2, xInfo.getItemcfgid());
/*     */       
/* 266 */       if (isZero)
/*     */       {
/*     */ 
/* 269 */         GameServer.logger().info(String.format("[hun]PGetHuanhunAwardReq.processImp@ role is in zero state!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */         
/* 271 */         IdipManager.zeroProfitMsg(this.roleId);
/* 272 */         return true;
/*     */       }
/*     */       
/* 275 */       AwardReason reason = new AwardReason(LogReason.HUN_GANG_HELP_AWARD);
/* 276 */       AwardModel am = AwardInterface.awardFixAward(HuanHunMiShuConsts.getInstance().HELP_OTHER_GANG_AWARD_ID, RoleInterface.getUserId(this.roleId), this.roleId, true, true, reason);
/*     */       
/* 278 */       if (am == null)
/*     */       {
/* 280 */         return false;
/*     */       }
/*     */       
/* 283 */       TriggerEventsManger.getInstance().triggerEvent(new HelpAddHuanHunItem(), new HelpAddHuanHunItemArg(this.roleId, this.roleidseekhelp, this.itemindex));
/*     */       
/* 285 */       return true;
/*     */     }
/* 287 */     OnlineManager.getInstance().send(this.roleId, sAddXItemInfoRep);
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   SAddXItemInfoRep fillAddHunItemInfo(ItemInfo xInfo)
/*     */   {
/* 299 */     SAddXItemInfoRep sAddXItemInfoRep = new SAddXItemInfoRep();
/* 300 */     sAddXItemInfoRep.itemindex = this.itemindex;
/* 301 */     sAddXItemInfoRep.roleidseekhelp = this.roleidseekhelp;
/*     */     
/* 303 */     RoleBaseInfo roleBaseInfo = HuanhunManager.fillRoleInfo(this.roleId);
/*     */     
/* 305 */     sAddXItemInfoRep.iteminfo.itemcfgid = xInfo.getItemcfgid();
/* 306 */     sAddXItemInfoRep.iteminfo.itemnum = xInfo.getItemnum();
/* 307 */     sAddXItemInfoRep.iteminfo.taskstate = 1;
/* 308 */     sAddXItemInfoRep.iteminfo.roleinfo = roleBaseInfo;
/* 309 */     sAddXItemInfoRep.iteminfo.ganghelpstate = 0;
/* 310 */     sAddXItemInfoRep.iteminfo.friendhelpstate = 0;
/* 311 */     return sAddXItemInfoRep;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void rmGangHelp(SAddXItemInfoRep sAddXItemInfoRep)
/*     */   {
/* 321 */     new PRmRoleGangHelp(this.roleidseekhelp, this.roleId, this.itemindex, sAddXItemInfoRep).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void afterAddHunItem(HanhunInfo xHunInfo)
/*     */   {
/* 332 */     if (!HuanhunManager.isAllBoxFull(xHunInfo))
/*     */     {
/* 334 */       return;
/*     */     }
/* 336 */     xHunInfo.setStatus(2);
/* 337 */     HuanhunManager.synHunStatus(this.roleidseekhelp, xHunInfo.getStatus());
/*     */     
/* 339 */     HuanhunManager.setHunTaskFinish(this.roleidseekhelp);
/*     */     
/*     */ 
/* 342 */     FinishHuanHunArg arg = new FinishHuanHunArg();
/* 343 */     arg.setRoleId(this.roleidseekhelp);
/* 344 */     TriggerEventsManger.getInstance().triggerEvent(new FinishHuanHun(), arg);
/*     */     
/*     */ 
/* 347 */     ActivityInterface.addActivityCount(this.userid, this.roleidseekhelp, HuanHunMiShuConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/* 350 */     ActivityInterface.logActivity(this.roleidseekhelp, HuanHunMiShuConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/* 351 */     ActivityInterface.tlogActivity(this.roleidseekhelp, HuanHunMiShuConsts.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PAddXItemInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */