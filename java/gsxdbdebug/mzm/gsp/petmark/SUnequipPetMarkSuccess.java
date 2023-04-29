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
/*    */ public class SUnequipPetMarkSuccess
/*    */   extends __SUnequipPetMarkSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628496;
/*    */   public long pet_mark_id;
/*    */   public long pet_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628496;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnequipPetMarkSuccess() {}
/*    */   
/*    */ 
/*    */   public SUnequipPetMarkSuccess(long _pet_mark_id_, long _pet_id_)
/*    */   {
/* 37 */     this.pet_mark_id = _pet_mark_id_;
/* 38 */     this.pet_id = _pet_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.pet_mark_id);
/* 47 */     _os_.marshal(this.pet_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.pet_mark_id = _os_.unmarshal_long();
/* 53 */     this.pet_id = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUnequipPetMarkSuccess)) {
/* 63 */       SUnequipPetMarkSuccess _o_ = (SUnequipPetMarkSuccess)_o1_;
/* 64 */       if (this.pet_mark_id != _o_.pet_mark_id) return false;
/* 65 */       if (this.pet_id != _o_.pet_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.pet_mark_id;
/* 74 */     _h_ += (int)this.pet_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.pet_mark_id).append(",");
/* 82 */     _sb_.append(this.pet_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnequipPetMarkSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.pet_mark_id - _o_.pet_mark_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.pet_id - _o_.pet_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SUnequipPetMarkSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */