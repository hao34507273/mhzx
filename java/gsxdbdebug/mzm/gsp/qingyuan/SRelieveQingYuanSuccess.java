/*    */ package mzm.gsp.qingyuan;
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
/*    */ public class SRelieveQingYuanSuccess
/*    */   extends __SRelieveQingYuanSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602882;
/*    */   public long active_role_id;
/*    */   public long passive_role_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602882;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRelieveQingYuanSuccess() {}
/*    */   
/*    */ 
/*    */   public SRelieveQingYuanSuccess(long _active_role_id_, long _passive_role_id_)
/*    */   {
/* 37 */     this.active_role_id = _active_role_id_;
/* 38 */     this.passive_role_id = _passive_role_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.active_role_id);
/* 47 */     _os_.marshal(this.passive_role_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.active_role_id = _os_.unmarshal_long();
/* 53 */     this.passive_role_id = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SRelieveQingYuanSuccess)) {
/* 63 */       SRelieveQingYuanSuccess _o_ = (SRelieveQingYuanSuccess)_o1_;
/* 64 */       if (this.active_role_id != _o_.active_role_id) return false;
/* 65 */       if (this.passive_role_id != _o_.passive_role_id) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.active_role_id;
/* 74 */     _h_ += (int)this.passive_role_id;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.active_role_id).append(",");
/* 82 */     _sb_.append(this.passive_role_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SRelieveQingYuanSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.active_role_id - _o_.active_role_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.passive_role_id - _o_.passive_role_id);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\SRelieveQingYuanSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */