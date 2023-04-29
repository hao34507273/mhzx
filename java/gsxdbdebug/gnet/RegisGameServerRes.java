/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RegisGameServerRes implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int retcode;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public RegisGameServerRes()
/*    */   {
/* 14 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public RegisGameServerRes(int _retcode_, int _reserved1_, Octets _reserved2_) {
/* 18 */     this.retcode = _retcode_;
/* 19 */     this.reserved1 = _reserved1_;
/* 20 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.retcode);
/* 29 */     _os_.marshal(this.reserved1);
/* 30 */     _os_.marshal(this.reserved2);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.retcode = _os_.unmarshal_int();
/* 36 */     this.reserved1 = _os_.unmarshal_int();
/* 37 */     this.reserved2 = _os_.unmarshal_Octets();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof RegisGameServerRes)) {
/* 44 */       RegisGameServerRes _o_ = (RegisGameServerRes)_o1_;
/* 45 */       if (this.retcode != _o_.retcode) return false;
/* 46 */       if (this.reserved1 != _o_.reserved1) return false;
/* 47 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.retcode;
/* 56 */     _h_ += this.reserved1;
/* 57 */     _h_ += this.reserved2.hashCode();
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.retcode).append(",");
/* 65 */     _sb_.append(this.reserved1).append(",");
/* 66 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\RegisGameServerRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */