/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.teamplatform.SSynTeamNumInfo;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ public class RSend2Client
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int levelLow;
/*    */   private final int levelHigh;
/*    */   private final SSynTeamNumInfo sSynTeamNumInfo;
/*    */   
/*    */   public RSend2Client(int levelLow, int levelHigh, SSynTeamNumInfo sSynTeamNumInfo)
/*    */   {
/* 20 */     this.levelLow = levelLow;
/* 21 */     this.levelHigh = levelHigh;
/* 22 */     this.sSynTeamNumInfo = sSynTeamNumInfo;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 28 */     Set<Long> roleIds = OnlineManager.getInstance().getOnlineRoleidSet(this.levelLow, this.levelHigh);
/* 29 */     Iterator<Long> it = roleIds.iterator();
/* 30 */     while (it.hasNext())
/*    */     {
/* 32 */       long roleId = ((Long)it.next()).longValue();
/* 33 */       if (TeamInterface.isRoleInTeam(roleId, false))
/*    */       {
/* 35 */         it.remove();
/*    */       }
/*    */     }
/* 38 */     if (roleIds.size() > 0)
/*    */     {
/* 40 */       OnlineManager.getInstance().sendMulti(this.sSynTeamNumInfo, roleIds);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RSend2Client.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */