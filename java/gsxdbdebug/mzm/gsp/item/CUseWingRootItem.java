/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PUseWingRootItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseWingRootItem
/*    */   extends __CUseWingRootItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584784;
/*    */   public long uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PUseWingRootItem(roleId, this.uuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584784;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUseWingRootItem() {}
/*    */   
/*    */ 
/*    */   public CUseWingRootItem(long _uuid_)
/*    */   {
/* 39 */     this.uuid = _uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.uuid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.uuid = _os_.unmarshal_long();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CUseWingRootItem)) {
/* 62 */       CUseWingRootItem _o_ = (CUseWingRootItem)_o1_;
/* 63 */       if (this.uuid != _o_.uuid) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += (int)this.uuid;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.uuid).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseWingRootItem _o_) {
/* 84 */     if (_o_ == this) return 0;
/* 85 */     int _c_ = 0;
/* 86 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseWingRootItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */