/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.item.SUseAxeItemFail;
/*     */ import mzm.gsp.item.SUseAxeItemSuccess;
/*     */ import mzm.gsp.item.confbean.SAxeItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCUseAxeItem extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int grid;
/*     */   private final int num;
/*     */   
/*     */   public PCUseAxeItem(long roleid, int grid, int num)
/*     */   {
/*  32 */     this.roleid = roleid;
/*  33 */     this.grid = grid;
/*  34 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  40 */     if ((this.grid < 0) || (this.num <= 0))
/*     */     {
/*     */ 
/*  43 */       onFail(-3, null);
/*  44 */       return false;
/*     */     }
/*  46 */     if (!isUseAxeItemSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  49 */       onFail(-1, null);
/*  50 */       return false;
/*     */     }
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 1112, true))
/*     */     {
/*     */ 
/*  55 */       onFail(-2, null);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  61 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  65 */     BasicItem axeItem = ItemInterface.getItem(this.roleid, this.grid);
/*  66 */     if (axeItem == null)
/*     */     {
/*     */ 
/*  69 */       onFail(-3, null);
/*  70 */       return false;
/*     */     }
/*  72 */     SAxeItemCfg cfg = SAxeItemCfg.get(axeItem.getCfgId());
/*  73 */     if (cfg == null)
/*     */     {
/*     */ 
/*  76 */       onFail(1, null);
/*  77 */       return false;
/*     */     }
/*  79 */     if (axeItem.getNumber() < this.num)
/*     */     {
/*     */ 
/*  82 */       onFail(2, null);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (!ItemInterface.removeItemByGrid(this.roleid, 340600000, this.grid, this.num, new TLogArg(LogReason.AXE_USE_AXE_ITEM_COST_ITEM)))
/*     */     {
/*     */ 
/*     */ 
/*  90 */       onFail(2, null);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (cfg.fix_award_id > 0)
/*     */     {
/*  96 */       for (int i = 0; i < this.num; i++)
/*     */       {
/*  98 */         AwardReason awardReason = new AwardReason(LogReason.AXE_USE_AXE_ITEM_AWARD, axeItem.getCfgId());
/*  99 */         AwardModel awardModel = AwardInterface.awardFixAward(cfg.fix_award_id, userid, this.roleid, false, true, awardReason);
/*     */         
/* 101 */         if (awardModel == null)
/*     */         {
/*     */ 
/* 104 */           onFail(3, null);
/* 105 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 110 */     SUseAxeItemSuccess protocol = new SUseAxeItemSuccess();
/* 111 */     protocol.axe_item_cfg_id = axeItem.getCfgId();
/* 112 */     protocol.grid = this.grid;
/* 113 */     protocol.num = this.num;
/* 114 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 116 */     StringBuilder sb = new StringBuilder();
/* 117 */     sb.append(String.format("[item]PCUseAxeItem.processImp@use axe item success|roleid=%d|grid=%d|num=%d|axe_item_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.grid), Integer.valueOf(this.num), Integer.valueOf(axeItem.getCfgId()) }));
/*     */     
/*     */ 
/* 120 */     GameServer.logger().info(sb.toString());
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 126 */     StringBuilder sb = new StringBuilder();
/* 127 */     sb.append(String.format("[item]PCUseAxeItem.processImp@use axe item fail|roleid=%d|grid=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.grid), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/* 129 */     if (extraInfo != null)
/*     */     {
/* 131 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 133 */         sb.append("|").append((String)entry.getKey());
/* 134 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 137 */     GameServer.logger().info(sb.toString());
/* 138 */     if (res > 0)
/*     */     {
/* 140 */       SUseAxeItemFail protocol = new SUseAxeItemFail();
/* 141 */       protocol.res = res;
/* 142 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isUseAxeItemSwitchOpenForRole(long roleid)
/*     */   {
/* 148 */     if (!OpenInterface.getOpenStatus(326))
/*     */     {
/* 150 */       return false;
/*     */     }
/* 152 */     if (OpenInterface.isBanPlay(roleid, 326))
/*     */     {
/* 154 */       OpenInterface.sendBanPlayMsg(roleid, 326);
/* 155 */       return false;
/*     */     }
/* 157 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCUseAxeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */