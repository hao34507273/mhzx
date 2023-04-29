/*    */ package mzm.gsp.gm;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChatMessage
/*    */   extends __CChatMessage__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585731;
/*    */   public String command;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585731;
/*    */   }
/*    */   
/*    */ 
/*    */   public CChatMessage()
/*    */   {
/* 31 */     this.command = "";
/*    */   }
/*    */   
/*    */   public CChatMessage(String _command_) {
/* 35 */     this.command = _command_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 43 */     _os_.marshal(this.command, "UTF-16LE");
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 48 */     this.command = _os_.unmarshal_String("UTF-16LE");
/* 49 */     if (!_validator_()) {
/* 50 */       throw new VerifyError("validator failed");
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof CChatMessage)) {
/* 58 */       CChatMessage _o_ = (CChatMessage)_o1_;
/* 59 */       if (!this.command.equals(_o_.command)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.command.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append("T").append(this.command.length()).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\CChatMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */