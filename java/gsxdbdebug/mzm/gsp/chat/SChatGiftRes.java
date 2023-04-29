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
/*    */ public class SChatGiftRes
/*    */   extends __SChatGiftRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585264;
/*    */   public ChatGiftOctets chatgiftoctest;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585264;
/*    */   }
/*    */   
/*    */ 
/*    */   public SChatGiftRes()
/*    */   {
/* 31 */     this.chatgiftoctest = new ChatGiftOctets();
/*    */   }
/*    */   
/*    */   public SChatGiftRes(ChatGiftOctets _chatgiftoctest_) {
/* 35 */     this.chatgiftoctest = _chatgiftoctest_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     if (!this.chatgiftoctest._validator_()) return false;
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.chatgiftoctest);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.chatgiftoctest.unmarshal(_os_);
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SChatGiftRes)) {
/* 59 */       SChatGiftRes _o_ = (SChatGiftRes)_o1_;
/* 60 */       if (!this.chatgiftoctest.equals(_o_.chatgiftoctest)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.chatgiftoctest.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.chatgiftoctest).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatGiftRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */