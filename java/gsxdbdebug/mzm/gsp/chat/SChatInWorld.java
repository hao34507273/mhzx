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
/*    */ 
/*    */ public class SChatInWorld
/*    */   extends __SChatInWorld__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585237;
/*    */   public ChatContent chatcontent;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585237;
/*    */   }
/*    */   
/*    */ 
/*    */   public SChatInWorld()
/*    */   {
/* 31 */     this.chatcontent = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatInWorld(ChatContent _chatcontent_) {
/* 35 */     this.chatcontent = _chatcontent_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.chatcontent._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.chatcontent);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.chatcontent.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SChatInWorld)) {
/* 59 */       SChatInWorld _o_ = (SChatInWorld)_o1_;
/* 60 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.chatcontent.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.chatcontent).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatInWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */