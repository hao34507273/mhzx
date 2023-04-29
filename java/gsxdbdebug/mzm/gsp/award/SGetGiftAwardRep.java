/*    */ package mzm.gsp.award;
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
/*    */ public class SGetGiftAwardRep
/*    */   extends __SGetGiftAwardRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583444;
/*    */   public int giftawardcfgid;
/*    */   public byte result;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583444;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetGiftAwardRep() {}
/*    */   
/*    */ 
/*    */   public SGetGiftAwardRep(int _giftawardcfgid_, byte _result_)
/*    */   {
/* 37 */     this.giftawardcfgid = _giftawardcfgid_;
/* 38 */     this.result = _result_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.giftawardcfgid);
/* 47 */     _os_.marshal(this.result);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.giftawardcfgid = _os_.unmarshal_int();
/* 53 */     this.result = _os_.unmarshal_byte();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGetGiftAwardRep)) {
/* 63 */       SGetGiftAwardRep _o_ = (SGetGiftAwardRep)_o1_;
/* 64 */       if (this.giftawardcfgid != _o_.giftawardcfgid) return false;
/* 65 */       if (this.result != _o_.result) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.giftawardcfgid;
/* 74 */     _h_ += this.result;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.giftawardcfgid).append(",");
/* 82 */     _sb_.append(this.result).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetGiftAwardRep _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.giftawardcfgid - _o_.giftawardcfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.result - _o_.result;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SGetGiftAwardRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */