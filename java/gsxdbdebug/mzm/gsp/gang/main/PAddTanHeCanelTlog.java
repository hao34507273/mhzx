/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PAddTanHeCanelTlog
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long bangzhuId;
/*    */   private final long tanheId;
/*    */   private final long gangId;
/*    */   private final long gangDisplayId;
/*    */   
/*    */   PAddTanHeCanelTlog(long tanheId, long bangzhuId, long gangId, long gangDisplayId)
/*    */   {
/* 48 */     this.tanheId = tanheId;
/* 49 */     this.bangzhuId = bangzhuId;
/* 50 */     this.gangId = gangId;
/* 51 */     this.gangDisplayId = gangDisplayId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 56 */     StringBuilder tLogStr = new StringBuilder();
/* 57 */     tLogStr.append(GameServerInfoManager.getHostIP()).append("|").append(RoleInterface.getUserId(this.tanheId)).append("|").append(this.tanheId).append("|").append(this.bangzhuId).append("|").append(this.gangId).append("|").append(0).append("|").append(GangTanheLogEnum.CANCEL).append("|").append(this.gangDisplayId);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 65 */     TLogManager.getInstance().addLog(this.tanheId, "GangTanHe", tLogStr.toString());
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PAddTanHeCanelTlog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */