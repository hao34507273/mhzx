/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PUseGiftBagItem;
/*    */ 
/*    */ 
/*    */ public class CUseGiftBagItem
/*    */   extends __CUseGiftBagItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584715;
/*    */   public long uuid;
/*    */   public int isuseall;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PUseGiftBagItem(roleId, this.uuid, this.isuseall == 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584715;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseGiftBagItem() {}
/*    */   
/*    */ 
/*    */   public CUseGiftBagItem(long _uuid_, int _isuseall_)
/*    */   {
/* 38 */     this.uuid = _uuid_;
/* 39 */     this.isuseall = _isuseall_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.uuid);
/* 48 */     _os_.marshal(this.isuseall);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.uuid = _os_.unmarshal_long();
/* 54 */     this.isuseall = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CUseGiftBagItem)) {
/* 64 */       CUseGiftBagItem _o_ = (CUseGiftBagItem)_o1_;
/* 65 */       if (this.uuid != _o_.uuid) return false;
/* 66 */       if (this.isuseall != _o_.isuseall) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.uuid;
/* 75 */     _h_ += this.isuseall;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.uuid).append(",");
/* 83 */     _sb_.append(this.isuseall).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseGiftBagItem _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.isuseall - _o_.isuseall;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseGiftBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */