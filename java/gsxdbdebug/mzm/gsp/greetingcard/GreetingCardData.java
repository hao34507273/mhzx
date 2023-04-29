/*    */ package mzm.gsp.greetingcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GreetingCardData implements Marshal
/*    */ {
/*    */   public int cardcfgid;
/*    */   public Octets content;
/*    */   public int resourceid;
/*    */   
/*    */   public GreetingCardData()
/*    */   {
/* 16 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GreetingCardData(int _cardcfgid_, Octets _content_, int _resourceid_) {
/* 20 */     this.cardcfgid = _cardcfgid_;
/* 21 */     this.content = _content_;
/* 22 */     this.resourceid = _resourceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.cardcfgid);
/* 31 */     _os_.marshal(this.content);
/* 32 */     _os_.marshal(this.resourceid);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.cardcfgid = _os_.unmarshal_int();
/* 38 */     this.content = _os_.unmarshal_Octets();
/* 39 */     this.resourceid = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof GreetingCardData)) {
/* 46 */       GreetingCardData _o_ = (GreetingCardData)_o1_;
/* 47 */       if (this.cardcfgid != _o_.cardcfgid) return false;
/* 48 */       if (!this.content.equals(_o_.content)) return false;
/* 49 */       if (this.resourceid != _o_.resourceid) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.cardcfgid;
/* 58 */     _h_ += this.content.hashCode();
/* 59 */     _h_ += this.resourceid;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.cardcfgid).append(",");
/* 67 */     _sb_.append("B").append(this.content.size()).append(",");
/* 68 */     _sb_.append(this.resourceid).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\greetingcard\GreetingCardData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */