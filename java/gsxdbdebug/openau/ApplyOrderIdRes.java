/*    */ package openau;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ApplyOrderIdRes implements Marshal
/*    */ {
/*    */   public int retcode;
/*    */   public Octets orderid;
/*    */   public Octets callbackurl;
/*    */   public Octets ext;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public ApplyOrderIdRes()
/*    */   {
/* 19 */     this.retcode = 9;
/* 20 */     this.orderid = new Octets();
/* 21 */     this.callbackurl = new Octets();
/* 22 */     this.ext = new Octets();
/* 23 */     this.reserved1 = 0;
/* 24 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public ApplyOrderIdRes(int _retcode_, Octets _orderid_, Octets _callbackurl_, Octets _ext_, int _reserved1_, Octets _reserved2_) {
/* 28 */     this.retcode = _retcode_;
/* 29 */     this.orderid = _orderid_;
/* 30 */     this.callbackurl = _callbackurl_;
/* 31 */     this.ext = _ext_;
/* 32 */     this.reserved1 = _reserved1_;
/* 33 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 41 */     _os_.marshal(this.retcode);
/* 42 */     _os_.marshal(this.orderid);
/* 43 */     _os_.marshal(this.callbackurl);
/* 44 */     _os_.marshal(this.ext);
/* 45 */     _os_.marshal(this.reserved1);
/* 46 */     _os_.marshal(this.reserved2);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.retcode = _os_.unmarshal_int();
/* 52 */     this.orderid = _os_.unmarshal_Octets();
/* 53 */     this.callbackurl = _os_.unmarshal_Octets();
/* 54 */     this.ext = _os_.unmarshal_Octets();
/* 55 */     this.reserved1 = _os_.unmarshal_int();
/* 56 */     this.reserved2 = _os_.unmarshal_Octets();
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof ApplyOrderIdRes)) {
/* 63 */       ApplyOrderIdRes _o_ = (ApplyOrderIdRes)_o1_;
/* 64 */       if (this.retcode != _o_.retcode) return false;
/* 65 */       if (!this.orderid.equals(_o_.orderid)) return false;
/* 66 */       if (!this.callbackurl.equals(_o_.callbackurl)) return false;
/* 67 */       if (!this.ext.equals(_o_.ext)) return false;
/* 68 */       if (this.reserved1 != _o_.reserved1) return false;
/* 69 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.retcode;
/* 78 */     _h_ += this.orderid.hashCode();
/* 79 */     _h_ += this.callbackurl.hashCode();
/* 80 */     _h_ += this.ext.hashCode();
/* 81 */     _h_ += this.reserved1;
/* 82 */     _h_ += this.reserved2.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.retcode).append(",");
/* 90 */     _sb_.append("B").append(this.orderid.size()).append(",");
/* 91 */     _sb_.append("B").append(this.callbackurl.size()).append(",");
/* 92 */     _sb_.append("B").append(this.ext.size()).append(",");
/* 93 */     _sb_.append(this.reserved1).append(",");
/* 94 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\ApplyOrderIdRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */