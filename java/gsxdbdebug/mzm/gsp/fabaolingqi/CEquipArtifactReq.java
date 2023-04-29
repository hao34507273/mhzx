/*    */ package mzm.gsp.fabaolingqi;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabaolingqi.main.PEquipArtifact;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEquipArtifactReq
/*    */   extends __CEquipArtifactReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618244;
/*    */   public int class_id;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/* 21 */       return;
/* 22 */     Role.addRoleProcedure(roleId, new PEquipArtifact(roleId, this.class_id));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12618244;
/*    */   }
/*    */   
/*    */ 
/*    */   public CEquipArtifactReq() {}
/*    */   
/*    */ 
/*    */   public CEquipArtifactReq(int _class_id_)
/*    */   {
/* 39 */     this.class_id = _class_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.class_id);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.class_id = _os_.unmarshal_int();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CEquipArtifactReq)) {
/* 62 */       CEquipArtifactReq _o_ = (CEquipArtifactReq)_o1_;
/* 63 */       if (this.class_id != _o_.class_id) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.class_id;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.class_id).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEquipArtifactReq _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = this.class_id - _o_.class_id;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\CEquipArtifactReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */