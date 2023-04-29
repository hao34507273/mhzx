/*    */ package mzm.gsp.market;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.market.main.PQueryPubOrSellNumberReq;
/*    */ 
/*    */ public class CQueryPubOrSellNumberReq
/*    */   extends __CQueryPubOrSellNumberReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601441;
/*    */   public HashSet<Integer> subids;
/*    */   public int puborsell;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PQueryPubOrSellNumberReq(roleId, this.subids, this.puborsell));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12601441;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CQueryPubOrSellNumberReq()
/*    */   {
/* 38 */     this.subids = new HashSet();
/*    */   }
/*    */   
/*    */   public CQueryPubOrSellNumberReq(HashSet<Integer> _subids_, int _puborsell_) {
/* 42 */     this.subids = _subids_;
/* 43 */     this.puborsell = _puborsell_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.subids.size());
/* 52 */     for (Integer _v_ : this.subids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     _os_.marshal(this.puborsell);
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 62 */       int _v_ = _os_.unmarshal_int();
/* 63 */       this.subids.add(Integer.valueOf(_v_));
/*    */     }
/* 65 */     this.puborsell = _os_.unmarshal_int();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CQueryPubOrSellNumberReq)) {
/* 75 */       CQueryPubOrSellNumberReq _o_ = (CQueryPubOrSellNumberReq)_o1_;
/* 76 */       if (!this.subids.equals(_o_.subids)) return false;
/* 77 */       if (this.puborsell != _o_.puborsell) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.subids.hashCode();
/* 86 */     _h_ += this.puborsell;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.subids).append(",");
/* 94 */     _sb_.append(this.puborsell).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\CQueryPubOrSellNumberReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */