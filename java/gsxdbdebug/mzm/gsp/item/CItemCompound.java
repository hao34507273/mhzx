/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PItemCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CItemCompound
/*    */   extends __CItemCompound__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584727;
/*    */   public long uuid;
/*    */   public int itemnum;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PItemCompound(roleid, this.uuid, this.itemnum));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584727;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CItemCompound() {}
/*    */   
/*    */ 
/*    */   public CItemCompound(long _uuid_, int _itemnum_)
/*    */   {
/* 40 */     this.uuid = _uuid_;
/* 41 */     this.itemnum = _itemnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.uuid);
/* 50 */     _os_.marshal(this.itemnum);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.uuid = _os_.unmarshal_long();
/* 56 */     this.itemnum = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CItemCompound)) {
/* 66 */       CItemCompound _o_ = (CItemCompound)_o1_;
/* 67 */       if (this.uuid != _o_.uuid) return false;
/* 68 */       if (this.itemnum != _o_.itemnum) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.uuid;
/* 77 */     _h_ += this.itemnum;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.uuid).append(",");
/* 85 */     _sb_.append(this.itemnum).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CItemCompound _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.itemnum - _o_.itemnum;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CItemCompound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */