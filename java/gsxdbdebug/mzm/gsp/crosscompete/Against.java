/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Against
/*    */   implements Marshal
/*    */ {
/*    */   public AgainstFaction faction1;
/*    */   public AgainstFaction faction2;
/*    */   public int compete_index;
/*    */   public long winner;
/*    */   
/*    */   public Against()
/*    */   {
/* 17 */     this.faction1 = new AgainstFaction();
/* 18 */     this.faction2 = new AgainstFaction();
/*    */   }
/*    */   
/*    */   public Against(AgainstFaction _faction1_, AgainstFaction _faction2_, int _compete_index_, long _winner_) {
/* 22 */     this.faction1 = _faction1_;
/* 23 */     this.faction2 = _faction2_;
/* 24 */     this.compete_index = _compete_index_;
/* 25 */     this.winner = _winner_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     if (!this.faction1._validator_()) return false;
/* 30 */     if (!this.faction2._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.faction1);
/* 36 */     _os_.marshal(this.faction2);
/* 37 */     _os_.marshal(this.compete_index);
/* 38 */     _os_.marshal(this.winner);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.faction1.unmarshal(_os_);
/* 44 */     this.faction2.unmarshal(_os_);
/* 45 */     this.compete_index = _os_.unmarshal_int();
/* 46 */     this.winner = _os_.unmarshal_long();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof Against)) {
/* 53 */       Against _o_ = (Against)_o1_;
/* 54 */       if (!this.faction1.equals(_o_.faction1)) return false;
/* 55 */       if (!this.faction2.equals(_o_.faction2)) return false;
/* 56 */       if (this.compete_index != _o_.compete_index) return false;
/* 57 */       if (this.winner != _o_.winner) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.faction1.hashCode();
/* 66 */     _h_ += this.faction2.hashCode();
/* 67 */     _h_ += this.compete_index;
/* 68 */     _h_ += (int)this.winner;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.faction1).append(",");
/* 76 */     _sb_.append(this.faction2).append(",");
/* 77 */     _sb_.append(this.compete_index).append(",");
/* 78 */     _sb_.append(this.winner).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\Against.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */