/*    */ package mzm.gsp.award;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.award.main.PCheckFixAwardInfoReq;
/*    */ 
/*    */ public class CCheckFixAwardInfoReq
/*    */   extends __CCheckFixAwardInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583425;
/*    */   public int fixawardid;
/*    */   public int itemindex;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     if (roleId < 0L) {
/* 19 */       return;
/*    */     }
/* 21 */     Role.addRoleProcedure(roleId, new PCheckFixAwardInfoReq(roleId, this.fixawardid, this.itemindex));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12583425;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCheckFixAwardInfoReq() {}
/*    */   
/*    */ 
/*    */   public CCheckFixAwardInfoReq(int _fixawardid_, int _itemindex_)
/*    */   {
/* 39 */     this.fixawardid = _fixawardid_;
/* 40 */     this.itemindex = _itemindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fixawardid);
/* 49 */     _os_.marshal(this.itemindex);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fixawardid = _os_.unmarshal_int();
/* 55 */     this.itemindex = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CCheckFixAwardInfoReq)) {
/* 65 */       CCheckFixAwardInfoReq _o_ = (CCheckFixAwardInfoReq)_o1_;
/* 66 */       if (this.fixawardid != _o_.fixawardid) return false;
/* 67 */       if (this.itemindex != _o_.itemindex) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fixawardid;
/* 76 */     _h_ += this.itemindex;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fixawardid).append(",");
/* 84 */     _sb_.append(this.itemindex).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CCheckFixAwardInfoReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.fixawardid - _o_.fixawardid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.itemindex - _o_.itemindex;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\CCheckFixAwardInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */