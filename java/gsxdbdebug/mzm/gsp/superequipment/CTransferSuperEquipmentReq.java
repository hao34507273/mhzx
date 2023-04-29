/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.superequipment.main.PTransferSuperEquipment;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CTransferSuperEquipmentReq
/*    */   extends __CTransferSuperEquipmentReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618755;
/*    */   public HashSet<Long> uuids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PTransferSuperEquipment(roleId, this.uuids));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12618755;
/*    */   }
/*    */   
/*    */ 
/*    */   public CTransferSuperEquipmentReq()
/*    */   {
/* 35 */     this.uuids = new HashSet();
/*    */   }
/*    */   
/*    */   public CTransferSuperEquipmentReq(HashSet<Long> _uuids_) {
/* 39 */     this.uuids = _uuids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.uuids.size());
/* 48 */     for (Long _v_ : this.uuids) {
/* 49 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       long _v_ = _os_.unmarshal_long();
/* 58 */       this.uuids.add(Long.valueOf(_v_));
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof CTransferSuperEquipmentReq)) {
/* 69 */       CTransferSuperEquipmentReq _o_ = (CTransferSuperEquipmentReq)_o1_;
/* 70 */       if (!this.uuids.equals(_o_.uuids)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.uuids.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.uuids).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\CTransferSuperEquipmentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */