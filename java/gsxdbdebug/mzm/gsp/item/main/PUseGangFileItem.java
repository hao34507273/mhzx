/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.SUseGangFileItemRes;
/*     */ import mzm.gsp.item.confbean.SGangFileItem;
/*     */ import mzm.gsp.item.event.UseGangFileItemArg;
/*     */ import mzm.gsp.item.event.UseGangFileItemEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Gang;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseGangFileItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   
/*     */   public PUseGangFileItem(long roleid, long uuid)
/*     */   {
/*  40 */     this.roleid = roleid;
/*  41 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!ItemModuleSwitchInterface.isUseGangFileItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  53 */       String logStr = String.format("[item]PUseGangFileItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  54 */       ItemManager.logger.info(logStr);
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     String userid = RoleInterface.getUserId(this.roleid);
/*  59 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  61 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  63 */     long gangId = GangInterface.getGangId(this.roleid);
/*  64 */     if (gangId == 0L)
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(gangId) }));
/*     */     
/*  70 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  71 */     if (item == null)
/*     */     {
/*  73 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  74 */       return false;
/*     */     }
/*  76 */     SGangFileItem gangFileItem = SGangFileItem.get(item.getCfgId());
/*  77 */     if (gangFileItem == null)
/*     */     {
/*  79 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/*  80 */       return false;
/*     */     }
/*  82 */     int itemnum = ItemInterface.getItemNumberById(this.roleid, item.getCfgId());
/*  83 */     int hasUsedCount = ItemInterface.getItemUseCount(this.roleid, item.getCfgId());
/*  84 */     int canUseNum = Math.min(gangFileItem.maxUseCount - hasUsedCount, itemnum);
/*  85 */     if (canUseNum <= 0)
/*     */     {
/*  87 */       ItemManager.sendWrongInfo(this.roleid, 103, new String[] { item.getCfgId() + "", gangFileItem.maxUseCount + "" });
/*     */       
/*  89 */       return false;
/*     */     }
/*  91 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_GANGFILE_REM, item.getCfgId());
/*  92 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/*  93 */     if (!ret)
/*     */     {
/*  95 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  96 */       return false;
/*     */     }
/*  98 */     if (canUseNum - 1 > 0)
/*     */     {
/* 100 */       ret = ItemInterface.removeItemById(this.roleid, 340600000, item.getCfgId(), canUseNum - 1, logArg);
/* 101 */       if (!ret)
/*     */       {
/* 103 */         ItemManager.sendWrongInfo(this.roleid, 40, new String[0]);
/* 104 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 108 */     int gangMoney = canUseNum * gangFileItem.addGangMoneyNum;
/*     */     
/* 110 */     ret = GangInterface.addGangMoney(gangId, gangMoney);
/* 111 */     if (!ret)
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     List<Integer> awardIds = new ArrayList();
/* 116 */     for (int i = 0; i < canUseNum; i++)
/*     */     {
/* 118 */       awardIds.add(Integer.valueOf(gangFileItem.rewardId));
/*     */     }
/*     */     
/*     */ 
/* 122 */     AwardModel aModel = AwardInterface.award(awardIds, null, userid, this.roleid, true, true, new AwardReason(LogReason.ITEM_USE_GANGFILE_REM, item.getCfgId()));
/*     */     
/* 124 */     if (aModel == null)
/*     */     {
/* 126 */       return false;
/*     */     }
/* 128 */     GangInterface.addItemBangGongCount(this.roleid, canUseNum);
/* 129 */     SUseGangFileItemRes s = new SUseGangFileItemRes();
/* 130 */     s.gangmoneynum = gangMoney;
/* 131 */     s.itemid = item.getCfgId();
/* 132 */     s.itemnum = canUseNum;
/* 133 */     s.roleid = this.roleid;
/* 134 */     Set<Long> roleList = GangInterface.getGangMemberList(gangId);
/* 135 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 137 */       OnlineManager.getInstance().send(r, s);
/*     */     }
/*     */     
/* 140 */     ret = ItemManager.addItemUseCount(this.roleid, item.getCfgId(), canUseNum);
/* 141 */     if (ret)
/*     */     {
/* 143 */       TriggerEventsManger.getInstance().triggerEvent(new UseGangFileItemEvent(), new UseGangFileItemArg(this.roleid, gangFileItem.id, canUseNum));
/*     */     }
/*     */     
/* 146 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseGangFileItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */