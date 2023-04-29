/*    */ package mzm.gsp.chat;
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
/*    */ public class SChatInFaction
/*    */   extends __SChatInFaction__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585233;
/*    */   public ChatContent chatcontent;
/*    */   public int position;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585233;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChatInFaction()
/*    */   {
/* 32 */     this.chatcontent = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatInFaction(ChatContent _chatcontent_, int _position_) {
/* 36 */     this.chatcontent = _chatcontent_;
/* 37 */     this.position = _position_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.chatcontent._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.chatcontent);
/* 47 */     _os_.marshal(this.position);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.chatcontent.unmarshal(_os_);
/* 53 */     this.position = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SChatInFaction)) {
/* 63 */       SChatInFaction _o_ = (SChatInFaction)_o1_;
/* 64 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/* 65 */       if (this.position != _o_.position) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.chatcontent.hashCode();
/* 74 */     _h_ += this.position;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.chatcontent).append(",");
/* 82 */     _sb_.append(this.position).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatInFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */