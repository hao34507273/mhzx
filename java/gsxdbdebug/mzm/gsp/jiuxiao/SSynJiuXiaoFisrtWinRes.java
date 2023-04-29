/*    */ package mzm.gsp.jiuxiao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSynJiuXiaoFisrtWinRes
/*    */   extends __SSynJiuXiaoFisrtWinRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12595469;
/*    */   public int cfgid;
/*    */   public ArrayList<RoleData> roles;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12595469;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynJiuXiaoFisrtWinRes()
/*    */   {
/* 34 */     this.roles = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynJiuXiaoFisrtWinRes(int _cfgid_, ArrayList<RoleData> _roles_) {
/* 38 */     this.cfgid = _cfgid_;
/* 39 */     this.roles = _roles_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (RoleData _v_ : this.roles)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.cfgid);
/* 50 */     _os_.compact_uint32(this.roles.size());
/* 51 */     for (RoleData _v_ : this.roles) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.cfgid = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       RoleData _v_ = new RoleData();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.roles.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSynJiuXiaoFisrtWinRes)) {
/* 73 */       SSynJiuXiaoFisrtWinRes _o_ = (SSynJiuXiaoFisrtWinRes)_o1_;
/* 74 */       if (this.cfgid != _o_.cfgid) return false;
/* 75 */       if (!this.roles.equals(_o_.roles)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.cfgid;
/* 84 */     _h_ += this.roles.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.cfgid).append(",");
/* 92 */     _sb_.append(this.roles).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\SSynJiuXiaoFisrtWinRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */