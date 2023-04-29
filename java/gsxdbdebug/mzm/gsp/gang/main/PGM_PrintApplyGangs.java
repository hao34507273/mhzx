/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ import xbean.RoleApplyGang;
/*    */ 
/*    */ public class PGM_PrintApplyGangs extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_PrintApplyGangs(long gmid, long roleid)
/*    */   {
/* 17 */     this.gmid = gmid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     RoleApplyGang xApplyGang = GangManager.getXRoleApplyGang(this.roleid, false);
/*    */     
/* 28 */     if ((xApplyGang == null) || (xApplyGang.getGangs().isEmpty())) {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmid, "当前没有申请的帮派");
/*    */     }
/*    */     else {
/* 32 */       StringBuilder sb = new StringBuilder();
/* 33 */       for (Iterator i$ = xApplyGang.getGangs().iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*    */         
/* 35 */         Gang xGang = GangManager.getXGang(gangid, false);
/* 36 */         sb.append("gangid=").append(gangid).append(",").append("gangname=");
/* 37 */         sb.append(xGang.getName()).append("\n");
/*    */       }
/* 39 */       GmManager.getInstance().sendResultToGM(this.gmid, sb.toString());
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGM_PrintApplyGangs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */