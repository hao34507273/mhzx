/*    */ package mzm.gsp.gift;
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
/*    */ public class SSynRoleReceiveGiftRes
/*    */   extends __SSynRoleReceiveGiftRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611075;
/*    */   public RoleInfo roleinfo;
/*    */   public int giftcfgid;
/*    */   public int receivesecs;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611075;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynRoleReceiveGiftRes()
/*    */   {
/* 35 */     this.roleinfo = new RoleInfo();
/*    */   }
/*    */   
/*    */   public SSynRoleReceiveGiftRes(RoleInfo _roleinfo_, int _giftcfgid_, int _receivesecs_) {
/* 39 */     this.roleinfo = _roleinfo_;
/* 40 */     this.giftcfgid = _giftcfgid_;
/* 41 */     this.receivesecs = _receivesecs_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.roleinfo._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.roleinfo);
/* 51 */     _os_.marshal(this.giftcfgid);
/* 52 */     _os_.marshal(this.receivesecs);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.roleinfo.unmarshal(_os_);
/* 58 */     this.giftcfgid = _os_.unmarshal_int();
/* 59 */     this.receivesecs = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynRoleReceiveGiftRes)) {
/* 69 */       SSynRoleReceiveGiftRes _o_ = (SSynRoleReceiveGiftRes)_o1_;
/* 70 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 71 */       if (this.giftcfgid != _o_.giftcfgid) return false;
/* 72 */       if (this.receivesecs != _o_.receivesecs) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.roleinfo.hashCode();
/* 81 */     _h_ += this.giftcfgid;
/* 82 */     _h_ += this.receivesecs;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roleinfo).append(",");
/* 90 */     _sb_.append(this.giftcfgid).append(",");
/* 91 */     _sb_.append(this.receivesecs).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gift\SSynRoleReceiveGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */