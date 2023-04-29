/*    */ package mzm.gsp.changemodelcard;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class CardInfo
/*    */   implements Marshal, Comparable<CardInfo>
/*    */ {
/*    */   public int card_cfg_id;
/*    */   public int level;
/*    */   public int exp;
/*    */   public int use_count;
/*    */   
/*    */   public CardInfo() {}
/*    */   
/*    */   public CardInfo(int _card_cfg_id_, int _level_, int _exp_, int _use_count_)
/*    */   {
/* 20 */     this.card_cfg_id = _card_cfg_id_;
/* 21 */     this.level = _level_;
/* 22 */     this.exp = _exp_;
/* 23 */     this.use_count = _use_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.card_cfg_id);
/* 32 */     _os_.marshal(this.level);
/* 33 */     _os_.marshal(this.exp);
/* 34 */     _os_.marshal(this.use_count);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.card_cfg_id = _os_.unmarshal_int();
/* 40 */     this.level = _os_.unmarshal_int();
/* 41 */     this.exp = _os_.unmarshal_int();
/* 42 */     this.use_count = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof CardInfo)) {
/* 49 */       CardInfo _o_ = (CardInfo)_o1_;
/* 50 */       if (this.card_cfg_id != _o_.card_cfg_id) return false;
/* 51 */       if (this.level != _o_.level) return false;
/* 52 */       if (this.exp != _o_.exp) return false;
/* 53 */       if (this.use_count != _o_.use_count) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += this.card_cfg_id;
/* 62 */     _h_ += this.level;
/* 63 */     _h_ += this.exp;
/* 64 */     _h_ += this.use_count;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.card_cfg_id).append(",");
/* 72 */     _sb_.append(this.level).append(",");
/* 73 */     _sb_.append(this.exp).append(",");
/* 74 */     _sb_.append(this.use_count).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CardInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = this.card_cfg_id - _o_.card_cfg_id;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.level - _o_.level;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.exp - _o_.exp;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.use_count - _o_.use_count;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\CardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */