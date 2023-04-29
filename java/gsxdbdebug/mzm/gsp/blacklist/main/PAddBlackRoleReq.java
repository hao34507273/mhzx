/*    */ package mzm.gsp.blacklist.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.blacklist.SAddBlackRoleRes;
/*    */ import mzm.gsp.friend.main.FriendInterface;
/*    */ import mzm.gsp.idip.main.IdipManager;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Blacklist;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PAddBlackRoleReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long blackRoleid;
/*    */   
/*    */   public PAddBlackRoleReq(long roleid, long blackRoleid)
/*    */   {
/* 23 */     this.roleid = roleid;
/* 24 */     this.blackRoleid = blackRoleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid), Long.valueOf(this.blackRoleid) }));
/*    */     
/*    */ 
/* 34 */     if (FriendInterface.isFriend(this.roleid, this.blackRoleid, true)) {
/* 35 */       BlacklistManager.sendNormalResult(this.roleid, 1);
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     Blacklist xBlacklist = BlacklistManager.getXBlacklistIfNotExist(this.roleid);
/*    */     
/* 41 */     if (xBlacklist.getList().contains(Long.valueOf(this.blackRoleid))) {
/* 42 */       BlacklistManager.sendNormalResult(this.roleid, 3);
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (xBlacklist.getList().size() >= FriendInterface.getBlackListMax()) {
/* 47 */       BlacklistManager.sendNormalResult(this.roleid, 2);
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     xBlacklist.getList().add(Long.valueOf(this.blackRoleid));
/*    */     
/*    */ 
/* 54 */     SAddBlackRoleRes res = new SAddBlackRoleRes();
/* 55 */     BlacklistManager.fillBlackRoleBean(this.blackRoleid, res.black_role);
/* 56 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/*    */ 
/* 59 */     IdipManager.blackListTLogAsync(this.roleid, this.blackRoleid, 1);
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\blacklist\main\PAddBlackRoleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */