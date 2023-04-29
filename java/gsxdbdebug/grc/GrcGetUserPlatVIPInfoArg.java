/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcGetUserPlatVIPInfoArg implements Marshal
/*    */ {
/*    */   public Octets appid;
/*    */   public Octets appkey;
/*    */   public Octets account;
/*    */   public Octets access_token;
/*    */   public int reserved1;
/*    */   public Octets reserved2;
/*    */   
/*    */   public GrcGetUserPlatVIPInfoArg()
/*    */   {
/* 19 */     this.appid = new Octets();
/* 20 */     this.appkey = new Octets();
/* 21 */     this.account = new Octets();
/* 22 */     this.access_token = new Octets();
/* 23 */     this.reserved2 = new Octets();
/*    */   }
/*    */   
/*    */   public GrcGetUserPlatVIPInfoArg(Octets _appid_, Octets _appkey_, Octets _account_, Octets _access_token_, int _reserved1_, Octets _reserved2_) {
/* 27 */     this.appid = _appid_;
/* 28 */     this.appkey = _appkey_;
/* 29 */     this.account = _account_;
/* 30 */     this.access_token = _access_token_;
/* 31 */     this.reserved1 = _reserved1_;
/* 32 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 40 */     _os_.marshal(this.appid);
/* 41 */     _os_.marshal(this.appkey);
/* 42 */     _os_.marshal(this.account);
/* 43 */     _os_.marshal(this.access_token);
/* 44 */     _os_.marshal(this.reserved1);
/* 45 */     _os_.marshal(this.reserved2);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.appid = _os_.unmarshal_Octets();
/* 51 */     this.appkey = _os_.unmarshal_Octets();
/* 52 */     this.account = _os_.unmarshal_Octets();
/* 53 */     this.access_token = _os_.unmarshal_Octets();
/* 54 */     this.reserved1 = _os_.unmarshal_int();
/* 55 */     this.reserved2 = _os_.unmarshal_Octets();
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof GrcGetUserPlatVIPInfoArg)) {
/* 62 */       GrcGetUserPlatVIPInfoArg _o_ = (GrcGetUserPlatVIPInfoArg)_o1_;
/* 63 */       if (!this.appid.equals(_o_.appid)) return false;
/* 64 */       if (!this.appkey.equals(_o_.appkey)) return false;
/* 65 */       if (!this.account.equals(_o_.account)) return false;
/* 66 */       if (!this.access_token.equals(_o_.access_token)) return false;
/* 67 */       if (this.reserved1 != _o_.reserved1) return false;
/* 68 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.appid.hashCode();
/* 77 */     _h_ += this.appkey.hashCode();
/* 78 */     _h_ += this.account.hashCode();
/* 79 */     _h_ += this.access_token.hashCode();
/* 80 */     _h_ += this.reserved1;
/* 81 */     _h_ += this.reserved2.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.appid.size()).append(",");
/* 89 */     _sb_.append("B").append(this.appkey.size()).append(",");
/* 90 */     _sb_.append("B").append(this.account.size()).append(",");
/* 91 */     _sb_.append("B").append(this.access_token.size()).append(",");
/* 92 */     _sb_.append(this.reserved1).append(",");
/* 93 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcGetUserPlatVIPInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */