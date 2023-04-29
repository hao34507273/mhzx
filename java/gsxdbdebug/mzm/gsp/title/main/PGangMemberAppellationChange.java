/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGangMemberAppellationChange
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long gangId;
/*    */   private final int gangAppId;
/*    */   
/*    */   public PGangMemberAppellationChange(long roleId, long gangId, int gangAppId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.gangId = gangId;
/* 24 */     this.gangAppId = gangAppId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     long gang_temp = GangInterface.getGangId(this.roleId);
/* 31 */     if (gang_temp != this.gangId) {
/* 32 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 36 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 37 */     GangInterface.getGang(this.gangId, true);
/*    */     
/* 39 */     List<String> args = getGangAppArgs(this.roleId, this.gangId);
/* 40 */     if ((args == null) || (args.size() == 0)) {
/* 41 */       return false;
/*    */     }
/*    */     
/* 44 */     return changeGangApp(this.roleId, args, this.gangAppId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean changeGangApp(long roleid, List<String> args, int gangAppId)
/*    */   {
/* 55 */     if (!TitleManager.isRoleHaveAppellationId(this.roleId, gangAppId)) {
/* 56 */       TitleInterface.addAppellation(this.roleId, gangAppId, args);
/* 57 */       return true;
/*    */     }
/*    */     
/* 60 */     return TitleManager.rpAppArgs(this.roleId, gangAppId, args);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private List<String> getGangAppArgs(long roleId, long gangId)
/*    */   {
/* 68 */     List<String> args = new ArrayList();
/* 69 */     String gangName = GangInterface.getGangNameByGangId(gangId);
/* 70 */     String dutyName = GangInterface.getGangDutyName(roleId);
/* 71 */     if ((gangName == null) || (gangName.equals("")) || (dutyName == null) || (dutyName.equals("")))
/*    */     {
/* 73 */       if (TitleManager.logger.isDebugEnabled()) {
/* 74 */         TitleManager.logger.debug(String.format("PGangMemberDutyChange.processImp@获取玩家帮派名或职位出错!|roleId=%d|gangId=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(gangId) }));
/*    */       }
/*    */       
/*    */ 
/* 78 */       return args;
/*    */     }
/* 80 */     args.add(gangName);
/* 81 */     args.add(dutyName);
/* 82 */     return args;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PGangMemberAppellationChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */