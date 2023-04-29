/*    */ package csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GiftCardUseArg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets userid;
/*    */   public long roleid;
/*    */   public Octets cardnumber;
/*    */   public int loginip;
/*    */   public int serverid;
/*    */   
/*    */   public GiftCardUseArg()
/*    */   {
/* 16 */     this.userid = new Octets();
/* 17 */     this.cardnumber = new Octets();
/*    */   }
/*    */   
/*    */   public GiftCardUseArg(Octets _userid_, long _roleid_, Octets _cardnumber_, int _loginip_, int _serverid_) {
/* 21 */     this.userid = _userid_;
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.cardnumber = _cardnumber_;
/* 24 */     this.loginip = _loginip_;
/* 25 */     this.serverid = _serverid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.userid);
/* 34 */     _os_.marshal(this.roleid);
/* 35 */     _os_.marshal(this.cardnumber);
/* 36 */     _os_.marshal(this.loginip);
/* 37 */     _os_.marshal(this.serverid);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     this.userid = _os_.unmarshal_Octets();
/* 43 */     this.roleid = _os_.unmarshal_long();
/* 44 */     this.cardnumber = _os_.unmarshal_Octets();
/* 45 */     this.loginip = _os_.unmarshal_int();
/* 46 */     this.serverid = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof GiftCardUseArg)) {
/* 53 */       GiftCardUseArg _o_ = (GiftCardUseArg)_o1_;
/* 54 */       if (!this.userid.equals(_o_.userid)) return false;
/* 55 */       if (this.roleid != _o_.roleid) return false;
/* 56 */       if (!this.cardnumber.equals(_o_.cardnumber)) return false;
/* 57 */       if (this.loginip != _o_.loginip) return false;
/* 58 */       if (this.serverid != _o_.serverid) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.userid.hashCode();
/* 67 */     _h_ += (int)this.roleid;
/* 68 */     _h_ += this.cardnumber.hashCode();
/* 69 */     _h_ += this.loginip;
/* 70 */     _h_ += this.serverid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 78 */     _sb_.append(this.roleid).append(",");
/* 79 */     _sb_.append("B").append(this.cardnumber.size()).append(",");
/* 80 */     _sb_.append(this.loginip).append(",");
/* 81 */     _sb_.append(this.serverid).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\GiftCardUseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */