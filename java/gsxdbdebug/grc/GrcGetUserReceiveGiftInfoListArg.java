/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcGetUserReceiveGiftInfoListArg implements Marshal
/*    */ {
/*    */   public Octets account;
/*    */   public int page_index;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public GrcGetUserReceiveGiftInfoListArg()
/*    */   {
/* 17 */     this.account = new Octets();
/* 18 */     this.reserved1 = 0;
/* 19 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public GrcGetUserReceiveGiftInfoListArg(Octets _account_, int _page_index_, int _reserved1_, int _reserved2_) {
/* 23 */     this.account = _account_;
/* 24 */     this.page_index = _page_index_;
/* 25 */     this.reserved1 = _reserved1_;
/* 26 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.account);
/* 35 */     _os_.marshal(this.page_index);
/* 36 */     _os_.marshal(this.reserved1);
/* 37 */     _os_.marshal(this.reserved2);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.account = _os_.unmarshal_Octets();
/* 43 */     this.page_index = _os_.unmarshal_int();
/* 44 */     this.reserved1 = _os_.unmarshal_int();
/* 45 */     this.reserved2 = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof GrcGetUserReceiveGiftInfoListArg)) {
/* 52 */       GrcGetUserReceiveGiftInfoListArg _o_ = (GrcGetUserReceiveGiftInfoListArg)_o1_;
/* 53 */       if (!this.account.equals(_o_.account)) return false;
/* 54 */       if (this.page_index != _o_.page_index) return false;
/* 55 */       if (this.reserved1 != _o_.reserved1) return false;
/* 56 */       if (this.reserved2 != _o_.reserved2) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.account.hashCode();
/* 65 */     _h_ += this.page_index;
/* 66 */     _h_ += this.reserved1;
/* 67 */     _h_ += this.reserved2;
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append("B").append(this.account.size()).append(",");
/* 75 */     _sb_.append(this.page_index).append(",");
/* 76 */     _sb_.append(this.reserved1).append(",");
/* 77 */     _sb_.append(this.reserved2).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetUserReceiveGiftInfoListArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */