/*    */ package mzm.gsp.fight;
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
/*    */ public class SSynRoleObserveType
/*    */   extends __SSynRoleObserveType__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594212;
/*    */   public long fight_uuid;
/*    */   public int teamtype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594212;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynRoleObserveType() {}
/*    */   
/*    */ 
/*    */   public SSynRoleObserveType(long _fight_uuid_, int _teamtype_)
/*    */   {
/* 37 */     this.fight_uuid = _fight_uuid_;
/* 38 */     this.teamtype = _teamtype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.fight_uuid);
/* 47 */     _os_.marshal(this.teamtype);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.fight_uuid = _os_.unmarshal_long();
/* 53 */     this.teamtype = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynRoleObserveType)) {
/* 63 */       SSynRoleObserveType _o_ = (SSynRoleObserveType)_o1_;
/* 64 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/* 65 */       if (this.teamtype != _o_.teamtype) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.fight_uuid;
/* 74 */     _h_ += this.teamtype;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.fight_uuid).append(",");
/* 82 */     _sb_.append(this.teamtype).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynRoleObserveType _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.fight_uuid - _o_.fight_uuid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.teamtype - _o_.teamtype;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSynRoleObserveType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */