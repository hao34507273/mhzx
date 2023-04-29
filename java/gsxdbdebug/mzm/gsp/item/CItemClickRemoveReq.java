/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PCItemClickRemoveReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CItemClickRemoveReq
/*    */   extends __CItemClickRemoveReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584864;
/*    */   public long uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleid, new PCItemClickRemoveReq(roleid, this.uuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12584864;
/*    */   }
/*    */   
/*    */ 
/*    */   public CItemClickRemoveReq() {}
/*    */   
/*    */ 
/*    */   public CItemClickRemoveReq(long _uuid_)
/*    */   {
/* 43 */     this.uuid = _uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.uuid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.uuid = _os_.unmarshal_long();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CItemClickRemoveReq)) {
/* 66 */       CItemClickRemoveReq _o_ = (CItemClickRemoveReq)_o1_;
/* 67 */       if (this.uuid != _o_.uuid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.uuid;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.uuid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CItemClickRemoveReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CItemClickRemoveReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */