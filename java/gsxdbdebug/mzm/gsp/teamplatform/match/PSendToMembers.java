/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSendToMembers
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int levelLow;
/*    */   private final int levelHigh;
/*    */   private final Protocol pro;
/*    */   
/*    */   public PSendToMembers(long roleId, int levelLow, int levelHigh, Protocol pro)
/*    */   {
/* 25 */     this.roleId = roleId;
/* 26 */     this.levelHigh = levelHigh;
/* 27 */     this.levelLow = levelLow;
/* 28 */     this.pro = pro;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (this.levelHigh < this.levelLow)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     OnlineManager.getInstance().sendToOnlineRoles(this.levelLow, this.levelHigh, this.pro);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   class PSendToMember
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final Protocol pro;
/*    */     private final int levelLow;
/*    */     private final int levelHigh;
/*    */     
/*    */     public PSendToMember(long roleId, int levelLow, int levelHigh, Protocol pro)
/*    */     {
/* 52 */       this.roleId = roleId;
/* 53 */       this.levelHigh = levelHigh;
/* 54 */       this.levelLow = levelLow;
/* 55 */       this.pro = pro;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 61 */       int level = RoleInterface.getLevel(this.roleId);
/* 62 */       if ((level < this.levelLow) || (level > this.levelHigh))
/*    */       {
/* 64 */         return false;
/*    */       }
/* 66 */       if (TeamInterface.isRoleInTeam(this.roleId, false))
/*    */       {
/* 68 */         return false;
/*    */       }
/* 70 */       OnlineManager.getInstance().send(this.roleId, this.pro);
/* 71 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PSendToMembers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */