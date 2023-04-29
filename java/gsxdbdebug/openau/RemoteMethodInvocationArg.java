/*    */ package openau;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RemoteMethodInvocationArg implements Marshal
/*    */ {
/*    */   public int methodid;
/*    */   public Octets methodargs;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public RemoteMethodInvocationArg()
/*    */   {
/* 17 */     this.methodargs = new Octets();
/* 18 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public RemoteMethodInvocationArg(int _methodid_, Octets _methodargs_, int _reserved1_, Octets _reserved2_) {
/* 22 */     this.methodid = _methodid_;
/* 23 */     this.methodargs = _methodargs_;
/* 24 */     this.reserved1 = _reserved1_;
/* 25 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.methodid);
/* 34 */     _os_.marshal(this.methodargs);
/* 35 */     _os_.marshal(this.reserved1);
/* 36 */     _os_.marshal(this.reserved2);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.methodid = _os_.unmarshal_int();
/* 42 */     this.methodargs = _os_.unmarshal_Octets();
/* 43 */     this.reserved1 = _os_.unmarshal_int();
/* 44 */     this.reserved2 = _os_.unmarshal_Octets();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof RemoteMethodInvocationArg)) {
/* 51 */       RemoteMethodInvocationArg _o_ = (RemoteMethodInvocationArg)_o1_;
/* 52 */       if (this.methodid != _o_.methodid) return false;
/* 53 */       if (!this.methodargs.equals(_o_.methodargs)) return false;
/* 54 */       if (this.reserved1 != _o_.reserved1) return false;
/* 55 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += this.methodid;
/* 64 */     _h_ += this.methodargs.hashCode();
/* 65 */     _h_ += this.reserved1;
/* 66 */     _h_ += this.reserved2.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.methodid).append(",");
/* 74 */     _sb_.append("B").append(this.methodargs.size()).append(",");
/* 75 */     _sb_.append(this.reserved1).append(",");
/* 76 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\RemoteMethodInvocationArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */