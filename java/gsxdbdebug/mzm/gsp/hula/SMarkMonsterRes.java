/*    */ package mzm.gsp.hula;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMarkMonsterRes
/*    */   extends __SMarkMonsterRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608774;
/*    */   public int seq;
/*    */   public Octets content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12608774;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMarkMonsterRes()
/*    */   {
/* 32 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public SMarkMonsterRes(int _seq_, Octets _content_) {
/* 36 */     this.seq = _seq_;
/* 37 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.seq);
/* 46 */     _os_.marshal(this.content);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.seq = _os_.unmarshal_int();
/* 52 */     this.content = _os_.unmarshal_Octets();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof SMarkMonsterRes)) {
/* 62 */       SMarkMonsterRes _o_ = (SMarkMonsterRes)_o1_;
/* 63 */       if (this.seq != _o_.seq) return false;
/* 64 */       if (!this.content.equals(_o_.content)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.seq;
/* 73 */     _h_ += this.content.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.seq).append(",");
/* 81 */     _sb_.append("B").append(this.content.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SMarkMonsterRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */