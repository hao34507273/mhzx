/*    */ package mzm.gsp.chess.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLogStatus;
/*    */ import mzm.gsp.activity3.confbean.ChessActivityConsts;
/*    */ import mzm.gsp.chess.event.ChessGameFinishArg;
/*    */ import mzm.gsp.chess.event.ChessGameFinishProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class POnChessGameFinish
/*    */   extends ChessGameFinishProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 24 */     ChessGameFinishArg arg = (ChessGameFinishArg)this.arg;
/* 25 */     if ((((ChessGameFinishArg)this.arg).context == null) || (!(((ChessGameFinishArg)this.arg).context instanceof ChessGameContext)))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     ChessGameContext chessGameContext = (ChessGameContext)((ChessGameFinishArg)this.arg).context;
/*    */     
/* 31 */     int activityId = chessGameContext.getActivityCfgId();
/* 32 */     if (activityId != ChessActivityConsts.getInstance().ACTIVITY_ID)
/*    */     {
/* 34 */       String logstr = String.format("[chess]POnChessGameFinish.processImp@activityId not match|arg activityId=%d,cfg activityId=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(ChessActivityConsts.getInstance().ACTIVITY_ID) });
/*    */       
/*    */ 
/* 37 */       ChessActivityManager.logger.error(logstr);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     List<Long> roleIds = Arrays.asList(new Long[] { Long.valueOf(arg.roleIdA), Long.valueOf(arg.roleIdB) });
/* 42 */     Map<Long, String> roleId2Userid = new HashMap();
/* 43 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 45 */       String userId = RoleInterface.getUserId(roleId);
/* 46 */       if (null == userId)
/*    */       {
/* 48 */         String logstr = String.format("[chess]POnChessGameFinish.processImp@userId not exist|roleId=%d", new Object[] { Long.valueOf(roleId) });
/* 49 */         ChessActivityManager.logger.error(logstr);
/* 50 */         return false;
/*    */       }
/* 52 */       roleId2Userid.put(Long.valueOf(roleId), RoleInterface.getUserId(roleId));
/*    */     }
/* 54 */     lock(User.getTable(), roleId2Userid.values());
/* 55 */     lock(Basic.getTable(), roleIds);
/*    */     
/* 57 */     ChessActivityManager.offerActivityAward((String)roleId2Userid.get(Long.valueOf(arg.roleIdA)), arg.roleIdA, arg.result);
/* 58 */     ChessActivityManager.offerActivityAward((String)roleId2Userid.get(Long.valueOf(arg.roleIdB)), arg.roleIdB, ChessGameManager.getEnemyGameResultBySelfResult(arg.result));
/*    */     
/* 60 */     ChessActivityManager.addActivityCount(arg.roleIdA, arg.result);
/* 61 */     ChessActivityManager.addActivityCount(arg.roleIdB, ChessGameManager.getEnemyGameResultBySelfResult(arg.result));
/*    */     
/* 63 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 65 */       String userId = (String)roleId2Userid.get(Long.valueOf(roleId));
/*    */       
/* 67 */       ActivityInterface.addActivityCount(userId, roleId, activityId);
/*    */       
/* 69 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*    */       
/* 71 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\POnChessGameFinish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */