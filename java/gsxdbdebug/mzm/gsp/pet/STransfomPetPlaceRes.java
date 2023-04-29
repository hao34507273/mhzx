/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class STransfomPetPlaceRes
/*    */   extends __STransfomPetPlaceRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590646;
/*    */   public static final int TARGET_BAG = 0;
/*    */   public static final int TARGET_DEPOT = 1;
/*    */   public long petid;
/*    */   public int target;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590646;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public STransfomPetPlaceRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public STransfomPetPlaceRes(long _petid_, int _target_)
/*    */   {
/* 40 */     this.petid = _petid_;
/* 41 */     this.target = _target_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.petid);
/* 50 */     _os_.marshal(this.target);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.petid = _os_.unmarshal_long();
/* 56 */     this.target = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof STransfomPetPlaceRes)) {
/* 66 */       STransfomPetPlaceRes _o_ = (STransfomPetPlaceRes)_o1_;
/* 67 */       if (this.petid != _o_.petid) return false;
/* 68 */       if (this.target != _o_.target) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.petid;
/* 77 */     _h_ += this.target;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.petid).append(",");
/* 85 */     _sb_.append(this.target).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(STransfomPetPlaceRes _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.target - _o_.target;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\STransfomPetPlaceRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */