/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PSplitItem;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSplitItemReq
/*    */   extends __CSplitItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584878;
/*    */   public long item_uuid;
/*    */   public int split_all;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleId, new PSplitItem(roleId, this.item_uuid, this.split_all != 0));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584878;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSplitItemReq() {}
/*    */   
/*    */ 
/*    */   public CSplitItemReq(long _item_uuid_, int _split_all_)
/*    */   {
/* 38 */     this.item_uuid = _item_uuid_;
/* 39 */     this.split_all = _split_all_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.item_uuid);
/* 48 */     _os_.marshal(this.split_all);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.item_uuid = _os_.unmarshal_long();
/* 54 */     this.split_all = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CSplitItemReq)) {
/* 64 */       CSplitItemReq _o_ = (CSplitItemReq)_o1_;
/* 65 */       if (this.item_uuid != _o_.item_uuid) return false;
/* 66 */       if (this.split_all != _o_.split_all) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.item_uuid;
/* 75 */     _h_ += this.split_all;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.item_uuid).append(",");
/* 83 */     _sb_.append(this.split_all).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSplitItemReq _o_) {
/* 89 */     if (_o_ == this) return 0;
/* 90 */     int _c_ = 0;
/* 91 */     _c_ = Long.signum(this.item_uuid - _o_.item_uuid);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.split_all - _o_.split_all;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CSplitItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */