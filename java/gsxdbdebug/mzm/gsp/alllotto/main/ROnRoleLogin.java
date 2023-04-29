/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.online.event.PlayerLoginRunnable;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAllLottoActivityInfo;
/*    */ import xbean.RoleAllLottoInfo;
/*    */ import xbean.RoleAllLottoTurnInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role_all_lotto_infos;
/*    */ import xtable.User;
/*    */ 
/*    */ public class ROnRoleLogin extends PlayerLoginRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 21 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     new PCheckAndSendAward(((Long)this.arg).longValue()).call();
/*    */   }
/*    */   
/*    */   class PCheckAndSendAward extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     
/*    */     PCheckAndSendAward(long roleid)
/*    */     {
/* 34 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 40 */       String userid = RoleInterface.getUserId(this.roleid);
/*    */       
/* 42 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */       
/* 44 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 45 */       RoleAllLottoInfo xRoleAllLottoInfo = Role_all_lotto_infos.get(Long.valueOf(this.roleid));
/* 46 */       if (xRoleAllLottoInfo == null)
/*    */       {
/* 48 */         return false;
/*    */       }
/* 50 */       for (Map.Entry<Integer, RoleAllLottoActivityInfo> activityEntry : xRoleAllLottoInfo.getActivity_infos().entrySet())
/*    */       {
/* 52 */         activityCfgid = ((Integer)activityEntry.getKey()).intValue();
/* 53 */         RoleAllLottoActivityInfo xRoleAllLottoActivityInfo = (RoleAllLottoActivityInfo)activityEntry.getValue();
/* 54 */         for (Map.Entry<Integer, RoleAllLottoTurnInfo> turnEntry : xRoleAllLottoActivityInfo.getTurn_infos().entrySet())
/*    */         {
/* 56 */           int turn = ((Integer)turnEntry.getKey()).intValue();
/* 57 */           RoleAllLottoTurnInfo xRoleAllLottoTurnInfo = (RoleAllLottoTurnInfo)turnEntry.getValue();
/* 58 */           if (xRoleAllLottoTurnInfo.getAward_state() == 1)
/*    */           {
/*    */ 
/*    */ 
/* 62 */             new PSendAward(this.roleid, activityCfgid, turn).call(); }
/*    */         } }
/*    */       int activityCfgid;
/* 65 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\ROnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */