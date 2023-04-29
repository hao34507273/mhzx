/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCheckFactionAppellationArgs
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCheckFactionAppellationArgs(long roleId)
/*    */   {
/* 24 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     Gang gang = GangInterface.getGangByRoleId(this.roleId, true);
/* 32 */     if (gang == null)
/*    */     {
/*    */ 
/* 35 */       return false;
/*    */     }
/* 37 */     List<String> newArgs = getNewGangAppArgs(gang);
/* 38 */     List<String> oldArgs = TitleInterface.getAppArgs(this.roleId, TitleManager.getGangAppId(), true);
/* 39 */     if ((oldArgs == null) || (oldArgs.size() == 0))
/*    */     {
/* 41 */       GameServer.logger().error(String.format("[title]PCheckFactionAppellationArgs.processImp@ gang's app args not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/*    */ 
/* 44 */       return false;
/*    */     }
/* 46 */     if (newArgs.size() != oldArgs.size())
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[title]PCheckFactionAppellationArgs.processImp@ gang's app is illegal!|roleId=%d|newArgs=%s|oldArgs=%s", new Object[] { Long.valueOf(this.roleId), newArgs.toString(), oldArgs.toString() }));
/*    */       
/*    */ 
/*    */ 
/* 52 */       return false;
/*    */     }
/* 54 */     if (isArgSame(newArgs, oldArgs))
/*    */     {
/* 56 */       return true;
/*    */     }
/* 58 */     NoneRealTimeTaskManager.getInstance().addTask(new PGangMemberAppellationChange(this.roleId, gang.getGangId(), TitleManager.getGangAppId()));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isArgSame(List<String> newArgs, List<String> oldArgs)
/*    */   {
/* 65 */     for (int index = 0; index < newArgs.size(); index++)
/*    */     {
/* 67 */       if (!((String)newArgs.get(index)).equals(oldArgs.get(index)))
/*    */       {
/*    */ 
/*    */ 
/* 71 */         return false; }
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */   
/*    */   private List<String> getNewGangAppArgs(Gang gang)
/*    */   {
/* 78 */     List<String> newArgs = new ArrayList();
/* 79 */     newArgs.add(gang.getName());
/* 80 */     newArgs.add(GangInterface.getGangDutyName(this.roleId));
/* 81 */     return newArgs;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PCheckFactionAppellationArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */