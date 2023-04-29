/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.PCChangeCommandReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeCommandReq
/*    */   extends __CChangeCommandReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594198;
/*    */   public int commandtype;
/*    */   public int commandindex;
/*    */   public String commandname;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCChangeCommandReq(roleid, this.commandtype, this.commandindex, this.commandname));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12594198;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CChangeCommandReq()
/*    */   {
/* 37 */     this.commandname = "";
/*    */   }
/*    */   
/*    */   public CChangeCommandReq(int _commandtype_, int _commandindex_, String _commandname_) {
/* 41 */     this.commandtype = _commandtype_;
/* 42 */     this.commandindex = _commandindex_;
/* 43 */     this.commandname = _commandname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.commandtype);
/* 52 */     _os_.marshal(this.commandindex);
/* 53 */     _os_.marshal(this.commandname, "UTF-16LE");
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.commandtype = _os_.unmarshal_int();
/* 59 */     this.commandindex = _os_.unmarshal_int();
/* 60 */     this.commandname = _os_.unmarshal_String("UTF-16LE");
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CChangeCommandReq)) {
/* 70 */       CChangeCommandReq _o_ = (CChangeCommandReq)_o1_;
/* 71 */       if (this.commandtype != _o_.commandtype) return false;
/* 72 */       if (this.commandindex != _o_.commandindex) return false;
/* 73 */       if (!this.commandname.equals(_o_.commandname)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.commandtype;
/* 82 */     _h_ += this.commandindex;
/* 83 */     _h_ += this.commandname.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.commandtype).append(",");
/* 91 */     _sb_.append(this.commandindex).append(",");
/* 92 */     _sb_.append("T").append(this.commandname.length()).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CChangeCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */