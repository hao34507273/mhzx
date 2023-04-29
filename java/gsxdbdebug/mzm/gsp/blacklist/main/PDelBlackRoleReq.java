/*    */ package mzm.gsp.blacklist.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Blacklist;
/*    */ 
/*    */ 
/*    */ public class PDelBlackRoleReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long blackRoleid;
/*    */   
/*    */   public PDelBlackRoleReq(long roleid, long blackRoleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/* 18 */     this.blackRoleid = blackRoleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     Blacklist xBlacklist = BlacklistManager.getXBlacklistIfNotExist(this.roleid);
/* 25 */     if (!xBlacklist.getList().remove(Long.valueOf(this.blackRoleid)))
/*    */     {
/* 27 */       BlacklistManager.sendNormalResult(this.roleid, 11);
/*    */     }
/*    */     else
/*    */     {
/* 31 */       BlacklistManager.syncDelBlackRole(this.roleid, this.blackRoleid);
/*    */       
/* 33 */       IdipManager.blackListTLogAsync(this.roleid, this.blackRoleid, 2);
/*    */     }
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\PDelBlackRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */