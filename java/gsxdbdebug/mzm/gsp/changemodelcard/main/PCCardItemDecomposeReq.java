/*     */ package mzm.gsp.changemodelcard.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.SCardItemDecomposeFail;
/*     */ import mzm.gsp.changemodelcard.SCardItemDecomposeSuccess;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardFragmentCfg;
/*     */ import mzm.gsp.changemodelcard.confbean.SChangeModelCardItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCCardItemDecomposeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final Collection<Long> itemUuids;
/*     */   private final boolean decomposeOne;
/*     */   
/*     */   public PCCardItemDecomposeReq(long roleId, Collection<Long> itemUuids, boolean decomposeOne)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.itemUuids = itemUuids;
/*  35 */     this.decomposeOne = decomposeOne;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!ChangeModelCardManager.isChangeModelCardOpen(this.roleId))
/*     */     {
/*  44 */       String logstr = String.format("[changemodelcard]PCCardItemDecomposeReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  46 */       GameServer.logger().info(logstr);
/*  47 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1976, true))
/*     */     {
/*  53 */       String logstr = String.format("[changemodelcard]PCCardItemDecomposeReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  55 */       GameServer.logger().info(logstr);
/*  56 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  60 */     if (!ChangeModelCardManager.checkRoleLevel(this.roleId))
/*     */     {
/*  62 */       onFail(-1);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     if ((this.decomposeOne) && (this.itemUuids.size() > 1))
/*     */     {
/*  69 */       onFail(-6);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     int totalScore = 0;
/*  75 */     for (Iterator i$ = this.itemUuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  78 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, 340600007, uuid);
/*  79 */       if (null == basicItem)
/*     */       {
/*  81 */         onFail(-2);
/*  82 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  87 */       int itemCfgId = basicItem.getCfgId();
/*  88 */       SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/*  89 */       int singleItemScore; if (sItemCfg.type == 151)
/*     */       {
/*     */ 
/*  92 */         SChangeModelCardItemCfg sChangeModelCardItemCfg = SChangeModelCardItemCfg.get(itemCfgId);
/*  93 */         singleItemScore = sChangeModelCardItemCfg.sellScore;
/*     */       } else { int singleItemScore;
/*  95 */         if (sItemCfg.type == 152)
/*     */         {
/*     */ 
/*  98 */           SChangeModelCardFragmentCfg sChangeModelCardFragmentCfg = SChangeModelCardFragmentCfg.get(itemCfgId);
/*  99 */           singleItemScore = sChangeModelCardFragmentCfg.sellScore;
/*     */         }
/*     */         else
/*     */         {
/* 103 */           onFail(-3);
/* 104 */           return false; } }
/*     */       int singleItemScore;
/* 106 */       int itemNum = this.decomposeOne ? 1 : basicItem.getNumber();
/* 107 */       totalScore += singleItemScore * itemNum;
/*     */       
/*     */ 
/* 110 */       TLogArg arg = new TLogArg(LogReason.CHANGE_MODEL_CARD_DECOMPOSE_COST);
/* 111 */       if (!ItemInterface.removeItemByUuid(this.roleId, 340600007, uuid, itemNum, arg))
/*     */       {
/* 113 */         onFail(-3);
/* 114 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 119 */     TLogArg arg = new TLogArg(LogReason.CHANGE_MODEL_CARD_DECOMPOSE_AWARD);
/* 120 */     JifenOperateResult result = MallInterface.addJifen(this.roleId, totalScore, 10, false, arg);
/*     */     
/* 122 */     if (!result.isSuccess())
/*     */     {
/* 124 */       onFail(-4);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     onSuccess(result.getChangenum());
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(long changeNum)
/*     */   {
/* 139 */     long newScore = MallInterface.getJifen(this.roleId, 10);
/*     */     
/* 141 */     SCardItemDecomposeSuccess protocol = new SCardItemDecomposeSuccess();
/* 142 */     protocol.get_score = changeNum;
/* 143 */     OnlineManager.getInstance().send(this.roleId, protocol);
/*     */     
/*     */ 
/* 146 */     String logstr = String.format("[changemodelcard]PCCardItemDecomposeReq.onSuccess@PCCardItemDecomposeReq success|roleId=%d,itemUuids=%s,newScore=%d", new Object[] { Long.valueOf(this.roleId), this.itemUuids, Long.valueOf(newScore) });
/*     */     
/*     */ 
/* 149 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 152 */     ChangeModelCardTLogManager.addChangeModelCardDecomposeTlog(this.roleId, newScore, changeNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 163 */     SCardItemDecomposeFail proto = new SCardItemDecomposeFail();
/* 164 */     proto.error_code = errorCode;
/* 165 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 168 */     String logstr = String.format("[changemodelcard]PCCardItemDecomposeReq.onFail@PCCardItemDecomposeReq failed|errorCode=%d,roleId=%d,itemUuids=%s", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), this.itemUuids });
/*     */     
/*     */ 
/* 171 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\main\PCCardItemDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */