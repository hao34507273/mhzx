/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.PCDelComandReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDelCommandReq
/*    */   extends __CDelCommandReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594203;
/*    */   public int commandtype;
/*    */   public int commandindex;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCDelComandReq(roleid, this.commandtype, this.commandindex));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12594203;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CDelCommandReq() {}
/*    */   
/*    */ 
/*    */   public CDelCommandReq(int _commandtype_, int _commandindex_)
/*    */   {
/* 39 */     this.commandtype = _commandtype_;
/* 40 */     this.commandindex = _commandindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.commandtype);
/* 49 */     _os_.marshal(this.commandindex);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.commandtype = _os_.unmarshal_int();
/* 55 */     this.commandindex = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CDelCommandReq)) {
/* 65 */       CDelCommandReq _o_ = (CDelCommandReq)_o1_;
/* 66 */       if (this.commandtype != _o_.commandtype) return false;
/* 67 */       if (this.commandindex != _o_.commandindex) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.commandtype;
/* 76 */     _h_ += this.commandindex;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.commandtype).append(",");
/* 84 */     _sb_.append(this.commandindex).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CDelCommandReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.commandtype - _o_.commandtype;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.commandindex - _o_.commandindex;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CDelCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */