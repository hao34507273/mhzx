/*    */ package mzm.gsp.corps;
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
/*    */ 
/*    */ public class SRefuseJoinCorps
/*    */   extends __SRefuseJoinCorps__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617477;
/*    */   public long roleid;
/*    */   public Octets rolename;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617477;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRefuseJoinCorps()
/*    */   {
/* 34 */     this.rolename = new Octets();
/*    */   }
/*    */   
/*    */   public SRefuseJoinCorps(long _roleid_, Octets _rolename_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.rolename = _rolename_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     _os_.marshal(this.rolename);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     this.rolename = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SRefuseJoinCorps)) {
/* 64 */       SRefuseJoinCorps _o_ = (SRefuseJoinCorps)_o1_;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     _h_ += this.rolename.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\SRefuseJoinCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */