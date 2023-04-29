/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fight.main.PCAddCommand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CAddCommandReq
/*    */   extends __CAddCommandReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 797717;
/*    */   public int commandtype;
/*    */   public String commandname;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCAddCommand(roleid, this.commandtype, this.commandname));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 797717;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAddCommandReq()
/*    */   {
/* 36 */     this.commandname = "";
/*    */   }
/*    */   
/*    */   public CAddCommandReq(int _commandtype_, String _commandname_) {
/* 40 */     this.commandtype = _commandtype_;
/* 41 */     this.commandname = _commandname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.commandtype);
/* 50 */     _os_.marshal(this.commandname, "UTF-16LE");
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.commandtype = _os_.unmarshal_int();
/* 56 */     this.commandname = _os_.unmarshal_String("UTF-16LE");
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CAddCommandReq)) {
/* 66 */       CAddCommandReq _o_ = (CAddCommandReq)_o1_;
/* 67 */       if (this.commandtype != _o_.commandtype) return false;
/* 68 */       if (!this.commandname.equals(_o_.commandname)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.commandtype;
/* 77 */     _h_ += this.commandname.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.commandtype).append(",");
/* 85 */     _sb_.append("T").append(this.commandname.length()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CAddCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */