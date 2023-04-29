/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SGetRoleMFVRankRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetRoleMFCRankReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int fromNo;
/*    */   private int toNo;
/*    */   
/*    */   public PCGetRoleMFCRankReq(long roleid, int fromNo, int toNo)
/*    */   {
/* 25 */     this.roleid = roleid;
/* 26 */     this.fromNo = fromNo;
/* 27 */     this.toNo = toNo;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (this.fromNo <= 0)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     if (this.fromNo > this.toNo)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     SGetRoleMFVRankRes roleMFVRankRes = new SGetRoleMFVRankRes();
/* 43 */     fillRoleMFVRankRes(roleMFVRankRes);
/* 44 */     OnlineManager.getInstance().send(this.roleid, roleMFVRankRes);
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void fillRoleMFVRankRes(SGetRoleMFVRankRes roleMFVRankRes)
/*    */   {
/* 56 */     List<RoleMultiFightValueChart> roleMFVCharts = NoneRealMFVRankManager.getInstance().getRankObjs(this.fromNo - 1, this.toNo - 1);
/* 57 */     Map<Long, Integer> rankChangeMap = NoneRealMFVRankManager.getInstance().getCacheRankChangeMap();
/* 58 */     MultiRankManager.fillProRankList(this.fromNo, roleMFVCharts, rankChangeMap, roleMFVRankRes.ranklist);
/* 59 */     roleMFVRankRes.myno = (NoneRealMFVRankManager.getInstance().getRank(Long.valueOf(this.roleid)) + 1);
/* 60 */     roleMFVRankRes.myvalue = MultiRankManager.getRoleMFValue(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PCGetRoleMFCRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */