/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.petmark.SPetMarkDecomposeFail;
/*     */ import mzm.gsp.petmark.SPetMarkDecomposeSuccess;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelBean;
/*     */ import mzm.gsp.petmark.confbean.SPetMarkLevelCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PetMarkInfo;
/*     */ import xbean.Role2PetMarkInfo;
/*     */ 
/*     */ public class PCPetMarkDecomposeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long petMarkId;
/*     */   
/*     */   public PCPetMarkDecomposeReq(long roleId, long petMarkId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.petMarkId = petMarkId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!PetMarkManager.isPetMarkOpen(this.roleId))
/*     */     {
/*  37 */       String logstr = String.format("[petmark]PCPetMarkDecomposeReq.processImp@function not open|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       GameServer.logger().info(logstr);
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 2137, true))
/*     */     {
/*  46 */       String logstr = String.format("[petmark]PCPetMarkDecomposeReq.processImp@status error|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  47 */       GameServer.logger().info(logstr);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (!PetMarkManager.checkRoleLevel(this.roleId))
/*     */     {
/*  54 */       onFail(-1);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     Role2PetMarkInfo xRole2PetMarkInfo = PetMarkManager.getRolePetMarkInfo(this.roleId);
/*  60 */     PetMarkInfo xPetMarkInfo = (PetMarkInfo)xRole2PetMarkInfo.getPetmarkid2info().get(Long.valueOf(this.petMarkId));
/*  61 */     if (null == xPetMarkInfo)
/*     */     {
/*  63 */       onFail(-2);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     if (xPetMarkInfo.getPet_id() > 0L)
/*     */     {
/*  70 */       onFail(-3);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     SPetMarkLevelBean levelBean = (SPetMarkLevelBean)SPetMarkLevelCfg.get(xPetMarkInfo.getPet_mark_cfg_id()).level2Bean.get(Integer.valueOf(xPetMarkInfo.getLevel()));
/*  76 */     TLogArg tLogArg = new TLogArg(LogReason.PET_MARK_DECOMPOSE_ADD);
/*  77 */     JifenOperateResult res = MallInterface.addJifen(this.roleId, levelBean.smeltScore, levelBean.smeltScoreType, true, tLogArg);
/*     */     
/*  79 */     if (!res.isSuccess())
/*     */     {
/*  81 */       onFail(-4);
/*  82 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  86 */     PetMarkManager.removePetMark(this.roleId, this.petMarkId, xRole2PetMarkInfo, PetMarkManager.RemovePetMarkReason.DECOMPOSE);
/*     */     
/*     */ 
/*  89 */     onSuccess(levelBean.smeltScoreType, levelBean.smeltScore, xPetMarkInfo);
/*     */     
/*  91 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void onSuccess(int tokenType, int tokenNum, PetMarkInfo xPetMarkInfo)
/*     */   {
/*  97 */     SPetMarkDecomposeSuccess proto = new SPetMarkDecomposeSuccess();
/*  98 */     proto.pet_mark_id = this.petMarkId;
/*  99 */     proto.get_score_map.put(Integer.valueOf(tokenType), Integer.valueOf(tokenNum));
/* 100 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 103 */     String logstr = String.format("[petmark]PCPetMarkDecomposeReq.onSuccess@PCPetMarkDecomposeReq success|roleId=%d,petMarkId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId) });
/*     */     
/*     */ 
/* 106 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 109 */     PetMarkTLogManager.addPetMarkDecomposeTLog(this.roleId, Collections.singletonMap(Integer.valueOf(tokenType), Integer.valueOf(tokenNum)));
/*     */   }
/*     */   
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 115 */     SPetMarkDecomposeFail proto = new SPetMarkDecomposeFail();
/* 116 */     proto.error_code = errorCode;
/* 117 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */     
/*     */ 
/* 120 */     String logstr = String.format("[petmark]PCPetMarkDecomposeReq.onFail@PCPetMarkDecomposeReq failed|roleId=%d,petMarkId=%d,reason=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.petMarkId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 123 */     GameServer.logger().info(logstr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PCPetMarkDecomposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */