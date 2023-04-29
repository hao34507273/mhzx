/*    */ package mzm.gsp.constellation;
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
/*    */ public class SSyncConstellationCards
/*    */   extends __SSyncConstellationCards__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612107;
/*    */   public ConstellationCards cards;
/*    */   public int choose_index;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612107;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncConstellationCards()
/*    */   {
/* 34 */     this.cards = new ConstellationCards();
/*    */   }
/*    */   
/*    */   public SSyncConstellationCards(ConstellationCards _cards_, int _choose_index_) {
/* 38 */     this.cards = _cards_;
/* 39 */     this.choose_index = _choose_index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.cards._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.cards);
/* 49 */     _os_.marshal(this.choose_index);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.cards.unmarshal(_os_);
/* 55 */     this.choose_index = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSyncConstellationCards)) {
/* 65 */       SSyncConstellationCards _o_ = (SSyncConstellationCards)_o1_;
/* 66 */       if (!this.cards.equals(_o_.cards)) return false;
/* 67 */       if (this.choose_index != _o_.choose_index) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.cards.hashCode();
/* 76 */     _h_ += this.choose_index;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.cards).append(",");
/* 84 */     _sb_.append(this.choose_index).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\SSyncConstellationCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */