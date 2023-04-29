/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SRoleInCrossServerRes
/*    */   extends __SRoleInCrossServerRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590103;
/*    */   public long roleid;
/*    */   public int zoneid;
/*    */   public Octets token;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590103;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRoleInCrossServerRes()
/*    */   {
/* 35 */     this.token = new Octets();
/*    */   }
/*    */   
/*    */   public SRoleInCrossServerRes(long _roleid_, int _zoneid_, Octets _token_) {
/* 39 */     this.roleid = _roleid_;
/* 40 */     this.zoneid = _zoneid_;
/* 41 */     this.token = _token_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.zoneid);
/* 51 */     _os_.marshal(this.token);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     this.zoneid = _os_.unmarshal_int();
/* 58 */     this.token = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SRoleInCrossServerRes)) {
/* 68 */       SRoleInCrossServerRes _o_ = (SRoleInCrossServerRes)_o1_;
/* 69 */       if (this.roleid != _o_.roleid) return false;
/* 70 */       if (this.zoneid != _o_.zoneid) return false;
/* 71 */       if (!this.token.equals(_o_.token)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += (int)this.roleid;
/* 80 */     _h_ += this.zoneid;
/* 81 */     _h_ += this.token.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.roleid).append(",");
/* 89 */     _sb_.append(this.zoneid).append(",");
/* 90 */     _sb_.append("B").append(this.token.size()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\SRoleInCrossServerRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */