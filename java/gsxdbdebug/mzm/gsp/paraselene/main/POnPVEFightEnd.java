/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.fight.event.PVEFightEndArg;
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ import mzm.gsp.fight.main.FightReason;
/*    */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnPVEFightEnd extends mzm.gsp.fight.event.PVEFightEndProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     FightContext fightContext = ((PVEFightEndArg)this.arg).context;
/* 21 */     if ((fightContext == null) || (!(fightContext instanceof ParaseleneFightContext)))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     ParaseleneFightContext paraseleneFightContex = (ParaseleneFightContext)fightContext;
/* 26 */     if (paraseleneFightContex.getFightReson().value != FightReason.PARASELENE_ACTIVITY_FIGHT.value)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(SParaseleneCfgConsts.getInstance().ActivityId);
/*    */     
/* 33 */     if ((((PVEFightEndArg)this.arg).roleList == null) || (((PVEFightEndArg)this.arg).roleList.size() == 0))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     Map<Long, String> allUsers = new HashMap();
/* 39 */     for (Long roleid : ((PVEFightEndArg)this.arg).roleList)
/*    */     {
/* 41 */       String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid.longValue());
/* 42 */       allUsers.put(roleid, userid);
/*    */     }
/* 44 */     lock(User.getTable(), allUsers.values());
/* 45 */     lock(xtable.Role2properties.getTable(), ((PVEFightEndArg)this.arg).roleList);
/*    */     
/* 47 */     int layer = paraseleneFightContex.getLayer();
/* 48 */     if (((PVEFightEndArg)this.arg).isPlayerWin)
/*    */     {
/* 50 */       List<Long> notEscaped = new ArrayList();
/* 51 */       notEscaped.addAll(((PVEFightEndArg)this.arg).roleList);
/* 52 */       notEscaped.removeAll(((PVEFightEndArg)this.arg).escapedRoles);
/* 53 */       Map<Long, String> notEscapedUsers = new HashMap();
/* 54 */       for (Iterator i$ = notEscaped.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 56 */         notEscapedUsers.put(Long.valueOf(roleId), allUsers.get(Long.valueOf(roleId)));
/*    */       }
/*    */       
/* 59 */       boolean hasFanPai = ParaseleneManager.offerAwardOnTaskEnd(notEscapedUsers, notEscaped, ((PVEFightEndArg)this.arg).roleList, layer, LogReason.PARASELENE_ACTIVITY_REWARD_ADD);
/*    */       
/* 61 */       ParaseleneManager.sendOnTaskSuccess(layer, ((PVEFightEndArg)this.arg).roleList);
/* 62 */       if (isActivityOpen)
/*    */       {
/*    */ 
/* 65 */         if (!hasFanPai)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 71 */           ParaseleneManager.transferToNextLayer(((PVEFightEndArg)this.arg).roleList, layer);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 76 */       ParaseleneManager.logActivityAndAddCount(notEscapedUsers, notEscaped);
/*    */       
/* 78 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 82 */     ParaseleneManager.sendOnTaskFailed(layer, ((PVEFightEndArg)this.arg).roleList);
/* 83 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\POnPVEFightEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */