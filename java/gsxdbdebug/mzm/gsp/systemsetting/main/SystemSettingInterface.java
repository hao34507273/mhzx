/*    */ package mzm.gsp.systemsetting.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.friend.confbean.SFriendConsts;
/*    */ import mzm.gsp.systemsetting.SSyncSystemSetting;
/*    */ import xbean.SystemSetting;
/*    */ import xtable.Role2systemsetting;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SystemSettingInterface
/*    */ {
/*    */   static void fill(long roleId, SSyncSystemSetting sSyncSystemSetting, SystemSetting xSystemSetting)
/*    */   {
/* 19 */     for (Map.Entry<Integer, Integer> entry : xSystemSetting.getSettingmap().entrySet())
/*    */     {
/* 21 */       sSyncSystemSetting.settingmap.put(entry.getKey(), entry.getValue());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void initSystemSetting(long roleId, SystemSetting xSystemSetting)
/*    */   {
/* 29 */     xSystemSetting.getSettingmap().put(Integer.valueOf(2), Integer.valueOf(1));
/* 30 */     xSystemSetting.getSettingmap().put(Integer.valueOf(3), Integer.valueOf(0));
/* 31 */     xSystemSetting.getSettingmap().put(Integer.valueOf(4), Integer.valueOf(0));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 36 */     xSystemSetting.getSettingmap().put(Integer.valueOf(6), Integer.valueOf(SFriendConsts.getInstance().addFriendLvSet));
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
/*    */ 
/*    */   public static Integer getSetting(long roleId, int type)
/*    */   {
/* 51 */     SystemSetting xSystemSetting = Role2systemsetting.select(Long.valueOf(roleId));
/* 52 */     if (xSystemSetting == null)
/*    */     {
/* 54 */       return Integer.valueOf(0);
/*    */     }
/* 56 */     Integer v = (Integer)xSystemSetting.getSettingmap().get(Integer.valueOf(type));
/* 57 */     if (v == null)
/* 58 */       v = Integer.valueOf(0);
/* 59 */     return v;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\systemsetting\main\SystemSettingInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */