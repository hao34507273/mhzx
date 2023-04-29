/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GenRoamTokenRsp implements Marshal
/*    */ {
/*    */   public Octets token;
/*    */   
/*    */   public GenRoamTokenRsp()
/*    */   {
/* 14 */     this.token = new Octets();
/*    */   }
/*    */   
/*    */   public GenRoamTokenRsp(Octets _token_) {
/* 18 */     this.token = _token_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.token);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.token = _os_.unmarshal_Octets();
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 36 */     if (_o1_ == this) return true;
/* 37 */     if ((_o1_ instanceof GenRoamTokenRsp)) {
/* 38 */       GenRoamTokenRsp _o_ = (GenRoamTokenRsp)_o1_;
/* 39 */       if (!this.token.equals(_o_.token)) return false;
/* 40 */       return true;
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 46 */     int _h_ = 0;
/* 47 */     _h_ += this.token.hashCode();
/* 48 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuilder _sb_ = new StringBuilder();
/* 53 */     _sb_.append("(");
/* 54 */     _sb_.append("B").append(this.token.size()).append(",");
/* 55 */     _sb_.append(")");
/* 56 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\GenRoamTokenRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */