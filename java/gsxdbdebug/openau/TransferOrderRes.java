/*    */ package openau;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class TransferOrderRes implements Marshal
/*    */ {
/*    */   public int retcode;
/*    */   public int sn;
/*    */   public Octets finalsucceedorderid;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public TransferOrderRes()
/*    */   {
/* 18 */     this.retcode = 9;
/* 19 */     this.finalsucceedorderid = new Octets();
/* 20 */     this.reserved1 = 0;
/* 21 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public TransferOrderRes(int _retcode_, int _sn_, Octets _finalsucceedorderid_, int _reserved1_, Octets _reserved2_) {
/* 25 */     this.retcode = _retcode_;
/* 26 */     this.sn = _sn_;
/* 27 */     this.finalsucceedorderid = _finalsucceedorderid_;
/* 28 */     this.reserved1 = _reserved1_;
/* 29 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 37 */     _os_.marshal(this.retcode);
/* 38 */     _os_.marshal(this.sn);
/* 39 */     _os_.marshal(this.finalsucceedorderid);
/* 40 */     _os_.marshal(this.reserved1);
/* 41 */     _os_.marshal(this.reserved2);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.retcode = _os_.unmarshal_int();
/* 47 */     this.sn = _os_.unmarshal_int();
/* 48 */     this.finalsucceedorderid = _os_.unmarshal_Octets();
/* 49 */     this.reserved1 = _os_.unmarshal_int();
/* 50 */     this.reserved2 = _os_.unmarshal_Octets();
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof TransferOrderRes)) {
/* 57 */       TransferOrderRes _o_ = (TransferOrderRes)_o1_;
/* 58 */       if (this.retcode != _o_.retcode) return false;
/* 59 */       if (this.sn != _o_.sn) return false;
/* 60 */       if (!this.finalsucceedorderid.equals(_o_.finalsucceedorderid)) return false;
/* 61 */       if (this.reserved1 != _o_.reserved1) return false;
/* 62 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.retcode;
/* 71 */     _h_ += this.sn;
/* 72 */     _h_ += this.finalsucceedorderid.hashCode();
/* 73 */     _h_ += this.reserved1;
/* 74 */     _h_ += this.reserved2.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.retcode).append(",");
/* 82 */     _sb_.append(this.sn).append(",");
/* 83 */     _sb_.append("B").append(this.finalsucceedorderid.size()).append(",");
/* 84 */     _sb_.append(this.reserved1).append(",");
/* 85 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\openau\TransferOrderRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */