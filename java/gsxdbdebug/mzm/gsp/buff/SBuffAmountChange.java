/*    */ package mzm.gsp.buff;
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
/*    */ public class SBuffAmountChange
/*    */   extends __SBuffAmountChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583172;
/*    */   public int buffid;
/*    */   public int buffcount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583172;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuffAmountChange() {}
/*    */   
/*    */ 
/*    */   public SBuffAmountChange(int _buffid_, int _buffcount_)
/*    */   {
/* 37 */     this.buffid = _buffid_;
/* 38 */     this.buffcount = _buffcount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.buffid);
/* 47 */     _os_.marshal(this.buffcount);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.buffid = _os_.unmarshal_int();
/* 53 */     this.buffcount = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SBuffAmountChange)) {
/* 63 */       SBuffAmountChange _o_ = (SBuffAmountChange)_o1_;
/* 64 */       if (this.buffid != _o_.buffid) return false;
/* 65 */       if (this.buffcount != _o_.buffcount) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.buffid;
/* 74 */     _h_ += this.buffcount;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.buffid).append(",");
/* 82 */     _sb_.append(this.buffcount).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuffAmountChange _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.buffid - _o_.buffid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.buffcount - _o_.buffcount;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\SBuffAmountChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */