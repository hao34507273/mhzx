/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PUseMoneybagItem;
/*    */ 
/*    */ 
/*    */ public class CUseMoneyBagItem
/*    */   extends __CUseMoneyBagItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584827;
/*    */   public long uuid;
/*    */   public int isuseall;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PUseMoneybagItem(roleId, this.uuid, this.isuseall == 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12584827;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseMoneyBagItem() {}
/*    */   
/*    */ 
/*    */   public CUseMoneyBagItem(long _uuid_, int _isuseall_)
/*    */   {
/* 41 */     this.uuid = _uuid_;
/* 42 */     this.isuseall = _isuseall_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.uuid);
/* 51 */     _os_.marshal(this.isuseall);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.uuid = _os_.unmarshal_long();
/* 57 */     this.isuseall = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CUseMoneyBagItem)) {
/* 67 */       CUseMoneyBagItem _o_ = (CUseMoneyBagItem)_o1_;
/* 68 */       if (this.uuid != _o_.uuid) return false;
/* 69 */       if (this.isuseall != _o_.isuseall) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.uuid;
/* 78 */     _h_ += this.isuseall;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.uuid).append(",");
/* 86 */     _sb_.append(this.isuseall).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseMoneyBagItem _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.isuseall - _o_.isuseall;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseMoneyBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */