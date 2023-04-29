/*    */ package mzm.gsp.changemodelcard;
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
/*    */ public class SUnlockCardSuccess
/*    */   extends __SUnlockCardSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624397;
/*    */   public long card_id;
/*    */   public CardInfo card_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624397;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUnlockCardSuccess()
/*    */   {
/* 34 */     this.card_info = new CardInfo();
/*    */   }
/*    */   
/*    */   public SUnlockCardSuccess(long _card_id_, CardInfo _card_info_) {
/* 38 */     this.card_id = _card_id_;
/* 39 */     this.card_info = _card_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.card_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.card_id);
/* 49 */     _os_.marshal(this.card_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.card_id = _os_.unmarshal_long();
/* 55 */     this.card_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SUnlockCardSuccess)) {
/* 65 */       SUnlockCardSuccess _o_ = (SUnlockCardSuccess)_o1_;
/* 66 */       if (this.card_id != _o_.card_id) return false;
/* 67 */       if (!this.card_info.equals(_o_.card_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.card_id;
/* 76 */     _h_ += this.card_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.card_id).append(",");
/* 84 */     _sb_.append(this.card_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUnlockCardSuccess _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.card_id - _o_.card_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.card_info.compareTo(_o_.card_info);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SUnlockCardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */