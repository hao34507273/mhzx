/*    */ package mzm.gsp.team;
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
/*    */ 
/*    */ public class SSynRolesUnderProtect
/*    */   extends __SSynRolesUnderProtect__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588344;
/*    */   public ArrayList<Long> rolesunderprotect;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588344;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynRolesUnderProtect()
/*    */   {
/* 33 */     this.rolesunderprotect = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynRolesUnderProtect(ArrayList<Long> _rolesunderprotect_) {
/* 37 */     this.rolesunderprotect = _rolesunderprotect_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.rolesunderprotect.size());
/* 46 */     for (Long _v_ : this.rolesunderprotect) {
/* 47 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       long _v_ = _os_.unmarshal_long();
/* 56 */       this.rolesunderprotect.add(Long.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynRolesUnderProtect)) {
/* 67 */       SSynRolesUnderProtect _o_ = (SSynRolesUnderProtect)_o1_;
/* 68 */       if (!this.rolesunderprotect.equals(_o_.rolesunderprotect)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.rolesunderprotect.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.rolesunderprotect).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SSynRolesUnderProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */