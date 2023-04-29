/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.item.SUseShapeShiftItemSuccess;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SShapeShiftItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCUseShapeShiftItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   
/*     */   public PCUseShapeShiftItem(long roleid, long uuid)
/*     */   {
/*  36 */     this.roleId = roleid;
/*  37 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (this.uuid <= 0L)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  54 */     if (!OpenInterface.getOpenStatus(539))
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     if (OpenInterface.isBanPlay(this.roleId, 539))
/*     */     {
/*  60 */       OpenInterface.sendBanPlayMsg(this.roleId, 539);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  67 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1401, true))
/*     */     {
/*  69 */       GameServer.logger().info(String.format("[item]PCUseShapeShiftItem.checkRoleStatus@status check failed|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     String userid = RoleInterface.getUserId(this.roleId);
/*  76 */     lock(Lockeys.get(User.getTable(), userid));
/*  77 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  82 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/*  83 */     if (item == null)
/*     */     {
/*  85 */       onFail(102);
/*  86 */       return false;
/*     */     }
/*  88 */     if (!item.canUse(this.roleId))
/*     */     {
/*  90 */       onFail(1210);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     int itemCfgid = item.getCfgId();
/*  95 */     SItemCfg itemCfg = SItemCfg.get(itemCfgid);
/*  96 */     if ((itemCfg == null) || (itemCfg.type != 124))
/*     */     {
/*  98 */       onFail(101);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 105 */     SShapeShiftItemCfg sShapeShiftItemCfg = SShapeShiftItemCfg.get(itemCfgid);
/* 106 */     if (sShapeShiftItemCfg == null)
/*     */     {
/* 108 */       onFail(101);
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 115 */     if (RoleInterface.getLevel(this.roleId) > sShapeShiftItemCfg.useLevelMax)
/*     */     {
/* 117 */       onFail(1210);
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 124 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_SHAPE_SHIFT_ITEM);
/* 125 */     if (!ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, logArg))
/*     */     {
/* 127 */       GameServer.logger().info(String.format("[item]PCUseShapeShiftItem.processImp@remove shapeshift item failed|roleid=%d|uuid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 137 */     int awardCfgid = sShapeShiftItemCfg.rewardCfgid;
/* 138 */     if (awardCfgid > 0)
/*     */     {
/* 140 */       LogReason logReason = LogReason.ITEM_USE_SHAPE_SHIFT_ITEM;
/* 141 */       AwardReason awardReason = new AwardReason(logReason, awardCfgid);
/* 142 */       awardReason.setAwardItemBind(true);
/* 143 */       AwardModel awardModel = null;
/* 144 */       if (sShapeShiftItemCfg.awardType == 2)
/*     */       {
/* 146 */         awardModel = AwardInterface.awardFixAward(awardCfgid, userid, this.roleId, true, true, awardReason);
/*     */       }
/*     */       else
/*     */       {
/* 150 */         awardModel = AwardInterface.award(awardCfgid, userid, this.roleId, true, true, awardReason);
/*     */       }
/* 152 */       if (awardModel == null)
/*     */       {
/* 154 */         GameServer.logger().info(String.format("[item]PCUseShapeShiftItem.processImp@use shapeshift item fail, bag full|roleid=%d|uuid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfgid) }));
/*     */         
/*     */ 
/*     */ 
/* 158 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */     Collection<Integer> buffCfgIds = sShapeShiftItemCfg.buffIds;
/* 167 */     for (Iterator i$ = buffCfgIds.iterator(); i$.hasNext();) { int buffCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 169 */       BuffInterface.installBuff(this.roleId, buffCfgId);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 174 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 175 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/* 176 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Integer.valueOf(itemCfgid), Integer.valueOf(0), Integer.valueOf(awardCfgid), buffCfgIds });
/*     */     
/* 178 */     TLogManager.getInstance().addLog(this.roleId, "UseShapeShiftItemForServer", logStr);
/*     */     
/* 180 */     SUseShapeShiftItemSuccess rsp = new SUseShapeShiftItemSuccess();
/* 181 */     rsp.item_cfgid = itemCfgid;
/* 182 */     rsp.used_num = 1;
/* 183 */     OnlineManager.getInstance().send(this.roleId, rsp);
/* 184 */     GameServer.logger().info(String.format("[item]PCUseShapeShiftItem.processImp@use shapeshift item success|roleid=%d|item_cfgid=%d|buffCfgIds=%s|awardCfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemCfgid), buffCfgIds, Integer.valueOf(awardCfgid) }));
/*     */     
/*     */ 
/*     */ 
/* 188 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int reason)
/*     */   {
/* 200 */     GameServer.logger().info(String.format("[item]PCUseShapeShiftItem.onFail@use shape shift item failed|roleid=%d|reason=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(reason), Long.valueOf(this.uuid) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 206 */     ItemManager.sendWrongInfo(this.roleId, reason, new String[0]);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseShapeShiftItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */