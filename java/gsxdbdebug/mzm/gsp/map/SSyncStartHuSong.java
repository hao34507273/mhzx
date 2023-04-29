/*    */ package mzm.gsp.map;
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
/*    */ public class SSyncStartHuSong
/*    */   extends __SSyncStartHuSong__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590897;
/*    */   public byte is_special;
/*    */   public Location targetpos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590897;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncStartHuSong()
/*    */   {
/* 34 */     this.targetpos = new Location();
/*    */   }
/*    */   
/*    */   public SSyncStartHuSong(byte _is_special_, Location _targetpos_) {
/* 38 */     this.is_special = _is_special_;
/* 39 */     this.targetpos = _targetpos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.targetpos._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.is_special);
/* 49 */     _os_.marshal(this.targetpos);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.is_special = _os_.unmarshal_byte();
/* 55 */     this.targetpos.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSyncStartHuSong)) {
/* 65 */       SSyncStartHuSong _o_ = (SSyncStartHuSong)_o1_;
/* 66 */       if (this.is_special != _o_.is_special) return false;
/* 67 */       if (!this.targetpos.equals(_o_.targetpos)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.is_special;
/* 76 */     _h_ += this.targetpos.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.is_special).append(",");
/* 84 */     _sb_.append(this.targetpos).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncStartHuSong _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.is_special - _o_.is_special;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.targetpos.compareTo(_o_.targetpos);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncStartHuSong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */