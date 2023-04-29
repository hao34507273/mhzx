/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.children.main.PCChildrenSelectOccupationReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChildrenSelectOccupationReq
/*    */   extends __CChildrenSelectOccupationReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609370;
/*    */   public long childrenid;
/*    */   public int occupation;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCChildrenSelectOccupationReq(roleid, this.childrenid, this.occupation));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12609370;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChildrenSelectOccupationReq() {}
/*    */   
/*    */ 
/*    */   public CChildrenSelectOccupationReq(long _childrenid_, int _occupation_)
/*    */   {
/* 39 */     this.childrenid = _childrenid_;
/* 40 */     this.occupation = _occupation_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childrenid);
/* 49 */     _os_.marshal(this.occupation);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childrenid = _os_.unmarshal_long();
/* 55 */     this.occupation = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CChildrenSelectOccupationReq)) {
/* 65 */       CChildrenSelectOccupationReq _o_ = (CChildrenSelectOccupationReq)_o1_;
/* 66 */       if (this.childrenid != _o_.childrenid) return false;
/* 67 */       if (this.occupation != _o_.occupation) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childrenid;
/* 76 */     _h_ += this.occupation;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childrenid).append(",");
/* 84 */     _sb_.append(this.occupation).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChildrenSelectOccupationReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.occupation - _o_.occupation;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\CChildrenSelectOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */