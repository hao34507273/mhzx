/*    */ package mzm.gsp.changemodelcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.changemodelcard.main.PCUnlockCardReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUnlockCardReq
/*    */   extends __CUnlockCardReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624385;
/*    */   public long item_uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId <= 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PCUnlockCardReq(roleId, this.item_uuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12624385;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUnlockCardReq() {}
/*    */   
/*    */ 
/*    */   public CUnlockCardReq(long _item_uuid_)
/*    */   {
/* 42 */     this.item_uuid = _item_uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.item_uuid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.item_uuid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CUnlockCardReq)) {
/* 65 */       CUnlockCardReq _o_ = (CUnlockCardReq)_o1_;
/* 66 */       if (this.item_uuid != _o_.item_uuid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.item_uuid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.item_uuid).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUnlockCardReq _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = Long.signum(this.item_uuid - _o_.item_uuid);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CUnlockCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */