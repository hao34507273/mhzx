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
/*    */ public class SChatInGroup
/*    */   extends __SChatInGroup__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585254;
/*    */   public long groupid;
/*    */   public ChatContent content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585254;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChatInGroup()
/*    */   {
/* 34 */     this.content = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatInGroup(long _groupid_, ChatContent _content_) {
/* 38 */     this.groupid = _groupid_;
/* 39 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.content._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.groupid);
/* 49 */     _os_.marshal(this.content);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.groupid = _os_.unmarshal_long();
/* 55 */     this.content.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SChatInGroup)) {
/* 65 */       SChatInGroup _o_ = (SChatInGroup)_o1_;
/* 66 */       if (this.groupid != _o_.groupid) return false;
/* 67 */       if (!this.content.equals(_o_.content)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.groupid;
/* 76 */     _h_ += this.content.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.groupid).append(",");
/* 84 */     _sb_.append(this.content).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatInGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */