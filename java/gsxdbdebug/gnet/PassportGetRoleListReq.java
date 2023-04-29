/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PassportGetRoleListReq
/*    */   extends __PassportGetRoleListReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 214;
/*    */   public int xid;
/*    */   public Octets userid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     GdeliveryHelper.getRoleList(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 214;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public PassportGetRoleListReq()
/*    */   {
/* 34 */     this.userid = new Octets();
/*    */   }
/*    */   
/*    */   public PassportGetRoleListReq(int _xid_, Octets _userid_) {
/* 38 */     this.xid = _xid_;
/* 39 */     this.userid = _userid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.xid);
/* 48 */     _os_.marshal(this.userid);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.xid = _os_.unmarshal_int();
/* 54 */     this.userid = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof PassportGetRoleListReq)) {
/* 64 */       PassportGetRoleListReq _o_ = (PassportGetRoleListReq)_o1_;
/* 65 */       if (this.xid != _o_.xid) return false;
/* 66 */       if (!this.userid.equals(_o_.userid)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.xid;
/* 75 */     _h_ += this.userid.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.xid).append(",");
/* 83 */     _sb_.append("B").append(this.userid.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\PassportGetRoleListReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */