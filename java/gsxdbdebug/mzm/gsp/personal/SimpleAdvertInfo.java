/*    */ package mzm.gsp.personal;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class SimpleAdvertInfo implements Marshal
/*    */ {
/*    */   public int adverttype;
/*    */   public Octets content;
/*    */   
/*    */   public SimpleAdvertInfo()
/*    */   {
/* 15 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public SimpleAdvertInfo(int _adverttype_, Octets _content_) {
/* 19 */     this.adverttype = _adverttype_;
/* 20 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.adverttype);
/* 29 */     _os_.marshal(this.content);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.adverttype = _os_.unmarshal_int();
/* 35 */     this.content = _os_.unmarshal_Octets();
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 40 */     if (_o1_ == this) return true;
/* 41 */     if ((_o1_ instanceof SimpleAdvertInfo)) {
/* 42 */       SimpleAdvertInfo _o_ = (SimpleAdvertInfo)_o1_;
/* 43 */       if (this.adverttype != _o_.adverttype) return false;
/* 44 */       if (!this.content.equals(_o_.content)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += this.adverttype;
/* 53 */     _h_ += this.content.hashCode();
/* 54 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuilder _sb_ = new StringBuilder();
/* 59 */     _sb_.append("(");
/* 60 */     _sb_.append(this.adverttype).append(",");
/* 61 */     _sb_.append("B").append(this.content.size()).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\SimpleAdvertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */