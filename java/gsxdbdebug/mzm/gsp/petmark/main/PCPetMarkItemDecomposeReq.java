/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkItemDecomposeFail;
/*     */ import mzm.gsp.petmark.SPetMarkItemDecomposeSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkItemCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PCPetMarkItemDecomposeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int petMarkItemCfgId;
/*     */   private final boolean decomposeAll;
/*     */   
/*     */   public PCPetMarkItemDecomposeReq(long roleId, int petMarkItemCfgId, byte decomposeAll)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.petMarkItemCfgId = petMarkItemCfgId;
/*  30 */     this.decomposeAll = (decomposeAll > 0);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  39 */       String logstr = String.format("[petmark]PCPetMarkItemDecomposeReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  41 */       GameServer.logger().info(logstr);
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2138, true))
/*     */     {
/*  48 */       String logstr = String.format("[petmark]PCPetMarkItemDecomposeReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  50 */       GameServer.logger().info(logstr);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  57 */       onFail(-1);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     SPetMarkItemCfg sPetMarkItemCfg = SPetMarkItemCfg.get(this.petMarkItemCfgId);
/*  63 */     if (null == sPetMarkItemCfg)
/*     */     {
/*  65 */       onFail(-3);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     int totalNum = ItemInterface.getItemNumberById(this.roleId, 340600009, this.petMarkItemCfgId);
/*  71 */     if (totalNum == 0)
/*     */     {
/*  73 */       onFail(-2);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     int costNum = this.decomposeAll ? totalNum : 1;
/*  79 */     int tokenType = sPetMarkItemCfg.smeltScoreType;
/*  80 */     int tokenNum = sPetMarkItemCfg.smeltScore * costNum;
/*  81 */     TLogArg addLogArg = new TLogArg(LogReason.PET_MARK_DECOMPOSE_ADD);
/*  82 */     JifenOperateResult res = MallInterface.addJifen(this.roleId, tokenNum, tokenType, true, addLogArg);
/*  83 */     if (!res.isSuccess())
/*     */     {
/*  85 */       onFail(-4);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     TLogArg costLogArg = new TLogArg(LogReason.PET_MARK_DECOMPOSE_COST);
/*  91 */     if (!ItemInterface.removeItemById(this.roleId, this.petMarkItemCfgId, costNum, costLogArg))
/*     */     {
/*  93 */       onFail(-5);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     onSuccess(tokenType, tokenNum, costNum);
/*     */     
/* 100 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(int tokenType, int tokenNum, int costItemNum)
/*     */   {
/* 106 */     SPetMarkItemDecomposeSuccess proto = new SPetMarkItemDecomposeSuccess();
/* 107 */     proto.get_score_map.put(Integer.valueOf(tokenType), Integer.valueOf(tokenNum));
/* 108 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 111 */     String logstr = String.format("[petmark]PCPetMarkItemDecomposeReq.onSuccess@PCPetMarkItemDecomposeReq success|roleId=%d,petMarkItemCfgId=%d,costItemNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petMarkItemCfgId), Integer.valueOf(costItemNum) });
/*     */     
/*     */ 
/* 114 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 117 */     PetMarkTLogManager.addPetMarkDecomposeTLog(this.roleId, Collections.singletonMap(Integer.valueOf(tokenType), Integer.valueOf(tokenNum)));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 123 */     SPetMarkItemDecomposeFail proto = new SPetMarkItemDecomposeFail();
/* 124 */     proto.error_code = errorCode;
/* 125 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 128 */     String logstr = String.format("[petmark]PCPetMarkItemDecomposeReq.onFail@PCPetMarkItemDecomposeReq failed|roleId=%d,petMarkItemCfgId=%d,useAll=%s,reason=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.petMarkItemCfgId), Boolean.valueOf(this.decomposeAll), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 131 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkItemDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */