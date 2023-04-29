/*    */ package mzm.gsp.mounts;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MountsConst
/*    */   implements Marshal, Comparable<MountsConst>
/*    */ {
/*    */   public static final int NO_RIDE = 0;
/*    */   public static final int MAIN_BATTLE_MOUNT_CELL = 1;
/*    */   public static final int NO_REFRESH_PASSIVE_SKILL = 0;
/*    */   public static final int NO_USE_YUAN_BAO = 0;
/*    */   public static final int YES_USE_YUAN_BAO = 1;
/*    */   public static final int TIME_FOREVER = -1;
/*    */   public static final int NO_CHIEF_BATTLE_MOUNTS = 0;
/*    */   public static final int YES_CHIEF_BATTLE_MOUNTS = 1;
/*    */   public static final int NO_STAR_NUM_ACTIVE = 0;
/*    */   public static final int COLOR_CHANGE = 0;
/*    */   public static final int MODEL_CHANGE = 1;
/*    */   public static final int CHIP_TYPE = 0;
/*    */   public static final int ITEM_TYPE = 1;
/*    */   public static final int NO_USE_ALL = 0;
/*    */   public static final int YES_UES_ALL = 1;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof MountsConst)) {
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(")");
/* 58 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MountsConst _o_) {
/* 62 */     if (_o_ == this) return 0;
/* 63 */     int _c_ = 0;
/* 64 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\MountsConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */