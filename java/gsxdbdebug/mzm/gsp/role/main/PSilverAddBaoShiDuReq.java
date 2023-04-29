/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.baoshidu.confbean.SAddBaoShiDuCfg;
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.main.PetInterface;
/*    */ import mzm.gsp.role.SAddBaoShiDuRes;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSilverAddBaoShiDuReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PSilverAddBaoShiDuReq(long roleId)
/*    */   {
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 219, true))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     RoleOutFightObj roleOutFightObj = RoleInterface.getRoleOutFightObject(this.roleId);
/* 38 */     int level = roleOutFightObj.getLevel();
/* 39 */     SAddBaoShiDuCfg addBaoShiDuCfg = null;
/* 40 */     for (SAddBaoShiDuCfg cfg : SAddBaoShiDuCfg.getAll().values())
/*    */     {
/* 42 */       if (cfg.level == level)
/*    */       {
/* 44 */         addBaoShiDuCfg = cfg;
/* 45 */         break;
/*    */       }
/*    */     }
/* 48 */     if (addBaoShiDuCfg == null)
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     if (addBaoShiDuCfg.add1BaoshiduNeedSilver == 0)
/*    */     {
/* 54 */       return false;
/*    */     }
/* 56 */     int baoShiDu = roleOutFightObj.getBaoShiDu();
/* 57 */     int needBaoShiDu = RoleCommonConstants.getInstance().BAOSHIDU_LIMIT - baoShiDu;
/* 58 */     if (needBaoShiDu <= 0)
/*    */     {
/* 60 */       return false;
/*    */     }
/* 62 */     int needSilver = needBaoShiDu * addBaoShiDuCfg.add1BaoshiduNeedSilver;
/* 63 */     if (needSilver > roleOutFightObj.getSilver())
/*    */     {
/* 65 */       needSilver = (int)roleOutFightObj.getSilver();
/* 66 */       needBaoShiDu = needSilver / addBaoShiDuCfg.add1BaoshiduNeedSilver;
/*    */     }
/*    */     
/* 69 */     if (!RoleInterface.cutSilver(this.roleId, needSilver, new TLogArg(LogReason.ROLE_ADDBAOSHIDU_SILVER_REM)))
/*    */     {
/* 71 */       return false;
/*    */     }
/* 73 */     roleOutFightObj.addBaoShiDu(needBaoShiDu);
/* 74 */     roleOutFightObj.setHpAndMpFull();
/*    */     
/* 76 */     Set<Long> petids = PetInterface.getPetList(this.roleId, true);
/* 77 */     for (Iterator i$ = petids.iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/*    */       
/* 79 */       PetInterface.recoveryHPAndMP(this.roleId, petid);
/*    */     }
/* 81 */     SAddBaoShiDuRes res = new SAddBaoShiDuRes();
/* 82 */     res.addbaoshudu = needBaoShiDu;
/* 83 */     OnlineManager.getInstance().send(this.roleId, res);
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PSilverAddBaoShiDuReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */