/*    */ package mzm.gsp.systemsetting.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.systemsetting.SSystemSettingRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Pod;
/*    */ import xbean.SystemSetting;
/*    */ import xtable.Role2systemsetting;
/*    */ 
/*    */ public class PSystemSettingReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int type;
/*    */   private int value;
/*    */   
/*    */   public PSystemSettingReq(long roleId, int type, int value)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.type = type;
/* 22 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (!validateTypeAndValue()) {
/* 28 */       return false;
/*    */     }
/* 30 */     SystemSetting xSystemSetting = Role2systemsetting.get(Long.valueOf(this.roleId));
/* 31 */     if (xSystemSetting == null) {
/* 32 */       xSystemSetting = Pod.newSystemSetting();
/* 33 */       Role2systemsetting.add(Long.valueOf(this.roleId), xSystemSetting);
/*    */     }
/* 35 */     xSystemSetting.getSettingmap().put(Integer.valueOf(this.type), Integer.valueOf(this.value));
/* 36 */     SSystemSettingRes res = new SSystemSettingRes();
/* 37 */     res.settingtype = this.type;
/* 38 */     res.settingvalue = this.value;
/* 39 */     OnlineManager.getInstance().send(this.roleId, res);
/* 40 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private boolean validateTypeAndValue()
/*    */   {
/* 54 */     switch (this.type)
/*    */     {
/*    */     case 6: 
/* 57 */       return (this.value > 0) && (this.value <= mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() - SFriendConsts.getInstance().addFriendMaxLvDiffWithServer);
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\systemsetting\main\PSystemSettingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */