/*    */ package mzm.gsp.avatar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.avatar.frame.PUseAvatarFrameUnlockItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseAvatarFrameUnlockItemReq
/*    */   extends __CUseAvatarFrameUnlockItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615185;
/*    */   public long item_uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PUseAvatarFrameUnlockItem(roleId, this.item_uuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12615185;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUseAvatarFrameUnlockItemReq() {}
/*    */   
/*    */ 
/*    */   public CUseAvatarFrameUnlockItemReq(long _item_uuid_)
/*    */   {
/* 37 */     this.item_uuid = _item_uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.item_uuid);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.item_uuid = _os_.unmarshal_long();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CUseAvatarFrameUnlockItemReq)) {
/* 60 */       CUseAvatarFrameUnlockItemReq _o_ = (CUseAvatarFrameUnlockItemReq)_o1_;
/* 61 */       if (this.item_uuid != _o_.item_uuid) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.item_uuid;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.item_uuid).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseAvatarFrameUnlockItemReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = Long.signum(this.item_uuid - _o_.item_uuid);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\CUseAvatarFrameUnlockItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */