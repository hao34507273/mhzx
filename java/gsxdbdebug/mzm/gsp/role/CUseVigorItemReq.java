/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PUseVigorItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CUseVigorItemReq
/*    */   extends __CUseVigorItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585993;
/*    */   public int itemkey;
/*    */   public int alluse;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PUseVigorItem(roleId, this.itemkey, this.alluse == 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12585993;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseVigorItemReq() {}
/*    */   
/*    */ 
/*    */   public CUseVigorItemReq(int _itemkey_, int _alluse_)
/*    */   {
/* 41 */     this.itemkey = _itemkey_;
/* 42 */     this.alluse = _alluse_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.itemkey);
/* 51 */     _os_.marshal(this.alluse);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.itemkey = _os_.unmarshal_int();
/* 57 */     this.alluse = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CUseVigorItemReq)) {
/* 67 */       CUseVigorItemReq _o_ = (CUseVigorItemReq)_o1_;
/* 68 */       if (this.itemkey != _o_.itemkey) return false;
/* 69 */       if (this.alluse != _o_.alluse) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemkey;
/* 78 */     _h_ += this.alluse;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.itemkey).append(",");
/* 86 */     _sb_.append(this.alluse).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseVigorItemReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.itemkey - _o_.itemkey;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.alluse - _o_.alluse;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CUseVigorItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */