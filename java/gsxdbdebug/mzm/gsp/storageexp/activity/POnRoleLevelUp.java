/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ import mzm.gsp.role.event.RoleLevelUpProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.AllLostExpInfo;
/*    */ import xbean.LostExpInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2alllostexpinfo;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLevelUp
/*    */   extends RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 23 */     long roleId = ((RoleLevelUpArg)this.arg).roleId;
/* 24 */     int oldLv = ((RoleLevelUpArg)this.arg).oldLevel;
/* 25 */     int newLv = ((RoleLevelUpArg)this.arg).newLevel;
/* 26 */     int stage = ActivityInterface.getActivityStage(LostAwardManager.getLostActivityId());
/* 27 */     if (stage != 0)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     String userid = RoleInterface.getUserId(roleId);
/* 33 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 35 */     AllLostExpInfo xAllLostExpInfo = Role2alllostexpinfo.get(Long.valueOf(roleId));
/* 36 */     if (xAllLostExpInfo == null)
/*    */     {
/* 38 */       LostAwardManager.logError("[lostexp]POnRoleLevelUp.processImp@ xAllLostExpInfo is null!|roleId=%d|oldLv=%d|newLv=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLv), Integer.valueOf(newLv) });
/*    */       
/*    */ 
/* 41 */       return false;
/*    */     }
/* 43 */     Map<Integer, LostExpInfo> xActivityInfos = xAllLostExpInfo.getActivityid2lostexpinfo();
/* 44 */     if ((xActivityInfos == null) || (xActivityInfos.size() == 0))
/*    */     {
/* 46 */       return false;
/*    */     }
/* 48 */     Iterator<Map.Entry<Integer, LostExpInfo>> it = xActivityInfos.entrySet().iterator();
/* 49 */     while (it.hasNext())
/*    */     {
/* 51 */       Map.Entry<Integer, LostExpInfo> entry = (Map.Entry)it.next();
/* 52 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 53 */       LostExpInfo xLostExpInfo = (LostExpInfo)entry.getValue();
/* 54 */       if ((xLostExpInfo.getBegintime() <= 0L) && 
/*    */       
/*    */ 
/*    */ 
/* 58 */         (ActivityInterface.isInActivityLevel(userid, roleId, activityId)))
/*    */       {
/*    */ 
/*    */ 
/* 62 */         long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 63 */         long beginTime = DateTimeUtils.getBeginTimeOfCurrDay(curTime);
/* 64 */         xLostExpInfo.setBegintime(beginTime);
/* 65 */         LostAwardManager.logInfo("[lostexp]POnRoleLevelUp.processImp@ open new activity!!|roleId=%d|oldLv=%d|newLv=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldLv), Integer.valueOf(newLv), Integer.valueOf(activityId) });
/*    */       }
/*    */     }
/*    */     
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */