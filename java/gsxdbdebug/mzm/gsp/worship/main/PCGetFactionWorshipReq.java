/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.worship.SSynFactionWorshipInfo;
/*    */ import xbean.FactionWorshipInfo;
/*    */ import xtable.Faction2worship;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetFactionWorshipReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCGetFactionWorshipReq(long roleId)
/*    */   {
/* 23 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long factionId = GangInterface.getGangId(this.roleId);
/* 30 */     if (factionId <= 0L)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     FactionWorshipInfo xFactionData = Faction2worship.select(Long.valueOf(factionId));
/* 36 */     if (xFactionData == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     Map<Integer, Integer> xFWorshipDatas = xFactionData.getWorshipdata();
/* 41 */     if ((xFWorshipDatas == null) || (xFWorshipDatas.size() == 0))
/*    */     {
/* 43 */       return false;
/*    */     }
/* 45 */     OnlineManager.getInstance().send(this.roleId, new SSynFactionWorshipInfo(new HashMap(xFWorshipDatas)));
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\PCGetFactionWorshipReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */