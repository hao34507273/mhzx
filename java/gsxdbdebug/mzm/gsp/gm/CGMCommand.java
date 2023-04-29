/*    */ package mzm.gsp.gm;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.gm.main.PGMCommand;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGMCommand
/*    */   extends __CGMCommand__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585733;
/*    */   public String command;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     new PGMCommand(Role.getRole(this), this.command).submit();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 26 */     return 12585733;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGMCommand()
/*    */   {
/* 32 */     this.command = "";
/*    */   }
/*    */   
/*    */   public CGMCommand(String _command_) {
/* 36 */     this.command = _command_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.command, "UTF-16LE");
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.command = _os_.unmarshal_String("UTF-16LE");
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof CGMCommand)) {
/* 59 */       CGMCommand _o_ = (CGMCommand)_o1_;
/* 60 */       if (!this.command.equals(_o_.command)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.command.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append("T").append(this.command.length()).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\CGMCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */