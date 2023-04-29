/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import hub.ExchangeDataHandlerInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossserver.main.ReturnFromRoamServerHandlerManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PPointRaceBack
/*    */   extends LogicProcedure
/*    */ {
/*    */   private PointRaceBackContext backContext;
/*    */   
/*    */   public PPointRaceBack(PointRaceBackContext backContext)
/*    */   {
/* 21 */     this.backContext = backContext;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     List<String> users = new ArrayList();
/* 28 */     List<Long> roleids = new ArrayList();
/* 29 */     Map<Long, String> role2User = new HashMap();
/* 30 */     for (PointRaceUserBackData userDataBack : this.backContext.userDatas)
/*    */     {
/* 32 */       users.add(userDataBack.userid);
/* 33 */       roleids.add(Long.valueOf(userDataBack.roleid));
/* 34 */       role2User.put(Long.valueOf(userDataBack.roleid), userDataBack.userid);
/*    */     }
/* 36 */     lock(User.getTable(), users);
/* 37 */     lock(Basic.getTable(), roleids);
/*    */     
/* 39 */     long corpsid = this.backContext.corpsInfo.getCorpsid();
/* 40 */     PointRaceBackContextManager.getInstance().put(corpsid, this.backContext);
/*    */     
/* 42 */     RoleStatusInterface.setStatus(roleids, 65, false);
/*    */     
/*    */ 
/* 45 */     for (PointRaceUserBackData userDataBack : this.backContext.userDatas)
/*    */     {
/* 47 */       ExchangeDataHandlerInfo exchangeDataHandlerInfo = userDataBack.exchangeDataDandlerInfo;
/* 48 */       if (exchangeDataHandlerInfo != null)
/*    */       {
/* 50 */         ReturnFromRoamServerHandlerManager.unboxData(userDataBack.userid, userDataBack.roleid, exchangeDataHandlerInfo);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 55 */     new PointRaceBackObserver(15L, corpsid);
/*    */     
/*    */ 
/* 58 */     return CrossBattlePointManager.updatePointRaceCorps(this.backContext.activityCfgid, this.backContext.timePointCfgid, this.backContext.corpsInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PPointRaceBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */