/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PMaidRenameReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMaidRenameReq
/*    */   extends __CMaidRenameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605450;
/*    */   public long maiduuid;
/*    */   public Octets name;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PMaidRenameReq(roleId, this.maiduuid, this.name));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605450;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CMaidRenameReq()
/*    */   {
/* 36 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public CMaidRenameReq(long _maiduuid_, Octets _name_) {
/* 40 */     this.maiduuid = _maiduuid_;
/* 41 */     this.name = _name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.maiduuid);
/* 50 */     _os_.marshal(this.name);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.maiduuid = _os_.unmarshal_long();
/* 56 */     this.name = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CMaidRenameReq)) {
/* 66 */       CMaidRenameReq _o_ = (CMaidRenameReq)_o1_;
/* 67 */       if (this.maiduuid != _o_.maiduuid) return false;
/* 68 */       if (!this.name.equals(_o_.name)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.maiduuid;
/* 77 */     _h_ += this.name.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.maiduuid).append(",");
/* 85 */     _sb_.append("B").append(this.name.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CMaidRenameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */