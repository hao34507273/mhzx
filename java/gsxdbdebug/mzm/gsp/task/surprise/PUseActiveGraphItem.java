/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.item.confbean.SActiveGraphItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseActiveGraphItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   
/*     */   public PUseActiveGraphItem(long roleId, long uuid)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     String userid = RoleInterface.getUserId(this.roleId);
/*  41 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  43 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*     */ 
/*  46 */     SActiveGraphItemCfg itemCfg = getItemCfg(this.roleId, this.uuid);
/*  47 */     if (itemCfg == null)
/*     */     {
/*  49 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.processImp@ itemCfg is null!|roleId=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid) });
/*  50 */       return false;
/*     */     }
/*  52 */     if (!checkGraphFinishCount(itemCfg))
/*     */     {
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     TLogArg logArg = new TLogArg(LogReason.SURPRISE_USE_ITEM, itemCfg.id);
/*     */     
/*  60 */     if (!ItemInterface.removeItemByUuid(this.roleId, this.uuid, 1, logArg))
/*     */     {
/*  62 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.processImp@ rm item err!|roleId=%d|uuid=%d|itemCfgId=%d|graphId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfg.id), Integer.valueOf(itemCfg.graphId), Integer.valueOf(itemCfg.id) });
/*     */       
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     if (!TaskInterface.activeGraph(Long.valueOf(this.roleId), itemCfg.graphId))
/*     */     {
/*  70 */       SurpriseTaskManager.loggerError("PActiveSurpriseGraph.processImp@ active graph err!|roleId=%d|graphId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemCfg.graphId), Integer.valueOf(itemCfg.id) });
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!ItemInterface.addItemUseCount(this.roleId, itemCfg.id, 1))
/*     */     {
/*  78 */       SurpriseTaskManager.loggerError("PActiveSurpriseGraph.processImp@ add day use count err!|roleId=%d|graphId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemCfg.graphId), Integer.valueOf(itemCfg.id) });
/*     */       
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     if (itemCfg.useType == 1)
/*     */     {
/*  86 */       SurpriseTaskManager.tlogSurprise(RoleInterface.getUserId(this.roleId), this.roleId, 4, itemCfg.id, itemCfg.graphId);
/*     */     }
/*     */     
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkGraphFinishCount(SActiveGraphItemCfg itemCfg)
/*     */   {
/*  95 */     if (TaskInterface.isHaveGraphId(this.roleId, itemCfg.graphId))
/*     */     {
/*  97 */       SurpriseTaskManager.sendSurpriseNotice(this.roleId, false, 3, new String[0]);
/*     */       
/*  99 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.checkGraphFinishCount@ already has this graph!|roleId=%d|uuid=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfg.graphId) });
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if ((itemCfg.limitDayUseCount) && (ItemInterface.getItemUseCount(this.roleId, itemCfg.id) >= itemCfg.dayUseCount))
/*     */     {
/* 107 */       SurpriseTaskManager.sendSurpriseNotice(this.roleId, false, 4, new String[0]);
/* 108 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.checkGraphFinishCount@ day can active time used up!|roleId=%d|uuid=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfg.graphId) });
/*     */       
/*     */ 
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if ((itemCfg.limitGlobalActiveCount) && (!SurpriseTaskManager.neverAcceptGraph(this.roleId, itemCfg.graphId, itemCfg.globalActiveCount)))
/*     */     {
/*     */ 
/* 117 */       SurpriseTaskManager.sendSurpriseNotice(this.roleId, false, 1, new String[] { String.valueOf(itemCfg.globalActiveCount) });
/*     */       
/* 119 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.checkGraphFinishCount@ open graph forbid!|roleId=%d|uuid=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.uuid), Integer.valueOf(itemCfg.graphId) });
/*     */       
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private SActiveGraphItemCfg getItemCfg(long roleId, long uuid)
/*     */   {
/* 134 */     BasicItem basicItem = ItemInterface.getItemByUuid(roleId, uuid);
/* 135 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/* 137 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.getItemCfg@ not own uuid's item!|roleId=%d|uuid=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(uuid) });
/*     */       
/* 139 */       return null;
/*     */     }
/* 141 */     SActiveGraphItemCfg itemCfg = SActiveGraphItemCfg.get(basicItem.getCfgId());
/* 142 */     if ((itemCfg == null) || (itemCfg.type != 116))
/*     */     {
/* 144 */       SurpriseTaskManager.loggerError("PUseActiveGraphItem.getItemCfg@ not active graph item!|roleId=%d|uuid=%d|itemCfgId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(uuid), Integer.valueOf(itemCfg.id) });
/*     */       
/*     */ 
/* 147 */       return null;
/*     */     }
/* 149 */     return itemCfg;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PUseActiveGraphItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */