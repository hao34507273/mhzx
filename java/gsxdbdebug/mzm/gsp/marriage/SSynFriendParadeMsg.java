/*    */ package mzm.gsp.marriage;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynFriendParadeMsg
/*    */   extends __SSynFriendParadeMsg__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599857;
/*    */   public ParadeRoleInfo myinfo;
/*    */   public ParadeRoleInfo coupleinfo;
/*    */   public int paradecfgid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599857;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynFriendParadeMsg()
/*    */   {
/* 35 */     this.myinfo = new ParadeRoleInfo();
/* 36 */     this.coupleinfo = new ParadeRoleInfo();
/*    */   }
/*    */   
/*    */   public SSynFriendParadeMsg(ParadeRoleInfo _myinfo_, ParadeRoleInfo _coupleinfo_, int _paradecfgid_) {
/* 40 */     this.myinfo = _myinfo_;
/* 41 */     this.coupleinfo = _coupleinfo_;
/* 42 */     this.paradecfgid = _paradecfgid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.myinfo._validator_()) return false;
/* 47 */     if (!this.coupleinfo._validator_()) return false;
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.myinfo);
/* 53 */     _os_.marshal(this.coupleinfo);
/* 54 */     _os_.marshal(this.paradecfgid);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.myinfo.unmarshal(_os_);
/* 60 */     this.coupleinfo.unmarshal(_os_);
/* 61 */     this.paradecfgid = _os_.unmarshal_int();
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSynFriendParadeMsg)) {
/* 71 */       SSynFriendParadeMsg _o_ = (SSynFriendParadeMsg)_o1_;
/* 72 */       if (!this.myinfo.equals(_o_.myinfo)) return false;
/* 73 */       if (!this.coupleinfo.equals(_o_.coupleinfo)) return false;
/* 74 */       if (this.paradecfgid != _o_.paradecfgid) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.myinfo.hashCode();
/* 83 */     _h_ += this.coupleinfo.hashCode();
/* 84 */     _h_ += this.paradecfgid;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.myinfo).append(",");
/* 92 */     _sb_.append(this.coupleinfo).append(",");
/* 93 */     _sb_.append(this.paradecfgid).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSynFriendParadeMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */