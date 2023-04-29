/*    */ package mzm.gsp.petmark;
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
/*    */ 
/*    */ 
/*    */ public class SUnlockPetMarkSuccess
/*    */   extends __SUnlockPetMarkSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628487;
/*    */   public long pet_mark_id;
/*    */   public PetMarkInfo pet_mark_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628487;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnlockPetMarkSuccess()
/*    */   {
/* 34 */     this.pet_mark_info = new PetMarkInfo();
/*    */   }
/*    */   
/*    */   public SUnlockPetMarkSuccess(long _pet_mark_id_, PetMarkInfo _pet_mark_info_) {
/* 38 */     this.pet_mark_id = _pet_mark_id_;
/* 39 */     this.pet_mark_info = _pet_mark_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.pet_mark_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.pet_mark_id);
/* 49 */     _os_.marshal(this.pet_mark_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.pet_mark_id = _os_.unmarshal_long();
/* 55 */     this.pet_mark_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SUnlockPetMarkSuccess)) {
/* 65 */       SUnlockPetMarkSuccess _o_ = (SUnlockPetMarkSuccess)_o1_;
/* 66 */       if (this.pet_mark_id != _o_.pet_mark_id) return false;
/* 67 */       if (!this.pet_mark_info.equals(_o_.pet_mark_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.pet_mark_id;
/* 76 */     _h_ += this.pet_mark_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.pet_mark_id).append(",");
/* 84 */     _sb_.append(this.pet_mark_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnlockPetMarkSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.pet_mark_id - _o_.pet_mark_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.pet_mark_info.compareTo(_o_.pet_mark_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SUnlockPetMarkSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */