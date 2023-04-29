/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PUseMoshouFragmentReq;
/*    */ 
/*    */ 
/*    */ public class CUseMoshuFragmentReq
/*    */   extends __CUseMoshuFragmentReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584845;
/*    */   public int itemid;
/*    */   public int exchangetype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PUseMoshouFragmentReq(roleId, this.itemid, this.exchangetype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584845;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CUseMoshuFragmentReq() {}
/*    */   
/*    */ 
/*    */   public CUseMoshuFragmentReq(int _itemid_, int _exchangetype_)
/*    */   {
/* 37 */     this.itemid = _itemid_;
/* 38 */     this.exchangetype = _exchangetype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.itemid);
/* 47 */     _os_.marshal(this.exchangetype);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.itemid = _os_.unmarshal_int();
/* 53 */     this.exchangetype = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof CUseMoshuFragmentReq)) {
/* 63 */       CUseMoshuFragmentReq _o_ = (CUseMoshuFragmentReq)_o1_;
/* 64 */       if (this.itemid != _o_.itemid) return false;
/* 65 */       if (this.exchangetype != _o_.exchangetype) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.itemid;
/* 74 */     _h_ += this.exchangetype;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.itemid).append(",");
/* 82 */     _sb_.append(this.exchangetype).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CUseMoshuFragmentReq _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.itemid - _o_.itemid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.exchangetype - _o_.exchangetype;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CUseMoshuFragmentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */