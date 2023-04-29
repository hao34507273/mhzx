/*     */ package mzm.gsp.wing.main2;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.corps.confbean.CorpsConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.server.main.AvailableStringArgs;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import mzm.gsp.wing.SRenameOccupationPlanNameRep;
/*     */ import xbean.AllWingPlans;
/*     */ import xbean.TransferOccupationWing;
/*     */ import xtable.Role2wingplans;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCRenameOccupationPlanNameReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int occId;
/*     */   private final String newName;
/*     */   private final Octets newNameOctets;
/*     */   
/*     */   public PCRenameOccupationPlanNameReq(long roleId, int occId, Octets newNameOctets)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.occId = occId;
/*     */     
/*  37 */     String tmpName = null;
/*     */     try
/*     */     {
/*  40 */       tmpName = newNameOctets.getString("UTF-8");
/*     */     }
/*     */     catch (Exception e) {}
/*     */     
/*     */ 
/*     */ 
/*  46 */     this.newName = tmpName.trim();
/*  47 */     this.newNameOctets = newNameOctets;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     SRenameOccupationPlanNameRep rep = new SRenameOccupationPlanNameRep();
/*  54 */     rep.newname = this.newNameOctets;
/*  55 */     rep.occupationid = this.occId;
/*  56 */     Pair<Integer, List<String>> res = changeName();
/*  57 */     rep.result = ((Integer)res.first).intValue();
/*  58 */     if (((Integer)res.first).intValue() != 1)
/*     */     {
/*  60 */       OnlineManager.getInstance().sendAtOnce(this.roleId, rep);
/*  61 */       return false;
/*     */     }
/*  63 */     OnlineManager.getInstance().send(this.roleId, rep);
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   private Pair<Integer, List<String>> changeName()
/*     */   {
/*  69 */     Pair<Integer, List<String>> resPair = new Pair(Integer.valueOf(1), new ArrayList());
/*     */     
/*  71 */     AllWingPlans xWingPlans = Role2wingplans.get(Long.valueOf(this.roleId));
/*  72 */     if (xWingPlans == null)
/*     */     {
/*  74 */       resPair.first = Integer.valueOf(2);
/*  75 */       return resPair;
/*     */     }
/*  77 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 288, true))
/*     */     {
/*  79 */       resPair.first = Integer.valueOf(2);
/*  80 */       return resPair;
/*     */     }
/*  82 */     TransferOccupationWing xWingInfo = (TransferOccupationWing)xWingPlans.getTransfer_occupation_wing_map().get(Integer.valueOf(this.occId));
/*  83 */     if (xWingInfo == null)
/*     */     {
/*  85 */       resPair.first = Integer.valueOf(2);
/*  86 */       return resPair;
/*     */     }
/*  88 */     if (xWingInfo.getPlanname().equals(this.newName))
/*     */     {
/*     */ 
/*  91 */       return resPair;
/*     */     }
/*  93 */     int res = isNameValid();
/*  94 */     if (res > 0)
/*     */     {
/*     */ 
/*  97 */       resPair.first = Integer.valueOf(res);
/*  98 */       return resPair;
/*     */     }
/*     */     
/* 101 */     xWingInfo.setPlanname(this.newName);
/*     */     
/* 103 */     return resPair;
/*     */   }
/*     */   
/*     */   private int isNameValid()
/*     */   {
/* 108 */     int res = 0;
/* 109 */     if ((this.newName.isEmpty()) || (Math.ceil(CommonUtils.getUTF16Length(this.newName) / 2.0D) > CorpsConsts.getInstance().CORPS_NAME_MAX_LENGTH) || (Math.ceil(CommonUtils.getUTF16Length(this.newName) / 2.0D) < CorpsConsts.getInstance().CORPS_NAME_MIN_LENGTH) || (!AvailableStringArgs.getInstance().isStringUsable(this.newName)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 114 */       res = 3;
/*     */     }
/* 116 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\main2\PCRenameOccupationPlanNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */