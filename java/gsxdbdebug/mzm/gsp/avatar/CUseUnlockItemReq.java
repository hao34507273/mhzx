/*    */ package mzm.gsp.avatar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.avatar.main.PUseUnlockItem;
/*    */ 
/*    */ 
/*    */ public class CUseUnlockItemReq
/*    */   extends __CUseUnlockItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615178;
/*    */   public ArrayList<Integer> item_keys;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PUseUnlockItem(roleId, this.item_keys));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615178;
/*    */   }
/*    */   
/*    */ 
/*    */   public CUseUnlockItemReq()
/*    */   {
/* 33 */     this.item_keys = new ArrayList();
/*    */   }
/*    */   
/*    */   public CUseUnlockItemReq(ArrayList<Integer> _item_keys_) {
/* 37 */     this.item_keys = _item_keys_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.item_keys.size());
/* 46 */     for (Integer _v_ : this.item_keys) {
/* 47 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       int _v_ = _os_.unmarshal_int();
/* 56 */       this.item_keys.add(Integer.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CUseUnlockItemReq)) {
/* 67 */       CUseUnlockItemReq _o_ = (CUseUnlockItemReq)_o1_;
/* 68 */       if (!this.item_keys.equals(_o_.item_keys)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.item_keys.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.item_keys).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\CUseUnlockItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */