/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.CBroadcastJoinGangReq;
/*    */ import mzm.gsp.gang.SGangNormalResult;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ import xbean.RoleApplyGang;
/*    */ 
/*    */ public class PBroadcastJoinGangReq
/*    */   extends GangProcedure<CBroadcastJoinGangReq>
/*    */ {
/*    */   public PBroadcastJoinGangReq(CBroadcastJoinGangReq protocol)
/*    */   {
/* 20 */     super(protocol);
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean doProcess(long roleId, CBroadcastJoinGangReq protocol)
/*    */   {
/* 26 */     GangMember xMember = GangManager.getXGangMember(roleId, true);
/* 27 */     if (xMember != null)
/*    */     {
/* 29 */       Gang xGang = GangManager.getXGang(xMember.getGangid(), true);
/*    */       
/*    */ 
/* 32 */       if ((xGang != null) && (GangManager.isInGang(xGang, roleId))) {
/* 33 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 38 */     RoleApplyGang xApplyGang = GangManager.getXRoleApplyGang(roleId, true);
/* 39 */     int applyCount = SGangConst.getInstance().APPLY_NUM_LIMIT;
/* 40 */     List<Long> excludeGangs = new ArrayList();
/* 41 */     if (xApplyGang != null) {
/* 42 */       applyCount -= xApplyGang.getGangs().size();
/* 43 */       excludeGangs.addAll(xApplyGang.getGangs());
/*    */     }
/* 45 */     if (applyCount > 0) {
/* 46 */       NoneRealTimeTaskManager.getInstance().addTask(new RApplyJoinGangsReq(roleId, applyCount, excludeGangs));
/*    */     }
/*    */     else {
/* 49 */       GangManager.logWarn("PBroadcastJoinGangReq.processImp@already applied enough gangs|gangs=%s", new Object[] { excludeGangs });
/*    */     }
/*    */     
/* 52 */     SGangNormalResult result = new SGangNormalResult();
/* 53 */     result.result = 13;
/* 54 */     OnlineManager.getInstance().send(roleId, result);
/* 55 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PBroadcastJoinGangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */