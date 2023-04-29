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
/*    */ 
/*    */ public class SChatInTrumpet
/*    */   extends __SChatInTrumpet__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585274;
/*    */   public int trumpet_cfg_id;
/*    */   public ChatContent chatcontent;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585274;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChatInTrumpet()
/*    */   {
/* 34 */     this.chatcontent = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatInTrumpet(int _trumpet_cfg_id_, ChatContent _chatcontent_) {
/* 38 */     this.trumpet_cfg_id = _trumpet_cfg_id_;
/* 39 */     this.chatcontent = _chatcontent_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.chatcontent._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.trumpet_cfg_id);
/* 49 */     _os_.marshal(this.chatcontent);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.trumpet_cfg_id = _os_.unmarshal_int();
/* 55 */     this.chatcontent.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SChatInTrumpet)) {
/* 65 */       SChatInTrumpet _o_ = (SChatInTrumpet)_o1_;
/* 66 */       if (this.trumpet_cfg_id != _o_.trumpet_cfg_id) return false;
/* 67 */       if (!this.chatcontent.equals(_o_.chatcontent)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.trumpet_cfg_id;
/* 76 */     _h_ += this.chatcontent.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.trumpet_cfg_id).append(",");
/* 84 */     _sb_.append(this.chatcontent).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatInTrumpet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */