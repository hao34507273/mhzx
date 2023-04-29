/*    */ package csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ActiveCardUseArg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets userid;
/*    */   public Octets cardnumber;
/*    */   public int loginip;
/*    */   public int serverid;
/*    */   
/*    */   public ActiveCardUseArg()
/*    */   {
/* 15 */     this.userid = new Octets();
/* 16 */     this.cardnumber = new Octets();
/*    */   }
/*    */   
/*    */   public ActiveCardUseArg(Octets _userid_, Octets _cardnumber_, int _loginip_, int _serverid_) {
/* 20 */     this.userid = _userid_;
/* 21 */     this.cardnumber = _cardnumber_;
/* 22 */     this.loginip = _loginip_;
/* 23 */     this.serverid = _serverid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.userid);
/* 32 */     _os_.marshal(this.cardnumber);
/* 33 */     _os_.marshal(this.loginip);
/* 34 */     _os_.marshal(this.serverid);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 39 */     this.userid = _os_.unmarshal_Octets();
/* 40 */     this.cardnumber = _os_.unmarshal_Octets();
/* 41 */     this.loginip = _os_.unmarshal_int();
/* 42 */     this.serverid = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof ActiveCardUseArg)) {
/* 49 */       ActiveCardUseArg _o_ = (ActiveCardUseArg)_o1_;
/* 50 */       if (!this.userid.equals(_o_.userid)) return false;
/* 51 */       if (!this.cardnumber.equals(_o_.cardnumber)) return false;
/* 52 */       if (this.loginip != _o_.loginip) return false;
/* 53 */       if (this.serverid != _o_.serverid) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.userid.hashCode();
/* 62 */     _h_ += this.cardnumber.hashCode();
/* 63 */     _h_ += this.loginip;
/* 64 */     _h_ += this.serverid;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 72 */     _sb_.append("B").append(this.cardnumber.size()).append(",");
/* 73 */     _sb_.append(this.loginip).append(",");
/* 74 */     _sb_.append(this.serverid).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\ActiveCardUseArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */