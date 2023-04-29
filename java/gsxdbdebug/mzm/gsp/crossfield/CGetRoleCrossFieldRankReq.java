/*    */ package mzm.gsp.crossfield;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossfield.main.PCGetRoleCrossFieldRank;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleCrossFieldRankReq
/*    */   extends __CGetRoleCrossFieldRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619534;
/*    */   public int rank_type;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCGetRoleCrossFieldRank(roleid, this.rank_type));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12619534;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetRoleCrossFieldRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoleCrossFieldRankReq(int _rank_type_)
/*    */   {
/* 40 */     this.rank_type = _rank_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.rank_type);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.rank_type = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CGetRoleCrossFieldRankReq)) {
/* 63 */       CGetRoleCrossFieldRankReq _o_ = (CGetRoleCrossFieldRankReq)_o1_;
/* 64 */       if (this.rank_type != _o_.rank_type) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.rank_type;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.rank_type).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleCrossFieldRankReq _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.rank_type - _o_.rank_type;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\CGetRoleCrossFieldRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */