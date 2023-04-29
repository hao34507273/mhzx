/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ import mzm.gsp.title.main.TitleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.CorpsMember;
/*    */ import xtable.Role2corps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HandCorpsAppellation
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final AppellationHandType handType;
/*    */   
/*    */   public HandCorpsAppellation(long roleId, AppellationHandType handType)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.handType = handType;
/*    */   }
/*    */   
/*    */   public static enum AppellationHandType
/*    */   {
/* 29 */     ADD, 
/* 30 */     CHANGE_ARGS;
/*    */     
/*    */     private AppellationHandType() {}
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 37 */     CorpsMember xCorpsMember = Role2corps.get(Long.valueOf(this.roleId));
/* 38 */     if (xCorpsMember == null)
/*    */     {
/* 40 */       GameServer.logger().error(String.format("[corps]AddCorpsAppellation.processImp@ not own corps!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     long corpsId = xCorpsMember.getCorpsid();
/* 45 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(corpsId));
/* 46 */     if (xCorps == null)
/*    */     {
/* 48 */       GameServer.logger().error(String.format("[corps]AddCorpsAppellation.processImp@ IMPOSSIBLE! not have this corps!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 53 */       return false;
/*    */     }
/* 55 */     List<String> args = CorpsManager.getCorpsAppellationArgs(xCorpsMember.getDuty(), corpsId, xCorps.getCorpsname());
/* 56 */     if (args == null)
/*    */     {
/* 58 */       GameServer.logger().error(String.format("[corps]AddCorpsAppellation.processImp@ IMPOSSIBLE! get corps args err!|roleId=%d|corpsId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(corpsId) }));
/*    */       
/*    */ 
/*    */ 
/* 62 */       return false;
/*    */     }
/* 64 */     switch (this.handType)
/*    */     {
/*    */     case ADD: 
/* 67 */       TitleInterface.addAppellation(this.roleId, CorpsConsts.getInstance().CORPS_APPELLATION_ID, args, true);
/* 68 */       break;
/*    */     case CHANGE_ARGS: 
/* 70 */       TitleInterface.replaceAppellationArgs(this.roleId, CorpsConsts.getInstance().CORPS_APPELLATION_ID, args);
/* 71 */       break;
/*    */     
/*    */     default: 
/* 74 */       return false;
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\HandCorpsAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */