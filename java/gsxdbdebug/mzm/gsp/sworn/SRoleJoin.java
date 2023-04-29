/*    */ package mzm.gsp.sworn;
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
/*    */ 
/*    */ public class SRoleJoin
/*    */   extends __SRoleJoin__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597791;
/*    */   public long swornid;
/*    */   public memberinfo newmemberinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12597791;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRoleJoin()
/*    */   {
/* 34 */     this.newmemberinfo = new memberinfo();
/*    */   }
/*    */   
/*    */   public SRoleJoin(long _swornid_, memberinfo _newmemberinfo_) {
/* 38 */     this.swornid = _swornid_;
/* 39 */     this.newmemberinfo = _newmemberinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.newmemberinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.swornid);
/* 49 */     _os_.marshal(this.newmemberinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.swornid = _os_.unmarshal_long();
/* 55 */     this.newmemberinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SRoleJoin)) {
/* 65 */       SRoleJoin _o_ = (SRoleJoin)_o1_;
/* 66 */       if (this.swornid != _o_.swornid) return false;
/* 67 */       if (!this.newmemberinfo.equals(_o_.newmemberinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.swornid;
/* 76 */     _h_ += this.newmemberinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.swornid).append(",");
/* 84 */     _sb_.append(this.newmemberinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SRoleJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */