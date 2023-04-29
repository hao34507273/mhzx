/*    */ package mzm.gsp.superequipment.wushi.event;
/*    */ 
/*    */ 
/*    */ public class UpgradeWuShiArg
/*    */ {
/*    */   public final long roleId;
/*    */   
/*    */   public final int wushicfgid_current;
/*    */   
/*    */   public final int wushicfgid_last;
/*    */   public final int fragmentCount;
/*    */   public final int isOn;
/*    */   
/*    */   public UpgradeWuShiArg(long roleId, int wushicfgid_current, int wushicfgid_last, int fragmentCount, int isOn)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.wushicfgid_current = wushicfgid_current;
/* 18 */     this.wushicfgid_last = wushicfgid_last;
/* 19 */     this.fragmentCount = fragmentCount;
/* 20 */     this.isOn = isOn;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\event\UpgradeWuShiArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */