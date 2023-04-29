/*    */ package mzm.gsp.masswedding;
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
/*    */ public class SBrocastLuckyBlesserToAll
/*    */   extends __SBrocastLuckyBlesserToAll__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604960;
/*    */   public RoleInfo operroleinfo;
/*    */   public RoleInfo luckyroleinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12604960;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBrocastLuckyBlesserToAll()
/*    */   {
/* 32 */     this.operroleinfo = new RoleInfo();
/* 33 */     this.luckyroleinfo = new RoleInfo();
/*    */   }
/*    */   
/*    */   public SBrocastLuckyBlesserToAll(RoleInfo _operroleinfo_, RoleInfo _luckyroleinfo_) {
/* 37 */     this.operroleinfo = _operroleinfo_;
/* 38 */     this.luckyroleinfo = _luckyroleinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     if (!this.operroleinfo._validator_()) return false;
/* 43 */     if (!this.luckyroleinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.operroleinfo);
/* 49 */     _os_.marshal(this.luckyroleinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.operroleinfo.unmarshal(_os_);
/* 55 */     this.luckyroleinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SBrocastLuckyBlesserToAll)) {
/* 65 */       SBrocastLuckyBlesserToAll _o_ = (SBrocastLuckyBlesserToAll)_o1_;
/* 66 */       if (!this.operroleinfo.equals(_o_.operroleinfo)) return false;
/* 67 */       if (!this.luckyroleinfo.equals(_o_.luckyroleinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.operroleinfo.hashCode();
/* 76 */     _h_ += this.luckyroleinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.operroleinfo).append(",");
/* 84 */     _sb_.append(this.luckyroleinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SBrocastLuckyBlesserToAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */