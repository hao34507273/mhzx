/*    */ package mzm.gsp.foolsday.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.foolsday.SSynOpenChestMakerids;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FoolsDayInfo;
/*    */ import xbean.RoleFoolsDayInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     long roleid = ((Long)this.arg).longValue();
/*    */     
/* 22 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/* 24 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 26 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/*    */     
/* 28 */     RoleFoolsDayInfo xRoleFoolsDayInfo = xtable.Role_fools_day_infos.get(Long.valueOf(roleid));
/* 29 */     if (xRoleFoolsDayInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 34 */     for (Map.Entry<Integer, FoolsDayInfo> entry : xRoleFoolsDayInfo.getFools_day_infos().entrySet())
/*    */     {
/* 36 */       if (DateTimeUtils.needDailyReset(((FoolsDayInfo)entry.getValue()).getOpen_chest_maker_ids_timestamp(), now, 0))
/*    */       {
/* 38 */         ((FoolsDayInfo)entry.getValue()).getOpen_chest_maker_ids().clear();
/* 39 */         ((FoolsDayInfo)entry.getValue()).setOpen_chest_maker_ids_timestamp(now);
/*    */       }
/*    */       
/* 42 */       SSynOpenChestMakerids protocol = new SSynOpenChestMakerids();
/* 43 */       protocol.activity_cfg_id = ((Integer)entry.getKey()).intValue();
/* 44 */       protocol.open_chest_maker_ids.addAll(((FoolsDayInfo)entry.getValue()).getOpen_chest_maker_ids());
/* 45 */       OnlineManager.getInstance().send(roleid, protocol);
/*    */     }
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */