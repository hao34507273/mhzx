/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.SSyncCorpsInfo2NewMember;
/*    */ import mzm.gsp.corps.event.JoinCorpsEventArg;
/*    */ import mzm.gsp.corps.event.JoinCorpsProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CorpsMember;
/*    */ import xtable.Role2corps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnJoinCorps
/*    */   extends JoinCorpsProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     CorpsManager.HandCorpsAppellationNoneRealTime(((JoinCorpsEventArg)this.arg).getNewGuy(), HandCorpsAppellation.AppellationHandType.ADD);
/*    */     
/* 23 */     long roleId = ((JoinCorpsEventArg)this.arg).getNewGuy();
/*    */     
/* 25 */     CorpsMember xCorpsMember = Role2corps.select(Long.valueOf(roleId));
/* 26 */     if (xCorpsMember == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     long corpsId = xCorpsMember.getCorpsid();
/* 32 */     xbean.Corps xCorps = xtable.Corps.select(Long.valueOf(corpsId));
/* 33 */     if (xCorps == null)
/*    */     {
/* 35 */       GameServer.logger().error(String.format("[corps]POnJoinCorps.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(corpsId) }));
/*    */       
/*    */ 
/*    */ 
/* 39 */       return false;
/*    */     }
/* 41 */     SSyncCorpsInfo2NewMember syn = new SSyncCorpsInfo2NewMember();
/* 42 */     CorpsManager.fillCorpsSynInfo(xCorps, syn.corpsinfo);
/* 43 */     OnlineManager.getInstance().send(roleId, syn);
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\POnJoinCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */