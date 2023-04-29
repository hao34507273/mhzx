/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PCSellAllItemReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSellAllItemReq
/*    */   extends __CSellAllItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584776;
/*    */   public int bagid;
/*    */   public long uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PCSellAllItemReq(this.uuid, this.bagid, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584776;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSellAllItemReq() {}
/*    */   
/*    */ 
/*    */   public CSellAllItemReq(int _bagid_, long _uuid_)
/*    */   {
/* 40 */     this.bagid = _bagid_;
/* 41 */     this.uuid = _uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.bagid);
/* 50 */     _os_.marshal(this.uuid);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.bagid = _os_.unmarshal_int();
/* 56 */     this.uuid = _os_.unmarshal_long();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CSellAllItemReq)) {
/* 66 */       CSellAllItemReq _o_ = (CSellAllItemReq)_o1_;
/* 67 */       if (this.bagid != _o_.bagid) return false;
/* 68 */       if (this.uuid != _o_.uuid) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.bagid;
/* 77 */     _h_ += (int)this.uuid;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.bagid).append(",");
/* 85 */     _sb_.append(this.uuid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSellAllItemReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.bagid - _o_.bagid;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CSellAllItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */