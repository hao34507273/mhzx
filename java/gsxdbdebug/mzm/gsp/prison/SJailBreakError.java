/*    */ package mzm.gsp.prison;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SJailBreakError
/*    */   extends __SJailBreakError__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12620040;
/*    */   public int errorcode;
/*    */   public ArrayList<Octets> params;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12620040;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SJailBreakError()
/*    */   {
/* 34 */     this.params = new ArrayList();
/*    */   }
/*    */   
/*    */   public SJailBreakError(int _errorcode_, ArrayList<Octets> _params_) {
/* 38 */     this.errorcode = _errorcode_;
/* 39 */     this.params = _params_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.errorcode);
/* 48 */     _os_.compact_uint32(this.params.size());
/* 49 */     for (Octets _v_ : this.params) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.errorcode = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       Octets _v_ = _os_.unmarshal_Octets();
/* 60 */       this.params.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SJailBreakError)) {
/* 71 */       SJailBreakError _o_ = (SJailBreakError)_o1_;
/* 72 */       if (this.errorcode != _o_.errorcode) return false;
/* 73 */       if (!this.params.equals(_o_.params)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.errorcode;
/* 82 */     _h_ += this.params.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.errorcode).append(",");
/* 90 */     _sb_.append(this.params).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\SJailBreakError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */