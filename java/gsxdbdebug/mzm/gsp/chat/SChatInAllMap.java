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
/*    */ public class SChatInAllMap
/*    */   extends __SChatInAllMap__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585265;
/*    */   public int map_cfg_id;
/*    */   public ChatContent content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585265;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChatInAllMap()
/*    */   {
/* 34 */     this.content = new ChatContent();
/*    */   }
/*    */   
/*    */   public SChatInAllMap(int _map_cfg_id_, ChatContent _content_) {
/* 38 */     this.map_cfg_id = _map_cfg_id_;
/* 39 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.content._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.map_cfg_id);
/* 49 */     _os_.marshal(this.content);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.map_cfg_id = _os_.unmarshal_int();
/* 55 */     this.content.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SChatInAllMap)) {
/* 65 */       SChatInAllMap _o_ = (SChatInAllMap)_o1_;
/* 66 */       if (this.map_cfg_id != _o_.map_cfg_id) return false;
/* 67 */       if (!this.content.equals(_o_.content)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.map_cfg_id;
/* 76 */     _h_ += this.content.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.map_cfg_id).append(",");
/* 84 */     _sb_.append(this.content).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\SChatInAllMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */