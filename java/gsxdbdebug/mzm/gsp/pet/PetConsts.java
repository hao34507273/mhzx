/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class PetConsts
/*    */   implements Marshal, Comparable<PetConsts>
/*    */ {
/*    */   public static final int PET_BAG_ID = 340600003;
/*    */   public static final int PET_DEPOT_ID = 340600004;
/*    */   public int abc;
/*    */   
/*    */   public PetConsts() {}
/*    */   
/*    */   public PetConsts(int _abc_)
/*    */   {
/* 18 */     this.abc = _abc_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.abc);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.abc = _os_.unmarshal_int();
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 36 */     if (_o1_ == this) return true;
/* 37 */     if ((_o1_ instanceof PetConsts)) {
/* 38 */       PetConsts _o_ = (PetConsts)_o1_;
/* 39 */       if (this.abc != _o_.abc) return false;
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 46 */     int _h_ = 0;
/* 47 */     _h_ += this.abc;
/* 48 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder _sb_ = new StringBuilder();
/* 53 */     _sb_.append("(");
/* 54 */     _sb_.append(this.abc).append(",");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(PetConsts _o_) {
/* 60 */     if (_o_ == this) return 0;
/* 61 */     int _c_ = 0;
/* 62 */     _c_ = this.abc - _o_.abc;
/* 63 */     if (0 != _c_) return _c_;
/* 64 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */