/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.huanhun.SRmGangHelpCache;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GangHelpInfo;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Gang2hunhelp;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmRoleAllHelp
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private long gangId;
/*    */   
/*    */   public PRmRoleAllHelp(long roleId)
/*    */   {
/* 26 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public PRmRoleAllHelp(long roleId, long gangId)
/*    */   {
/* 37 */     this.roleId = roleId;
/* 38 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 45 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 46 */     if (xHunInfo == null)
/*    */     {
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     if (this.gangId <= 0L)
/*    */     {
/* 53 */       this.gangId = GangInterface.getGangId(this.roleId);
/* 54 */       if (this.gangId <= 0L)
/*    */       {
/* 56 */         return false;
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SRmGangHelpCache());
/*    */     }
/*    */     
/* 65 */     if (GangInterface.getGang(this.gangId, true) == null)
/*    */     {
/* 67 */       GameServer.logger().info(String.format("[hun]PRmRoleAllHelp@processImp@ have no gang!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     GangHelpInfo xHelpInfo = Gang2hunhelp.get(Long.valueOf(this.gangId));
/*    */     
/* 73 */     if (xHelpInfo == null)
/*    */     {
/* 75 */       GameServer.logger().info(String.format("[hun]PRmRoleAllHelp@processImp@ no gang data!|roleId=%d|gangId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.gangId) }));
/*    */       
/* 77 */       return false;
/*    */     }
/* 79 */     GangHelpManager.rmRoleGangHelp(this.gangId, xHelpInfo, this.roleId, new HashSet());
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PRmRoleAllHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */